var proCode = null;
var proName = null;
var proContact = null;
var proPhone = null;
var addBtn = null;
var backBtn = null;

$(function(){
	proCode = $("#proCode");
	proName = $("#proName");
	addBtn = $("#add");
	backBtn = $("#back");
	//初始化的时候，要把所有的提示信息变为：* 以提示必填项，更灵活，不要写在页面上
	proCode.next().html("*");
	proName.next().html("*");

	
	/*
	 * 验证
	 * 失焦\获焦
	 * jquery的方法传递
	 */
	proCode.on("blur",function(){
		if(proCode.val() != null && proCode.val() != ""){
			//使用getJSON验证用户商编码的验证
			$.getJSON("role/checkExists.json",{"roleCode":proCode.val()},function (data) {
				if(data.result.code == 1001){
					//不存在
                    validateTip(proCode.next(),{"color":"green"},imgYes,true);
				}else{
					//存在
                    validateTip(proCode.next(),{"color":"red"},imgNo+" 角色商编码已存在，请重新输入",false);
				}
            });

		}else{
			validateTip(proCode.next(),{"color":"red"},imgNo+" 角色编码不能为空，请重新输入",false);
		}
	}).on("focus",function(){
		//显示友情提示
		validateTip(proCode.next(),{"color":"#666666"},"* 请输入角色商编码",false);
	}).focus();
	
	proName.on("focus",function(){
		validateTip(proName.next(),{"color":"#666666"},"* 请输入角色名称",false);
	}).on("blur",function(){
		if(proName.val() != null && proName.val() != ""){
			validateTip(proName.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(proName.next(),{"color":"red"},imgNo+" 角色名称不能为空，请重新输入",false);
		}
		
	});
	

	

	
	addBtn.bind("click",function(){
		if(proCode.attr("validateStatus") != "true"){
			proCode.blur();
		}else if(proName.attr("validateStatus") != "true"){
			proName.blur();
		}else{
			if(confirm("是否确认提交数据")){
				$("#providerForm").submit();
			}
		}
	});
	
	backBtn.on("click",function(){
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