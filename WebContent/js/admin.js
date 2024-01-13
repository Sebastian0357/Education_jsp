$(function() {

	showBase()

	$("td").click(
			function() {
				$(this).addClass("s1").siblings().removeClass("s1");
				$(this).addClass("s1").parent().siblings().children()
						.removeClass("s1");
				showBase()
			});

	$("td").dblclick(function() {
		var cname = $(".s1").find("p").text();
		$("#cityname").val(cname);
		$("form").submit();
	});
	function showBase() {
		var arr = $(".s1").find("input").val()

		$("#cityText").text(' ')
		var q = arr.split(" ");
		for (var i = 0; i < q.length; i++) {
			tr = '<tr></tr>';
			td = '<td>' + q[i] + '</td>';
			$("#cityText").append(td)
			if ((i + 1) % 4 == 0) {
				$("#cityText").append(tr)
			}
		}
	}

});