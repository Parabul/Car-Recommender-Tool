<%@tag description="Select2 tag" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@attribute name="title" required="true" type="java.lang.String"%>
<%@attribute name="helpBlock" required="false" type="java.lang.String"%>
<%@attribute name="id" required="true" type="java.lang.String"%>
<%@attribute name="items" required="true" type="java.util.Collection"%>
<script>
	$(function() {
		$('#${id}').select2();
	});
</script>
<div class="form-group">
	<label class="col-md-4 control-label">${title}</label>
	<div class="col-md-8">
		<select id="${id}" name="${id}" class="form-control select2">
			<option value="">Не выбрано</option>
			<c:forEach var="entry" items="${items}">
				<option value="${entry}">${entry}</option>
			</c:forEach>

		</select> <span class="help-block"> ${helpBlock} </span>
	</div>
</div>