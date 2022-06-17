package factur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacturDAO {

	
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
	public static int selectbyid(Factur f){ 
		
	
		try { Connection conn=getConnection(); 
		 PreparedStatement ps1=conn.prepareStatement("select max(code_factur) as code_factur from factur where factur.code_compteur=?");
	        ps1.setInt(1,f.getId());
	        
	        ResultSet rs=ps1.executeQuery();  
	        while(rs.next()){  
	        	 
	        	R=rs.getInt("code_factur"); 
	        }
		}catch(Exception e){System.out.println(e);} 
	    return R;  
	}  
	
	
	
	public static Factur FacturById(int id){  
		Factur f=null;  
	    try{  
	        Connection conn=getConnection();  
	        PreparedStatement ps=conn.prepareStatement("select * from factur where code_factur=?");  
	        ps.setInt(1,id);
	        
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            f=new Factur();
	            f.setCode_factur(rs.getInt("code_factur"));
	            f.setCode_compteur(rs.getInt("code_compteur"));
	            f.setIndex_nouveau(rs.getInt("index_nouveau"));
	            f.setIndex_precedent(rs.getInt("index_precedent"));
	            f.setCONSOMMATION(rs.getInt("CONSOMMATION"));
	            f.setMontant_total(rs.getDouble("Montant_nouveau"));
	            f.setTVA(rs.getDouble("TVA"));
	            f.setMois(rs.getString("mois"));
	            f.setAnne(rs.getString("annee"));
	            f.setDate(rs.getString("date"));
	              
	            
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return f;  
	}  
	
	
	public static List<Factur> getAllRecords(int id){  
	    List<Factur> list=new ArrayList<Factur>();  
	      
	    try{  
	        Connection conn=getConnection();  
	         
	        PreparedStatement ps=conn.prepareStatement("select * from factur where code_compteur=?");  
	        ps.setInt(1,id);
	        
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){ 
	        	
	        	Factur f=new Factur();
	            f.setCode_factur(rs.getInt("code_factur"));
	            f.setCode_compteur(rs.getInt("code_compteur"));
	            f.setIndex_nouveau(rs.getInt("index_nouveau"));
	            f.setIndex_precedent(rs.getInt("index_precedent"));
	            f.setCONSOMMATION(rs.getInt("CONSOMMATION"));
	            f.setMontant_total(rs.getDouble("Montant_nouveau"));
	            f.setTVA(rs.getDouble("TVA"));
	            f.setMois(rs.getString("mois"));
	            f.setAnne(rs.getString("annee"));
	            f.setDate(rs.getString("date"));
	            list.add(f);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}  
	
	
}
