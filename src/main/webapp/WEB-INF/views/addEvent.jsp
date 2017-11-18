<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="title.event.add"/></title>
</head>
<body>
<div class="container">
    <form:form modelAttribute="newEvent" action="addEvent" method="POST">
    <p>
  		<form:errors path="*" cssStyle="color : red;" /> 
    </p>
    <p>
    	<label for="description"><spring:message code="form.event.description"/></label>
    	<form:textarea path="description" id="description" rows="30" cssStyle="min-width: 70em"/>
    	<div style="text-align: center;">
 				<form:errors path="description" cssStyle="color : red;" /> 
 		</div>
    </p>
    <p>
    	<label for="duration"><spring:message code="form.event.duration"/></label>
    	<form:select path="duration.id" items="${durations}" id="duration" itemValue="id" itemLabel="duration" cssStyle="min-width: 70em"/>
   		<div style="text-align: center;">
 				<form:errors path="duration.id" cssStyle="color : red;" /> 
 		</div>
    </p>
    <p>
    	<label for="feeling"><spring:message code="form.event.feeling"/></label>
    	<form:select path="feeling.id" items="${feelings}" id="feeling" itemValue="id" itemLabel="feeling" cssStyle="min-width: 70em"/>
    	<div style="text-align: center;">
 				<form:errors path="feeling.id" cssStyle="color : red;" /> 
 		</div>
    </p>
    <p>
    	<label for="type"><spring:message code="form.event.type"/></label>
    	<form:select path="type.id" items="${types}" id="type" itemValue="id" itemLabel="type" cssStyle="min-width: 70em"/>
    	<div style="text-align: center;">
 				<form:errors path="type.id" cssStyle="color : red;" /> 
 		</div>
    </p>
    <p>
    	<label for="frequency"><spring:message code="form.event.frequency"/></label>
    	<form:select path="frequency.id" items="${frequencies}" id="frequency" itemValue="id" itemLabel="frequency" cssStyle="min-width: 70em"/>
    	<div style="text-align: center;">
 				<form:errors path="frequency.id" cssStyle="color : red;" /> 
 		</div>
    </p>
    <p>
    	<label for="date"><spring:message code="form.event.date"/></label>
    	<form:input path="date" id="date" cssStyle="min-width: 70em"/>
    	<div style="text-align: center;">
 				<form:errors path="date" cssStyle="color : red;" /> 
 		</div>
    </p>
    <p>
        <input id="submit" type="submit" value="<spring:message code="form.event.btn.add"/>">
    </p>
    </form:form>
</div>
</body>
