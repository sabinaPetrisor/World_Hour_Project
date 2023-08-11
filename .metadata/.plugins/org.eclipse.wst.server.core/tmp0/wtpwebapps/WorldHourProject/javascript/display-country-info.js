$(document).ready(function() {
	$('#search-button').click(function(e) {
		var cid = $('#cid').val();
		var cname = $('#cname').val();
		var ccapital = $('#ccapital').val();
		var ccontinent = $('#ccontinent').val();
		
		$.ajax ({
			type: 'post',
			url: "<%=WHPView.MainServlet %>",
			data: {
				cid: cid,
				cname: cname,
				ccapital: ccapital,
				ccontinent: ccontinent
			},
			success: function(msg) {
				$('#result').html(msg);
			}
		})
		e.preventDefault();
	});
});