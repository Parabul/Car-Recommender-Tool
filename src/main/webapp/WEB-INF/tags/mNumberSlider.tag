<%@tag description="http://seiyria.com/bootstrap-slider/" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@attribute name="title" required="true" type="java.lang.String"%>
<%@attribute name="min" required="true" type="java.lang.Integer"%>
<%@attribute name="max" required="true" type="java.lang.Integer"%>
<%@attribute name="step" required="true" type="java.lang.Integer"%>

<%@attribute name="helpBlock" required="false" type="java.lang.String"%>
<%@attribute name="id" required="true" type="java.lang.String"%>

<%@attribute name="minName" required="true" type="java.lang.String"%>
<%@attribute name="maxName" required="true" type="java.lang.String"%>
<script>
$(function() {	
	var ${id}Slider= $("#${id}Slider").slider({}).on('slide', function() {		
		$('#${minName}').val(${id}Slider.getValue()[0]);
		$('#${maxName}').val(${id}Slider.getValue()[1]);
	}).data('slider');
});
</script>
<style>
.slider-selection {
	background: #149bdf;
}
</style>
<div class="form-group">
	<label class="col-md-4 control-label">${title}</label>
	<div class="col-md-8">
		<div id="${id}Slider" style="width:200px;" data-slider-min="${min}" data-slider-max="${max}" data-slider-step="${step}" data-slider-value="[${min},${max}]"></div>
		 <span class="help-block"> ${helpBlock} </span>
		 <input type="hidden" id="${minName}" name="${minName}" />
		 <input type="hidden" id="${maxName}" name="${maxName}" />
	</div>
</div>