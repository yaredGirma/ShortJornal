<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>


<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />


<link href="${pageContext.request.contextPath}/resource/css/style.css"
	rel="stylesheet" />


<header id="top">

	<nav id="nav-wrap">

		<a class="mobile-btn" href="#nav-wrap" title="Show navigation">Show
			Menu</a> <a class="mobile-btn" href="#" title="Hide navigation">Hide
			Menu</a>

		<div class="row">

			<ul id="nav" class="nav">
				<li>Lang: <a href="?language=mn_MN">MN</a>|<a
					href="?language=en_US">EN</a></li>
			
				<security:authorize access="isAuthenticated()">
					<li><a href="<spring:url value="/welcome"/>"><spring:message
								code="menu.home" /></a></li>
				</security:authorize>

				<security:authorize access="isAuthenticated()">
					<li><a href="<spring:url value='/addEvent' />"
						class="btn btn-default pull-right"> <spring:message
								code="menu.event.add" /></a></li>
				</security:authorize>

				<security:authorize access="isAuthenticated()">
					<li><a href="<spring:url value='/viewEvents' />"
						class="btn btn-default pull-right"> <spring:message
								code="menu.events.view" /></a></li>
				</security:authorize>

				<security:authorize access="hasRole('ROLE_ADMIN')">
					<li><a href="<spring:url value='/blogManagement/posts' />"
						class="btn btn-default pull-right"> Blog Management </a></li>
				</security:authorize>


				<li><a href="<spring:url value='/blog' />"
					class="btn btn-default pull-right"> <spring:message
							code="menu.blog" /></a></li>

				<security:authorize access="isAnonymous()">
					<li><a href="<spring:url value='/login' />"
						class="btn btn-default pull-right"> <spring:message
								code="menu.login" /></a></li>
				</security:authorize>

				<security:authorize access="isAnonymous()">
					<li><a href="<spring:url value='/registers/addUser' />"
						class="btn btn-default pull-right"> Sign Up</a></li>
				</security:authorize>

				<security:authorize access="hasRole('ROLE_ADMIN')">
					<li><a href="<spring:url value='/registers/addAdmin' />"
						class="btn btn-default pull-right"> Add Admin</a></li>
				</security:authorize>

				<security:authorize access="hasRole('ROLE_ADMIN')">
					<li><a href="<spring:url value='/registers' />"
						class="btn btn-default pull-right"> Users</a></li>
				</security:authorize>

				<security:authorize access="hasRole('ROLE_USER')">
					<li><a href="<spring:url value='/feedback/feedbackList'  />"
						class="btn btn-default pull-right"> Feedbacks</a></li>
				</security:authorize>

				<security:authorize access="isAuthenticated()">
					<li><a href="<spring:url value='/flowFeedback' />"
						class="btn btn-default pull-right"> <spring:message
								code="menu.event.add.feedback" /></a></li>
				</security:authorize>

				<security:authorize access="isAuthenticated()">
					<li><a href="<spring:url value='/logout' />"
						class="btn btn-default pull-right"> <spring:message
								code="menu.logout" /></a></li>
				</security:authorize>



			</ul>
			<!-- end #nav -->

		</div>

	</nav>
	<!-- end #nav-wrap -->

</header>
<!-- Header End -->




