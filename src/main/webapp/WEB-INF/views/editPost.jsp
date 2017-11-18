<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%-- <%@ include file="/WEB-INF/tiles/template/navigation.jsp" %> --%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Post</title>
</head>
<body>

	<div id="content-wrap">
		<div id="centerForm">

			<form:form commandName="editPost">
				<fieldset>
					<h2 style="color:#9fcc7f; margin-bottom: 40px;">Edit Post</h2>
					<form:errors path="*" class="alert-danger" element="div" />

					<label for="title">Title</label>
					<form:input id="title" path="title" type="text" class="postField" value="${post.title}" />

					<label for="desciption">Desciption</label>
					<form:textarea id="desciption" path="desciption" rows="5" cols="22" class="postField" value="${post.desciption}"/>

					<label for="date">Date</label>
					<form:input id="date" path="date" value="${post.date}" />

					<input type="submit" value="Add" id="add" /> <input type="reset" />
				</fieldset>

			</form:form>
		</div>
	</div>
</body>
</html>