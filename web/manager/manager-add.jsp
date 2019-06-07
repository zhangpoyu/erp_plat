<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/Hui-iconfont/1.0.7/iconfont.css" />

		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/h-ui/css/H-ui.min.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/h-ui.admin/css/H-ui.admin.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/icheck/icheck.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/h-ui.admin/skin/default/skin.css" id="skin" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/h-ui.admin/css/style.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/gaozhu.francis.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/lib/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/1.9.1/jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/lib/layer/2.1/layer.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/MyJs.js"></script>
		<link href="${pageContext.request.contextPath}/css/mycss.css" rel="stylesheet" type="text/css" />
		<style type="text/css">
			.marginLeft30 {
				margin-left: 30px;
			}
			
			.marginRight30 {
				margin-right: 30px;
			}
		</style>
        <script type="text/javascript">
            function checkAddMgr()
            {
                var loginName = document.getElementById('loginName').value;
                if('' == loginName)
                {
                    alert('登录名不能为空！');
                    return false;
                }

                var loginPwd = document.getElementById('loginPwd').value;
                if('' == loginPwd)
                {
                    alert('密码不能不能为空！');
                    return false;
                }

                var name = document.getElementById('name').value;
                if('' == name)
                {
                    alert('用户姓名不能为空！');
                    return false;
                }


                var birth = document.getElementById('birthday').value;
                if('' == birth)
                {
                    alert('出生日期未选择！');
                    return false;
                }


                var role = document.getElementById('role').value;
                if('' == role)
                {
                    alert('角色未选择！');
                    return false;
                }

                return true;
            }
        </script>
		<title></title>
	</head>
    <body>
    	<div style="margin-top: 20px; text-align: center;" class="form form-horizontal">
			<form method="post" action="managerMgr?_sign=add">

				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">账号：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input id="loginName" type="text" maxlength="11" class="input-text" name="loginName" />
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">密码：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input id="loginPwd" type="password" class="input-text" name="loginPwd" />
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">姓名：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input id="name" type="text" class="input-text" name="name"/>
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">出生日期：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input id="birthday" type="text" onclick="WdatePicker()" class="input-text Wdate" name="birthday"/>
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">账户状态：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<c:forEach items="${managerStates}" var="state">
							<input type="radio" name="managerState" value="${state.value}" <c:if test="${state.value eq 2}">checked="checked"</c:if>/>${state.text}
						</c:forEach>
					</div>
				</div>
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">角色：</label>
					<div class="formControls col-xs-8 col-sm-9" style="text-align: left">
						<select class="hl_manager_drop" name="role" id="role">
							<option>--请选择--</option>
							<c:forEach items="${roles}" var="role">
								<option value="${role.id}">${role.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="row cl">
					<div class="form-label col-xs-4 col-sm-2"></div>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="submit" onclick="return checkAddMgr();" value="新增" class="btn btn-success" />
					</div>
				</div>
			</form>
	    </div>
 	</body>
</html>