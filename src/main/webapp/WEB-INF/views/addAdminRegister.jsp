<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
</head>
<body>
</br></br>
	<section>
		<form:form modelAttribute="newRegister">
			<fieldset>
				<legend><h4>User Sign UP Form</h4></legend>
				<!-- Hiden filed hilds the value of id so that we can use it for updating -->
				<form:hidden path="id" />
				<form:errors path="*" />
				<div>
					<label for="firstName">First
						Name</label>
					<div >
						<form:input id="firstName" path="firstName" type="text"
							 />
						<form:errors path="firstName" />
					</div>
				</div>

				<div>
					<label for="lastName">Last
						Name</label>
					<div >
						<form:input id="lastName" path="lastName" type="text" />
						<form:errors path="lastName" />
					</div>
				</div>

				<div>
					<label for="email">Email</label>
					<div >
						<div>
							<form:input id="email" path="email" type="text"/>
							<form:errors path="email"/>
						</div>
					</div>
				</div>

				<div>
					<label for="userName">User
						Name</label>
					<div>
						<div>
							<form:input id="username" path="userCredentials.username" type="text"/>
							<form:errors path="userCredentials.username" />
						</div>
					</div>
				</div>

				<div >
					<label for="password">Password</label>
					<div>
						<div>
							<form:password id="password" path="userCredentials.password"/>
							<form:errors path="userCredentials.password" />
						</div>
					</div>
				</div>


				<div >
					<label for="verifyPassword">Verify
						Password</label>
					<div >
						<div >
							<form:password path="userCredentials.verifyPassword" />
							<form:errors path="userCredentials.verifyPassword"/>
						</div>
					</div>
				</div>

				<div>
					<label for="authority">Role</label>
					<div >
						<div >
							<form:input path="userCredentials.authority[0].authority"
								type="text" value="ROLE_ADMIN" />
							<form:errors path="userCredentials.authority[0].authority" />
						</div>
					</div>
				</div>
				
				<form:hidden path="userCredentials.enabled" value="TRUE" />

				<div>
					<div >
						<input type="submit" id="btnAdd" value="Save" />
					</div>
				</div>

			</fieldset>
		</form:form>
	</section>
</body>
</html>
