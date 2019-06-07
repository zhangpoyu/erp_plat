<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
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

		<div style="margin-top: 20px; text-align: center;" class="form form-horizontal">
			<form method="post" action="${pageContext.request.contextPath}/manager/roleMgr?_sign=save">
				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">角色名称：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" class="input-text" name="name" placeholder="请输入角色名称"/>
					</div>
				</div>

				<div class="row cl">
					<label class="form-label col-xs-4 col-sm-2">描述信息：</label>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="text" class="input-text" name="remark" placeholder="请输入备注信息（可以不写）"/>
					</div>
				</div>

				<div class="row cl">
					<div class="form-label col-xs-4 col-sm-2"></div>
					<div class="formControls col-xs-8 col-sm-9">
						<input type="submit" value="保存" class="btn btn-success" />
					</div>
				</div>
			</form>
		</div>
	</body>

</html>