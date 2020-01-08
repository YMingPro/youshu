<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<link href="../others/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link href="../others/layui/css/layui.css" rel="stylesheet">
<link href="../css/back-utils.css" rel="stylesheet">
<%-- ico引入 --%>
<link rel="Shortcut Icon" href="../img/admin.ico" />
<link rel="icon" href="../img/admin.ico" />
</head>
<body>
	
	<div style="padding: 15px 10px 0px 10px;">
		<form class="layui-form" action="BookUpdate" method="post" style="text-align: center;">
			<input type="hidden" name="ISBN" value="${requestScope.book.bookISBN}" />
			
      		
      		 <input type="text" name="bookISBN" required lay-verify="required|number" value="${requestScope.book.bookISBN}"
      		 		placeholder="请填写ISBN" autocomplete="off" class="layui-input" style="margin-top: 10px;margin-bottom: 10px;">
					<input type="text" name="bookName" required  lay-verify="required" value="${requestScope.book.bookName}"
      		 		placeholder="请填写书名" autocomplete="off" class="layui-input" style="margin-bottom: 10px;">
					<input type="text" name="bookAuthor" required  lay-verify="" value="${requestScope.book.bookAuthor}"
      		 		placeholder="请填写作者" autocomplete="off" class="layui-input" style="margin-bottom: 10px;">
					<input type="text" name="bookPublisher" required  lay-verify="" value="${requestScope.book.bookPublisher}"
      		 		placeholder="请填写出版社" autocomplete="off" class="layui-input" style="margin-bottom: 10px;">
					<textarea  type="text" name="bookInfo" required  lay-verify="" style="height:100px;margin-bottom: 10px;"
      		 		placeholder="请填写简介" autocomplete="off" class="layui-input" style="margin-bottom: 10px;">${requestScope.book.bookInfo}</textarea>
      		 		
      		 		<div class="layui-col-xs6" style="padding-right: 5px;">
	      		 		<input type="text" name="bookStock" required  lay-verify="required|number" value="${requestScope.book.bookStock}"
	      		 		placeholder="请填写库存" autocomplete="off" class="layui-input" style="margin-bottom: 10px;">
      		 		</div>
      		 		<div class="layui-col-xs6" style="padding-left: 5px;">
	      		 		<input type="text" name="bookPrice" required  lay-verify="required|number" value="${requestScope.book.bookPrice}"
	      		 		placeholder="请填写价格" autocomplete="off" class="layui-input" style="margin-bottom: 10px;">
      		 		</div>
			
			
			<div style="margin-bottom: 20px;"></div>
			
      		 
	       
	        <button class="layui-btn layui-btn-fluid " lay-submit lay-filter="submit">保存</button>
		</form>
	</div>
	<%-- 加载js --%>
	<script src="../others/jquery.min.js"></script>
	<script src="../others/layui/layui.js"></script>
	<script src="../js/back-utils.js"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		layui.use(['form'], function(){
			var form = layui.form;
		});
	});
	</script>
</body>
</html>