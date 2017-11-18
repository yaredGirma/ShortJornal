/**
 * 
 */


$(document).ready(function(){

	var contextRoot = "/" + window.location.pathname.split('/')[1];
	
	removeEvent = function(eventId) {
	    
		$.ajax({
			url: contextRoot+'/events/remove/'+ eventId,
	 		type: 'PUT',
			dataType: "json",
			contentType: "application/json",
		 	 success: function (response) {
	 		 		location.reload(true);
				},
				error: function(){						
					location.reload(true);
		 	 } 
	   });
   }
	
});

