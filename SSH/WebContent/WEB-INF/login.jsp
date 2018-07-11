<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="SSH.css">
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="function.js"></script>
<title>login</title>
</head>
<body>

		<div style="margin-top:100px;"></div>
		<center>
    	<div class="easyui-panel" border="false" style="width:100%;max-width:400px;padding:50px 60px;" >
        <center><h1 style="color:red">login</h1></center>
            <form action="dl" id="dlf"> 			
             <div style="margin-bottom:20px">
				<input class="easyui-textbox"  id="USER" name="entity.userName" prompt="Username" iconWidth="28" style="width:100%;height:34px;padding:10px;" required="true" missingMessage="用户名不能为空">
			</div>
			<div style="margin-bottom:20px">
				<input class="easyui-passwordbox" name="entity.userPass" prompt="Password" iconWidth="28" style="width:100%;height:34px;padding:10px" required="true" missingMessage="密码不能为空">
			</div>
 			<div style="margin-bottom:20px">
 				<button type="submit" class="easyui-linkbutton" onclick="submitForm()" style="width:115%;height:30px;padding:20px">登录</button>
         	</div>
            </form>
	             <center><font color="blue"> <s:property value="info"/></font></center>
	     </div>
	   	</center>
</body>
</html>