package controlador;

import modelo.Archivo;
import modelo.Usuario;

import javax.json.Json;
import javax.json.JsonException;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

@WebServlet("/upload")
@MultipartConfig(fileSizeThreshold=1024*1024*1,	// 1MB
                 maxFileSize=1024*1024*200,		// 200MB
                 maxRequestSize=1024*1024*200)	// 200MB

public class ServletFile extends HttpServlet
{
    // Directorio de archivos
    private static final String SAVE_DIR = "Files";
    private static String NIVEL;
    private static String MAT;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        if (request.getParameter("info") != null)
        {
            JsonObject json = null;
            StringReader info = new StringReader(request.getParameter("info"));

            try (JsonReader jsonReader = Json.createReader(info))
            {
                json = jsonReader.readObject();
                NIVEL = json.getString("nivel");
                MAT = json.getString("materia");
            }
            catch (JsonException e)
            {
                e.printStackTrace();
            }

            return;
        }

        // gets absolute path of the web application
        String appPath = request.getServletContext().getRealPath("");

        // constructs path of the directory to save uploaded file
        String savePath = appPath + File.separator + SAVE_DIR + File.separator + NIVEL + File.separator + MAT;
        String filePath = null;

        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);

        if (!fileSaveDir.exists())
        {
            fileSaveDir.mkdir();
        }

        String fileName = null;
        String type = null;
        Long size = null;

        for (Part part : request.getParts())
        {
            fileName = extractFileName(part).replaceAll(" ", "");
            type = part.getContentType();
            size = part.getSize();
            System.out.println("Type: " + part.getContentType());
            System.out.println("Size: " + part.getSize());
            part.write(savePath + File.separator + fileName);
            filePath = SAVE_DIR + File.separator +  NIVEL + File.separator + MAT + File.separator + fileName;
        }

        Archivo file = null;

        if (filePath != null)
        {
            file = new Archivo();
            file.setIdUsuario(((Usuario)request.getSession().getAttribute("usuario")).getIdUsuario());
            file.setMateria(MAT);
            file.setRuta(filePath);
            file.setIdTipo(type);
            file.setPeso(size.toString());
            System.out.println("URL: " + filePath);
            NIVEL = null;
            MAT = null;
            getServletContext().setAttribute("file", file);
        }
        else
        {
            System.out.println("Error al subir el archivo");
            request.setAttribute("message", "Error al subir el archivo");
        }
    }

    /**
     * Extracts file name from HTTP header content-disposition
     */
    private String extractFileName(Part part)
    {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");

        for (String s : items)
        {
            if (s.trim().startsWith("filename"))
            {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }

        return "";
    }
}

