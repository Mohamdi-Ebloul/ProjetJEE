<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Consultation</title>
</head>
<body>


      
<script>

function relever() {
    Swal.fire({
        position: 'top-end',
        icon: 'success',
        title: "relever Susseced",
        showConfirmButton: false,
        timer: 2000
    })
} </script>


<script type="text/javascript">
relever();
</script>
<jsp:include page="ConsultationForm.html" ></jsp:include>



</body>
</html>