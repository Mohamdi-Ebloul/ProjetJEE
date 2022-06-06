<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 </head>
<body>


<%@page import="factur.ClientDao" %>
<jsp:useBean id="c" class="factur.Consultation"></jsp:useBean>
<jsp:setProperty property="*" name="c"/>



<%
int num = ClientDao.UpdateConsommation(c);

if(num>0){
	response.sendRedirect("ConsultationAdd.jsp");
}else{
	response.sendRedirect("ConsultationFaild.jsp");
}
%>








</body>
</html>