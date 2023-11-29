$(function () {
    $("#username").blur(checkUsername);//blur失去焦点
    $("#password").blur(checkPwd);

    $("#form_one").submit(function () {
        var flag = true;
        if (!checkUsername()) { flag = false; }
        if (!checkPwd()) { flag = false; }
        return flag;
    });
    //验证账号
    function checkUsername() {
//        var phone = $("#username").val();
//        var phones = /^1\d{10}$/;
//        if (phones.test(phone) == false) {
//            $("#checkPhone").text("请输入11位手机号");
//            return false
//        }
        return true
    }
    //验证密码
    function checkPwd() {
        var $pwd = $("#password").val();
        var paws = /^[0-9]{6,12}$/;
        if (paws.test($pwd) == false) {
            $("#checkPass").text("请输入6到12位纯数字密码");
            return false
        }
        return true
    }
})