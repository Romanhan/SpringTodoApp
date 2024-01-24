<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
    <h5>Enter Todo Page</h5>

    <form:form method="post" modelAttribute="todo">
        <fieldset class="mb-3">
            <form:label path="description">Description</form:label>
            <form:input type="text" path="description" class="form-control" required="required"/>
            <form:errors path="description" cssClass="text-warning"/>
        </fieldset>

        <fieldset class="mb-3">
            <form:label path="targetDate">Target Date</form:label>
            <form:input type="text" path="targetDate" class="form-control" required="required"/>
            <form:errors path="targetDate" cssClass="text-warning"/>
        </fieldset>

        <form:input type="hidden" path="id"/>
        <form:input type="hidden" path="completed"/>
        <input type="submit" class="btn btn-success"/>
    </form:form>
</div>

<%@ include file="common/footer.jspf" %> 
   
<script type="text/javascript">
	$('#targetDate').datepicker({
	    format: 'dd.mm.yyyy',
	});
</script>



