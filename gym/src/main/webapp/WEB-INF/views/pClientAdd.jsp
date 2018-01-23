<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
						<form:form method="post" action="clientAdd" modelAttribute="client">
							<div class="col-lg-6">
								<div class="form-group">
									<form:label path="cName">Nombre:</form:label>
									<form:input path="cName" class="form-control" />
								</div>
								<div class="form-group">
									<form:label path="cLastName">Apellido Paterno:</form:label>
									<form:input path="cLastName" class="form-control" />
								</div>
								<div class="form-group">
									<form:label path="cSecondLastName">Apellido Materno:</form:label>
									<form:input path="cSecondLastName" class="form-control" />
								</div>
								<div class="form-group">
									<div class="form-group">
										<form:label path="cAge">Edad:</form:label>
										<form:select path="cAge" class="form-control">
											<%
												for (int i = 10; i < 100; i++) {
											%>
											<option><%=i%></option>
											<%
												}
											%>
										</form:select>
									</div>
								</div>
								<form:label path="cWeight">Peso:</form:label>
								<div class="form-group input-group">
									<form:input path="cWeight" type="text" class="form-control" />
									<span class="input-group-addon">kg</span>
								</div>
								<div class="form-group">
									<form:label path="cWeight">Meta:</form:label>
									<form:textarea path="cGoal" class="form-control" rows="3"></form:textarea>
								</div>

								<button type="submit" class="btn btn-primary">Agregar</button>

							</div>
							<div class="col-lg-6">
								<div class="form-group">
									<form:label path="cStartingDate">Fecha Ingreso:</form:label>
									<%
										java.text.DateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");										
									%>
									<form:input type="date" path="cStartingDate" class="form-control" value="<%=sdf.format(new java.util.Date())%>" />
								</div>								
							</div>
						</form:form>
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
