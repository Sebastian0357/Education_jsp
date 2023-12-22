$(function () {
	
	showBase()
	
    $("td").click(function () {
        $(this).addClass("s1").siblings().removeClass("s1");
        $(this).addClass("s1").parent().siblings().children().removeClass("s1");
        showBase()
    });
    
	function showBase() {
		var arr = $(".s1").find("input").val()
      
		$("#cityText").text(' ')
		var q = arr.split(" ");
		for (var i = 0; i < q.length; i++) {
	          tr = '<tr></tr>';
	          td = '<td><a href="https://www.baidu.com/s?wd=' + q[i] + '">' + q[i] + '</a></td>';
	          $("#cityText").append(td)
	          if ((i + 1) % 4 == 0) {
	              $("#cityText").append(tr)
	          }
		}
	}
});