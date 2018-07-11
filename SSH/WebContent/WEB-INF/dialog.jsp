<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<div id="editpassword" class="easyui-dialog" title="修改密码" 
	 style="width:250px;height:250px;padding:10px;display:none"
	 modal="true"
	 cache="false"
	 closed="true"
	 data-options="	 	
				buttons: [{
			text:'Ok',
			iconCls:'icon-ok',
			handler:function(){
				$('#editpass').form('submit',{
					url:'editpassword',
					success:function(data){
						data=$.parseJSON(data);
						$.messager.show({
								title:'提示',
								timeout:2000,
								msg:data.msg
							});
						if(data.success){
							delay('login.action');
						}
					}
				});
				
			}
			},{
				text:'Cancel',
				iconCls:'icon-cancel',
				handler:function(){
				Xclose('editpassword');
				}
			}],
			 onClose:function(){
			 $('#editpass').form('clear'); 
			}
			">
			<form id="editpass" action="editpassword">
				<div style="margin-bottom:20px">
				<label for="oldpass" class="label-left">&nbsp;&nbsp;&nbsp;&nbsp;旧密码:</label>
		       	<input type="password" id="oldpass" class="easyui-validatebox" name="OldPass" style="width:120px;height:20px;"  data-options="required:true">
		       	</div>
		       	<div style="margin-bottom:20px">
				<label for="newpass" class="label-left">&nbsp;&nbsp;&nbsp;&nbsp;新密码:</label>
		       	<input type="password" id="newpass" class="easyui-validatebox" name="NewPass" style="width:120px;height:20px;"  data-options="required:true">
		       	</div>
		        <div style="margin-bottom:20px">
				<label for="comfirepass" class="label-left">确认密码:</label>
		       	<input type="password" id="comfirepass" class="easyui-validatebox" name="comfirepass" style="width:120px;height:20px;"  
		      			required="true" validType="equalTo['#newpass']"
		       	>
		       	</div>
			</form>
	</div>


<script type="text/javascript">
	$.extend($.fn.validatebox.defaults.rules, {
    /*必须和某个字段相等*/
    equalTo: { validator: function (value, param) { return $(param[0]).val() == value; }, message: '两次密码不匹配' }
   });
</script>