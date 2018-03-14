// Helper function to serialize all the form fields into a JSON string
function formToJSON() {
	return JSON.stringify({
		"lat1": $('#lat1').val(), 
		"lat2": $('#lat2').val(), 
		"lng1": $('#lng1').val(),
		"lng2": $('#lng2').val()
		});
}

function genDistance(){
	console.log('getDistance');
	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: "http://localhost:8080/Exercise1/WS/Part2/Abc",
		dataType: "text",
		data: formToJSON(),
		success: function(response){
			document.getElementById("distance").innerHTML=response;
		},
		error: function (err) {
	        alert("AJAX error in request: " + JSON.stringify(err, null, 2));
	    }
	});
}

