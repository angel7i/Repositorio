package modelo;

import java.sql.*;

public class BeanRegistro
{
	private String nombre="";
	private String apellidop="";
	private String apellidom="";
        private String fecNac="";
        private String idUsuario="";
        private String password1="";
        private String password2="";
        private String correo="";
        
        

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
        
        

	public void setApellidop(String apellidop)
	{
		this.apellidop = apellidop;
	}

	public void setApellidom(String apellidom)
	{
		this.apellidom = apellidom;
	}
        
        public void setFecNac(String fecNac)
	{
		this.fecNac = fecNac;
	}
        
        public void setIdUsuario(String idUsuario)
	{
		this.idUsuario = idUsuario;
	}
        
        public void setPassword1(String password1)
	{
		this.password1 = password1;
	}
        
        public void setPassword2(String password2)
	{
		this.password2 = password2;
	}
        
        public void setCorreo(String correo)
	{
		this.correo = correo;
	}

	
        
        
        
        public String getNombre()
	{
		return nombre;
	}

	public String getApellidop()
	{
		return apellidop;
	}

	public String getApellidom()
	{
		return apellidom;
	}
        
        public String getFecNac()
	{
		return fecNac;
	}
        
        public String getIdUsuario()
	{
		return idUsuario;
	}
        
        public String getPassword1()
	{
		return password1;
	}
        
        public String getPassword2()
	{
		return password2;
	}
        
        public String getCorreo()
	{
		return correo;
	}
       
               

	public void add(String nombre, String apellidop, String apellidom, String fecNac, String idUsuario, String password1, String password2, String correo)
	{
			this.nombre=nombre;
                        this.apellidom=apellidom;
                        this.apellidop=apellidop;
                        this.fecNac=fecNac;
                        this.idUsuario=idUsuario;
                        this.password1=password1;
                        this.password2=password2;
                        this.correo=correo;
                        

			try
			{

				Connection con = DataAccess.getConexion();

				if(con!=null)
				{
					PreparedStatement ps = con.prepareStatement("INSERT INTO usuario (idUsuario, nombre, apellidop, apellidom, fecha_nac, correo, password) VALUES (?,?,?,?,?,?,?)");
					ps.setString(1,idUsuario);
					ps.setString(2,nombre);
                                        ps.setString(3,apellidop);
                                        ps.setString(4,apellidom);
                                        ps.setString(5,fecNac);
                                        ps.setString(6,correo);
                                        ps.setString(7,password1);
                                        
					ps.execute();
					con.close();
				}
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
                               
				
			}
	}
        
        public boolean read(String boleta)
	{
		
		this.idUsuario = boleta;

		try
		{

			Connection con = DataAccess.getConexion();
			if(con != null)
			{
				PreparedStatement ps = con.prepareStatement("select *from usuario where idUsuario = ?");
				ps.setString(1,idUsuario);

				ps.executeQuery();
				ResultSet rs = ps.getResultSet();
				if(rs.next())
				{
                                        
                                        con.close();
					return true;
					
				}
				else {con.close(); return false;}
				
                                
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return false;

		}
              return false;
	}


	/*public void reset()
	{
		this.id = "";
		this.descripcion="";
		this.mensaje="";
	}

	public static String[][] readAll()
	{


		try
		{

			Connection con = DataAccess.obtieneConexionDelPool();
			if(con != null)
			{
				Statement st = con.createStatement();
				st.executeQuery("select * from productos order by id");
				ResultSet rs = st.getResultSet();
				String[][] data = null;

				if(rs.next())
				{
					rs.last();
					int rows = rs.getRow();
					if(rows > 0)
					{
						data = new String[rows][2];
						rs.beforeFirst();
						rows=0;
						while(rs.next())
						{
							data[rows][0] = rs.getString("id");
							data[rows][1] = rs.getString("descripcion");
							rows++;
						}

					}

				}
				con.close();
				return data;
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return null;
	}*/
}


