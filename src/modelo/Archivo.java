package modelo;


public class Archivo
{
    private int idArchivo;
    private String idUsuario;
    private String idTipo;
    private String idMaestro;
    private String nombre;
    private String ruta;
    private String fecha;
    private String grupo;
    private String descripcion;
    private String parcial;
    private String peso;
    private String materia;

    public Archivo() {}

    public Archivo(String path)
    {
        this.ruta = path;
    }

    public int getIdArchivo()
    {
        return idArchivo;
    }
    public void setIdArchivo(int idArchivo)
    {
        this.idArchivo = idArchivo;
    }

    public String getIdUsuario()
    {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario)
    {
        this.idUsuario = idUsuario;
    }

    public String getIdTipo()
    {
        return idTipo;
    }

    public void setIdTipo(String idTipo)
    {
        this.idTipo = idTipo;
    }

    public String getIdMaestro()
    {
        return idMaestro;
    }

    public void setIdMaestro(String idMaestro)
    {
        this.idMaestro = idMaestro;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getRuta()
    {
        return ruta;
    }

    public void setRuta(String ruta)
    {
        this.ruta = ruta;
    }

    public String getFecha()
    {
        return fecha;
    }

    public void setFecha(String fecha)
    {
        this.fecha = fecha;
    }

    public String getGrupo()
    {
        return grupo;
    }

    public void setGrupo(String grupo)
    {
        this.grupo = grupo;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public String getParcial()
    {
        return parcial;
    }

    public void setParcial(String parcial)
    {
        this.parcial = parcial;
    }

    public String getPeso()
    {
        return peso;
    }

    public void setPeso(String peso)
    {
        this.peso = peso;
    }

    public String getMateria()
    {
        return materia;
    }

    public void setMateria(String materia)
    {
        this.materia = materia;
    }
}
