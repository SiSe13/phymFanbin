var SUCCESS=0;
$(function(){
	inforMation()
});

function  inforMation(){
	var url ="";
	var data={userId:getCookie("userId")};
	$.post(url,data,function(result){
		if(result.status==SUCCESS){
			
		}
	});
}


