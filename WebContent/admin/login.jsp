<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>有书网后台登录</title>
<%-- 引入css --%>
<link rel="stylesheet" type="text/css" href="../css/normalize.css" />
<link rel="stylesheet" type="text/css" href="../css/demo.css" />
<link rel="stylesheet" type="text/css" href="../css/component.css" />
<link rel="stylesheet" type="text/css" href="../others/layui/css/layui.css" />
<style>
	input:-webkit-autofill, textarea:-webkit-autofill, select:-webkit-autofill {
		-webkit-text-fill-color: #ededed !important;
		-webkit-box-shadow: 0 0 0px 1000px transparent inset !important;
		background-color: transparent;
		background-image: none;
		transition: background-color 50000s ease-in-out 0s;
	}
	input {
		background-color: transparent;
	}
</style>
<%-- 引入icon --%>
<link rel="Shortcut Icon" href="../img/admin.ico" />
<link rel="icon" href="../img/admin.ico" />
</head>
<body>
	<div class="container demo-1">
		<div class="content">
			<div id="large-header" class="large-header">
				<canvas id="demo-canvas"></canvas>
				<div class="logo_box">
					<div style="text-align: center">
						<img src="../img/index.png">
					</div>
					<form class="layui-form" action="BackLogin" name="f" method="post">
						<div class="input_outer ">
							<span class="u_user"></span> <input name="username" class="text"
								style="color: #FFFFFF !important" type="text" 
								placeholder="请输入账户">
						</div>
						<div class="input_outer">
							<span class="us_uer"></span> <input name="password" class="text"
								style="color: #FFFFFF !important; position: absolute; z-index: 100;"
								value="" type="password" placeholder="请输入密码" >
						</div>
						<div class="mb2">
							<button
								class="layui-btn layui-btn-fluid layui-btn layui-btn-lg layui-btn-radius layui-btn-normal" lay-submit lay-filter="login">
								<strong>登 入</strong>
							</button>

						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<%-- 引入js --%>
	<script type="text/javascript" src="../others/jquery.min.js"></script>
	<script type="text/javascript" src="../others/layui/layui.js"></script>
	<script type="text/javascript" src="../js/TweenLite.min.js"></script>
	<script type="text/javascript" src="../js/EasePack.min.js"></script>
	<script type="text/javascript" src="../js/rAF.js"></script>
	<script type="text/javascript" src="../js/demo-1.js"></script>
	<script>
		layui.use([ 'form' ], function() {
			var form = layui.form, layer = layui.layer;

			// 登录过期的时候，跳出ifram框架
			if (top.location != self.location)
				top.location = self.location;

			// 进行登录操作
			form.on('submit(login)', function(data) {
				data = data.field;
				if (data.username == '') {
					layer.msg('用户名不能为空');
					return false;
				} else if (data.password == '') {
					layer.msg('密码不能为空');
					return false;
				} else {
					if (data.username == 'admin' && data.password == '123456') {
						window.location.href = 'LoginCheck'
					} else {
						layer.msg('账号或密码错误');
					}
				}
				return false;
			});
		});
	</script>
</body>
</html>