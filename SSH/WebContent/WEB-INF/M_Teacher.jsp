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
	<table id="tdg"></table>
	<div id="tdlg" style="display:none">
		<div class="easyui-panel" style="width:100%;max-width:400px;padding:30px 60px;">
		<form id="tff" method="post">
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="tea.Tno" id="Tid" style="width:100%" data-options="label:'教工号:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="tea.Tname" id="Tname" style="width:100%" data-options="label:'姓名:',required:true">
			</div>
			<div style="margin-bottom:20px">
				<select class="easyui-combobox" name="tea.TSex" id="Tsex" style="width:100%" data-options="label:'性别:',panelHeight: 'auto',editable:false"><option value="男">男</option><option value="女">女</option></select>
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-textbox" name="tea.phone" id="Tphone" style="width:100%" data-options="label:'手机:'">
			</div>
		</form>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function(){
		var B1	= Xbutton("Teacheradd","tdlg","tff","tdg");
		var B2  = Xbutton("Teacherupdate","tdlg","tff","tdg");
		var toolbar = [{
			text:'增加',
			iconCls:'icon-add',
			handler:function(){
				$('#tff').form('clear');
				$('#Tid').textbox('textbox').attr('readonly',false);
				$('#Tsex').combobox('setValue',"男");
				$('#tdlg').dialog({
					height:350,
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
				var row = $('#tdg').datagrid('getSelected');
				if(row)
				{
					$('#Tid').textbox('textbox').attr('readonly',true);
					$('#Tid').textbox('setValue',row.tno);
					$('#Tname').textbox('setValue',row.tname);
 					$('#Tsex').combobox('setValue',row.tSex);
 					$('#Tphone').textbox('setValue',row.phone);
					$('#tdlg').dialog({
						height:350,
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
				var row = $('#tdg').datagrid('getSelected');
				if(row)
				{
					Tconfirm(row);
				}
			}
		}];
	    $('#tdg').datagrid({
	        url:"Teachermessage.action",
	        fit:true,
	        toolbar:toolbar,
	        singleSelect:true,
	        columns:[[
	    		{field:'tno',title:'教工号',width:100},
	    		{field:'tname',title:'姓名',width:100},
	    		{field:'tSex',title:'性别',width:100},
	    		{field:'phone',title:'手机号码',width:150,align:'right'}
	        ]]
	    });
	});
</script>
</html>