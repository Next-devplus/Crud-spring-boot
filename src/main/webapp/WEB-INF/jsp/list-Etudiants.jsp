 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>

<head>
<title>Etudiant Management</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

<style>
.footer {
	position: fixed;
	left: 0;
	bottom: 0;
	width: 100%;
	background-color: black;
	color: white;
	height: 100px;
	text-align: center;
}
</style>

</head>

<body>

<nav role="navigation" class="navbar navbar-default">
	<div class="">
		<a href="http://www.javaguides.net" class="navbar-brand">Java Guides</a>
	</div>
	<div class="navbar-collapse">
		<ul class="nav navbar-nav">
			<li class="active"><a href="/">Home</a></li>
			<li><a href="/list-Etudiants">Etudiants</a></li>
		</ul>
		<ul class="nav navbar-nav">
			<li><a href="/logout">Logout</a></li>
		</ul>
	</div>
</nav>
<div class="container">
	<div>
		<a type="button" class="btn btn-primary btn-md" href="/add-Etudiant">Add Etudiant</a>
	</div>
	<br>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3>List of Etudiant's</h3>
		</div>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th width="40%">Description</th>
						<th width="40%">Target Date</th>
						<th width="20%"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${Etudiants1}" var="Etudiant">
						<tr>
							<td>${Etudiant.description}</td>
							<td><fmt:formatDate value="${Etudiant.targetDate}"
									pattern="dd/MM/yyyy" /></td>
							<td><a type="button" class="btn btn-success"
								href="/update-Etudiant?id=${Etudiant.id}">Update</a>
							<a type="button" class="btn btn-warning"
								href="/delete-Etudiant?id=${Etudiant.id}">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script
	src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
<script>
	$('#targetDate').datepicker({
		format : 'dd/mm/yyyy'
	});
</script>


<div class="footer">
	Fixed Footer
	<h1>
		<a href="http://www.javaguides.net/p/spring-boot-tutorial.html">
			Spring Boot Tutorial</a>
	</h1>
</div>
</body>
</html>