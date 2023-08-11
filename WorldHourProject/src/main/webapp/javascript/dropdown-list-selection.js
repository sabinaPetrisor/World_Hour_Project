$(document).ready(function() {
	$('#add-button').click(function(e) {
		var countryName = $('#cname').val();
		var capitalName = $('#ccapital').val();
		var continentName = $('#ccontinent option:selected').val();
		
		$.ajax({
			type: 'post',
			url: "<%=WHPView.AddCountryServlet %>",
			data: { 
				cname: countryName,
				ccapital: capitalName,
				ccontinent: continentName
				},
			success: function(msg) {
				$('#successful-db-insertion').text(msg);
				window.location = "<%=WHPView.AdminPage %>";
			}
		})
		e.preventDefault();
		
	})
});