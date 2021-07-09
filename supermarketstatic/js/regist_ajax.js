


/**
 * 提交表单校验
 * @param element 表单标签
 * @returns {boolean} 是否已婚徐提交
 */
function register(element) {
    let userName = $(element).find("input[name=username]").val();
    let userPassword = $(element).find("input[name=password]").val();
    let userEmail = $(element).find("input[name=email]").val();
    let result = true;
    result = checkNull("username", "用户名不能为空") && result;
    result = checkNull("password", "密码不能为空") && result;
    result = checkNull("password2", "确认密码不能为空") && result;
    result = checkNull("email", "手机号不能为空") && result;
    result = isEqual("password", "两次密码输入不一致") && result;
    console.log(result);

    if (result) {
        $.ajax({
            url: "http://localhost:8585/user/register",
            type: "post",
            data: {
                "username": userName,
                "password": userPassword,
                "phone": userEmail,
            },
            dataType: "json",
            success: function (result) {
                if (result.status == true) {
                    // 注册成功
                    var afdata = JSON.stringify(result);
                    var af = JSON.parse(afdata);
                    //console.log(af.data.userid);
                    document.cookie="uid="+af.data.userid;
                    window.location.href = "./regist_success.html";
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
    return false;
}


/**
 * 用户名输入框离焦事件
 * @param element 标签
 */
function usernameBlur(element) {
    let userName = $(element).val();
    if (!checkNull("username", "用户名不能为空")) {
        setMsg("username", "用户名不能为空");
    } else {
        $.ajax({
            url: "http://localhost:8585/user/checkUser",
            type: "post",
            data: {"username": userName},
            dataType: "json",
            success: function (result) {
                if (result == false ) {
                    // 用户名重复
                    $("#username_msg").text("用户名已存在");
                } else if (result == true ) {
                    // 用户名可用
                    $("#username_msg").text("用户名可用").css("color", "green");
                } else {
                    // 其他异常
                    alert(result.msg);
                }
            },
            error: function () {
                alert("请求失败！");
            }
        });
    }
}

/**
 * 检查是否为空
 * @param name input的name
 * @param msg 提示消息
 * @returns {boolean} 是否通过校验
 */
function checkNull(name, msg){
    let value = $("input[name=" + name + "]").val();
    if ($.trim(value) === "") {
        setMsg(name, msg);
        return false;
    }else{
        setMsg(name, "");
        return  true;
    }
}
/**
 * 设置校验消息提示
 * @param name input的name
 * @param msg 提示的消息
 */
function setMsg(name, msg) {
    $("#" + name + "_msg").text(msg);
}

/**
 * 一致性校验
 * @param name input的name
 * @param msg 提示消息
 * @return {boolean} 是否通过校验
 */
function isEqual(name, msg){
    let pwd = $("input[name=" + name + "]").val();
    let pwd2 = $("input[name=" + name + "2]").val();
    if ($.trim(pwd) === "" || $.trim(pwd2) === ""){
        // 如果二者有一个为0，这是前面非空校验要做的事情
        return false;
    }
    if ($.trim(pwd) !== "" && $.trim(pwd2) !== "" && pwd !== pwd2) {
        setMsg(name, msg);
        setMsg(name + "2", msg);
        return false;
    }else{
        setMsg(name, "");
        setMsg(name + "2", "");
        return true;
    }
}

/**
 * 是否为邮箱
 * @param name input的name
 * @param msg 提示消息
 * @return {boolean} 是否为邮箱
 */
function isEmail(name, msg){
    let value = $("input[name=" + name + "]").val();
    let reg = /^\w+(\.\w+)*@\w+(\.\w+)+$/;
    if ($.trim(value) === "")
        // 如果为空，这是前面非空校验做的事情
        return false;
    if (!reg.test(value)) {
        setMsg(name, msg);
        return false;
    }else {
        setMsg(name, "");
        return true;
    }
}
