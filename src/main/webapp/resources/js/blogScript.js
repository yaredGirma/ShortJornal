/**
 * 
 */


$(document).ready(function(){

	var contextRoot = "/" + window.location.pathname.split('/')[1];

	removeFromCart = function(postId) {
		
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
	    
		$.ajax({
			url: contextRoot+'/blogManagement/remove/'+ postId,
	 		type: 'PUT',
			dataType: "json",
			beforeSend: function(xhr) {
	            // here it is
	            xhr.setRequestHeader(header, token);
	        },
		 	 success: function (response) {
	 		 		location.reload(true);
				},
				error: function(){						
//					alert('Error while request..');
					location.reload(true);
					
//					console.log(postId);
		 	 } 
	   });
   }
	
});

