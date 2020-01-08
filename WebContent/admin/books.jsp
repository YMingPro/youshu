<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.youshu.admin.bean.BookBean"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>

<%-- 基本模型 --%>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%-- css引入 --%>
<link href="../others/font-awesome-4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href="../others/layui/css/layui.css" rel="stylesheet">
<link href="../others/layui/css/layuimini.css" rel="stylesheet">
<link href="../css/back-utils.css" rel="stylesheet">
<title>有书网后台 - 图书管理</title>
<%-- ico引入 --%>
<link rel="Shortcut Icon" href="../img/admin.ico" />
<link rel="icon" href="../img/admin.ico" />


</head>
<body class="layui-layout-body">
	<%
		@SuppressWarnings("unchecked")
		List<BookBean> list = (List<BookBean>) request.getAttribute("list");
	%>
	<div class="layui-layout layui-layout-admin">
		<%-- 头部 --%>
		<jsp:include page="head.jsp"></jsp:include>

		<%-- 左侧导航栏 --%>
		<jsp:include page="nav.jsp"></jsp:include>

		<%-- 主体内容区域 --%>
		<div class="layui-body">
			<fieldset class="layui-elem-field layui-field-title">
				<legend style="font-weight: normal">图书管理</legend>
			</fieldset>
			<div class="layui-row layui-col-space15">
				<div class="layui-col-xs12">
					<%-- 添加图书 --%>
					<div class="layui-card">
						<div class="layui-card-header">添加图书</div>
						<div class="layui-card-body layui-row layui-col-space10">
							<div class="layui-col-xs12">
								<button class="layui-btn" type="button" id="addcommodity">添加商品</button>
							</div>
						</div>
					</div>
					<%-- 搜索框 --%>
					<div class="layui-card">
						<div class="layui-card-header">图书查询</div>
						<div class="layui-card-body layui-row layui-col-space10">
							<div class="layui-col-xs12">
								<form class="layui-form" action="BookSearch" method="post">
									<div class="layui-col-xs10">
										<input name="conditions" value="${requestScope.conditions }"
											autocomplete="off" type="text" class="layui-input">
									</div>
									<div class="layui-col-xs2" style="text-align: center;">
										<button class="layui-btn" id="selectButton"
											style="width: 100%;">查询</button>
									</div>
								</form>
							</div>
						</div>
					</div>
					<%-- 查询结果 --%>
					<div class="layui-card">
						<div class="layui-card-header">查询结果</div>
						<div class="layui-card-body layui-row layui-col-space10">
							<div class="layui-col-xs12">
								<table lay-filter="table">
									<thead>
										<tr>
											<th
												lay-data="{field : 'ISBN',title : '#',sort : true,type : 'numbers',fixed : 'left'}"></th>
											<th
												lay-data="{field:'Status',width:50,type:'checkbox',fixed : 'left'}"></th>
											<th lay-data="{field:'test1',sort : true,title:'ISBN',minWidth:150}"></th>
											<th lay-data="{field:'test3',sort : true,title:'书名',minWidth:150,}"></th>
											<th lay-data="{field:'test2',sort : true,title:'作者',minWidth:150}"></th>
											<th lay-data="{field:'test4',sort : true,title:'出版社',minWidth:150}"></th>
											<th lay-data="{field:'test5',sort : true,title:'售价',minWidth:80}"></th>
											<th
												lay-data="{field:'test6',sort : true,title:'简介',width:360}"></th>
											<th lay-data="{field:'test7',sort : true,title:'库存',minWidth:80}"></th>
											<th
												lay-data="{title : '操作',width : 140,toolbar : '#tableBar',unresize : true,align : 'center'}"></th>
										</tr>
									</thead>
									<tbody>
										<%
											for (int i = 0; i < list.size(); i++) {
										%>
										<tr>
											<td><%=list.get(i).getBookISBN()%></td>
											<td></td>
											<td><%=list.get(i).getBookISBN()%></td>
											<td><%=list.get(i).getBookName()%></td>
											<td><%=list.get(i).getBookAuthor()%></td>
											<td><%=list.get(i).getBookPublisher()%></td>
											<td><%=list.get(i).getBookPrice()%></td>
											<td><%=list.get(i).getBookInfo()%></td>
											<td><%=list.get(i).getBookStock()%></td>
											<td></td>
										</tr>
										<%
											}
										%>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<%-- 批量操作 --%>
					<div class="layui-card">
						<div class="layui-card-header">批量操作</div>
						<div class="layui-card-body layui-row layui-col-space10">
							<div class="layui-col-xs12">
								<form class="layui-form" action="BookDelete" method="post"
									id="batchSelect">
									<div class="layui-inline">
										<div class="layui-input-inline" style="width: 180px;">
											<select name="batchSelect" lay-verify="required"
												lay-filter="batchSelect">
												<option value="del">批量删除</option>
											</select>
										</div>
										<div class="layui-input-inline">
											<button class="layui-btn" type="button" lay-submit
												lay-filter="executeList">执行</button>
											<button style="display: none;" type="submit"></button>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/html" id="tableBar">
		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
		<a class="layui-btn layui-btn-xs" lay-event="img">图片</a>
	</script>

	<%-- 加载js --%>
	<script src="../others/jquery.min.js"></script>
	<script src="../others/layui/layui.js"></script>
	<script src="../others/layui/lay-config.js"></script>
	<script src="../js/back-utils.js"></script>
	<script src="../js/back-book.js"></script>
</body>
</html>