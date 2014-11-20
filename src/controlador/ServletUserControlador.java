package controlador;

import modelo.DataAccess;
import modelo.Usuario;

import javax.json.Json;
import javax.json.JsonException;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet("/controlador")

public class ServletUserControlador extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String nombre = null;
        String apellidop = null;
        String apellidom = null;
        String fecNac = null;
        String id = null;
        String password = null;
        String email = null;
        int comando = -1;

        PrintWriter out = response.getWriter();
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        HttpSession session = request.getSession(true);
        Usuario user = (Usuario) session.getAttribute("usuario");

        JsonObject jsonUsuario = null;
        StringReader json = new StringReader(request.getParameter("jsonUser"));

        try (JsonReader jsonReader = Json.createReader(json))
        {
            jsonUsuario = jsonReader.readObject();
            nombre = jsonUsuario.getString("nombre");
            apellidop = jsonUsuario.getString("apellidop");
            apellidom = jsonUsuario.getString("apellidom");
            fecNac = jsonUsuario.getString("fecNac");
            id 			= jsonUsuario.getString("idUser");
            password = jsonUsuario.getString("password");
            email = jsonUsuario.getString("email");
            comando		= jsonUsuario.getInt("accion");
        }
        catch (JsonException e)
        {
            e.printStackTrace();
        }

        user = new Usuario(id, nombre, apellidop, apellidom, fecNac, email, password);

        switch (comando)
        {
            // Crear nueva cuenta
            case 0:
                if (insertUsuario(user))
                {
                    rd.forward(request, response);
                    System.out.println("Usuario agregado");
                }
                break;
        }
    }

    private boolean insertUsuario(Usuario user)
    {
        boolean bool = false;
        String insert = "INSERT INTO usuario (idUsuario, nombre, apellidom, apellidop, fecha_nac, correo, password) "
                      + "VALUES (?,?,?,?,?,?,?) ";

        try
        {
            Connection con = DataAccess.getConexion();
            PreparedStatement ps = con.prepareStatement(insert);
            ps.setString(1, user.getIdUsuario());
            ps.setString(2, user.getNombre());
            ps.setString(3, user.getApellidoMat());
            ps.setString(4, user.getApellidoPat());
            ps.setString(5, user.getFechaNac());
            ps.setString(6, user.getCorreo());
            ps.setString(7, user.getPassword());
            ps.execute();
            ps.close();
            bool = true;
        }
        catch (SQLException e)
        {
            System.out.println("Error al agregar usuario: " + e.getMessage());
            e.printStackTrace();
        }

        return  bool;
    }
}
