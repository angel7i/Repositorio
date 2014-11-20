package controlador;

import modelo.DataAccess;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/controladorMenu")

public class ServletMenu extends HttpServlet
{

    String opcion=null;
    String atributo=null;
    String tabla="";
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
		JSONObject jsonProducto;

		try
		{
		 	jsonProducto = new JSONObject(request.getParameter("jsonProducto"));
			opcion 	= jsonProducto.getString("opcion");
            atributo    =jsonProducto.getString("atributo");
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

		if(opcion==null) { opcion=""; }
        if(atributo==null) { atributo=""; }

        if("0".equals(opcion))
        {
            tabla=tabla+"<table id=\"rounded-corner\" ><thead><tr><th scope=\"col\" class=\"rounded-company\" >Materia</th><th scope=\"col\" class=\"rounded-q1\" >Nivel</th></tr></thead><tbody>";
            System.out.println("entro a opcion 0 switch busca: "+opcion+atributo);

            try
            {
                Connection con = DataAccess.getConexion();

                if(con!=null)
                {
                    PreparedStatement ps = con.prepareStatement("select  nombre, nivel from materia where nivel = ?");
                    ps.setString(1,atributo);
                    ps.executeQuery();
                    ResultSet rs = ps.getResultSet();

                    while(rs.next())
                    {
                        tabla = tabla+"<tr><td>"+rs.getString("nombre")+"</td><td>"+rs.getString("nivel")+"</td></tr>";
                    }

                    tabla=tabla+"</tbody></table>";
                }

                con.close();
                System.out.println("entro a opcion 0 consulta");

            }
            catch (Exception ex)
            {
                ex.printStackTrace();
                System.out.println("entro a opcion 0 excepcion");
            }

        }
        else if("1".equals(opcion))
        {
            System.out.println("entro a opcion 1 switch busca " +opcion +atributo);
            tabla=tabla+"<table id=\"rounded-corner\" ><thead><tr><th scope=\"col\" class=\"rounded-company\" colspan=\"3\" >Maestro</th><th scope=\"col\" class=\"rounded-q1\" >Materia</th></tr></thead><tbody>";

            try
            {
                Connection con = DataAccess.getConexion();

                if(con!=null)
                {
                    PreparedStatement ps = con.prepareStatement("select  u.nombre maestro, u.apellidop apellidopat, u.apellidom apellidomat, m.nombre materia from usuario u, materia m, usuario_maestro um where m.nombre = ? and (u.idUsuario = um.idUsuario_Maestro) and (um.idMateria = m.idMateria)");
                    ps.setString(1,atributo);

                                     ps.executeQuery();
                ResultSet rs = ps.getResultSet();
                while(rs.next())
                {
                                    tabla=tabla+"<tr><td>"+rs.getString("maestro")+"</td><td>"+rs.getString("apellidopat")+"</td><td>"+rs.getString("apellidomat")+ "</td><td>"+rs.getString("materia")+"</td></tr>";


                }
                                tabla=tabla+"</tbody></table>";

                }
                                con.close();
                                System.out.println("entro a opcion 0 consulta");
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
                               System.out.println("entro a opcion 0 excepcion");

            }
        }
        else
        {
            System.out.println("entro a default switch busca "+opcion +atributo);
            //opcion es 2 para todos los datos para que entre a este else
            //atributo identifica al maestro ejemplo: atributo=Alejandro Botello Castillo  hay que separar el nombre, apellidop, apellidom para la consulta sql

            // tabla=tabla+"<table><th><td>Maestro</td></th><th><td>Materia</td></th>";
        }

        try
        {
            JSONObject jsonRespuesta = new JSONObject();
            jsonRespuesta.put("tabla",tabla);

            //out.print(jsonRespuesta);

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        		
        out.print(tabla);
        tabla="";
    }
}
