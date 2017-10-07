//详情
function details(outDoorId){
	    layer.open({
			type: 2,
			title: '详情页',
			shadeClose: true,
			shade: 0.8,
			area: ['1002px', '55%'],
			content: '../details.html?outdoorId='+outDoorId //url
	    });
}