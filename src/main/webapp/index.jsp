<!DOCTYPE html>
<%
if (session.getAttribute("username") == null || 
session.getAttribute("username").equals(""))
{
response.sendRedirect("login.jsp");
}
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<FRAMESET ROWS="12%,88%" border=0 frameborder=no framespacing=0>
<FRAME src="nav.jsp">
<FRAMESET COLS="14%,76%,10%">
<FRAME src="side.html">
<FRAME src="home.html" NAME="home" >
<FRAME >
</FRAMESET>
</FRAMESET>

</html>