<!DOCTYPE html>
<html lang="en">
   <head>
<meta charset="UTF-8">
<meta http-equiv="content-type" content="text/html">
<title> Acceil </title>
 <link href="navbar/css/bootstrap.min.css" rel="stylesheet">
</head>
    <body>
  <nav class="navbar  justify-content-between">
  <a class="navbar-brand" href="home.html" target="home" ><h1>Home</h1></a>
  <a class="navbar-brand" align=center><h1>Gestion des factures d'�lectricit�</h1></a>
  <form class="form-inline">
    
    <table class="nav-link  mr-sm-2" ><tr><td><%= (new java.util.Date()).toLocaleString()%></td><td> <a class="nav-link active" id="v-pills-home-tab" data-toggle="pill" href="Logoutserevlet" role="tab" aria-controls="v-pills-home" aria-selected="true">Deconnexion</a>
</td></tr></table>
  </form>
</nav>
    </body>
</html>