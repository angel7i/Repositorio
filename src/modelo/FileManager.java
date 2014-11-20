package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager
{
    private Connection connection;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    
    public FileManager() 
    {
        connection = DataAccess.getConexion();
    }

    public void addFile(Archivo file)
    {
        int id = 1;

        try
        {
            ps = connection.prepareStatement("INSERT INTO archivo (idArchivo, idUsuario, idMaestro, idMateria, idTipo, " +
                                             "nombre, ruta, fecha, grupo, descripcion, parcial, peso) " +
                                             "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");

            st = connection.createStatement();
            rs = st.executeQuery("SELECT MAX(idArchivo) AS idArchivo FROM archivo ");

            if (rs.first())
            {
                id = rs.getInt("idArchivo") + 1;
            }

            ps.setInt(1, id);
            ps.setString(2, file.getIdUsuario());
            ps.setString(3, file.getIdMaestro());
            ps.setString(4, file.getMateria());
            ps.setInt(5, getType(file.getIdTipo()));
            ps.setString(6, file.getNombre());
            ps.setString(7, file.getRuta());
            ps.setString(8, file.getFecha());
            ps.setString(9, file.getGrupo());
            ps.setString(10, file.getDescripcion());
            ps.setString(11, file.getParcial());
            ps.setString(12, file.getPeso());
            ps.executeUpdate();
            ps.close();
            st.close();
            rs.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void deleteFile(int fileId)
    {
        try
        {
            ps = connection.prepareStatement("DELETE FROM archivo WHERE idArchivo=? ");
            ps.setInt(1, fileId);
            ps.executeUpdate();
            ps.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void updateFile(Archivo file)
    {
        try
        {
            ps = connection.prepareStatement("UPDATE archivo " +
                                             "SET nombre=?, fecha=?, grupo=?, descripcion=?, parcial=? " +
                                             "WHERE idArchivo=? ");
            ps.setString(1, file.getNombre());
            ps.setString(2, file.getFecha());
            ps.setString(3, file.getGrupo());
            ps.setString(4, file.getDescripcion());
            ps.setString(5, file.getParcial());
            ps.setInt(6, file.getIdArchivo());
            ps.executeUpdate();
            ps.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public List<Archivo> getFilesByUser(String user)
    {
        List<Archivo> files = new ArrayList<>();

        try
        {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT * FROM archivo WHERE idUsuario = '" + user + "' ");
            
            while (rs.next()) 
            {
                Archivo file = new Archivo();
                file.setIdArchivo(rs.getInt("idArchivo"));
                file.setIdUsuario(rs.getString("idUsuario"));
                file.setIdMaestro(rs.getString("idMaestro"));
                file.setMateria(getMateria(rs.getString("idMateria")));
                file.setIdTipo(rs.getString("idTipo"));
                file.setNombre(rs.getString("nombre"));
                file.setRuta(rs.getString("ruta"));
                file.setFecha(rs.getString("fecha"));
                file.setGrupo(rs.getString("grupo"));
                file.setDescripcion(rs.getString("descripcion"));
                file.setParcial(rs.getString("parcial"));
                file.setPeso(rs.getString("peso"));
                files.add(file);
            }

            st.close();
            rs.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return files;
    }

    public List<Archivo> getFilesByNivel(String nivel)
    {
        List<Archivo> files = new ArrayList<>();

        try
        {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT a.idArchivo, a.idUsuario, a.idMaestro, a.idMateria, " +
                                 "a.idTipo, a.nombre, a.ruta, a.fecha, a.grupo, " +
                                 "a.descripcion, a.parcial, a.peso  " +
                                 "FROM archivo a " +
                                 "JOIN materia m " +
                                 "ON a.idMateria = m.idMateria " +
                                 "WHERE m.nivel = '" + nivel + "'");

            while (rs.next())
            {
                Archivo file = new Archivo();
                file.setIdArchivo(rs.getInt("idArchivo"));
                file.setIdUsuario(rs.getString("idUsuario"));
                file.setIdMaestro(rs.getString("idMaestro"));
                file.setMateria(getMateria(rs.getString("idMateria")));
                file.setIdTipo(rs.getString("idTipo"));
                file.setNombre(rs.getString("nombre"));
                file.setRuta(rs.getString("ruta"));
                file.setFecha(rs.getString("fecha"));
                file.setGrupo(rs.getString("grupo"));
                file.setDescripcion(rs.getString("descripcion"));
                file.setParcial(rs.getString("parcial"));
                file.setPeso(rs.getString("peso"));
                files.add(file);
            }

            st.close();
            rs.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return files;
    }

    public List<Archivo> getFilesByMateria(String materia)
    {
        List<Archivo> files = new ArrayList<>();

        try
        {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT a.idArchivo, a.idUsuario, a.idMaestro, a.idMateria, " +
                                 "a.idTipo, a.nombre, a.ruta, a.fecha, a.grupo, " +
                                 "a.descripcion, a.parcial, a.peso  " +
                                 "FROM archivo a " +
                                 "JOIN materia m " +
                                 "ON a.idMateria = m.idMateria " +
                                 "WHERE m.nombre = '" + materia + "'");

            while (rs.next())
            {
                Archivo file = new Archivo();
                file.setIdArchivo(rs.getInt("idArchivo"));
                file.setIdUsuario(rs.getString("idUsuario"));
                file.setIdMaestro(rs.getString("idMaestro"));
                file.setMateria(getMateria(rs.getString("idMateria")));
                file.setIdTipo(rs.getString("idTipo"));
                file.setNombre(rs.getString("nombre"));
                file.setRuta(rs.getString("ruta"));
                file.setFecha(rs.getString("fecha"));
                file.setGrupo(rs.getString("grupo"));
                file.setDescripcion(rs.getString("descripcion"));
                file.setParcial(rs.getString("parcial"));
                file.setPeso(rs.getString("peso"));
                files.add(file);
            }

            st.close();
            rs.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return files;
    }

    public List<Archivo> getFilesByMaestro(String maestro)
    {
        List<Archivo> files = new ArrayList<>();

        try
        {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT a.idArchivo, a.idUsuario, a.idMaestro, a.idMateria, " +
                                 "a.idTipo, a.nombre, a.ruta, a.fecha, a.grupo, " +
                                 "a.descripcion, a.parcial, a.peso  " +
                                 "FROM archivo a " +
                                 "JOIN usuario_maestro um " +
                                 "ON a.idMaestro = um.idUsuario_Maestro " +
                                 "JOIN usuario u " +
                                 "ON um.idUsuario_Maestro = u.idUsuario " +
                                 "WHERE concat(u.nombre,' ',apellidop,' ',apellidom)  = '" + maestro + "' " +
                                 "GROUP BY idArchivo ");

            while (rs.next())
            {
                Archivo file = new Archivo();
                file.setIdArchivo(rs.getInt("idArchivo"));
                file.setIdUsuario(rs.getString("idUsuario"));
                file.setIdMaestro(rs.getString("idMaestro"));
                file.setMateria(getMateria(rs.getString("idMateria")));
                file.setIdTipo(rs.getString("idTipo"));
                file.setNombre(rs.getString("nombre"));
                file.setRuta(rs.getString("ruta"));
                file.setFecha(rs.getString("fecha"));
                file.setGrupo(rs.getString("grupo"));
                file.setDescripcion(rs.getString("descripcion"));
                file.setParcial(rs.getString("parcial"));
                file.setPeso(rs.getString("peso"));
                files.add(file);
            }

            st.close();
            rs.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return files;
    }

    public List<Archivo> getAllFiles()
    {
        List<Archivo> files = new ArrayList<>();

        try
        {
            st = connection.createStatement();
            rs = st.executeQuery("SELECT * FROM archivo ");

            while (rs.next())
            {
                Archivo file = new Archivo();
                file.setIdArchivo(rs.getInt("idArchivo"));
                file.setIdUsuario(rs.getString("idUsuario"));
                file.setIdMaestro(rs.getString("idMaestro"));
                file.setMateria(getMateria(rs.getString("idMateria")));
                file.setIdTipo(rs.getString("idTipo"));
                file.setNombre(rs.getString("nombre"));
                file.setRuta(rs.getString("ruta"));
                file.setFecha(rs.getString("fecha"));
                file.setGrupo(rs.getString("grupo"));
                file.setDescripcion(rs.getString("descripcion"));
                file.setParcial(rs.getString("parcial"));
                file.setPeso(rs.getString("peso"));
                files.add(file);
            }

            st.close();
            rs.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return files;
    }

    public String getMateria(String id)
    {
        String materia = "N/A";

        try
        {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT m.nombre FROM materia m " +
                                                         "JOIN archivo a " +
                                                         "ON a.idMateria = m.idMateria " +
                                                         "WHERE m.idMateria = '" + id + "'");

            if (resultSet.first())
                materia = resultSet.getString("nombre");

            statement.close();
            resultSet.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return  materia;
    }

    public int getType(String type)
    {
        int typeint = 0;

        switch (type)
        {
            case "image/jpeg":
                typeint = 1;
                break;
            case "image/png":
                typeint = 2;
                break;
            case "image/gif":
                typeint = 3;
                break;
            case "application/pdf":
                typeint = 4;
                break;
            case "text/plain":
                typeint = 5;
                break;
            case "text/css":
                typeint = 6;
                break;
            case "text/html":
                typeint = 7;
                break;
            case "text/xml":
                typeint = 8;
                break;
        }

        return typeint;
    }
}
