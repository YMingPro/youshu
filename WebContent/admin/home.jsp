<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<% request.setCharacterEncoding("UTF-8");%>

<!DOCTYPE html>
<html>
<head>
<title>有书网后台 - 首页</title>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<%-- 引入css --%>
<link href="../others/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link href="../others/layui/css/layui.css" rel="stylesheet">
<link href="../others/layui/css/layuimini.css" rel="stylesheet">
<link rel="stylesheet" href="../others/layui/css/public.css" media="all">
<link rel="stylesheet" href="../css/back-home.css" media="all">
<%-- 引入icon --%>
<link rel="Shortcut Icon" href="../img/admin.ico" />
<link rel="icon" href="../img/admin.ico" />
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">

		<%-- 头部 --%>
		<jsp:include page="head.jsp"></jsp:include>

		<%-- 左侧导航栏 --%>
		<jsp:include page="nav.jsp"></jsp:include>

		<div class="layui-body">
			<div class="layuimini-container layui-card-body">
				<%-- 上面部分 --%>
				<div class="layuimini-main layui-top-box ">
					<%-- 总统计板块 --%>
					<div class="layui-row layui-col-space10">

						<div class="layui-col-md3">
							<div class="col-xs-6 col-md-3">
								<div class="panel layui-bg-cyan">
									<div class="panel-body">
										<div class="panel-title">
											<span class="label pull-right layui-bg-blue">实时</span>
											<h3>用户统计</h3>
										</div>
										<div class="panel-content" style="margin-top: 7px">
											<h1 class="no-margins">${userCount}</h1>
											<div class="stat-percent font-bold text-gray">
												<i class="fa fa-commenting" style="visibility: hidden"></i>
											</div>
											<small>当前分类总记录数</small>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="layui-col-md3">
							<div class="col-xs-6 col-md-3">
								<div class="panel layui-bg-blue">
									<div class="panel-body">
										<div class="panel-title">
											<span class="label pull-right layui-bg-cyan">实时</span>
											<h3>图书统计</h3>
										</div>
										<div class="panel-content" style="margin-top: 7px">
											<h1 class="no-margins">${bookCount }</h1>
											<div class="stat-percent font-bold text-gray">
												<i class="fa fa-commenting" style="visibility: hidden"></i>
											</div>
											<small>当前分类总记录数</small>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="layui-col-md3">
							<div class="col-xs-6 col-md-3">
								<div class="panel layui-bg-green">
									<div class="panel-body">
										<div class="panel-title">
											<span class="label pull-right layui-bg-orange">实时</span>
											<h3>浏览统计</h3>
										</div>
										<div class="panel-content" style="margin-top: 7px">
											<h1 class="no-margins">${visitCount}</h1>
											<div class="stat-percent font-bold text-gray">
												<i class="fa fa-commenting" style="visibility: hidden"></i>
											</div>
											<small>当前分类总记录数</small>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="layui-col-md3">
							<div class="col-xs-6 col-md-3">
								<div class="panel layui-bg-orange">
									<div class="panel-body">
										<div class="panel-title">
											<span class="label pull-right layui-bg-green">实时</span>
											<h3>订单统计</h3>
										</div>
										<div class="panel-content" style="margin-top: 7px">
											<h1 class="no-margins">${orderCount}</h1>
											<div class="stat-percent font-bold text-gray">
												<i class="fa fa-commenting" style="visibility: hidden"></i>
											</div>
											<small>当前分类总记录数</small>
										</div>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>
				<%-- 上面部分结束 --%>
				<%-- 下面部分 --%>
				<div class="layuimini-main">
					<div class="layui-row layui-col-space15">
						<%-- 图表板块 --%>
						<div class="layui-col-md8">
							<div class="layui-row layui-col-space15">


								<div class="layui-col-md12">
									<div class="layui-card">
										<div class="layui-card-header">
											<i class="fa fa-line-chart icon"></i>报表统计
										</div>
										<div class="layui-card-body">
											<div id="echarts-records"
												style="width: 100%; min-height: 535px"></div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<%-- 信息板块 --%>
						<div class="layui-col-md4">
							<%--  分割线 --%>
							<div class="layui-card">
								<div class="layui-card-header">
									<i class="fa fa-tag icon icon-tip"></i>当前天气
								</div>
								<div class="layui-card-body layui-text" align="middle">
									<iframe width="420" scrolling="no" height="60" frameborder="0"
										allowtransparency="true"
										src="//i.tianqi.com/index.php?c=code&id=12&icon=1&py=dongguan&num=5&site=12"></iframe>
								</div>
							</div>
							<%--  分割线 --%>
							<div class="layui-card">
								<div class="layui-card-header">
									<i class="fa fa-bullhorn icon icon-tip"></i>系统信息
								</div>
								<div class="layui-card-body layui-text">
									<div class="layuimini-notice">
										<div class="layuimini-notice-title">${msgInfo}</div>
										<div class="layuimini-notice-extra"><%=new SimpleDateFormat("yyyy-MM-dd").format(new Date())%></div>
									</div>
								</div>
								<div class="layui-card-body layui-text">
									<div class="layuimini-notice">
										<div class="layuimini-notice-title">上次登录时间：${loginTime}</div>
										<div class="layuimini-notice-extra"><%=new SimpleDateFormat("yyyy-MM-dd").format(new Date())%></div>
									</div>
								</div>
							</div>
							<%--  分割线 --%>
							<div class="layui-card">
								<div class="layui-card-header">
									<i class="fa fa-warning icon"></i>数据统计
								</div>
								<div class="layui-card-body">
									<div class="welcome-module">
										<div class="layui-row layui-col-space10">

											<div class="layui-col-xs6">
												<div class="panel layui-bg-number">
													<div class="panel-body">
														<div class="panel-title">
															<h5>今天新用户数</h5>
														</div>
														<div class="panel-content">
															<h1 class="no-margins">${usertoday}</h1>
															<small>当前分类总记录数</small>
														</div>
													</div>
												</div>
											</div>

											<div class="layui-col-xs6">
												<div class="panel layui-bg-number">
													<div class="panel-body">
														<div class="panel-title">
															<h5>今天新评价数</h5>
														</div>
														<div class="panel-content">
															<h1 class="no-margins">${evaluationtoday}</h1>
															<small>当前分类总记录数</small>
														</div>
													</div>
												</div>
											</div>

											<div class="layui-col-xs6">
												<div class="panel layui-bg-number">
													<div class="panel-body">
														<div class="panel-title">
															<h5>今天新浏览数</h5>
														</div>
														<div class="panel-content">
															<h1 class="no-margins">${visittoday}</h1>
															<small>当前分类总记录数</small>
														</div>
													</div>
												</div>
											</div>

											<div class="layui-col-xs6">
												<div class="panel layui-bg-number">
													<div class="panel-body">
														<div class="panel-title">
															<h5>今天新订单数</h5>
														</div>
														<div class="panel-content">
															<h1 class="no-margins">${ordertoday}</h1>
															<small>当前分类总记录数</small>
														</div>
													</div>
												</div>
											</div>

										</div>
									</div>
								</div>

							</div>
							<%--  分割线 --%>
						</div>

					</div>
				</div>
				<%-- 下面部分结束 --%>
			</div>
		</div>
	</div>
	<%-- 引入js --%>
	<script src="../others/jquery.min.js" charset="utf-8"></script>
	<script src="../others/layui/layui.js" charset="utf-8"></script>
	<script src="../others/layui/lay-config.js?v=1.0.4" charset="utf-8"></script>
	<script src="../js/back-utils.js"></script>
	<script>
		layui.use(
						[ 'layer', 'layuimini', 'echarts' ],
						function() {
							var $ = layui.jquery, 
							layer = layui.layer, 
							layuimini = layui.layuimini,
							echarts = layui.echarts;

							$('.login-out').click(function() {
								var layerOpen = layer.open({
									content : "确认退出登录吗？",
									title : "退出",
									btn : [ '确定', '取消' ],
									resize : false,
									shadeClose : true,
									yes : function(index, layero) {
										layer.close(layerOpen);
										window.top.location.href = "BackLogout";
									}
								});
							});
							
							/**
							 * 报表功能
							 */

							var echartsRecords = echarts.init(document
									.getElementById('echarts-records'),
									'walden');
							var optionRecords = {
								tooltip : {
									trigger : 'axis'
								},
								legend : {
									data : [ '用户数量', '浏览数量', '订单数量' ]
								},
								grid : {
									left : '3%',
									right : '4%',
									bottom : '3%',
									containLabel : true
								},
								toolbox : {
									feature : {
										saveAsImage : {}
									}
								},
								xAxis : {
									type : 'category',
									boundaryGap : false,
									data : [ '前5天', '前4天', '前3天', '前2天', '前1天',
											'昨天', '今天' ]
								},
								yAxis : {
									type : 'value'
								},
								series : [
										{
											name : '用户数量',
											type : 'line',
											data : [ ${userdate[6]}, ${userdate[5]}, ${userdate[4]}, ${userdate[3]}, ${userdate[2]},
												${userdate[1]},${userdate[0]}]
},
										
										{
											name : '浏览数量',
											type : 'line',
											data : [ ${visitdate[6]}, ${visitdate[5]}, ${visitdate[4]}, ${visitdate[3]}, ${visitdate[2]},
												${visitdate[1]}, ${visitdate[0]}]
										},
										
										{
											name : '订单数量',
											type : 'line',
											data : [ ${orderdate[6]}, ${orderdate[5]}, ${orderdate[4]}, ${orderdate[3]}, ${orderdate[2]},
												${orderdate[1]}, ${orderdate[0]} ]
										} ]
							};
							echartsRecords.setOption(optionRecords);

							// echarts 窗口缩放自适应
							window.onresize = function() {
								echartsRecords.resize();
							}

						});
	</script>
</body>
</html>
