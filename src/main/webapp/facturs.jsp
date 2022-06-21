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
  <%@page import='java.sql.*'%>
 
<%@page import="java.util.*"%>  


   
   <%@page import="factur.FacturDAO" %>
<jsp:useBean id="c" class="factur.Factur"></jsp:useBean>
<jsp:setProperty property="*" name="c"/>







 


<div class="container" style=" height: 600px;width: 100%;sbackground-color: powderblue;">
 
  <p>Les Facturs :</p>            
  <table class="table table-bordered">
    <thead>
      <tr>
      <th>Code factur</th>
      <th>Reference</th>
        <th>Index nouveau</th>
        <th>Index Total</th>
        <th>Consomation</th>
        <th> Montant Total</th>
        <th>Montant Nouveau</th>
        <th>TVA</th>
        <th>Mois</th>
        <th>Annee</th>
        <th>Date</th>
       
         
       <th>View</th>      
      </tr>
    </thead>
  
    <%
     String id=request.getParameter("id");  
        List <Factur> list=FacturDAO.getAllRecords(Integer.parseInt(id));
        %> 
    
    
<%
         for(Factur s:list){
         %> 
     <tbody>
   
      <tr>
        <td><%= s.getCode_factur() %></td>
        <td><%= s.getCode_compteur()   %></td>
        <td><%= s.getIndex_nouveau()   %></td>
        <td><%= s.getIndex_precedent() %></td>
        <td><%= s.getCONSOMMATION() %></td>
        <td><%= s.getMontant_total() %></td>
        <td><%= s.getMontant_nouveau() %></td>
        <td><%= s.getTVA() %></td>
        <td><%= s.getMois() %></td>
        <td><%= s.getAnne() %></td>
        <td><%= s.getDate() %></td>
       <td><a href=" viewFactur.jsp?id=<%= s.getCode_factur() %>" target="home" >View</a></td>
      
      
      </tr>
    </tbody>
         <% }    %> 
  </table>
</div>












</body>
</html>