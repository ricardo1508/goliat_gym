<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="main_template_top.jsp" />
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">${pageTitle}</h1>
		</div>
	</div>
	<!-- /.row -->
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">Nuevo</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-6">
							<form role="form">
								<div class="form-group">
									<label>Nombre:</label> <input class="form-control">
								</div>
								<div class="form-group">
									<label>Apellido paterno:</label> <input class="form-control">
								</div>
								<div class="form-group">
									<label>Apellido materno:</label> <input class="form-control">
								</div>
								<div class="form-group">
									<label>Email:</label> <input class="form-control">
								</div>
								<button type="submit" class="btn btn-default">Agregar</button>
								<button type="reset" class="btn btn-default">Restablecer</button>
							</form>
						</div>
						<div class="col-lg-6">
							
						</div>
						<!-- /.col-lg-6 (nested) -->
					</div>
					<!-- /.row (nested) -->
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- /.row -->
</div>
<!-- /#page-wrapper -->
<jsp:include page="main_template_bottom.jsp" />
