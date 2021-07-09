/*
function getuname(element){

    //获取用户名
    userId = document.cookie;
    console.log(userId);
    if (userId != null) {
        console.log("cookie:" + userId);
        uid = userId.split("=")[1];
        console.log(uid);
        let uname = "";
        $.ajax({
            url: "http://localhost:8585/user/"+uid,
            type: "get",
            dataType: "json",
            success: function (result) {
                if (result.status == true) {
                    // 注册成功
                    var afdata = JSON.stringify(result);
                    var af = JSON.parse(afdata);
                    //console.log(af);
                    uname = af.data.username;
                    $("#head_span").text(" 当前用户："+uname);
                } else if (result.status == false) {
                    // 后端校验出错
                    $("#alert").text(result.message);
                } else {
                    alert(result.msg);
                }
            },
            error: function () {
                alert("请求失败！");
            }
        });
    }
}

*/
