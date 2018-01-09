<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Inicio sesión</title>

    <!-- Bootstrap Core CSS -->
    <link href="resources/bootstrap_template/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="resources/bootstrap_template/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="resources/bootstrap_template/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="resources/bootstrap_template/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>
<body style="background-image: url(resources/images/bg_login_admin.jpeg)">
 <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Iniciar Sesión</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Usuario" name="user" type="text" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Constraseña" name="password" type="password" value="">
                                </div>                                
                                <!-- Change this to a button or input when using this as a form -->
                                <a href="home" class="btn btn-lg btn-success btn-block">Iniciar Sesión</a>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-12 col-md-offset-2">
        	<h1 style="color:white;font-size:800%;font-weight:bold;font-style:italic">Goliath Gym</h1>
        </div>
        
    </div>
    <!-- jQuery -->
    <script src="resources/bootstrap_template/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="resources/bootstrap_template/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="resources/bootstrap_template/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="resources/bootstrap_template/dist/js/sb-admin-2.js"></script>
</body>
</html>