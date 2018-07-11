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
	<table id="cdg"></table>
	<div id="cdlg" style="display:none">
		<div class="easyui-panel" style="width:100%;max-width:600px;padding:30px 60px;">
		<form id="cff" method="post">
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="cno.Cno" id="Cno" style="width:100%" data-options="label:'课程号:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="cno.Cname" id="Cname" style="width:100%" data-options="label:'课程名:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-numberbox" name="cno.GPA" id="GPA" style="width:100%" data-options="label:'学分:',required:true,precision:1">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="cno.Tno" id="Tno" labelPosition="top" style="width:100%" data-options="label:'任课教师教工号:'">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="cno.Tname" id="Tname" labelPosition="top" style="width:100%" data-options="label:'任课教师姓名:'">
			</div>
		</form>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function(){
		var B1	= Xbutton("Cnoadd","cdlg","cff","cdg");
		var B2  = Xbutton("Cnoupdate","cdlg","cff","cdg");
		var toolbar = [{
			text:'增加',
			iconCls:'icon-add',
			handler:function(){
				$('#cff').form('clear');
				$('#Cno').textbox('textbox').attr('readonly',false);
				$('#cdlg').dialog({
					height:460,
					width:400,
					title:"增加信息",
					buttons: B1
				})
			}
		},{
			text:'修改',
			iconCls:'icon-edit',
			handler:function(){
// 				$('#dg').datagrid('reload');
// 				alert('add');
				var row = $('#cdg').datagrid('getSelected');
				if(row)
				{
					$('#Cno').textbox('textbox').attr('readonly',true);
					$('#Cno').textbox('setValue',row.cno);
					$('#Cname').textbox('setValue',row.cname);
 					$('#GPA').numberbox('setValue',row.gPA);
 					$('#Tno').textbox('setValue',row.tno);
 					$('#Tname').textbox('setValue',row.tname);
					$('#cdlg').dialog({
						height:460,
						width:400,
						title:"修改信息",
						buttons:B2
					})
				}
			}
		},'-',{
			text:'删除',
			iconCls:'icon-cancel',
			handler:function(){
				var row = $('#cdg').datagrid('getSelected');
				if(row)
				{
					Cconfirm(row);
				}
			}
		}];
	    $('#cdg').datagrid({
	        url:"Cnomessage.action",
	        fit:true,
	        toolbar:toolbar,
	        singleSelect:true,
	        columns:[[
	    		{field:'cno',title:'课程号',width:100},
	    		{field:'cname',title:'课程名',width:100},
	    		{field:'gPA',title:'学分',width:100,formatter:function(val,rowData,rowIndex){
	    			if(val!=null)
	    				return val.toFixed(1);
	    		}
	    			
	    		},
	    		{field:'tno',title:'任课教师教工号',width:150,align:'right'},
	    		{field:'tname',title:'任课教师姓名',width:150,align:'right'}
	        ]]
	    });
	});
</script>
</html>