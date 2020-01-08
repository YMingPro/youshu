<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- ico引入 --%>

<header>
	<div class="layui-header header"
		onclick="window.location.href= *${pageContext.request.contextPath}/admin/index*;return false">
		">
		<div class="layui-logo" onclick="window.location.href='/youshu_System/admin/index';return false">
			<img src="../img/admin.png" alt="logo">
			<h1>有书网后台</h1>
		</div>
		<a>
			<span class="layuimini-tool">
				<i title="展开" class="fa fa-outdent" data-side-fold="1"></i>
			</span>
		</a>
		<ul class="layui-nav layui-layout-right">

			<li class="layui-nav-item layuimini-setting"><a
				href="javascript:;">admin</a>
				<dl class="layui-nav-child">
					<dd>
						<a href="javascript:;" class="login-out">退出登录</a>
					</dd>
				</dl></li>


			<li class="layui-nav-item layuimini-select-bgcolor mobile layui-hide-xs" style="margin:0px 20px">
				<i
					class="fa fa-ellipsis-v"></i>
			</li>
		</ul>
	</div>
	<script>
    layui.use(['element', 'layer', 'layuimini'], function () {
        var $ = layui.jquery,
            element = layui.element,
            layer = layui.layer;

        $('.login-out').on("click", function () {
            layer.msg('退出登录成功', function () {
                window.location = '/page/login-1.html';
            });
        });
    });
</script>
</header>