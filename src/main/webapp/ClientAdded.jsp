<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<script>

function Create() {
    Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: 'Abonnement Create',
        showConfirmButton: false,
        timer: 2500
    })
} </script> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Abonnementt</title>
</head>
<body >

<script type="text/javascript">
Create();
</script>
  

 
<jsp:include page="ClientForm.html"></jsp:include>



</body>
</html>