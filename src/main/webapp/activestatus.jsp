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
<%@page import='factur.statusDAO'%>
  
   <%@page import="factur.statusDAO" %>
<jsp:useBean id="c" class="factur.Client"></jsp:useBean>
<jsp:setProperty property="*" name="c"/>



<%@page import='factur.Client' %>
<%@page import='factur.statusDAO'%>
  
<%
  String id=request.getParameter("id");  
    Client s=statusDAO.activesatus(Integer.parseInt(id));
  %> 




<div class="container">

 
  
   Refrence:<br>
  <input type="text" name="id"  class="form-control" value="<%=s.getReference() %>"><br>
  Staus:<br>
   <input type="text" name="d"  class="form-control" value="<%=s.getS() %>"><br>

  
 
 <a href=" activestatus.jsp?id=<%=s.getReference() %>" ><button class="btn btn-primary btn-lg pull-right">Activer</button></a>
        <a href=" Desactivestatus.jsp?id=<%=s.getReference() %>" ><button class="btn btn-primary btn-lg pull-right">DesActiver</button> </a>

     </div>














</body>
</html>