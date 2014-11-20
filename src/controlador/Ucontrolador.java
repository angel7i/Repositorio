package controlador;

import modelo.Usuario;
import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class Ucontrolador extends HttpServlet
{

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
        String nombre = null;
        String apellidop = null;
        String apellidom = null;
        String fecNac = null;
        String id = null;
        String password = null;
        String email = null;
        String fb = null;
        String tweeter = null;
        
        int comando = -1;

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        HttpSession ses = request.getSession(true);
        Usuario user = (Usuario) ses.getAttribute("user");
        if(user == null)
        	user = new Usuario();

		JSONObject jsonUsuario;

		try
		{
	    jsonUsuario =new JSONObject(request.getParameter("jsonUsuario"));
            nombre = jsonUsuario.getString("nombre");
            apellidop = jsonUsuario.getString("apellidop");
            apellidom = jsonUsuario.getString("apellidom");
            fecNac = jsonUsuario.getString("fecNac");
            id 			= jsonUsuario.getString("idUser");
            password = jsonUsuario.getString("password");
            email = jsonUsuario.getString("email");
            fb = jsonUsuario.getString("fb");
            tweeter = jsonUsuario.getString("tweeter");
            
            comando		= jsonUsuario.getInt("accion");

		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

		if(nombre==null) nombre="";
		if(apellidop==null) apellidop="";
		if(apellidom==null) apellidom="";
		if(fecNac==null) fecNac="";
		if(id==null) id="";
		if(password==null) password="";
	    if(email==null) email="";
            if(fb==null) fb="";
            if(tweeter==null) tweeter="";

        switch(comando)
        {
        	case 1: //Consulta
        		{
//        			user.read(id);
					try
					{
						JSONObject jsonRespuesta = new JSONObject();
						jsonRespuesta.put("nombre",user.getNombre());
						jsonRespuesta.put("apellidop",user.getApellidoPat());
						jsonRespuesta.put("apellidom",user.getApellidoMat());
						jsonRespuesta.put("fecNac",user.getFechaNac());
						jsonRespuesta.put("idUser",user.getIdUsuario());
						jsonRespuesta.put("password",user.getPassword());
						jsonRespuesta.put("email",user.getCorreo());
                                                jsonRespuesta.put("fb",user.getFb());
                                                jsonRespuesta.put("tweeter",user.getTweeter());
						out.print(jsonRespuesta);

					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
        		}
			break;
			
			case 4: //actualiza
			{
//				user.update(nombre,apellidop,apellidom,fecNac,id,password,email,fb,tweeter);
				try
					{
						JSONObject jsonRespuesta = new JSONObject();
						jsonRespuesta.put("nombre",user.getNombre());
						jsonRespuesta.put("apellidop",user.getApellidoPat());
						jsonRespuesta.put("apellidom",user.getApellidoMat());
						jsonRespuesta.put("fecNac",user.getFechaNac());
						jsonRespuesta.put("idUser",user.getIdUsuario());
						jsonRespuesta.put("password",user.getPassword());
						jsonRespuesta.put("email",user.getCorreo());
						jsonRespuesta.put("fb",user.getFb());
                                                jsonRespuesta.put("tweeter",user.getTweeter());
						out.print(jsonRespuesta);

					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
				
			}
        }		
        }
    }
