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
							</div>
							<div class="col-lg-6">
								<div class="form-group">
									<form:label path="cStartingDate">Fecha Ingreso:</form:label>
									<%
										java.text.DateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
									%>
									<form:input type="date" path="cStartingDate"
										class="form-control"
										value="<%=sdf.format(new java.util.Date())%>" />
								</div>
							</div>
							<div class="col-lg-6">
								<div class="panel panel-primary">
									<div class="panel-heading">PAGOS</div>
									<div class="panel-body">
										<div class="form-row">
											<div class="form-group col-md-6">
												<label id="lmonthCost">Costo Mensualidad:</label> <input
													type="text" class="form-control allownumericwithdecimal"
													id="monthCost" value="${month_cost}" />
											</div>
											<div class="form-group col-md-3">
												<label id="ltotalMonths">Total Meses:</label> <select
													class="form-control" id="totalMonths">
													<%
														for (int i = 1; i < 5; i++) {
													%>
													<option>x<%=i%></option>
													<%
														}
													%>
												</select>
											</div>
											<div class="form-group col-md-3">
												<label id="ltotalMonthCost">Total:</label> <input
													type="text" class="form-control" id="totalMonthCost"
													value="$ ${month_cost}" readonly />
											</div>
										</div>
										<div class="form-row">
											<div class="form-group col-md-9">
												<label id="lmonthCost">Otro pago (Descripción):</label> 
												<input type="text" class="form-control" id="anotherPayment" value="" />
											</div>
											<div class="form-group col-md-3">
												<label id="lotherPayment">Total:</label> <input type="text" class="form-control allownumericwithdecimal" id="otherPayment" value="" />
											</div>
										</div>
									</div>
									<div class="panel-footer">
										<label class="col-md-9" id="lTOTAL">TOTAL:</label> 
										<form:label path="payment.pAmount" class="col-md-3" id="totalPayment">$ ${month_cost}</form:label> <br />
										<form:input type="hidden" path="payment.pAmount" id="itotalPayment" value="${month_cost}"/>
										<form:input type="hidden" path="payment.pDescription" id="pDescription" value="Costo Mensualidad $ ${month_cost} x1 = $ ${month_cost}. TOTAL =  $ ${month_cost}"/>
									</div>
								</div>
							</div>
							<div class="col-lg-6">
								<button type="submit" class="btn btn-success">Agregar</button>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /#page-wrapper -->
<jsp:include page="main_template_bottom.jsp" />


<script type="text/javascript">
$(document).ready(function(){

	$("#monthCost").change(function() {		
		paymentAmountChanged();	
	});
	
	$("#totalMonths").change(function() {	
		paymentAmountChanged();
	});
	
	$("#otherPayment").change(function() {	
		paymentAmountChanged();
	});
	
	function paymentAmountChanged(){
		$("#totalMonthCost").val("$" + getMonthTotal().toFixed(2));
		$("#itotalPayment").val("$" + getTotalPayment().toFixed(2));		
		$("#totalPayment").text("$" + getTotalPayment().toFixed(2));
		var pDescription = "Costo Mensualidad $"+ parseFloat($("#monthCost").val()).toFixed(2) 
			+" "
			+$("#totalMonths").val()
			+"="+$("#totalMonthCost").val()
			+". ";
		if($("#otherPayment").val() != ""){
			pDescription +="Otro pago:" + $("#anotherPayment").val() +" = $"+parseFloat($("#otherPayment").val()).toFixed(2) + ". ";
		}
		pDescription += "TOTAL: "+ $("#itotalPayment").val();
		$("#pDescription").val(pDescription);
	}
	
	function getMonthTotal() {
		var mCost = parseFloat($("#monthCost").val());
		var totalMonths = parseFloat($("#totalMonths").val().replace("x",""));
		var totalCost= mCost * totalMonths;
		return totalCost;
	}
	
	function getTotalPayment(){
		var totalMonthCost = getMonthTotal();
		var totalOthers = parseFloat($("#otherPayment").val());
		if(isNaN(totalOthers)) {
			totalOthers = 0;
		}
		return totalOthers + totalMonthCost;
	}
	
	 $(".allownumericwithdecimal").on("keypress keyup blur",function (event) {
		 //this.value = this.value.replace(/[^0-9\.]/g,'');
		 $(this).val($(this).val().replace(/[^0-9\.]/g,''));
		 if ((event.which != 46 || $(this).val().indexOf('.') != -1) && (event.which < 48 || event.which > 57)) {
			 event.preventDefault();
		 }
		 paymentAmountChanged();
     });
}); 
</script>
