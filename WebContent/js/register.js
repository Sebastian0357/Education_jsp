$(function() {
	pwdfocus()
	$("#username").blur(checkUsername);
	$("#password").blur(checkPwd);
	$("#confirm_password").blur(confirmpassword);

	$("#sub").click(function() {
		if (!checkPwd()) {
			return false;
		}
		if (!confirmpassword()) {
			return false;
		}
		$("[name='flag']").val("1");
		$("form").submit();
		return true;
	});
	// 验证账号的方法
	function checkUsername() {

		$("[name='flag']").val("0");
		$("form").submit();
		return true
	}
	// 验证密码的方法
	function checkPwd() {
		var pwd = $("#password").val();
		var paws = /^[0-9]{6,12}$/;
		if (paws.test(pwd) == false) {
			$("#checkPass").text("请输入6到12位纯数字密码");
			return false
		}
		return true
	}

	function confirmpassword() {
		var pwd = $("#password").val();
		var confirmpwd = $("#confirm_password").val();
		if (pwd != confirmpwd) {
			$("#checkConPass").text("请确认密码");
			return false
		}
		return true
	}
	function pwdfocus() {
		if($("#username").val() != "") {
			$("#password").focus();
		}
	}

})