package factur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConsultationDAO {

	
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
	

	static int change=0;
	static int Index_precedent;
	static int consomet;
	static double Montant_nouveau;
	static double Montant_total;
	static double Montant_totals;
	static double tva;
	static int nb_fil;
	static  int status=0;
	static double exoneration,eclairage,redevence,prime;
	
	public static int UpdateConsommation(Consultation c){  
	  
	    String statu="";
	   
	    try{  
	    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	    	   LocalDateTime now = LocalDateTime.now();  
	    	  
	        Connection conn=getConnection();  
	        
	        PreparedStatement ps1=conn.prepareStatement("select * from consommation,compteur where consommation.code_compteur=? and compteur.code_compteur=?");
	        ps1.setInt(1,c.getId());
	        ps1.setInt(2,c.getId()); 
	        ResultSet rs=ps1.executeQuery();  
	        while(rs.next()){  
	            
	        	Index_precedent=rs.getInt("Index_nouveau"); 
	        	 Montant_total=rs.getInt("Montant_total");
	        	 nb_fil=rs.getInt("nb_fil");
	        	 statu=rs.getString("status");
	        }
	        consomet=c.getIndex()-Index_precedent;
	        prime=330+46.2;
	        redevence=80.8+11.2;
	        eclairage=(consomet*0.072)+7.2;
	        exoneration=247.8;  
	        tva=prime+redevence+eclairage-exoneration;
	        Montant_nouveau=(consomet*15*nb_fil)+tva;
        	 Montant_totals=Montant_nouveau+Montant_total;
        	 

	       if((c.getIndex()>Index_precedent)||(statu=="active")){  
	        
	        PreparedStatement ps=conn.prepareStatement(  
	 "update consommation set Index_precedent=?,Index_nouveau=?,CONSOMMATION=?,Montant_total=?,Montant_nouveau=?,TVA=?,date_changement=? where consommation.code_compteur=?"); 
	    
	        ps.setInt(1,Index_precedent); 
	        ps.setInt(2,c.getIndex());
	        ps.setInt(3,consomet);
	        ps.setDouble(4,Montant_totals);
	        ps.setDouble(5,Montant_nouveau);
	        ps.setDouble(6,tva);
	        ps.setString(7,dtf.format(now));         
	        ps.setInt(8,c.getId());


	           
status=ps.executeUpdate();

DateTimeFormatter mois = DateTimeFormatter.ofPattern("MM");  
DateTimeFormatter annee = DateTimeFormatter.ofPattern("yyyy");  



if(status!=0) {
PreparedStatement ps3=conn.prepareStatement(  
		"INSERT INTO Factur(code_compteur,Index_nouveau,Index_precedent,CONSOMMATION,Montant_total,Montant_nouveau,TVA,mois,annee,date) VALUES(?,?,?,?,?,?,?,?,?,?)");  
ps3.setInt(1,c.getId());
ps3.setInt(2,c.getIndex());
ps3.setInt(3,Index_precedent); 
ps3.setInt(4,consomet);
ps3.setDouble(5,Montant_totals);
ps3.setDouble(6,Montant_nouveau);
ps3.setDouble(7,tva);
ps3.setString(8,mois.format(now));
ps3.setString(9,annee.format(now));
ps3.setString(10,dtf.format(now));         

status=ps3.executeUpdate();}
	   }
	    
	    
	    	   
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	} 
	
		
public static int payer(Consultation c){  
		  
	    String statu="";
	   
	    try{  
	    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	    	   LocalDateTime now = LocalDateTime.now();  
	    	  
	        Connection conn=getConnection();  
	        
	        PreparedStatement ps1=conn.prepareStatement("select * from consommation,compteur where consommation.code_compteur=? and compteur.code_compteur=?");
	        ps1.setInt(1,c.getId());
	        ps1.setInt(2,c.getId()); 
	        ResultSet rs=ps1.executeQuery();  
	        while(rs.next()){  
	            
	        	
	        	 Montant_total=rs.getInt("Montant_total");
	        	
	        }
	        
        	 Montant_totals=Montant_total-c.getIndex();
        	 

	        
	        PreparedStatement ps=conn.prepareStatement(  
	 "update consommation set Montant_total=? where consommation.code_compteur=?"); 
	    
	       
	        ps.setDouble(1,Montant_totals);
	        
	        ps.setInt(2,c.getId());


	           
status=ps.executeUpdate();

 




PreparedStatement ps3=conn.prepareStatement(  
		"INSERT INTO payer(montant,montant_total,code_compteur,Date) VALUES(?,?,?,?)");  



ps3.setDouble(1,c.getIndex());

ps3.setDouble(2,Montant_totals);
        
ps3.setInt(3,c.getId());
ps3.setString(4,dtf.format(now)); 
status=ps3.executeUpdate();
	   
	    
	    
	    	   
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}  
	
	
	
		
}
