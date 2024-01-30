<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">

 <div class="card my-3">
    <div class="card-header text-black">
    <h5 class="card-title">Home Page</h5>
    </div>
     
        <div class="card-body">
           Welcome ${name}! <a href="/list-todos">Click here</a> to manage your todo's.
        </div>
     </div>
 </div>


<%@ include file="common/footer.jspf" %>