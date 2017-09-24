$(function(){
	$(".tpl-table-fz-check").click(function(){
        if ($(this).is(':checked')) {
        	$("[name='test']").prop("checked",true);
        }else{
        	$("[name='test']").prop("checked",false);
        }
    });
});
     
     //若有一个未全选，取消全选
$(".tpl-table-fz-check").each(function(){
        $(this).click(function () {
            if($(this).is(':checked')){
                var num=0;
                $(".tpl-table-fz-check").each(function(){
                    if($(this).is(':checked')){
                        num++;
                }
                });
                if(num==$(".tpl-table-fz-check").length){
                	$("[name='test']").prop("checked",true);
                }
            }else{
            	$(".tpl-table-fz-check").prop("checked", false);
            }
        })
    });
      