$(function () {
    var bjtb = '<tr><td>铁道兵纪念馆</td><td>中国法院博物馆</td><td>中国海关博物馆</td><td>中国妇女儿童博物馆</td></tr>' +
        '<tr><td>中国华侨历史博物馆</td><td>宋庆龄同志故居</td><td>北京新文化运动纪念馆</td><td>北京正负电子对撞机实验室</td></tr>' +
        '<tr><td>中国印刷博物馆</td><td>北京李大钊故居</td></tr>';
    $("#cityText").append(bjtb)
    $("td").click(function () {
        $(this).addClass("s1").siblings().removeClass("s1");
        $(this).addClass("s1").parent().siblings().children().removeClass("s1");
        text = $(this).children().text();
        
        for (let key in a) {
            var k = key.trim();
            var t = text.trim();
            console.log(k);
            console.log(t);
            if (k === t) {

                $("#cityText").text(' ')
                var introduce = a[key];
                var q = introduce.split(" ");
                // alert(q)
                for (var i = 0; i < q.length; i++) {
                    // alert(i)
                    tr = '<tr></tr>';
                    td = '<td>' + q[i] + '</td>';
                    $("#cityText").append(td)
                    if ((i + 1) % 4 == 0) {
                        $("#cityText").append(tr)
                    }

                }
            }
        }
    });

});