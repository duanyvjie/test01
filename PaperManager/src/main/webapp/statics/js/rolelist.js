var userObj;

//用户管理页面上点击删除按钮弹出删除框(userlist.jsp)
function deleteUser(obj){
	$.ajax({
		type:"GET",
		url:path+"/role/delete",
		data:{roleid:obj.attr("userid")},
		dataType:"json",
		success:function(data){
			if(data.delResult == "true"){//删除成功：移除删除行
				cancleBtn();
				obj.parents("tr").remove();
				alert("删除角色【"+obj.attr("username")+"】成功");
			}else if(data.delResult == "false"){//删除失败
				//alert("对不起，删除用户【"+obj.attr("username")+"】失败");
				changeDLGContent("对不起，删除用户【"+obj.attr("username")+"】失败");
			}else if(data.delResult == "notexist"){
				//alert("对不起，用户【"+obj.attr("username")+"】不存在");
				changeDLGContent("对不起，用户【"+obj.attr("username")+"】不存在");
			}
		},
		error:function(data){
			//alert("对不起，删除失败");
			changeDLGContent("对不起，删除失败");
		}
	});
}

function openYesOrNoDLG(){
	$('.zhezhao').css('display', 'block');
	$('#removeUse').fadeIn();
}

function cancleBtn(){
	$('.zhezhao').css('display', 'none');
	$('#removeUse').fadeOut();
}
function changeDLGContent(contentStr){
	var p = $(".removeMain").find("p");
	p.html(contentStr);
}

$(function(){
	//通过jquery的class选择器（数组）
	//对每个class为viewUser的元素进行动作绑定（click）
	/**
	 * bind、live、delegate
	 * on
	 */
	$(".viewUser").on("click",function(){
		//将被绑定的元素（a）转换成jquery对象，可以使用jquery方法
		var obj = $(this);
		/*window.location.href=path+"/role/view/"+ obj.attr("roleid");*/
		$.ajax({
			type:"GET",//请求类型
			url:path+"/user/view",//请求的url
			data:{id:obj.attr("userid")},//请求参数
			dataType:"json",//ajax接口（请求url）返回的数据类型
			success:function(data){//data：返回数据（json对象）
				$(".providerView #userCode").html(data.userCode);
				$(".providerView #userName").html(data.userName);
				if (data.gender == 1){
					$(".providerView #gender").html("男");
				}else {
					$(".providerView #gender").html("女");
				}

				$(".providerView #birthday").html(data.birthday);
				$(".providerView #phone").html(data.phone);
				$(".providerView #address").html(data.address);
				$(".providerView #userRoleName").html(data.userRoleName);
				/*if(data.user != null){//账号已存在，错误提示
					validateTip(userView,{"color":"red"},imgNo+ " 该用户账号已存在",false);
				}else{//账号可用，正确提示
					validateTip(userView,{"color":"green"},imgYes+" 该账号可以使用",true);
				}*/
			}
		});
	});
	
	$(".modifyUser").on("click",function(){
		var obj = $(this);
		window.location.href=path+"/role/toRoleModify/"+ obj.attr("userid");
	});

	$('#no').click(function () {
		cancleBtn();
	});
	
	$('#yes').click(function () {
		deleteUser(userObj);
	});

	$(".deleteUser").on("click",function(){
		userObj = $(this);
		changeDLGContent("你确定要删除角色【"+userObj.attr("username")+"】吗？");
		openYesOrNoDLG();
	});

});