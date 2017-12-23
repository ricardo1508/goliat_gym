<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="main_template_top.jsp"/>
<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">${pageTitle}</h1>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">Nuevo</div>
				<div class="panel-body">
					<div class="row">
						<!-- <form role="form" action="#"> -->
							<div class="col-lg-6">
								<div class="form-group">
									<label>Nombre:</label> <input class="form-control"
										name="client_name" required>
								</div>
								<div class="form-group">
									<label>Apellido paterno:</label> <input class="form-control"
										name="f_last_name" required>
								</div>
								<div class="form-group">
									<label>Apellido materno:</label> <input class="form-control"
										name="m_last_name" required>
								</div>
							</div>
							<div class="col-lg-6">
								<div class="form-group">
									<label>Contraseña:</label> <input type="password" class="form-control"
										name="password" id="inputSuccess" required>
								</div>
								<div class="form-group">
									<label>Confirmar Contraseña:</label> <input type="password" class="form-control"
										name="confirmPassword" required>
								</div>
								<div id="demo">sgsg</div>
								<button onclick="checkElements()">test</button>
								<!--  <button type="submit" class="btn btn-default">Agregar</button>
								<button type="reset" class="btn btn-default">Restablecer</button>-->
							</div>
						<!-- </form> -->
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
<jsp:include page="main_template_bottom.jsp"/> 

<script>
		function checkElements(){
			//document.getElementById('demo').innerHTML=document.getElementsByName('client_name')[0].value;
			var name = document.getElementsByName('client_name')[0].value;
			var fLastName = document.getElementsByName('f_last_name')[0].value;
			var mLastName = document.getElementsByName('m_last_name')[0].value;
			var pass = document.getElementsByName('password')[0].value;
			var confPass = document.getElementsByName('confirmPassword')[0].value;
			if (name!="" ||  fLastName!="" ||  fLastName!="" ||  mLastName!="" ||  pass!="" ||  confPass!=""){
				if (pass == confPass){
					//Aqui se manda
				}else{					
					document.getElementById('demo').innerHTML="Las contraseñas no coinciden";
				}	
			}else{
				document.getElementById('demo').innerHTML="Hay espacios vacios";
			}
			
		}
</script>
