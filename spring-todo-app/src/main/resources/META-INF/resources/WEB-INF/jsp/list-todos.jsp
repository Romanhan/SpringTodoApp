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
                        <th width="20%">Completed</th>
                        <th width="20%"></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${todos}" var="todo">
                        <tr>
                            <td>${todo.description}</td>
                            <td>${todo.targetDate}</td>
                            <td>${todo.completed}</td>
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

           

<%@ include file="common/footer.jspf"%>
