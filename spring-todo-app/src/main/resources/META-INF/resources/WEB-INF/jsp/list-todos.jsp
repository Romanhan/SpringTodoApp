<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
    <div class="card my-3">
        <div class="card-header">
            <h5 class="card-title">List of TODO's</h5>
        </div>
        <div class="card-body">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th width="40%">Description</th>
                        <th width="20%">Target Date</th>
                        <th width="10%">Completed</th>
                        <th width="20%"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${todos}" var="todo">
					    <tr>
					        <form action="/update-todo" method="post">
					            <input type="hidden" name="id" value="${todo.id}">
					            <td>${todo.description}</td>
					            <input type="hidden" name="description" value="${todo.description}">
					            <td>${todo.targetDate}</td>
					            <input type="hidden" name="targetDate" value="${todo.targetDate}">
					            <td>
					                <input type="checkbox" name="completed" ${todo.completed ? 'checked' : ''} onchange="this.form.submit()">
					            </td>
					        </form>
					        <td>
					            <a href="/update-todo?id=${todo.id}" class="btn btn-success">Update</a>
					            <a href="/delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a>
					        </td>
					    </tr>
					</c:forEach>
                </tbody>
            </table>         
        </div> 
    </div>
    
    <div class="mt-3">
        <a href="/add-todo" class="btn btn-primary btn-md">Add Todo</a>
    </div>
</div>

<script>
    $('#targetDate').datepicker({
        format: 'dd.mm.yyyy'
    });
</script>
           

<%@ include file="common/footer.jspf"%>
