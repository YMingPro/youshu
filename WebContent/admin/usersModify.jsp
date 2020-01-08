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
		<form class="layui-form" action="UserUpdate" method="post" style="text-align: center;">
			<input type="hidden" name="UID" value="${requestScope.user.userId}" />
			<input type="text" value="用户 ${requestScope.user.userId}" class="layui-input" disabled="disabled" style="margin-bottom: 10px;text-align:center;border-style:none;font-weight:bold;font-size:20px" />
      		
      		 	<input type="text" name="userName" required  lay-verify="required"
      		 placeholder="请填写用户名" value="${requestScope.user.userName}" autocomplete="off" class="layui-input" style="margin-bottom: 15px;">
      	
			<select name="userSex" lay-verify="required" lay-filter="">
				<c:if test='${requestScope.user.userSex eq "男" }'>
					<option value="男" selected>男</option>
					<option value="女">女</option>
				</c:if>
				<c:if test='${requestScope.user.userSex eq "女" }'>
					<option value="男">男</option>
					<option value="女" selected>女</option>
				</c:if>
			</select>
			
			<div style="margin-bottom: 20px;"></div>
			
      		 
	        <button class="layui-btn layui-btn-fluid" lay-submit lay-filter="submit">保存</button>
		</form>
	</div>
	
	<%-- 加载js --%>
	<script src="../others/jquery.min.js"></script>
	<script src="../others/layui/layui.js"></script>
	<script src="../js/back-utils.js"></script>
</body>
</html>