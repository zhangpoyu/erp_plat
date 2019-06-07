<%@ page import="gaozhu.francis.entity.Role" %>
<%@ page import="gaozhu.francis.entity.Priv" %>
<%@ page import="java.util.List" %>
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
    	<div style="padding: 15px">
       		<div style="margin-top: 20px">
	            <table class="table table-border table-bordered table-bg table-hover table-sort">
	                <thead>
	                    <tr class="text-c">
	                    	<th>选择</th>
	                        <th>权限</th>
	                        <th>分组</th>
	                    </tr>
	                </thead>
	                <tbody>
						<form method="post" action="${pageContext.request.contextPath}/manager/roleMgr?_sign=privSave">
							<input type="hidden" name="rid" value="${role.id}"
							<%
								Role role = (Role)request.getAttribute("role");
								List<Priv> privs = (List<Priv>)request.getAttribute("privs");


								for(Priv param : privs)
								{

								    %>
									<tr class="text-c">
										<td class="text-c">
											<input type="checkbox"
													<%
														if(role.getPrivs().contains(param))
														{
														    %>
																checked="checked"
															<%
														}
													%> name="selPrivs" value="<%=param.getId()%>"/>
										</td>
										<td class="text-l">
											<%=param.getText()%>
										</td>
										<td class="text-l">
											<%=param.getGroupName()%>
										</td>
									</tr>
									<%

								}

							%>
							<tr class="text-c">
								<td colspan="3" class="text-c">
									<input type="submit" class="btn btn-success" value="保存"/>
								</td>
							</tr>
						</form>
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