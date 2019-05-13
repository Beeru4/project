var userObj;

//用户管理页面上点击删除按钮弹出删除框(userlist.jsp)
function deleteUser(obj) {
    $.ajax({
        type: "GET",
        /*url:path+"/jsp/user.do",*/
        url: path + "/sys/user/delUser",
        data: { uid: obj.attr("userid")},
        dataType: "json",
        success: function (data) {
            if (data.key.delResult == "true") {//删除成功：移除删除行
                cancleBtn();
                //obj.parents("tr").remove();
                location.reload();
            } else if (data.key.delResult == "false") {//删除失败
                //alert("对不起，删除用户【"+obj.attr("username")+"】失败");
                changeDLGContent("对不起，删除用户【" + obj.attr("username") + "】失败");
            } else if (data.key.delResult == "notexist") {
                //alert("对不起，用户【"+obj.attr("username")+"】不存在");
                changeDLGContent("对不起，用户【" + obj.attr("username") + "】不存在");
            }
        },
        error: function (data) {
            //alert("对不起，删除失败");
            changeDLGContent("对不起，删除失败");
        }
    });
}

function openYesOrNoDLG() {
    $('.zhezhao').css('display', 'block');
    $('#removeUse').fadeIn();
}

function cancleBtn() {
    $('.zhezhao').css('display', 'none');
    $('#removeUse').fadeOut();
}

function changeDLGContent(contentStr) {
    var p = $(".removeMain").find("p");
    p.html(contentStr);
}

$(function () {
    //通过jquery的class选择器（数组）
    //对每个class为viewUser的元素进行动作绑定（click）
    /**
     * bind、live、delegate
     * on
     */
    $(".viewUser").on("click", function () {
        //将被绑定的元素（a）转换成jquery对象，可以使用jquery方法
        var obj = $(this);
        /*path+"/jsp/user.do?method=view&uid="+ obj.attr("userid");*/
        window.location.href = path + "/sys/user/userview/" + obj.attr("userid");
    });

    $(".modifyUser").on("click", function () {
        var obj = $(this);
        /*/jsp/user.do?method=modify&uid=*/
        window.location.href = path + "/sys/user/modifyBefore/" + obj.attr("userid");
    });

    $('#no').click(function () {
        cancleBtn();
    });

    $('#yes').click(function () {
        deleteUser(userObj);
    });

    $(".deleteUser").on("click", function () {
        userObj = $(this);
        //判断 如果登录的用户是自己 不能删除
        if (userObj.attr("username").trim() == $("#logName").text().trim()) {
            changeDLGContent("删除失败,您删除的当前是登陆用户!");
            openYesOrNoDLG();
            $("#yes").css("display","none");
        } else {
            $("#yes").css("display","inline-block");
            changeDLGContent("你确定要删除用户【" + userObj.attr("username") + "】吗？");
            openYesOrNoDLG();
        }

    });

    /*$(".deleteUser").on("click",function(){
        var obj = $(this);
        if(confirm("你确定要删除用户【"+obj.attr("username")+"】吗？")){
            $.ajax({
                type:"GET",
                url:path+"/jsp/user.do",
                data:{method:"deluser",uid:obj.attr("userid")},
                dataType:"json",
                success:function(data){
                    if(data.delResult == "true"){//删除成功：移除删除行
                        alert("删除成功");
                        obj.parents("tr").remove();
                    }else if(data.delResult == "false"){//删除失败
                        alert("对不起，删除用户【"+obj.attr("username")+"】失败");
                    }else if(data.delResult == "notexist"){
                        alert("对不起，用户【"+obj.attr("username")+"】不存在");
                    }
                },
                error:function(data){
                    alert("对不起，删除失败");
                }
            });
        }
    });*/
});