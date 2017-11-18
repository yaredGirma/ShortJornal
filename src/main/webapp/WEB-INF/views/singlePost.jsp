<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/resource/css/style.css"
	rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


   <!-- Content
   ================================================== -->
   <div id="content-wrap">

   	<div class="row" >

   		<div class="eight columns" id="blogColumn">

   			<article class="entry">

					<header class="entry-header">

						<h2 class="entry-title">
							${post.title}
						</h2> 				 
				
						<div class="entry-meta">
							<ul>
								<li>${post.date }</li>
								
							</ul>
						</div> 
				 
					</header> 
				
					<div class="entry-content-media">
						<div class="post-thumb">
							<img src="${pageContext.request.contextPath}/resource/images/m-farmerboy.jpg">
						</div> 
					</div>

					<div class="entry-content" >
						<p class="lead">${post.desciption}</p>
					</div>

<hr/>
  			       <ul class="post-nav group">
  			            <li class="prev"><a rel="prev" href="<spring:url value='/blog/post?id=${post.id-1}' />"><strong>Previous Article</strong></a></li>
  				         <li class="next"><a rel="next" href="<spring:url value='/blog/post?id=${post.id+1}' />"><strong>Next Article</strong></a></li>
  			        </ul>

				</article>

				<!-- Comments
            ================================================== -->
            <div id="comments">



               <!-- respond -->
               <div class="respond">

                  <h3>Leave a Comment</h3>

                  <!-- form -->
                  <form name="contactForm" id="contactForm" method="post" action="">
  					   <fieldset>

                     <div class="group">
  						      <label for="cName">Name <span class="required">*</span></label>
  						      <input name="cName" type="text" id="cName" size="35" value="" />
                     </div>

                     <div class="group">
  						      <label for="cEmail">Email <span class="required">*</span></label>
  						      <input name="cEmail" type="text" id="cEmail" size="35" value="" />
                     </div>

                     <div class="group">
  						      <label for="cWebsite">Website</label>
  						      <input name="cWebsite" type="text" id="cWebsite" size="35" value="" />
                     </div>

                     <div class="message group">
                        <label  for="cMessage">Message <span class="required">*</span></label>
                        <textarea name="cMessage"  id="cMessage" rows="10" cols="50" ></textarea>
                     </div>

                     <button type="submit" class="submit">Submit</button>

  					   </fieldset>
  				      </form> <!-- Form End -->

               </div> <!-- Respond End -->

            </div>  <!-- Comments End -->		
   			

   		</div> <!-- main End -->

   		<div id="sidebar" class="four columns">

   			<div class="widget widget_search">
                  <h3>Search</h3> 
                  <form action="#">

                     <input type="text" value="Search here..." onblur="if(this.value == '') { this.value = 'Search here...'; }" onfocus="if (this.value == 'Search here...') { this.value = ''; }" class="text-search">
                     <input type="submit" value="" class="submit-search">

                  </form>
               </div>

   			<div class="widget widget_categories group">
   				<h3>Categories.</h3> 
   				<ul>
						<li><a href="#" title="">Wordpress</a> (2)</li>
						<li><a href="#" title="">Ghost</a> (14)</li>
						<li><a href="#" title="">Joomla</a> (5)</li>
						<li><a href="#" title="">Drupal</a> (3)</li>
						<li><a href="#" title="">Magento</a> (2)</li>
						<li><a href="#" title="">Uncategorized</a> (9)</li>						
					</ul>
				</div>

				<div class="widget widget_text group">
					<h3>Widget Text.</h3>

   				<p>Lorem ipsum Ullamco commodo laboris sit dolore commodo aliquip incididunt fugiat esse dolor aute fugiat minim eiusmod do velit labore fugiat officia ad sit culpa labore in consectetur sint cillum sint consectetur voluptate adipisicing Duis irure magna ut sit amet reprehenderit.</p>

   			</div>

   			<div class="widget widget_tags">
               <h3>Post Tags.</h3>

               <div class="tagcloud group">
                	<a href="#">Corporate</a>
                  <a href="#">Onepage</a>
                  <a href="#">Agency</a>
                  <a href="#">Multipurpose</a>
                  <a href="#">Blog</a>
                  <a href="#">Landing Page</a>
                  <a href="#">Resume</a>
               </div>
                  
            </div>

            <div class="widget widget_popular">
               <h3>Popular Post.</h3>

               <ul class="link-list">
                  <li><a href="#">Sint cillum consectetur voluptate.</a></li>
                  <li><a href="#">Lorem ipsum Ullamco commodo.</a></li>
                  <li><a href="#">Fugiat minim eiusmod do.</a></li>                     
               </ul>
                  
            </div>
   			
   		</div> <!-- end sidebar -->

  		</div> <!-- end row -->

   </div> <!-- end content-wrap -->   


</body>
</html>