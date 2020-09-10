var userName = null;
var userRole = null;
var saveBtn = null;
var backBtn = null;

$(function(){
	roleCode = $("#roleCode");
	roleName = $("#roleName");
	saveBtn = $("#save");
	backBtn = $("#back");

	roleCode.next().html("*");
	roleName.next().html("*");

	/*roleCode.bind("blur",function(){
		//ajax后台验证--roleCode
		$.ajax({
			type:"GET",//请求类型
			url:path+"/role/rcexist",//请求的url
			data:{roleCode:roleCode.val()},//请求参数
			dataType:"json",//ajax接口（请求url）返回的数据类型
			success:function(data){//data：返回数据（json对象）
				if(data.roleCode == "exist"){//账号已存在，错误提示
					validateTip(roleCode.next(),{"color":"red"},imgNo+ " 该角色编码已存在",false);
				}else{//账号可用，正确提示
					validateTip(roleCode.next(),{"color":"green"},imgYes+" 该角色编码可以使用",true);
				}
			},
			error:function(data){//当访问时候，404，500 等非200的错误状态码
				validateTip(roleCode.next(),{"color":"red"},imgNo+"请求错误，您访问的页面不存在",false);
			}
		});


	}).bind("focus",function(){
		//显示友情提示
		validateTip(roleCode.next(),{"color":"#666666"},"* 角色编码是唯一编码",false);
	}).focus();*/
	

	

	
	saveBtn.on("click",function(){
		/*userName.blur();
		phone.blur();
		birthday.blur();
		userRole.blur();
		if(userName.attr("validateStatus") == "true" 
			&& phone.attr("validateStatus") == "true"
			&& birthday.attr("validateStatus") == "true"
			&& userRole.attr("validateStatus") == "true"){*/
			if(confirm("是否确认要提交数据？")){
				$("#userForm").submit();
			}
		/*}*/
	});
	
	backBtn.on("click",function(){
		//alert("modify: "+referer);
		if(referer != undefined 
			&& null != referer 
			&& "" != referer
			&& "null" != referer
			&& referer.length > 4){
		 window.location.href = referer;
		}else{
			history.back(-1);
		}
	});
});