<%@ page language="java" contentType="text/html; utf-8"
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
	<script type="text/javascript" src="treetabs.js"></script>
</head>
<body>
	<table id="sdg"></table>
	<div id="stool" style="padding:2px 5px;display:none">
		课程： <input class="easyui-textbox" id="cno" style="width:110px" data-options="required:true">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="querycou()">查询</a>
		学号： <input class="easyui-textbox" id="sno" style="width:110px">
		<a href="javascript:void(0)" class="easyui-linkbutton" id="addstudent" onclick="addcou()" iconCls="icon-add"  plain="true">增加学生</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="delcou()"  plain="true">删除学生</a>
	</div>
</body>
<script type="text/javascript">
	$(function(){
		$('#addstudent').linkbutton('disable');
	    $('#sdg').datagrid({
	        url:"Selshow.action",
	        fit:true,
	        toolbar:'#stool',
	        singleSelect:true,
	        columns:[[
	    		{field:'id',title:'学号',width:100},
	    		{field:'sname',title:'姓名',width:100}
	        ]]
	    });
	});
</script>
</html>