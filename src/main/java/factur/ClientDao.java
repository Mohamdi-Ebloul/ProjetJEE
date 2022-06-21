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
	

	

	
	static int code_client;
	static int code_compteur;
	public static int save(Client s){  
	    int status=0;  
	    try{  
	    	
	        Connection conn=getConnection();  
	        PreparedStatement ps=conn.prepareStatement(  
	"INSERT INTO client(nom, tel, ville,Adresse,categorie) VALUES(?,?,?,?,?)");  
	    
	        ps.setString(1,s.getNom());  
	        ps.setInt(2,s.getTel());  
	        ps.setString(3,s.getVille());  
	        ps.setString(4,s.getAdresse());  
	        ps.setString(5,s.getCategorie());
	        
	        
	        status=ps.executeUpdate();  
	        
	        if(status!=0) {
	        	 
		    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		    	   LocalDateTime now = LocalDateTime.now();  
		    	   
		        
		        PreparedStatement ps1=conn.prepareStatement("select max(id) as id from client");   
		        ResultSet rs=ps1.executeQuery();  
		        while(rs.next()){  
		            
		        	code_client=rs.getInt("id");  
		        }
		        PreparedStatement ps2=conn.prepareStatement(  
		"INSERT INTO compteur(nb_fil,Date_placement,status,code_client) VALUES(?,?,?,?)");  
		      
		        ps2.setInt(1,s.getFil()); 
		        ps2.setString(2,dtf.format(now));
		        ps2.setString(3,"Active");   
		        ps2.setInt(4,code_client);
		        
		        ps2.executeUpdate(); 
		        
		        PreparedStatement ps3=conn.prepareStatement("select max(code_compteur) as code_compteur from compteur");   
		        ResultSet rs2=ps3.executeQuery();  
		        while(rs2.next()){  
		            
		        	code_compteur=rs2.getInt("code_compteur");  
		        }
		        PreparedStatement ps4=conn.prepareStatement(  
		"INSERT INTO consommation(code_compteur,date_changement) VALUES(?,?)");  
		    
		        ps4.setInt(1,code_compteur);
		        ps4.setString(2,dtf.format(now));
		           
	status=ps4.executeUpdate();  
		        
		        
	        }
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}  
	
	

	
	public static int update(Client s){  
	    int status=0;  
	    try{  
	        Connection conn=getConnection();  
	        PreparedStatement ps=conn.prepareStatement(  
	"update client set nom=?,tel=?,ville=?,adresse=?,categorie=? where id=?");  
	      
	        ps.setString(1,s.getNom());  
	        ps.setInt(2,s.getTel());  
	        ps.setString(3,s.getVille());  
	        ps.setString(4,s.getAdresse());  
	        ps.setString(5,s.getCategorie());
	        ps.setInt(6,s.getId()); 
	        
	        status=ps.executeUpdate(); 
	        PreparedStatement ps1=conn.prepareStatement(  
	        		"update compteur set nb_fil=? where code_client=?");  
	        		      
	        		          
	        		        ps1.setInt(1,s.getFil());  
	        		        
	        		        ps1.setInt(2,s.getId()); 
	        		        
	        		        status=ps1.executeUpdate(); 
	        
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
	        PreparedStatement ps=conn.prepareStatement("SELECT * FROM client,compteur where client.id=compteur.code_client ");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	        	Client s=new Client();  
	            s.setId(rs.getInt("id"));
	            s.setReference(rs.getInt("code_compteur"));
	            s.setFil(rs.getInt("nb_fil")); 
	            s.setNom(rs.getString("nom")); 
	            s.setTel(rs.getInt("tel"));  
	            s.setVille(rs.getString("ville"));  
	            s.setAdresse(rs.getString("Adresse"));  
	            s.setCategorie(rs.getString("categorie"));  
	             
	            list.add(s);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}  
	


	static int R=0;
	public static int selectbyid(Client c){ 
		
	
		try { Connection conn=getConnection(); 
		 PreparedStatement ps1=conn.prepareStatement("select * from client,compteur where compteur.code_compteur=?");
	        ps1.setInt(1,c.getId());
	        
	        ResultSet rs=ps1.executeQuery();  
	        while(rs.next()){  
	        	 
	        	R=rs.getInt("code_client"); 
	        }
		}catch(Exception e){System.out.println(e);} 
	    return R;  
	}  
	
	
	
	public static Client getRecordById(int id){  
		Client s=null;  
	    try{  
	        Connection conn=getConnection();  
	        PreparedStatement ps=conn.prepareStatement("select * from client,compteur where id=? and compteur.code_client=?");  
	        ps.setInt(1,id);
	        ps.setInt(2,id);
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            s=new Client();  
	            s.setId(rs.getInt("id"));  
	            s.setNom(rs.getString("nom")); 
	            s.setTel(rs.getInt("tel"));  
	            s.setVille(rs.getString("ville"));  
	            s.setAdresse(rs.getString("Adresse"));
	            s.setCategorie(rs.getString("categorie"));
	            s.setFil(rs.getInt("nb_fil"));
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return s;  
	}  
	
	
	
	

	
	
	
	
	
}
