var SUCCESS = 0;

$(function(){
	//页面加载时查询所有的数据
	enquiriesOutDoors();
	
	//检索
	$("#search_in").click(search_adv); 
	
	//绑定“翻页”笔记本列表点击事件
	/*$('#notebooks').on('click','li',showPagedNotesAction);*/
	
	
	
});
