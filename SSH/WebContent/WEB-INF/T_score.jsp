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
	<table id="tsdg">
	</table>
	<div id="ttool" style="padding:2px 5px;display:none">
		课程： <input class="easyui-textbox" id="cno" style="width:110px" data-options="required:true">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="checkscore()">查询</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save"   onclick="endEditing();scoresave();"   plain="true">保存成绩</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="scorecomfirm()"  plain="true">提交成绩</a>
	</div>
	
</body>
<script type="text/javascript">
	var editIndex = undefined;
	function endEditing(){
		if (editIndex == undefined){return true}
		if ($('#tsdg').datagrid('validateRow', editIndex)){
			$('#tsdg').datagrid('endEdit', editIndex);
			editIndex = undefined;
			return true;
		} else {
			return false;
		}
	} 
	$(function(){
	    $('#tsdg').datagrid({
	    	singleSelect: true,
			toolbar: "#ttool",
		    fit:true,
			url: "Scoreoutput.action",
			rownumbers:true,
			 onDblClickRow: function (index) {	                //双击开启编辑行
				 	if (editIndex != index){
							if (endEditing()){
								$('#tsdg').datagrid('selectRow', index)
										.datagrid('beginEdit', index);
								editIndex = index;
							} else {
								$('#tsdg').datagrid('selectRow', editIndex);
							}
						}
	                },
// 	                onBeforeEdit:function(index,row){
// 	                    row.editing = true;
// 	                    $('#tsdg').datagrid('refreshRow', index);
// 	                },
// 	                onAfterEdit:function(index,row){
// 	                    row.editing = false;
// 	                    $('#tsdg').datagrid('refreshRow', index);
// 	                },
// 	                onCancelEdit:function(index,row){
// 	                    row.editing = false;
// 	                    $('#tsdg').datagrid('refreshRow', index);
// 	                },
// 			method: "get",
	        columns:[[
	        	{field:'sno',title:'学号',width:100,align:'right'},
	    		{field:'score',title:'成绩',width:100,align:'right',editor:{type:'numberbox',options:{min:0,max:100}}}
	        ]]
	    });
	}); 
</script>
</html>