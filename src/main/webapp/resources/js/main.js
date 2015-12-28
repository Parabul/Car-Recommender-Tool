google.load('visualization', '1', {
    packages : [ 'corechart' ]
});

$(function() {
    $('#cars-table').DataTable({
	language : {
	    "processing" : "Подождите...",
	    "search" : "Поиск:",
	    "lengthMenu" : "Показать _MENU_ записей",
	    "info" : "Записи с _START_ до _END_ из _TOTAL_ записей",
	    "infoEmpty" : "Записи с 0 до 0 из 0 записей",
	    "infoFiltered" : "(отфильтровано из _MAX_ записей)",
	    "infoPostFix" : "",
	    "loadingRecords" : "Загрузка записей...",
	    "zeroRecords" : "Записи отсутствуют.",
	    "emptyTable" : "В таблице отсутствуют данные",
	    "paginate" : {
		"first" : "Первая",
		"previous" : "Предыдущая",
		"next" : "Следующая",
		"last" : "Последняя"
	    },
	    "aria" : {
		"sortAscending" : ": активировать для сортировки столбца по возрастанию",
		"sortDescending" : ": активировать для сортировки столбца по убыванию"
	    }
	},
	data : [],
	columns : [ {
	    title : "#"
	}, {
	    title : "Год выпуска"
	}, {
	    title : "Пробег, км"
	}, {
	    title : "Цена, $"
	}, {
	    title : "Марка"
	}, {
	    title : "Тип транмиссии"
	} ]
    });

    $("#advise-form").on("submit", function(event) {
	event.preventDefault();
	$.blockUI({ message: '<h1>Обработка запроса....</h1>' });
	request = $(this).serialize();

	$.post("./advise?" + request, function(data) {
	    $.unblockUI();
	    console.log(data.carInfos.length);
	    if (data.carInfos.length < 2) {
		$.growlUI('Нет подходящих автомобилей', 'Укажите другие параметры поиска'); 
		return;
	    }
	    $('#avgPrice').html(data['avgPrice'].toFixed(2));
	    $('#avgMileage').html(data['avgMileage'].toFixed(2));
	    $('#avgAge').html(data['avgAge'].toFixed(2));
	    var dataSet = [];
	    for ( var id in data.carInfos) {
		var item = data.carInfos[id];
		dataSet.push([ '<a  id="#' + item.id + '">' + item.id + '</a>', item.manufactureyear, item.mileage, item.price, item.title, item.transmissiontype ]);
	    }
	    $('#cars-table').dataTable().fnClearTable();
	    $('#cars-table').dataTable().fnAddData(dataSet);
	    $('#cars-table').dataTable().fnDraw();
	    $('#cars-table').DataTable().search('', false, true).draw();
	    var agedata = [];
	    var milesagedata = [];
	    var minyear = 2016;
	    var maxyear = 0;

	    var minmiles = 10000000;
	    var maxmiles = 0;
	    for ( var id in data.carInfos) {
		var carInfo = data.carInfos[id];
		agedata.push([ carInfo.manufactureyear, null, carInfo.price, carInfo.id ]);

		minyear = Math.min(carInfo.manufactureyear, minyear);
		maxyear = Math.max(carInfo.manufactureyear, maxyear);

		milesagedata.push([ carInfo.mileage, null, carInfo.price, carInfo.id ]);
		minmiles = Math.min(carInfo.mileage, minmiles);
		maxmiles = Math.max(carInfo.mileage, maxmiles);
	    }

	    for (var year = minyear; year <= maxyear; year++) {
		var reg = data.yearRegressionResult.intercept + data.yearRegressionResult.slope * year;
		agedata.push([ year, reg, null, null ]);

	    }

	    for (var miles = minmiles; miles <= maxmiles; miles += 10000) {
		var reg = data.mileageRegressionResult.intercept + data.mileageRegressionResult.slope * miles;
		milesagedata.push([ miles, reg, null, null ]);

	    }

	    var data = new google.visualization.DataTable();

	    data.addColumn('number', 'Год произовдства');
	    data.addColumn('number', 'Средняя ожидаемая цена, $');
	    data.addColumn('number', 'Фактические\r\n предложения на рынке, $');
	    data.addColumn({
		type : 'number',
		role : 'id'
	    });
	    
	    data.addRows(agedata);

	    var chart = new google.visualization.ScatterChart(document.getElementById('chart_div_age'));

	    chart.draw(data, {
		height : 500,
		width : 800,
		series : {
		    0 : {
			lineWidth : 1
		    }
		}
	    });

	    google.visualization.events.addListener(chart, 'select', selectAgeHandler);

	    function selectAgeHandler() {
		var selectedItem = chart.getSelection()[0];
		var value = data.getValue(selectedItem.row, 3);

		if (value != null) {
		    $('#carinfo-tabs a[href="#data-table"]').tab('show');
		    $('#cars-table').DataTable().search(value, false, true).draw();
		}

	    }

	    var milesData = new google.visualization.DataTable();

	    milesData.addColumn('number', 'Пробег, км');
	    milesData.addColumn('number', 'Средняя ожидаемая цена, $');
	    milesData.addColumn('number', 'Фактические\r\n предложения на рынке, $');
	    milesData.addColumn({
		type : 'number',
		role : 'id'
	    });
	    milesData.addRows(milesagedata);

	    var chart_miles = new google.visualization.ScatterChart(document.getElementById('chart_div_miles'));

	    chart_miles.draw(milesData, {
		height : 500,
		width : 800,
		series : {
		    0 : {
			lineWidth : 1
		    }
		}
	    });

	    google.visualization.events.addListener(chart_miles, 'select', selectMilesHandler);

	    function selectMilesHandler() {
		var selectedItem = chart_miles.getSelection()[0];
		var value = milesData.getValue(selectedItem.row, 3);

		if (value != null) {
		    $('#carinfo-tabs a[href="#data-table"]').tab('show');
		    $('#cars-table').DataTable().search(value, false, true).draw();
		}

	    }

	}).fail(function() {
	    $.unblockUI();
	});
    });
});