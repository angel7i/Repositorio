package controlador;

import modelo.Usuario;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/home.jsp","/filesUser.jsp","/menu.html","/perfil.jsp","/menuperfil.html"} )

public class Filtro implements Filter
{
    public void init(FilterConfig filterConfig) throws ServletException
    {   }
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
    {
        //Obtenemos un objeto request de http, para poder acceder a la ruta
        //del contexto

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        //Obtenemos la sessión con la cual validaremos al usuario;

        HttpSession sesion = httpRequest.getSession();

        //Recuperamos el Bean usuario de los atributos de la sesion

        Usuario usuario = (Usuario) sesion.getAttribute("usuario");

        //Validamos que el usuario no sea nulo, ya que si es nulo quiere decir
        //que no se ha firmado aun

        if (usuario == null || (usuario != null && !usuario.isAutentico()))
        {
            System.out.println("Filtro: Llamar al Servlet Identificar");

            //Redirecciona a la pagina de inicio
            RequestDispatcher rd = httpRequest.getRequestDispatcher("index.jsp");
            //método que redirecciona
            rd.forward(request, response);

            //Si el usuario existe el filtro termina y cede el paso, por si exisite
            //un filtro adicional o simplemente continua con el flujo normal.

        }
        else
        {
            chain.doFilter(request, response);
        }
    }
    
    public void destroy()
    {	}
}
