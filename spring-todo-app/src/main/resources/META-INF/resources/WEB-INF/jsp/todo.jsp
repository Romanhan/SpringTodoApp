<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<html>
<head>
    <link href="webjars/bootstrap/5.3.2/css/bootstrap.min.css" rel="stylesheet" >
    <link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css" rel="stylesheet" >
</head>
<body>
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

</body>
</html>

