<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>




		<h2>THis is THe header</h2>

		<div class="jumbotron">
			<h1>
				<tiles:insertAttribute name="heading" />
			</h1>
			<p>							
				<tiles:insertAttribute name="tagline" />
			</p>	
		</div>					
