$(document).ready(function() {
	layui.use([ 'element', 'layer', 'form', 'util', 'layuimini' ], function() {
		var element = layui.element;
		var layer = layui.layer;
		var form = layui.form;
		var util = layui.util;

		var $ = layui.jquery, element = layui.element, layer = layui.layer;
		// echarts 窗口缩放自适应
		window.onresize = function() {
			echartsRecords.resize();
		}

		util.fixbar({});
		$('.login-out').click(function() {
			var layerOpen = layer.open({
				content : "确认退出登录吗？",
				title : "退出",
				btn : [ '确定', '取消' ],
				resize : false,
				shadeClose : true,
				yes : function(index, layero) {
					layer.close(layerOpen);
					window.top.location.href = "Logout";
				}
			});
		});
		
		$('#tj').click(function() {
			layer.open({
				type : 2,
				title : '统计销售额',
				resize : false,
				move : false,
				shadeClose : true,
				area : [ '500px', '580px' ],
				content : 'SaleSelect',
			});
		});
	});
});

function checkImgType(type) {
	if (type.indexOf('image/') != -1) {
		return true;
	}
	return false;
}
