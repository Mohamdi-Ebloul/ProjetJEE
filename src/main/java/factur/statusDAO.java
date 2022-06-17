package factur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class statusDAO {

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
	
	
	
	
	
	static int R=0;
	public static int selectsatusbyid(Client c){ 
		
	
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
	
	
	
	public static Client StatuById(int id){  
		Client s=null;  
	    try{  
	        Connection conn=getConnection();  
	        PreparedStatement ps=conn.prepareStatement("select * from compteur where compteur.code_client=?");  
	        ps.setInt(1,id);
	        
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            s=new Client();  
	            s.setReference(rs.getInt("code_compteur"));  
	             
	            s.setS(rs.getString("status"));  
	            
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return s;  
	}  

	
	public static Client activesatus(int id){  
		Client s=null; 
		int code=0;
	    try{  
	        Connection conn=getConnection();  
	        PreparedStatement ps2=conn.prepareStatement( "update compteur set status=? where compteur.code_compteur=?"); 

	        ps2.setString(1,"active");  
	        ps2.setInt(2,id);            
	         ps2.executeUpdate();
	    
	         PreparedStatement ps1=conn.prepareStatement("select * from client,compteur where compteur.code_compteur=?");
		        ps1.setInt(1,id);
		        
		        ResultSet rs1=ps1.executeQuery();  
		        while(rs1.next()){  
		        	 
		        	code=rs1.getInt("code_client"); 
		        }
	         
	         
	        PreparedStatement ps=conn.prepareStatement("select * from compteur where compteur.code_client=?");  
	        ps.setInt(1,code);
	        
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            s=new Client();  
	            s.setReference(rs.getInt("code_compteur"));  
	             
	            s.setS(rs.getString("status"));  
	            
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return s;  
	}  
	
	
	
	public static Client desactivesatus(int id){  
		Client s=null; 
		int code=0;
	    try{  
	        Connection conn=getConnection();  
	        PreparedStatement ps2=conn.prepareStatement( "update compteur set status=? where compteur.code_compteur=?"); 

	        ps2.setString(1,"Nom active");  
	        ps2.setInt(2,id);            
	         ps2.executeUpdate();
	    
	         PreparedStatement ps1=conn.prepareStatement("select * from client,compteur where compteur.code_compteur=?");
		        ps1.setInt(1,id);
		        
		        ResultSet rs1=ps1.executeQuery();  
		        while(rs1.next()){  
		        	 
		        	code=rs1.getInt("code_client"); 
		        }
	         
	         
	        PreparedStatement ps=conn.prepareStatement("select * from compteur where compteur.code_client=?");  
	        ps.setInt(1,code);
	        
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            s=new Client();  
	            s.setReference(rs.getInt("code_compteur"));  
	             
	            s.setS(rs.getString("status"));  
	            
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return s;  
	}  
	
}
