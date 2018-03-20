<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="main_template_top.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">${pageTitle}</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-3 col-md-6">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<div class="row">
						<div class="col-xs-3">
							<i class="fa fa-user fa-5x"></i>
						</div>
						<div class="col-xs-9 text-right">
							<div class="huge">Cliente</div>
							<div>Nuevo</div>
						</div>
					</div>
				</div>
				<a href="pClientAdd">
					<div class="panel-footer">
						<span class="pull-left">Comenzar</span> <span class="pull-right"><i
							class="fa fa-arrow-circle-right"></i></span>
						<div class="clearfix"></div>
					</div>
				</a>
			</div>
		</div>
		<div class="col-lg-3 col-md-6">
			<div class="panel panel-green">
				<div class="panel-heading">
					<div class="row">
						<div class="col-xs-3">
							<i class="fa fa-tasks fa-5x"></i>
						</div>
						<div class="col-xs-9 text-right">
							<div class="huge"></div>
							<div>Reportes</div>
						</div>
					</div>
				</div>
				<a href="pReportTodayPayments">
					<div class="panel-footer">
						<span class="pull-left">Checar reportes</span> <span
							class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
						<div class="clearfix"></div>
					</div>
				</a>
			</div>
		</div>
		<div class="col-lg-3 col-md-6">
			<div class="panel panel-yellow">
				<div class="panel-heading">
					<div class="row">
						<div class="col-xs-3">
							<i class="fa fa-users fa-5x"></i>
						</div>
						<div class="col-xs-9 text-right">
							<div class="huge"></div>
							<div>Clientes</div>
						</div>
					</div>
				</div>
				<a href="pClients">
					<div class="panel-footer">
						<span class="pull-left">Administrar clientes</span> <span
							class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
						<div class="clearfix"></div>
					</div>
				</a>
			</div>
		</div>
		<div class="col-lg-3 col-md-6">
			<div class="panel panel-red">
				<div class="panel-heading">
					<div class="row">
						<div class="col-xs-3">
							<i class="fa fa-gears fa-5x"></i>
						</div>
						<div class="col-xs-9 text-right">
							<div class="huge"></div>
							<div>Configuración</div>
						</div>
					</div>
				</div>
				<a href="pConfig">
					<div class="panel-footer">
						<span class="pull-left">Ir a configuración</span> <span
							class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
						<div class="clearfix"></div>
					</div>
				</a>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-8">
			<div class="panel panel-default">
				<div class="panel-heading">
					<i class="fa fa-bar-chart-o fa-fw"></i> Ingresos por año
					<div class="pull-right">
						<div class="btn-group">
							<button type="button"
								class="btn btn-default btn-xs dropdown-toggle"
								data-toggle="dropdown">
								Actions <span class="caret"></span>
							</button>
							<ul class="dropdown-menu pull-right" role="menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li class="divider"></li>
								<li><a href="#">Separated link</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="panel-body">
					<div id="morris-area-chart"></div>
				</div>
			</div>
		</div>
		<div class="col-lg-4">
			<div class="panel panel-default">
				<div class="panel-heading">
					<i class="fa fa-bell fa-fw"></i> Ultimas visitas
				</div>
				<div class="panel-body">
					<div class="list-group">
						<c:forEach items="${lastVisits}" var="visit">
							<i class="fa fa-user fa-fw"></i>
							<c:out value="${visit.getCvName()}" />
							<span class="pull-right text-muted small"><em><c:out
										value="${visit.getCvDate()}" /></em></span>
										<br/>
						</c:forEach>						 
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="main_template_bottom.jsp" />
