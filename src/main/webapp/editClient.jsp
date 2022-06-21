<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Client</title>
 <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>







<%@page import='factur.Client' %>
<%@page import='factur.ClientDao'%>
  
<%
  String id=request.getParameter("id");  
    Client s=ClientDao.getRecordById(Integer.parseInt(id));
  %> 




<div class="container">

 <form action="ClientEdit.jsp" method="post">
  
   ID:<br>
  <input type="text" name="id"  class="form-control" value="<%=s.getId() %>"><br>
  Nom:<br>
   <input type="text" name="nom"  class="form-control" value="<%=s.getNom() %>"><br>
  Tel:<br>
  <input type="text" name="tel"  class="form-control" value="<%= s.getTel() %>"><br> 
    Ville:<br>
  <input type="text" name="ville"  class="form-control" value="<%= s.getVille() %>"><br> 
      Adresse:<br>
  <input type="text" name="adresse"  class="form-control" value="<%= s.getAdresse() %>"><br> 
  
   <table width="20%"> <tr><td>Categorie </td>
 <td align="right"> <select name="categorie" >
  <option value="<%=s.getCategorie() %>"><%=s.getCategorie() %></option>
  <option value="Maison">Maison</option>
  <option value="Societe">Societe</option>
</select></td></tr></table> 
<p>

</p>
   <table width="20%" > <tr>
 <td >    Nombre de fil</td>
 <td align="right"> <select name="fil" >
  <option value="<%= s.getFil() %>"><%= s.getFil() %> File</option>
  <option value="2">2 File</option>
  <option value="4">4 File</option>
  <option value="8">8 File</option>
  <option value="10">10 File</option>
</select></td></tr></table>
  
  
  <input type="submit" value="Edit" class="btn btn-primary btn-lg pull-right">
</form> 


     </div>














</body>
</html>