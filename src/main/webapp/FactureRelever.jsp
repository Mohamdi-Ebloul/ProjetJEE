<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Status</title>
 <link href="css/bootstrap.min.css" rel="stylesheet">
 <style>
#div1{
border: 2px solid blue;
  border-radius: 8px;height:100px;
  padding-top: 20px;
  padding-right: 20px;
  padding-bottom: 20px;
  padding-left: 20px;
}
#b{
border: 2px solid blue;
  border-radius: 8px;color:black;widht:20px;
}
#tr1{ color:white;
background-color: blue;
  border-radius: 20px;height:40px;
}
#td1{text-align: right;}
#t1{height:100px;
color:blue;font-size: 30px;
}
#td2{

}
img{font-size: 18px;border: 1px solid blue;
  border-radius: 8px;
   width: 100px;
   height: 40px;}
   #b2{background-color: blue;border: 1px solid blue;
  border-radius: 8px;
   }
</style>
<script>
function imprimer(divName) {
      var printContents = document.getElementById(divName).innerHTML;    
   var originalContents = document.body.innerHTML;      
   document.body.innerHTML = printContents;     
   window.print();     
   document.body.innerHTML = originalContents;
   }
</script>
</head>
<body>



<%@page import='factur.Client' %>
<%@page import='factur.ClientDao'%>
  
   <%@page import="factur.ClientDao" %>
<jsp:useBean id="d" class="factur.Client"></jsp:useBean>
<jsp:setProperty property="*" name="d"/>



<%@page import='factur.Factur' %>
<%@page import='factur.FacturDAO'%>
  
   <%@page import="factur.FacturDAO" %>
<jsp:useBean id="c" class="factur.Factur"></jsp:useBean>
<jsp:setProperty property="*" name="c"/>
<%@page import="java.util.*"%>  

    <%
        List<Factur> list=FacturDAO.getAllRecords();
        %> 
    
    
<%
         for(Factur s:list){
         %> 


<div id='sectionAimprimer'>



<table id="t1" width="60%"  align="center" >
<tr ><td style=" width:100%;"  align="center">FACTURE ELECTRICITE</td></tr>
</table >

<table width="100%" align="center"><tr style=" height: 140px;vertical-align:top;width:40px;"><td>

<table   width=90%  align=center>
<tr><td style=" width:50%;"><div id=div1>
<table>
<tr><td width=15%>Mois de Releve</td><td width=40%><%=s.getMois() %>/<%=s.getAnne() %></td></tr>
<tr><td>Tel.Renseignem</td><td>00000000</td></tr>
<tr ><td>Tel.Depar Elec</td><td>00000000</td></tr>
</table></div>
</td>

<td align=left><div id=div1>
<table >
<tr><td width=80%>Reference</td><td width=20% ><%=s.getCode_compteur() %></td></tr>
<tr><td>Nom du Client</td><td><%=s.getNom() %></td></tr>
<tr ><td>Adresee du Client</td><td><%=s.getAdresse() %></td></tr>
</table></div>
</td>
</tr>
</table>
</td></tr>
<tr ><td>

<table width=90%  align=center>
<tr id=tr1><td>CONSOMMATION ENREGISTREE</td><td></td><td></td><td id=td1>Ancien Index</td><td id=td1>Nouvel Index</td><td id=td1>Consommation</td></tr>
<tr style=" height: 60px;vertical-align:top;"><td >CONSOMMATION ELECTRICITE RELEVE</td><td></td><td></td><td id=td1><%=s.getIndex_precedent() %></td><td id=td1><%=s.getIndex_nouveau() %></td><td id=td1><%=s.getCONSOMMATION() %></td></tr>




<tr id=tr1><td>FACTURATION CONSOMMATION </td><td id=td1>Consommation</td><td id=td1>Prix Unitaire</td><td id=td1>Montant Bruts</td id=td1><td>Montants des Taxes</td><td id=td1>Montants T.T.C</td></tr>
<tr><td>ELEC TARIF  </td><td id=td1><%=s.getCONSOMMATION() %></td><td id=td1><%=s.getFil()*15 %></td><td id=td1><%=s.getCONSOMMATION()*s.getFil()*15 %></td><td id=td1>595.8</td><td id=td1><%=s.getCONSOMMATION()*s.getFil()*15+595.8 %></td></tr>
<tr><td>PRIME FIXE ELECTRICITE </td><td id=td1></td><td id=td1>165.0</td><td id=td1>330.0</td><td id=td1>46.2</td><td id=td1>376.2</td></tr>
<tr><td>REDEVENCE DE GESTION ELEC </td><td id=td1></td><td id=td1>40.400</td><td id=td1>80.8</td><td id=td1>11.2</td><td id=td1>92.0</td></tr>
<tr><td>ECLAIRAGE PUBLIC </td><td id=td1><%=s.getCONSOMMATION() %></td><td id=td1>0.072</td><td id=td1><%=s.getCONSOMMATION()*0.072 %></td><td id=td1>7.2</td><td id=td1><%=s.getCONSOMMATION()*0.072+7.2 %></td></tr>
<tr style=" height: 40px;vertical-align:top;width:40px;"><td style=" width:40%;">EXONERATION TAXE ELEC </td><td id=td1></td><td id=td1></td><td id=td1></td><td id=td1></td ><td id=td1>-247.8</td></tr>
<tr><td></td><td></td><td></td><td></td><td>TOTAL FACTURE </td><td align=right id=td2><%=s.getMontant_nouveau()%></td></tr>
<tr><td></td><td></td><td></td><td></td><td>ARRIERE </td><td align=right id=td2><%=s.getMontant_total()-s.getMontant_nouveau()%></td></tr>
<tr><td></td><td></td><td></td><td></td><td>TOTAL A PAYER </td><td align=right id=td2><%=s.getMontant_total() %></td></tr>
</table>


</td></tr>
</table>
</div><br>  <% }    %> 
<table id="t2" width="90%"  align="center" >
<tr ><td style=" width:50%;"  align="left"> <button id=b2 onClick="imprimer('sectionAimprimer')"><img alt="" src="navbar/imprimer.png"></button></td>

</tr>
</table >



</body>
</html>