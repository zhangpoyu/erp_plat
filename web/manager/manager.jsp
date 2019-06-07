<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	<title></title>
</head>
<body>
<nav class="breadcrumb">
	<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 系统管理 <span class="c-gray en">&gt;</span> 工号信息管理 <a class="btn btn-success radius r" style="line-height: 1.6em; margin-top: 3px" href="javascript:location.replace(location.href);" title="刷新"><i class="Hui-iconfont">&#xe68f;</i></a>
</nav>
<div style="padding: 15px">
	<div class="cl pd-5 bg-1 bk-gray mt-20">
	            <span class="l">
	                <a class="btn btn-primary radius" onclick="LayerAdd('添加工号','managerMgr?_sign=initAdd')" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加工号</a>
	            </span>
	</div>
	<div style="margin-top: 20px">
		<table class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
			<tr class="text-c">
				<th>账号</th>
				<th>名称</th>
				<th>出生日期</th>
				<th style="width: 200px">新密码</th>
				<th>状态</th>
				<th>角色</th>
				<th style="width: 200px">操作</th>
			</tr>
			</thead>
			<tbody>
				<c:forEach items="${managers}" var="manager">
					<form method="post" action="${pageContext.request.contextPath}/manager/managerMgr?_sign=save">
						<input type="hidden" name="id" value="${manager.id}"/>
						<input type="hidden" name="name" value="${manager.name}"/>
						<tr class="text-c">
							<td>${manager.loginname}</td>
							<td>${manager.name}</td>
							<td>
								<fmt:formatDate value="${manager.birthday}" pattern="yyyy年 MM月 dd日"></fmt:formatDate>
							</td>
							<td class="text-l">
								<input type="password" class="input-text" name="newpwd" />
							</td>
							<td class="text-l">
								<select class="hl_manager_drop" name="state">
									<c:forEach items="${states}" var="state">
										<option value="${state.value}" <c:if test="${state.value eq manager.state}">selected="selected"</c:if>>${state.text}</option>
									</c:forEach>
								</select>
							</td>
							<td class="text-l">
								<select class="hl_manager_drop" name="role">
									<c:forEach items="${roles}" var="role">
										<option <c:if test="${manager.rid eq role.id}">selected="selected"</c:if> value="${role.id}">${role.name}</option>
									</c:forEach>
								</select>
							</td>
							<td>
								<input type="submit" value="保存" onclick="return confirm('确认保存该条记录吗？')" class="btn btn-success" />
								<input type="button" value="删除" onclick="confirmAndRedirect('您是否要删除姓名为${manager.name}的信息？', '${pageContext.request.contextPath}/manager/managerMgr?_sign=delete&mid=${manager.id}')" class="btn btn-warning" />
							</td>
						</tr>
					</form>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<script type="text/javascript">
    function LayerAdd(title, url) {
        var index = layer.open({
            type: 2,
            title: title,
            //area: ['60%', '60%'],
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