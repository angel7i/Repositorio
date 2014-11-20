package controlador;

import modelo.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")

public class ServletIdentificar extends HttpServlet implements Servlet
{
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        //System.out.println("Sevlet de Identificación");

        if (request.getParameter("usuario") != null && request.getParameter("password") != null)
        {
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            usuario.setIdUsuario(request.getParameter("usuario"));
            usuario.setPassword(request.getParameter("password"));
            usuario.identificar(request, response);

            //System.out.println("User: " + usuario.getIdUsuario() + " Password: " + (usuario.getPassword().isEmpty() ?  "" : "#######"));

            if(usuario.isAutentico())
            {
                //System.out.println("Usuario registrado");

                request.setAttribute("name", usuario.getNombre() + " " + usuario.getApellidoPat());
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
                dispatcher.forward(request, response);
            }
            else
            {
                //System.out.println("Usuario no registrado");

                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
            }
        }
        else
        {
            //Redireccionamiento a la pagina de login
            //System.out.println("Parametros null");

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request,response);
    }
}
