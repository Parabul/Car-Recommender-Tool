<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Car Selection Adviser</title>
<link href="<c:url value='/favicon.ico'/>" type="image/x-icon" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<link href="<c:url value='/resources/css/bootstrap.css'/>"
	rel="stylesheet">
<link href="<c:url value='/resources/css/bootstrap-slider.css'/>"
	rel="stylesheet">
<link
	href="//cdnjs.cloudflare.com/ajax/libs/select2/4.0.1/css/select2.min.css"
	rel="stylesheet" />
<link
	href="//cdn.datatables.net/1.10.10/css/dataTables.bootstrap.min.css"
	rel="stylesheet" />



<script src="<c:url value='/resources/js/jquery.js'/>"></script>
<script src="<c:url value='/resources/js/bootstrap.js'/>"></script>
<script src="<c:url value='/resources/js/bootstrap-slider.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js/jquery.blockUI.js'/>"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/select2/4.0.1/js/select2.min.js"></script>
<script src="//cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>
<script
	src="//cdn.datatables.net/1.10.10/js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script  src="<c:url value='/resources/js/main.js'/>" type="text/javascript">
	
</script>
</head>
<body>


	<div class="container">


		<div class="row">
			<div class="col-sm-12">
				<h1>Помощник в выборе авто по честной цене</h1>
				<hr />
			</div>
		</div>

		<div class="row">
			<div class="col-sm-6">
				<form id="advise-form" method="POST" class="form-horizontal"
					role="form">
					<t:mSelectOne title="Марка автомобиля" id="title" items="${titles}" />
					<t:mSelectOne title="Тип трансмиссии" id="transmissionType"
						items="${transmissionTypes}" />

					<t:mNumberSlider title="Год выпуска" id="manufactureYear"
						min="1980" max="2016" minName="manufactureYearFrom"
						maxName="manufactureYearTo" step="1" />

					<t:mNumberSlider title="Пробег" id="mileage" min="100" max="400000"
						minName="mileageFrom" maxName="mileageTo" step="1000" />

					<button class="btn btn-success" id="sumbit">Оценить</button>
				</form>
			</div>
			<div class="col-sm-6">
				<ul style="list-style: none;">
					<li><strong>Средняя цена, $</strong> <span id="avgPrice"></span></li>
					<li><strong>Средний пробег, км</strong> <span id="avgMileage"></span></li>
					<li><strong>Средний год выпуска</strong> <span id="avgAge"></span></li>

				</ul>
			</div>

		</div>

		<div class="row">

			<div class="col-sm-12">
				<hr />
				<ul id="carinfo-tabs" class="nav nav-tabs" role="tablist">
					<li role="presentation" class="active"><a href="#year"
						aria-controls="year" role="tab" data-toggle="tab">По году
							выпуска</a></li>
					<li role="presentation"><a href="#mileage"
						aria-controls="mileage" role="tab" data-toggle="tab">По
							пробегу</a></li>
					<li role="presentation"><a href="#data-table"
						aria-controls="data-table" role="tab" data-toggle="tab">Данные</a></li>

				</ul>

				<div class="tab-content">
					<div role="tabpanel" class="tab-pane active" id="year">

						<div id="chart_div_age" style="width: 800px; height: 500px;"></div>

					</div>
					<div role="tabpanel" class="tab-pane" id="mileage">

						<div id="chart_div_miles" style="width: 800px; height: 500px;"></div>

					</div>
					<div role="tabpanel" class="tab-pane" id="data-table">
						<div class="row" style="margin-top: 10px;">
							<div class="col-sm-12">
								<table id="cars-table"
									class="table table-striped table-bordered" width="100%"></table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>


	</div>


</body>
</html>
