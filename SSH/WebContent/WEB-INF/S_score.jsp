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
	<table id="ssdg">
	</table>
</body>
<script type="text/javascript">
	$(function(){
		 $('#ssdg').datagrid({
		        url:"Scorequery.action",
		        fit:true,
		        singleSelect:true,
		        rownumbers:true,
		        columns:[[
		    		{field:'cname',title:'课程名',width:100,align:'right'},
		    		{field:'credit',title:'学分',width:100,align:'right',formatter:function(val,rowData,rowIndex){
		    			if(val!=null)
		    				return val.toFixed(1);
		    		}},
		    		{field:'gpa',title:'绩点',width:100,align:'right',formatter:function(val,rowData,rowIndex){
		    			if(val!=null)
		    				return val.toFixed(1);
		    		}},
		    		{field:'score',title:'总成绩',width:150,align:'right'}
		        ]]
		    });
	}); 
</script>
</html>