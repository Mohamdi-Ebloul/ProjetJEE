<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Factur</title>
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




 <%
     String id=request.getParameter("id");  

  
 Factur s=FacturDAO.recuById(Integer.parseInt(id));
  %> 



<div id='sectionAimprimer'>



<table id="t1" width="60%"  align="center" >
<tr ><td style=" width:100%;"  align="center">RECUS ELECTRICITE</td></tr>
</table >

<table width="100%" align="center"><tr style=" height: 140px;vertical-align:top;width:40px;"><td>

<table   width=90%  align=center>
<tr><td style=" width:50%;"><div id=div1>
<table>
<tr><td width=15%>Mois de Releve</td></tr>
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


<tr><td></td><td></td><td></td><td></td><td>Montant TOTAL </td><td align=right id=td2><%=s.getMontant_total()+s.getMontant_nouveau()%></td></tr>
<tr><td></td><td></td><td></td><td></td><td>Montant payee </td><td align=right id=td2><%=s.getMontant_nouveau()%></td></tr>
<tr><td></td><td></td><td></td><td></td><td>Montant Aprer paiement </td><td align=right id=td2><%=s.getMontant_total() %></td></tr>
</table>


</td></tr>
</table>
</div><br>
<table id="t2" width="90%"  align="center" >
<tr ><td style=" width:50%;"  align="left"> <button id=b2 onClick="imprimer('sectionAimprimer')"><img alt="" src="navbar/imprimer.png"></button></td>
<td align=right> <a href=" Recuss.jsp?id=<%=s.getCode_compteur() %>" target="home" ><button id=b>tout les Payment de ces reference</button></a></td>

</tr>
</table >



</body>
</html>