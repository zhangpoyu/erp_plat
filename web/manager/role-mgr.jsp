<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" type="text/css" href="../lib/Hui-iconfont/1.0.7/iconfont.css" />

		<link rel="stylesheet" type="text/css" href="../css/h-ui/css/H-ui.min.css" />
		<link rel="stylesheet" type="text/css" href="../css/h-ui.admin/css/H-ui.admin.css" />
		<link rel="stylesheet" type="text/css" href="../lib/icheck/icheck.css" />
		<link rel="stylesheet" type="text/css" href="../css/h-ui.admin/skin/default/skin.css" id="skin" />
		<link rel="stylesheet" type="text/css" href="../css/h-ui.admin/css/style.css" />
		<link rel="stylesheet" type="text/css" href="../css/gaozhu.francis.css" />
		<script type="text/javascript" src="../lib/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="../lib/jquery/1.9.1/jquery.min.js"></script>
		<script type="text/javascript" src="../lib/layer/2.1/layer.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/MyJs.js"></script>
		<link href="../css/mycss.css" rel="stylesheet" type="text/css" />
		<style type="text/css">
			.marginLeft30 {
				margin-left: 30px;
			}
			
			.marginRight30 {
				margin-right: 30px;
			}
		</style>
		<title></title>
	</head>
		
	<body>
		<nav class="breadcrumb">
        	<i class="Hui-iconfont">&#xe67f;</i> 首页
        	<span class="c-gray en">&gt;</span>
        	xxxx模块 
        	<span class="c-gray en">&gt;</span> 
        	xxxx功能 
        	<a class="btn btn-success radius r" style="line-height: 1.6em; margin-top: 3px" href="javascript:location.replace(location.href);" title="刷新"><i class="Hui-iconfont">&#xe68f;</i></a>
    	</nav>
    	<div style="padding: 15px">
	        <div class="cl pd-5 bg-1 bk-gray mt-20">
	        	<a class="btn btn-primary radius" onclick="doLayer('添加角色','${pageContext.request.contextPath}/manager/role-add.jsp')" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加角色</a>
	        </div>
       		<div style="margin-top: 20px">
	            <table class="table table-border table-bordered table-bg table-hover table-sort">
	                <thead>
	                    <tr class="text-c">
	                    	<th>序号</th>
	                        <th>角色名称</th>
	                        <th>角色描述</th>
	                        <th>操作</th>
	                    </tr>
	                </thead>
	                <tbody>
						<c:forEach var="role" items="${roles}" varStatus="i">
							<form method="post" action="${pageContext.request.contextPath}/manager/roleMgr?_sign=update">
								<input type="hidden" name="id" value="${role.id}"/>
								<tr class="text-c">
									<td class="text-c">${i.index + 1}</td>
									<td class="text-l">
										<input type="text" value="${role.name}" name="name" class="input-text" />
									</td>
									<td class="text-l">
										<input type="text" value="${role.remark}" name="remark" class="input-text" />
									</td>
									<td>
										<input type="submit" class="btn btn-success" value="保存" />
										<input type="button" class="btn btn-success" value="分配对应权限" onclick="doLayer('分配权限','${pageContext.request.contextPath}/manager/roleMgr?_sign=privInit&id=${role.id}')" />
										<input type="button" class="btn btn-warning" onclick="confirmAndRedirect('您是否删除角色[${role.name}]？', '${pageContext.request.contextPath}/manager/roleMgr?_sign=delete&id=${role.id}')" value="删除" />
									</td>
								</tr>
							</form>
						</c:forEach>
					</tbody>
	            </table>
        	</div>
    	</div>
	    <script type="text/javascript">
	        function doLayer(title, url) {
	            var index = layer.open({
	                type: 2,
	                title: title,
	                area: ['60%', '60%'],
	                fix: false, //不固定
	                content: url,
	                end: function () {
	                    location.replace(location.href);
	                }
	            });
	            layer.full(index);
	        }
	    </script>
	</body>

</html>