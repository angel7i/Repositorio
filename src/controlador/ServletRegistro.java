package controlador;


import modelo.BeanRegistro;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/controladorR")

public class ServletRegistro extends HttpServlet
{

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
        String nombre=null;
        String apellidop=null;
        String apellidom=null;
        String fecNac=null;
        String idUsuario=null;
        String password1=null;
        String password2=null;
        String correo=null;
        String mensaje=null;

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        HttpSession ses = request.getSession(true);
        BeanRegistro usuario = null;
        usuario = new BeanRegistro();

		JSONObject jsonUsuario;

		try
		{
		 	jsonUsuario = new JSONObject(request.getParameter("jsonUsuario"));
			nombre 			= jsonUsuario.getString("nombre");
			apellidop 			= jsonUsuario.getString("apellidop");
                        apellidom 			= jsonUsuario.getString("apellidom");
                        fecNac 			= jsonUsuario.getString("fecNac");
                        idUsuario 			= jsonUsuario.getString("idUsuario");
                        password1 			= jsonUsuario.getString("password1");
                        password2 			= jsonUsuario.getString("password2");
                        correo 			= jsonUsuario.getString("correo");
                        
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

	    if(nombre==null) nombre="";
	    if(apellidop==null) apellidop="";
            if(apellidom==null) apellidom="";
            if(fecNac==null) fecNac="1990-06-06";
            if(idUsuario==null) idUsuario="";
            if(password1==null) password1="";
            if(password2==null) password2="";
            if(correo==null) correo="";
            

                                boolean bandera=false;
                                bandera=usuario.read(idUsuario);
                                if(bandera==true){
                                    try
					{
						JSONObject jsonRespuesta = new JSONObject();
						jsonRespuesta.put("nombre",usuario.getNombre());
						jsonRespuesta.put("apellidop", usuario.getApellidop());
                                                jsonRespuesta.put("apellidom",usuario.getApellidom());
						System.out.println("usuario ya registrado");
						out.print("El Usuario ya est� registrado con esa boleta");

					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
                                }
                                else{
        	
				usuario.add(nombre,apellidop,apellidom,fecNac,idUsuario,password1,password2,correo);
				try
					{
						JSONObject jsonRespuesta = new JSONObject();
						jsonRespuesta.put("nombre",usuario.getNombre());
						jsonRespuesta.put("apellidop", usuario.getApellidop());
                                                jsonRespuesta.put("apellidom",usuario.getApellidom());
						System.out.println("regitro usuario bien");
						out.print("Registro exitoso, revise su correo");

					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
                                
                                    }
				
			
			
			
			

        
    }



}
