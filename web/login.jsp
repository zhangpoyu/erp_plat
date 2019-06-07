<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
	    <meta charset="utf-8">
	    <meta name="renderer" content="webkit|ie-comp|ie-stand">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	    <meta http-equiv="Cache-Control" content="no-siteapp" />
	    <link href="${pageContext.request.contextPath}/css/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
	    <link href="${pageContext.request.contextPath}/css/h-ui.admin/css/H-ui.login.css" rel="stylesheet" type="text/css" />
	    <link href="${pageContext.request.contextPath}/css/h-ui.admin/css/style.css" rel="stylesheet" type="text/css" />
	    <link href="${pageContext.request.contextPath}/lib/Hui-iconfont/1.0.7/iconfont.css" rel="stylesheet" type="text/css" />
	    <link href="${pageContext.request.contextPath}/css/mycss.css" rel="stylesheet" type="text/css" />
	    <title>后台登录</title>
    </head>
    <body>
    	<form id="form1" action="login" method="post" class="form form-horizontal">
		    <div class="loginWraper">
		        <div id="loginform" class="loginBox">
		            <div class="row cl">
		                <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60d;</i></label>
		                <div class="formControls col-xs-8">
		                    <input type="text" placeholder="账户" name="userName" class="input-text size-L" MaxLength="11" />
		                </div>
		            </div>
		            <div class="row cl">
		                <label class="form-label col-xs-3"><i class="Hui-iconfont">&#xe60e;</i></label>
		                <div class="formControls col-xs-8">
		                    <input type="password" placeholder="密码" name="userPwd" class="input-text size-L" />
		                </div>
		            </div>
		            <div class="row cl">
		                <div class="formControls col-xs-8 col-xs-offset-3">
		                    <input type="submit" value="&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;" class="btn btn-success radius size-L" />
		                    <input type="reset" class="btn btn-default radius size-L" value="&nbsp;取&nbsp;&nbsp;&nbsp;&nbsp;消&nbsp;">
		                </div>
		            </div>
		
		            <div class="row cl">
		                <div class="formControls col-xs-8 col-xs-offset-3">
		                    <span class="font-warring">${notice}</span>
		                </div>
		            </div>
		        </div>
	        </div>
	        <div class="footer">
	            Copyright XXXX科技股份有限公司
	        </div>
        </form>
 	</body>
</html>