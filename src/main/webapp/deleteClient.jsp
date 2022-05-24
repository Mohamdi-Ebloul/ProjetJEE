<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete Client</title>
</head>
<body>


<%@page import='factur.ClientDao'%>
<jsp:useBean id="s" class="factur.Client"></jsp:useBean>  
<jsp:setProperty property="*" name="s"/>  


<%
  ClientDao.delete(s);  
  response.sendRedirect("viewClient.jsp");
  %> 




</body>
</html>