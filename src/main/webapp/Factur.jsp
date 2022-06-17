<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Status</title>
 <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>







<%@page import='factur.Factur' %>
<%@page import='factur.FacturDAO'%>
  
   <%@page import="factur.FacturDAO" %>
<jsp:useBean id="c" class="factur.Factur"></jsp:useBean>
<jsp:setProperty property="*" name="c"/>



<%
int num = FacturDAO.selectbyid(c);


%>
  
<%
  
    Factur s=FacturDAO.FacturById(num);
  %> 




<div class="container">

 
  
   Code factur:<br>
  <input type="text" name="id"  class="form-control" value="<%=s.getCode_factur() %>"><br>
  Reference:<br>
   <input type="text" name="d"  class="form-control" value="<%=s.getCode_compteur() %>"><br>
    Index nouvrau:<br>
  <input type="text" name="id"  class="form-control" value="<%=s.getIndex_nouveau() %>"><br>
  Index Total:<br>
   <input type="text" name="d"  class="form-control" value="<%=s.getIndex_precedent() %>"><br>
    Consomation:<br>
  <input type="text" name="id"  class="form-control" value="<%=s.getCONSOMMATION() %>"><br>
  Montant Total:<br>
   <input type="text" name="d"  class="form-control" value="<%=s.getMontant_total() %>"><br>
    Montant Nouveau:<br>
  <input type="text" name="id"  class="form-control" value="<%=s.getMontant_nouveau()%>"><br>
  TVA:<br>
   <input type="text" name="d"  class="form-control" value="<%=s.getTVA() %>"><br>
    Mois:<br>
  <input type="text" name="id"  class="form-control" value="<%=s.getMois() %>"><br>
  Annee:<br>
   <input type="text" name="d"  class="form-control" value="<%=s.getAnne() %>"><br>
    Date:<br>
  <input type="text" name="id"  class="form-control" value="<%=s.getDate() %>"><br>
   
    <a href=" facturs.jsp?id=<%=s.getCode_compteur() %>" ><button class="btn btn-primary btn-lg pull-right">Les Facturs</button></a>
  

  
 

     </div>














</body>
</html>