package mailer;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

import modelo.*;

import org.json.*;

import javax.servlet.annotation.WebServlet;

// Java Mail Packages

import javax.mail.*;
import javax.mail.internet.*;
@WebServlet("/recuperaS")

public class ServletCarteroR extends HttpServlet
{

    private static final String SMTP_HOST_NAME 	= "smtp.gmail.com"; 	// Servidor de Correo GMAIL
    private static final int SMTP_HOST_PORT 	= 465;				    // Puerto de Salida de Correo
    private static final String SMTP_AUTH_USER 	= "correopractica8web@gmail.com"; // Cuenta de Correo GMAIL
    private static final String SMTP_AUTH_PWD  	= "contrasena1"; // Contrase�a de la cuenta
	
    
    String correo=null;
    

    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
    	processRequest(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        

       
        
       

		JSONObject jsonUsuarioC;

		try
		{
		 	jsonUsuarioC = new JSONObject(request.getParameter("jsonUsuario"));
			
                        correo 			= jsonUsuarioC.getString("correor");
                        
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

	    
            if(correo==null) correo="";
            
            
            
    	processRequest(request, response);
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {	
        String to=correo; 		
    	String subject="Recuperacion de datos"; 	
    	String body="Sus datos son: <br> <br> "; 
		
    	response.setContentType("text/html");
    	PrintWriter out = response.getWriter();
		
        
        try
		{

			Connection con = DataAccess.getConexion();
			if(con != null)
			{
				PreparedStatement ps = con.prepareStatement("select idUsuario, password from usuario where correo = ?");
				ps.setString(1,correo);

				ps.executeQuery();
				ResultSet rs = ps.getResultSet();
				while(rs.next())
				{
					body = body + "usuario: " + rs.getString("idUsuario") + "<br><br>";
                                        body = body + "password: " + rs.getString("password") + "<br><br>";
                                       
										
				}
                                
				
				con.close();
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			

		}
        
        System.out.println("correo por enviar a " + correo + body);
    	String[] direcciones = to.split(",|;");  // Separa las direcciones si se utilizo coma(,) o punto y coma(;) para separarlas


    	if(to != null && subject != null && body != null)
    		sendEmail(direcciones, subject, body, out);

        
	}

   	// Metodo para enviar el correo

    public static void sendEmail(String[] direcciones, String subject, String body, PrintWriter out)
    {
        Properties props = new Properties();

		String signature = "<br><hr><p style=\"font-size: small; color: #660033\" >Powered by JavaMail</p><img src=\"http://kenai.com/attachments/wiki_images/chessgame/java-duke-logo.png\" />";

		body+=signature;
		try
		{

        	props.put("mail.transport.protocol", "smtps");
        	props.put("mail.smtps.host", SMTP_HOST_NAME);
        	props.put("mail.smtps.auth", "true");

        	Session mailSession = Session.getDefaultInstance(props);
        	Transport transport = mailSession.getTransport();

        	MimeMessage message = new MimeMessage(mailSession);
        	message.setSubject(subject);
        	message.setContent(body, "text/html");

            // Agrega las direcciones de destinatarios

			InternetAddress to[] = new InternetAddress[direcciones.length];

			for(int i=0;i<direcciones.length;i++)
				to[i] = new InternetAddress(direcciones[i]);

        	message.addRecipients(Message.RecipientType.TO, to);

        	transport.connect(SMTP_HOST_NAME, SMTP_HOST_PORT, SMTP_AUTH_USER, SMTP_AUTH_PWD);

        	transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
        	transport.close();
		}
        catch(Exception ex)
        {
        	ex.printStackTrace(out);
        }
    }
	
	
}