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

	static int change=0;
	public static Client activesatus(int id){  
		Client s=null; 
		int code=0;
	    try{  
	        Connection conn=getConnection();  
	        PreparedStatement ps2=conn.prepareStatement( "update compteur set status=? where compteur.code_compteur=?"); 

	        ps2.setString(1,"active");  
	        ps2.setInt(2,id);            
	        change= ps2.executeUpdate();
	    
	        String ch="";
    		if(change!=0) {
    		
    			ch="Abonnement activer";
    		}
	         
	        PreparedStatement ps=conn.prepareStatement("select * from compteur where compteur.code_compteur=?");  
	        ps.setInt(1,id);
	        
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            s=new Client();  
	            s.setReference(rs.getInt("code_compteur"));  
	             
	            s.setS(rs.getString("status"));  
	            
	        }  s.setChange(ch);
	    }catch(Exception e){System.out.println(e);}  
	    return s;  
	}  
	
	
	static double Montant_totals;	
	public static Client desactivesatus(int id){  
		Client s=null; 
		int code=0;
	    try{  
	        Connection conn=getConnection();
	        
	        PreparedStatement ps1=conn.prepareStatement("select * from consommation,compteur where consommation.code_compteur=? and compteur.code_compteur=?");
	        ps1.setInt(1,id);
	        ps1.setInt(2,id); 
	        ResultSet rs1=ps1.executeQuery();  
	        while(rs1.next()){  
	            
	        	
	        	 Montant_totals=rs1.getInt("Montant_total");
	        	
	        }
	        
	        if(Montant_totals<=0) {
	        
	        PreparedStatement ps2=conn.prepareStatement( "update compteur set status=? where compteur.code_compteur=?"); 
           
	        ps2.setString(1,"Non active");  
	        ps2.setInt(2,id);            
	         change=ps2.executeUpdate();
	    
	        }
		        
	        
	    		String ch="";
	    		if(change==0) {
	    		ch="Impossible de des activer Abonnement";
	    		}
	    		if(change>0) {
	    			ch="Abonnement desactiver";
	    		}
	    	
	         
	        PreparedStatement ps=conn.prepareStatement("select * from compteur where compteur.code_compteur=?");  
	        ps.setInt(1,id);
	        
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            s=new Client();  
	            s.setReference(rs.getInt("code_compteur"));  
	            
	            s.setS(rs.getString("status"));
	            
	            
	        }  s.setChange(ch);
	    }catch(Exception e){System.out.println(e);}  
	    return s;  
	}
	
	
}
