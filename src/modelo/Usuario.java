package modelo;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Usuario
{
    private String idUsuario;
    private String nombre;
    private String apellidoPat;
    private String apellidoMat;
    private String fechaNac;
    private String correo;
    private String fb;
    private String tweeter;
    private String password;
    private String imagen;
    private String cookie;
    private HttpServletRequest request;
    private boolean autentico;

    public Usuario()
    {
        idUsuario = null;
        password = null;
        autentico = false;
    }

    public Usuario(String idUsuario, String nombre, String apellidoPat, String apellidoMat, String fechaNac, String correo, String password)
    {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.fechaNac = fechaNac;
        this.correo = correo;
        this.password = password;
        autentico = false;
    }

    public String getIdUsuario()
    {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario)
    {
        if (idUsuario != null)
            this.idUsuario = idUsuario;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        if (nombre != null)
            this.nombre = nombre;
    }


    public String getApellidoPat()
    {
        return apellidoPat;
    }

    public void setApellidoPat(String apellidoPat)
    {
        if (apellidoPat != null)
            this.apellidoPat = apellidoPat;
    }

    public String getApellidoMat()
    {
        return apellidoMat;
    }

    public void setApellidoMat(String apellidoMat)
    {
        if (apellidoMat != null)
            this.apellidoMat = apellidoMat;
    }

    public String getFechaNac()
    {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac)
    {
        if (fechaNac != null)
            this.fechaNac = fechaNac;
    }

    public String getCorreo()
    {
        return correo;
    }

    public void setCorreo(String correo)
    {
        if (correo != null)
            this.correo = correo;
    }

    public String getFb()
    {
        return fb;
    }

    public void setFb(String fb)
    {
        if (fb != null)
            this.fb = fb;
    }

    public String getTweeter()
    {
        return tweeter;
    }

    public void setTweeter(String tweeter)
    {
        if (tweeter != null)
            this.tweeter = tweeter;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        if (password != null)
            this.password = password;
    }

    public String getImagen()
    {
        return imagen;
    }

    public void setImagen(String imagen)
    {
        if (imagen != null)
            this.imagen = imagen;
    }

    public boolean isAutentico()
    {
        return autentico;
    }

    public void setRequest(HttpServletRequest request)
    {
       this.request = request;
    }

    public String getCookie(HttpServletRequest request)
    {
        String nombreCookie = "user";
        Cookie[] cookies = request.getCookies();

        if (cookies != null)
        {
            for (int i=0; i<cookies.length; i++)
            {
                Cookie cookie = cookies[i];

                if (nombreCookie.equals(cookie.getName()))
                {
                    this.cookie = cookie.getValue();

                    return cookie.getValue();
                }
            }
        }

        return null;
    }

    public String getCookie()
    {
        if (request != null)
        {
            cookie = getCookie(this.request);

            if (cookie != null)
            {
                return cookie;
            }
        }

        return "";
    }

    public void setCookie(HttpServletResponse response)
    {
        if (autentico && idUsuario != null)
        {
            Cookie cookie = new Cookie("user", idUsuario);
            cookie.setMaxAge(3600);
            cookie.setComment("Cookie creada desde el BEAN Identificar");
            cookie.setSecure(false);
            response.addCookie(cookie);
        }
    }

    public void identificar(HttpServletRequest request, HttpServletResponse response)
    {
        this.request = request;

        if (idUsuario != null && !idUsuario.isEmpty())
        {
            try
            {
                Connection conn = DataAccess.getConexion();

                if (conn != null)
                {
                    Statement stmt = conn.createStatement();
                    boolean r = stmt.execute("SELECT * FROM usuario WHERE idUsuario = '" + this.idUsuario + "'");

                    if (r)
                    {
                        ResultSet rs = stmt.getResultSet();

                        if (rs.next())
                        {
                            String pass = rs.getString("password").trim();
                            password = password.trim();

                            if (pass.equals(password))
                            {
                                autentico = true;
                                this.nombre   = rs.getString("nombre");
                                this.apellidoPat = rs.getString("apellidop");
                                this.apellidoMat = rs.getString("apellidom");
                                this.fechaNac = rs.getString("fecha_nac");
                                this.correo = rs.getString("correo");
                                this.fb = rs.getString("fb");
                                this.tweeter = rs.getString("tweeter");
                                this.password = pass;
                                setCookie(response);
                            }
                        }
                    }

                    conn.close();
                }
                else
                    System.out.println("No hay conexion con la BD");
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public void reset()
    {
        idUsuario = null;
        password = null;
        nombre = null;
        autentico = false;
    }
}
