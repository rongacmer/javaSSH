<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="SSH.css">
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="function.js"></script>
	<script type="text/javascript" src="teatabs.js"></script>
	<title>管理系统</title>
</head>

<body>
	<div id="hidebg"></div>
	<div class="easyui-layout" data-options="fit:true">
		<div data-options="region:'north'" style="height:50px">
			<div>
				${userName}
				&nbsp;&nbsp;
			</div>
			<div>
				<a href="javascript:void(0)" onclick="Xshow('editpassword');">修改密码</a>|<a href="login.action">注销</a>
			</div>
		</div>
		<div data-options="region:'west',split:true" title="菜单" style="width:150px;">
			<div class="easyui-accordion" data-options="fit:true">
				<div title="信息管理" style="padding:10px;">
					<ul id="tree"></ul>
				</div>
			</div>
		</div>
		<div data-options="region:'center'">
        	<div id="tabs" class="easyui-tabs" data-options="fit: true, border: false,showOption: true, enableNewTabMenu: true, enableJumpTabMenu: true">
        	</div>
		</div>
</body>
	<%@include file="dialog.jsp"%>
</html>

