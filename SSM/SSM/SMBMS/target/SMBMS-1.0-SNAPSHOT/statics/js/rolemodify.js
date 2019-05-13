var proContact = null;
var proPhone = null;
var saveBtn = null;
var backBtn = null;

$(function(){
	proContact = $("#proName");
	saveBtn = $("#save");
	backBtn = $("#back");
	//初始化的时候，要把所有的提示信息变为：* 以提示必填项，更灵活，不要写在页面上
	proContact.next().html("*");

	/*
	 * 验证
	 * 失焦\获焦
	 * jquery的方法传递
	 */
	proContact.on("focus",function(){
		validateTip(proContact.next(),{"color":"#666666"},"* 请输入角色名称",false);
	}).on("blur",function(){
		if(proContact.val() != null && proContact.val() != ""){
			validateTip(proContact.next(),{"color":"green"},imgYes,true);
		}else{
			validateTip(proContact.next(),{"color":"red"},imgNo+" 角色不能为空，请重新输入",false);
		}
		
	});


	
	saveBtn.on("click",function(){
		proContact.blur();
		if(proContact.attr("validateStatus") == "true" ){
			if(confirm("是否确认提交数据")){
				$("#providerForm").submit();
			}
		}
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