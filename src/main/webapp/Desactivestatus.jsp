<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Desactive</title>
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
    Client s=statusDAO.desactivesatus(Integer.parseInt(id));
  %> 




<div class="container" style=" height: 600px;width: 30%;sbackground-color: powderblue;">
<div class="panel panel-primary">
  <div class="panel-heading">
    <h3 class="panel-title"> Status   </h3>
  </div>
  
  
  <div class="panel-body">
 
    
<script>

function desactiver() {
    Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: "<%=s.getChange()%>",
        showConfirmButton: false,
        timer: 2000
    })
} </script>


<script type="text/javascript">
desactiver();
</script>

<table ><tr align="right"><td> <form action="status.jsp" method="post" target="home" >
  
  Nouveau Reference 
  <input class="form-control" type="text" name="id"  size=30><br>
  <input type="submit" value="Ok" >
</form> 
  </td>
  
  <tr><td>
 
   Refrence:<br>
  <input type="text" name="id"  class="form-control" value="<%=s.getReference() %>"  disabled ><br>
  Staus:<br>
   <input type="text" name="d"  class="form-control" value="<%=s.getS() %>" disabled><br>

  <a href=" activestatus.jsp?id=<%=s.getReference() %>" target="home" ><button class="btn btn-primary btn-lg pull-right">Activer</button></a>
        <a href=" Desactivestatus.jsp?id=<%=s.getReference() %>" target="home" ><button class="btn btn-primary btn-lg pull-right">DesActiver</button> </a>


    
    
  </td></tr></table>


  </div>
</div>
</div>




</body>
</html>