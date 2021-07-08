




/**
 * 登录事件
 * @returns {boolean}
 */
function login(){
	//获取页面数据
	let userName = $.trim($("form input[name=username]").val());
	let userPassword = $.trim($("form input[name=password]").val());
	if(userName===""){
		$("form table tr:eq(0) td span").html("用户名不能为空");
		return false;
	}
	if(userPassword===""){
		$("form table tr:eq(1) td span").html("密码不能为空");
		return false;
	}



	$.ajax({
		url:"http://localhost:8585/user/login",
		type:"post",
		data:{
			"username": userName,
			"password": userPassword,
		},
		dataType:"json",
		success:function(result){
			//result是服务端返回的数据
			if(result.data != null) {
				// 登录成功
				var af = JSON.stringify(result);
				var af = JSON.parse(af);
				//console.log(af.data.userid);
				document.cookie="uid="+af.data.userid;
				//$.cookie("uid", af.data.userid, { expires: 7 });		

				window.location.href = "./index.html";
				
			}else if (result.data == null){
				// 用户不存在
				alert("用户不存在")
			}else{
				alert(result.data);
			}
		},
		error:function(){
			alert("请求失败!");
		}
	});
	return false;
}

