package modelo;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;

public class DataAccess
{
    public static Connection getConexion()
    {
        Connection con = null;

        try
        {
            // Acceso al POOL DE CONEXIONES
            // Obtiene el contexto del Servidor
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");

            // Obtiene el DataSource del contexto
            DataSource ds = (DataSource) envCtx.lookup("jdbc/Repositorio");

            // Se obtiene una conexion al DataSource
            con = ds.getConnection();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return con;
    }
}
