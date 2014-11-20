package controlador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import modelo.Archivo;
import modelo.FileManager;
import modelo.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@WebServlet("/controlFile")

public class ServletFileControlador extends HttpServlet
{
    private FileManager fm = new FileManager();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
//        System.out.println("action=" + request.getParameter("action"));
//        System.out.println("nivel=" + request.getParameter("nivel"));
//        System.out.println("materia=" + request.getParameter("materia"));
//        System.out.println("maestro=" + request.getParameter("maestro"));
        if(request.getParameter("action") != null)
        {
            Archivo file = (Archivo)getServletContext().getAttribute("file");
            List<Archivo> listFiles = fm.getAllFiles();
            String action = request.getParameter("action");
            Gson gson = new Gson();
            response.setContentType("application/json");

            switch (action)
            {
                case "listFiles":
                    try
                    {
                        String filtro = null;
                        if (request.getParameter("nivel") != null)
                        {
                            filtro = request.getParameter("nivel");
                            listFiles = fm.getFilesByNivel(filtro);
                        }
                        else if (request.getParameter("materia") != null)
                        {
                            filtro = request.getParameter("materia");
                            listFiles = fm.getFilesByMateria(filtro);
                        }
                        else if (request.getParameter("maestro") != null)
                        {
                            filtro = request.getParameter("maestro");
                            listFiles = fm.getFilesByMaestro(filtro.trim());
                        }
                        else
                        {
                            listFiles = fm.getAllFiles();
                        }

                        System.out.println("list: " + filtro);
                        //Convert Java Object to Json
                        JsonElement element = gson.toJsonTree(listFiles, new TypeToken<List<Archivo>>() {}.getType());
                        JsonArray jsonArray = element.getAsJsonArray();
                        String listData = jsonArray.toString();
                        //Return Json in the format required by jTable plugin
                        listData = "{\"Result\":\"OK\",\"Records\":"+listData+",\"TotalRecordCount\":\""+listFiles.size()+"\"}";
                        response.getWriter().print(listData);
                    }
                    catch(Exception ex)
                    {
                        String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getMessage()+"}";
                        response.getWriter().print(error);
                        ex.printStackTrace();
                    }
                    break;

                case "listByUser":
                    try
                    {
                        //Fetch Data from Archivo Table
                        //System.out.println(((Usuario)request.getSession().getAttribute("usuario")).getIdUsuario());
                        listFiles = fm.getFilesByUser(((Usuario)request.getSession().getAttribute("usuario")).getIdUsuario());
                        //Convert Java Object to Json
                        JsonElement element = gson.toJsonTree(listFiles, new TypeToken<List<Archivo>>() {}.getType());
                        JsonArray jsonArray = element.getAsJsonArray();
                        String listData = jsonArray.toString();
                        //Return Json in the format required by jTable plugin
                        listData = "{\"Result\":\"OK\",\"Records\":"+listData+",\"TotalRecordCount\":\""+listFiles.size()+"\"}";
                        response.getWriter().print(listData);
                    }
                    catch(Exception ex)
                    {
                        String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getMessage()+"}";
                        response.getWriter().print(error);
                        ex.printStackTrace();
                    }
                    break;
                case "create":
                    try
                    {
                        if (file != null)
                        {
                            file = processArchivo(request, file);
                        }
                        else
                        {
                            System.out.println("file null");
                            String error = "{\"Result\":\"ERROR\",\"Message\":" + "No se ha cargado el archivo" + "}";
                            response.getWriter().print(error);

                            return;
                        }

                        fm.addFile(file);
                        listFiles.add(file);
                        //Convert Java Object to Json
                        String json = gson.toJson(file);
                        //Return Json in the format required by jTable plugin
                        String listData = "{\"Result\":\"OK\",\"Record\":" + json + "}";
                        response.getWriter().print(listData);
                    }
                    catch(Exception ex)
                    {
                        System.out.println(ex.getMessage());
                        String error = "{\"Result\":\"ERROR\",\"Message\":" + "No se ha cargado el archivo" + "}";
//                        String error = "{\"Result\":\"ERROR\",\"Message\":" + Arrays.toString(ex.getStackTrace()) + "}";
                        response.getWriter().print(error);
                    }
                    break;
                case "update":
                    try
                    {
                        if (file == null) { file = new Archivo(); }
                        file = processArchivo(request, file);
                        System.out.println("Update: " + file.getIdArchivo());
                        fm.updateFile(file);
                        String listData = "{\"Result\":\"OK\"}";
                        response.getWriter().print(listData);
                    }
                    catch(Exception ex)
                    {
                        String error = "{\"Result\":\"ERROR\",\"Message\":"+ Arrays.toString(ex.getStackTrace()) +"}";
                        response.getWriter().print(error);
                    }
                    break;
                case "delete":
                    try
                    {
                        if (request.getParameter("idArchivo") != null)
                        {
                            String id = request.getParameter("idArchivo");
                            System.out.println("Delete: " + id);
                            fm.deleteFile(Integer.parseInt(id));
                            String listData = "{\"Result\":\"OK\"}";
                            response.getWriter().print(listData);
                        }
                    }
                    catch(Exception ex)
                    {
                        String error = "{\"Result\":\"ERROR\",\"Message\":"+ Arrays.toString(ex.getStackTrace()) +"}";
                        response.getWriter().print(error);
                    }
                    break;
            }
        }
    }

    private Archivo processArchivo(HttpServletRequest request, Archivo file)
    {
        if (request.getParameter("idArchivo") != null)
        {
            int id = Integer.parseInt(request.getParameter("idArchivo"));
            file.setIdArchivo(id);
        }
        if (request.getParameter("idUsuario") != null)
        {
            String user = request.getParameter("idUsuario");
            file.setIdUsuario(user);
        }
        if (request.getParameter("idMaestro") != null)
        {
            String maestro = request.getParameter("idMaestro");
            file.setIdMaestro(maestro);
        }
        if (request.getParameter("nombre") != null)
        {
            String nombre = request.getParameter("nombre");
            file.setNombre(nombre);
        }
        if (request.getParameter("fecha") != null)
        {
            String fecha = request.getParameter("fecha");
            SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
            try
            {
                Date to = date.parse(fecha);
                date = new SimpleDateFormat("yyyy-MM-dd");
                file.setFecha(date.format(to));
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
            date = null;
        }
        if (request.getParameter("grupo") != null)
        {
            String grupo = request.getParameter("grupo");
            file.setGrupo(grupo);
        }
        if (request.getParameter("descripcion") != null)
        {
            String descripcion = request.getParameter("descripcion");
            file.setDescripcion(descripcion);
        }
        if (request.getParameter("parcial") != null)
        {
            String parcial = request.getParameter("parcial");
            file.setParcial(parcial);
        }

        return file;
    }
}
