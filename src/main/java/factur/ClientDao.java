package factur;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {

	
	
	public static Connection getConnection(){
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/electricite";
			conn = DriverManager.getConnection(url, "root","");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}
	
	
	
	public static int save(Client s){  
	    int status=0;  
	    try{  
	    	
	        Connection conn=getConnection();  
	        PreparedStatement ps=conn.prepareStatement(  
	"INSERT INTO client(nom, tel, ville,Adresse,categorie,nb_fil) VALUES(?,?,?,?,?,?)");  
	    
	        ps.setString(1,s.getNom());  
	        ps.setInt(2,s.getTel());  
	        ps.setString(3,s.getVille());  
	        ps.setString(4,s.getAdresse());  
	        ps.setString(5,s.getCategorie());
	        ps.setString(6,s.getFil()); 
	        
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}  
	
	
	static int code_client;
	public static int savecompteur(){  
	    int status=0;
	    
	    try{  
	    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	    	   LocalDateTime now = LocalDateTime.now();  
	    	  
	        Connection conn=getConnection();  
	        
	        PreparedStatement ps1=conn.prepareStatement("select max(id) as id from client");   
	        ResultSet rs=ps1.executeQuery();  
	        while(rs.next()){  
	            
	        	code_client=rs.getInt("id");  
	        }
	        PreparedStatement ps=conn.prepareStatement(  
	"INSERT INTO compteur(Date_placement,code_client) VALUES(?,?)");  
	    
	        ps.setString(1,dtf.format(now));
	           
	        ps.setInt(2,code_client);
	        
	        
	        
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}  
	
	static int code_compteur;
	public static int saveconsommation(){  
	    int status=0;
	    
	    try{  
	    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	    	   LocalDateTime now = LocalDateTime.now();  
	    	  
	        Connection conn=getConnection();  
	        
	        PreparedStatement ps1=conn.prepareStatement("select max(code_compteur) as code_compteur from compteur");   
	        ResultSet rs=ps1.executeQuery();  
	        while(rs.next()){  
	            
	        	code_compteur=rs.getInt("code_compteur");  
	        }
	        PreparedStatement ps=conn.prepareStatement(  
	"INSERT INTO consommation(code_compteur,date_changement) VALUES(?,?)");  
	    
	        ps.setInt(1,code_compteur);
	        ps.setString(2,dtf.format(now));
	           
status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}  
	
	
	
	
	
	
	
	public static int update(Client s){  
	    int status=0;  
	    try{  
	        Connection conn=getConnection();  
	        PreparedStatement ps=conn.prepareStatement(  
	"update client set nom=?,tel=?,ville=?,adresse=?,categorie=?,nb_fil=? where id=?");  
	      
	        ps.setString(1,s.getNom());  
	        ps.setInt(2,s.getTel());  
	        ps.setString(3,s.getVille());  
	        ps.setString(4,s.getAdresse());  
	        ps.setString(5,s.getCategorie());
	        ps.setString(6,s.getFil()); 
	        ps.setInt(7,s.getId()); 
	        
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}  
	
	
	
	
	
		
	
	public static int delete(Client s){  
	    int status=0;  
	    try{  
	        Connection conn=getConnection();  
	        PreparedStatement ps=conn.prepareStatement("delete from client where id=?");  
	        ps.setInt(1,s.getId());  
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	  
	    return status;  
	}
	
	
	
	
	

	
	
	
	public static List<Client> getAllRecords(){  
	    List<Client> list=new ArrayList<Client>();  
	      
	    try{  
	        Connection conn=getConnection();  
	        PreparedStatement ps=conn.prepareStatement("SELECT * FROM `client` ");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	        	Client s=new Client();  
	            s.setId(rs.getInt("id"));  
	            s.setNom(rs.getString("nom")); 
	            s.setTel(rs.getInt("tel"));  
	            s.setVille(rs.getString("ville"));  
	            s.setAdresse(rs.getString("Adresse"));  
	            s.setCategorie(rs.getString("categorie"));  
	            s.setFil(rs.getString("nb_fil"));  
	            list.add(s);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}  
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	public static Client getRecordById(int id){  
		Client s=null;  
	    try{  
	        Connection conn=getConnection();  
	        PreparedStatement ps=conn.prepareStatement("select * from client where id=?");  
	        ps.setInt(1,id);  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            s=new Client();  
	            s.setId(rs.getInt("id"));  
	            s.setNom(rs.getString("nom")); 
	            s.setTel(rs.getInt("tel"));  
	            s.setVille(rs.getString("ville"));  
	            s.setAdresse(rs.getString("Adresse"));
	            s.setCategorie(rs.getString("categorie"));
	            s.setFil(rs.getString("nb_fil"));
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return s;  
	}  
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
