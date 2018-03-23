<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Goliat Gym</title>

<link href="resources/bootstrap_template/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/bootstrap_template/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
<link href="resources/bootstrap_template/dist/css/sb-admin-2.css" rel="stylesheet">
<link href="resources/bootstrap_template/vendor/morrisjs/morris.css" rel="stylesheet">
<link href="resources/bootstrap_template/vendor/font-awesome/css/font-awesome.min.css"rel="stylesheet" type="text/css">
<link href="resources/bootstrap_template/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">
<link href="resources/bootstrap_template/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<div id="wrapper">
		<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html">Goliat Gym</a>
			</div>
			<ul class="nav navbar-top-links navbar-right">
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
						<i class="fa fa-caret-down"></i>
				</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="pConfig"><i class="fa fa-gear fa-fw"></i>Configuración</a>
						</li>
						<li class="divider"></li>
						<li><a href="logout"><i class="fa fa-sign-out fa-fw"></i>Salir</a></li>
					</ul> 
					</li>
			</ul>
			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">
						<li><a href="home"><i class="fa fa-dashboard fa-fw"></i>Inicio</a></li>
						<li><a href="pClientAdd"><i class="fa fa-user fa-fw"></i>Cliente nuevo</a></li>
						<li><a href="#"><i class="fa fa-edit fa-fw"></i>Reportes<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a href="pReportTodayPayments">Ingresos del día</a></li>
								<li><a href="pReportTodayVisits">Visitas del día</a></li>
							</ul>
						</li>
						<li><a href="pClients"><i class="fa fa-users fa-fw"></i>Clientes</a></li>
						<li><a href="#"><i class="fa fa-check-square-o fa-fw"></i>Inventario<span class="fa arrow"></span></a>
							<ul class="nav nav-second-level">
								<li><a href="pProducts">Productos</a></li>
								<li><a href="pProductAdd">Agregar Producto</a></li>
								<li><a href="pProductSell">Venta</a></li>
							</ul>
						</li>
						<li><a href="pConfig"><i class="fa fa-gears fa-fw"></i>Configuración</a></li>
						<li><div class="alert alert-info"><a href="pGenerateBackup"><i class="fa fa-save fa-fw"></i>Finalizar día</a></div></li>
					</ul>
				</div>
			</div>
		</nav>