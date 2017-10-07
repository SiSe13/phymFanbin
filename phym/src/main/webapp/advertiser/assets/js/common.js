$(function(){
	var $wholeChexbox=$(".tpl-table-fz-check");
	 $wholeChexbox.click(function(){
        if($(this).is(":checked")){
           $("[name=test]").prop("checked",true);
         //若有一个未全选，取消全选
           $("[name=test]").each(function(){
              $(this).click(function () {
                  if($(this).is(':checked')){
                      var num=0;
                      $("[name=test]").each(function(){
                          if($(this).is(':checked')){
                              num++;
                      }
                      });
                      if(num==$("[name=test]").length){
                          $wholeChexbox.prop("checked", true);                   
                      }
                  }else{
                      $wholeChexbox.prop("checked", false);                
                  }
              })
          })
        }else{
        	$("[name=test]").prop("checked",false);
        }
    });
});