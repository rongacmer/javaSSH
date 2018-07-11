/**
 * 
 */
function submitForm()
{
	$('#dlf').form('submit',{
		onSubmit:function(){
			return $(this).form('enableValidation').form('validate');
		}
	});
}

function Xshow(ID)  //显示隐藏层和弹出层 
{ 
   $('#'+ID).dialog("open"); 
} 

function Xclose(ID)
{	
	$('#'+ID).dialog("close");	
}

function delay(url){
	setTimeout("top.location.href='"+url+"'",2000);
}

function Xconfirm(row){
	$.messager.confirm('删除', '确认删除?', function(r){
		if (r){
			$.ajax({
				type:"post",
				url:"studentdel.action",
				data:{"stu.id":row.id,"stu.Sname":row.sname,"stu.Sex":row.sex,"stu.phone":row.phone},
				success:function(){
					$('#dg').datagrid('reload');
				}
			});
		}
	});
}
function Tconfirm(row){
	$.messager.confirm('删除', '确认删除?', function(r){
		if (r){
			$.ajax({
				type:"post",
				url:"Teacherdel.action",
				data:{"tea.Tno":row.tno,"tea.Tname":row.tname,"tea.TSex":row.tSex,"tea.phone":row.phone},
				success:function(data){
					
					data=$.parseJSON(data);
					$.messager.show({
							title:'提示',
							timeout:2000,
							msg:data.msg
						});
					if(data.success){
							$('#tdg').datagrid('reload');
					}
				}
			});
		}
	});
}

function Cconfirm(row){
	$.messager.confirm('删除', '确认删除?', function(r){
		if (r){
			$.ajax({
				type:"post",
				url:"Cnodel.action",
				data:{"cno.Cno":row.cno,"cno.Cname":row.cname,"cno.GPA":row.gPA,"cno.Tno":row.tno,"cno.Tname":row.tname},
				success:function(data){
							$('#cdg').datagrid('reload');
				}
			});
		}
	});
}
function Xbutton(url,dlg,form,isdata)
{
	isdata = null || isdata;
	var Buttons=[{
		text:'Ok',
		iconCls:"icon-ok",
		handler:function(){
			$('#'+form).form('submit',{
				url:url,
				success:function(data){
//					alert("yes");
					data=$.parseJSON(data);
					$.messager.show({
							title:'提示',
							timeout:2000,
							msg:data.msg
						});
					if(data.success){
						Xclose(dlg);
						if(isdata)
						{
							$('#'+isdata).datagrid('reload');
						}
					}
				}
			});
		}
		},{
			text:'Cancel',
			iconCls:"icon-cancel",
			handler:function(){
				Xclose(dlg);
			}
		}];
	return Buttons;
}
function querycou(){
	
	var val = $("#cno").textbox('getValue');
//	$.ajax({
//		type:"post",
//		url:"Selq.action"
//	});
//	alert("xxx");
	$.ajax({
		type:"post",
		url:"Selq.action",
		data:{"cno":val},
		success:function(data){
			data=$.parseJSON(data);
			$.messager.show({
					title:'提示',
					timeout:2000,
					msg:data.msg
				});
			if(data.success){
				$('#addstudent').linkbutton('enable');
				$('#sdg').datagrid('reload');
			}
					
		}
	});
}

function addcou(){
	var val = $("#sno").textbox('getValue');
//	alert(val);
//	$.ajax({
//		type:"post",
//		url:"Selq.action"
//	});
//	alert("xxx");
	$.ajax({
		type:"post",
		url:"Seladd.action",
		data:{"sno":val},
		success:function(data){
			data=$.parseJSON(data);
			if(data.success){
				$('#addstudent').linkbutton('enable');
				$('#sdg').datagrid('reload');
			}
			else{
				$.messager.show({
					title:'提示',
					timeout:2000,
					msg:data.msg
				});
			}
				
					
		}
	});
}
function delcou(){
	var row = $('#sdg').datagrid('getSelected');
	if(row)
	{
		$.messager.confirm('删除', '确认删除?', function(r){
			if (r){
				$.ajax({
					type:"post",
					url:"Seldel.action",
					data:{"sno":row.id},
					success:function(data){
						$('#sdg').datagrid('reload');
					}
				});
			}
		});
	}
}

function checkscore()
{
	var val = $("#cno").textbox('getValue');
//	$.ajax({
//		type:"post",
//		url:"Scorecheck.action"
//	});
//	
	$.ajax({
		type:"post",
		url:"Scorecheck.action",
		data:{"cname":val},
		success:function(data){
			data=$.parseJSON(data);
			$.messager.show({
					title:'提示',
					timeout:2000,
					msg:data.msg
				});
			if(data.success){
				$('#tsdg').datagrid('reload');
			}
					
		}
	});
//	alert("xxx");
}

function scoresave(){
	var rows = $('#tsdg').datagrid('getChanges');
	var flag = true;
	for(var i = 0; i < rows.length; i++)
	{
		$.ajax({
			type:"post",
			url:"Scoreadd.action",		
			data:{"sco.sno":rows[i].sno,"sco.Score":rows[i].score},
			success:function(data){
				data=$.parseJSON(data);
				if(data.success == false){
					$.messager.show({
						title:'提示',
						timeout:2000,
						msg:data.msg
					});
					flag = false;
				}
			}
		});
		if(flag == false)
		{
			break;
		}
	}
	if(flag){
		$.messager.show({
			title:'提示',
			timeout:2000,
			msg:"保存成功"
		});
	}
}


function scorecomfirm()
{
	$.ajax({
		type:"post",
		url:"Scorecomfirm.action",
		success:function(data){
			data=$.parseJSON(data);
			$.messager.show({
					title:'提示',
					timeout:2000,
					msg:data.msg
				});
		}
	});
}