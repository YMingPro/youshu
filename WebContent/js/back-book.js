$(document).ready(function(){
	layui.use(['form','table','layer'], function(){
		var form = layui.form;
		var table = layui.table;
		var layer = layui.layer;
		table.init('table', {
			id : 'table',
			page : true,
			loading : true,
			text : {
				none: '暂无相关数据'
			},
		});
		table.on('tool(table)',function(obj){
			var data = obj.data;
			var layEvent = obj.event;
			var ISBN = data.ISBN;
			if(layEvent == "edit"){
				layer.open({
					type: 2,
					title: '修改书本信息',
					resize: false,
					move: false,
					shadeClose: true,
					area: ['500px','50%'],
					content: 'BookOne?ISBN='+ISBN,
					end: function(){
						$('#selectButton').click();
					},
				});
			}else{
				layer.open({
					type: 2,
					title: '修改书本图片',
					resize: false,
					move: false,
					shadeClose: true,
					area: ['465px','430px'],
					content: ['BookImgOne?ISBN='+ISBN,'no'],
				});
			}
		});
		$('#addcommodity').click(function(){
			layer.open({
				type: 2,
				title: '添加书本',
				resize: false,
				move: false,
				shadeClose: true,
				area: ['460px','750px'],
				content: ['booksAdd.jsp','no'],
			});
		});
		form.on('submit(executeList)', function(dt){
			var layerOpen = layer.open({
				content : "确认删除吗？",
				title : "批量删除",
				btn : [ '确定', '取消' ],
				resize: false,
				shadeClose: true,
				yes : function(index, layero) {
					layer.close(layerOpen);
					var action = dt.field.batchSelect;
					if(action == "del"){
						var d = table.checkStatus('table').data;
						for(var i=0;i<d.length;i++){
							var content = "<input type='hidden' value='"+d[i].ISBN+"' name='ISBN' />";
							$(content).appendTo('#batchSelect');
						}
						$('#batchSelect button[type="submit"]').click();
					}
				}
			});
		});
	});
});
