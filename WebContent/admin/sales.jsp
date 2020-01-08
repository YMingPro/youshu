<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>销售额</title>
<%-- 基本模型 --%>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%-- css引入 --%>
<link href="../others/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link href="../others/layui/css/layui.css" rel="stylesheet">
<link href="../css/back-utils.css" rel="stylesheet">
<%-- ico引入 --%>
<link rel="Shortcut Icon" href="../img/admin.ico" />
<link rel="icon" href="../img/admin.ico" />
</head>
<body>
	<div style="padding: 15px 10px 0px 10px;">
		<form class="layui-form" action="SaleSelect" method="post">
			<div class="layui-col-xs12">
				<div class="layui-col-xs6 " style="padding: 0 5px;">
					<div style="line-height: 38px;">
						<span>销售额：</span> <span style="font-size: 28px;">¥${requestScope.sum}</span>
					</div>
				</div>
				<div class="layui-col-xs6"
					style="padding: 0 5px; text-align: right;">
					<button class="layui-btn" lay-submit lay-filter="submit">统计</button>
				</div>
			</div>

			<span class="clear"></span>
			<div style="border-bottom: 1px dashed #dedede; margin: 10px 0;"></div>
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">开始日期：</label>
					<div class="layui-input-block">
						<input type="text" name="date1" id="date1" autocomplete="off"
							class="layui-input" value='${requestScope.beginTime}'>
					</div>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-inline">
					<label class="layui-form-label">结束日期：</label>
					<div class="layui-input-block">
						<input type="text" name="date2" id="date" autocomplete="off"
							class="layui-input" value='${requestScope.endTime}'>
					</div>
				</div>
			</div>
		</form>
	</div>

	<%-- 加载js --%>
	<script src="../others/jquery.min.js"></script>
	<script src="../others/layui/layui.js"></script>
	<script src="../js/back-utils.js"></script>
	<script>
		layui.use([ 'form', 'layedit', 'laydate' ],
			function() {
				var form = layui.form, layer = layui.layer, layedit = layui.layedit, laydate = layui.laydate;

				//日期
				laydate.render({
					elem : '#date'
				});
				laydate.render({
					elem : '#date1'
				});

			});
		$(document).ready(function() {
			layui.use([ 'form', 'laydate' ], function() {
				var form = layui.form;
				var laydate = layui.laydate;
				laydate.render({
					elem : '#time',
					type : 'date',
					calendar : true,
				});
			});
		});
	</script>

</body>
</html>