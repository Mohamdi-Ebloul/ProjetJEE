<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="content-type" content="text/html">
<title>All Client</title>
 <link href="css/bootstrap.min.css" rel="stylesheet">
 
</head>
<body>


<%@page import='factur.Client' %>
<%@page import='factur.ClientDao'%>
<%@page import='java.sql.*'%>
 
<%@page import="java.util.*"%>  


   
 
 
<div class="container">
  <div class="jumbotron">
     
    <h1>All Client</h1>  
  </div>
 
</div>







   

 



<div class="container">
 
  <p>Client information :</p>            
  <table class="table table-bordered">
    <thead>
      <tr>
      <th>ID</th>
      <th>Reference conteur</th>
        <th>Nom</th>
        <th>Tel</th>
        <th>Ville</th>
        <th>Adresse</th>
        <th>Categorie</th>
        <th>Fil</th>
       
         <th>Delete</th>
       <th>Edit</th>      
      </tr>
    </thead>
    
    <%
        List<Client> list=ClientDao.getAllRecords();
        %> 
    
    
<%
         for(Client s:list){
         %> 
     <tbody>
   
      <tr>
        <td><%= s.getId() %></td>
        <td><%= s.getReference()   %></td>
        <td><%= s.getNom()   %></td>
        <td><%= s.getTel() %></td>
        <td><%= s.getVille() %></td>
        <td><%= s.getAdresse() %></td>
        <td><%= s.getCategorie() %></td>
        <td><%= s.getFil() %></td>
       <td><a href=" deleteClient.jsp?id=<%= s.getId() %>">delete</a></td>
        <td><a href=" editClient.jsp?id=<%= s.getId() %>">edit</a></td>
      
      </tr>
    </tbody>
         <% }    %> 
  </table>
</div>


    <a class="btn btn-info btn-lg" href="addClient.jsp" role="button">Add Client</a>














</body>
</html>