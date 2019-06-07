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
		<nav class="breadcrumb">
        	<i class="Hui-iconfont">&#xe67f;</i> 首页
        	<span class="c-gray en">&gt;</span>
        	xxxx模块 
        	<span class="c-gray en">&gt;</span> 
        	xxxx功能 
        	<a class="btn btn-success radius r" style="line-height: 1.6em; margin-top: 3px" href="javascript:location.replace(location.href);" title="刷新"><i class="Hui-iconfont">&#xe68f;</i></a>
    	</nav>
    	<div style="padding: 15px">
        	<div class="text-c">
        		查询条件1(文字)：<input type="text" style="width:150px" class="input-text" placeholder="提示文字"/>&nbsp;
        		查询条件2(日期)：
        		<input type="text" style="width:150px" onclick="WdatePicker()" class="input-text Wdate"/>
        		-
        		<input type="text" style="width:150px" onclick="WdatePicker()" class="input-text Wdate"/>&nbsp;
        		查询条件3(下拉框)：
        		<select class="hl_manager_drop">
        			<option>--请选择--</option>
        			<option value="条件值1">条件内容1</option>
        			<option value="条件值2">条件内容2</option>
        			<option value="条件值3">条件内容3</option>
        		</select>
            	<input type="button" class="btn btn-success" value="查找"/>
            	
        	</div>
	        <div class="cl pd-5 bg-1 bk-gray mt-20">
	            <span class="r">共有数据：<strong>-</strong> 条记录</span>
	        </div>
       		<div style="margin-top: 20px">
	            <table class="table table-border table-bordered table-bg table-hover table-sort">
	                <thead>
	                    <tr class="text-c">
	                        <th>列1</th>
	                        <th>列2</th>
	                        <th>列3</th>
	                        <th>列4</th>
	                        <th>列5</th>
	                        <th>操作</th>
	                    </tr>
	                </thead>
	                <tbody>
                        <tr class="text-c">
                            <td class="text-c">值1</td>
                            <td class="text-c">值2</td>
                            <td class="text-c">值3</td>
                            <td class="text-c">值4</td>
                            <td class="text-c">值5</td>
                            <td>
                                <input type="button" class="btn btn-success" value="查看" onclick="doLayer('测试', 'xxx-edit.jsp')" />
                                <input type="button" class="btn btn-warning" value="删除" />
                            </td>
                        </tr>
                        <tr class="text-c">
                            <td class="text-c">值1</td>
                            <td class="text-c">值2</td>
                            <td class="text-c">值3</td>
                            <td class="text-c">值4</td>
                            <td class="text-c">值5</td>
                            <td>
                                <input type="button" class="btn btn-success" value="查看" onclick="doLayer('测试', 'xxx-edit.jsp')" />
                                <input type="button" class="btn btn-warning" value="删除" />
                            </td>
                        </tr>
                        <tr class="text-c">
                            <td class="text-c">值1</td>
                            <td class="text-c">值2</td>
                            <td class="text-c">值3</td>
                            <td class="text-c">值4</td>
                            <td class="text-c">值5</td>
                            <td>
                                <input type="button" class="btn btn-success" value="查看" onclick="doLayer('测试', 'xxx-edit.jsp')" />
                                <input type="button" class="btn btn-warning" value="删除" />
                            </td>
                        </tr>
                        <tr class="text-c">
                            <td class="text-c">值1</td>
                            <td class="text-c">值2</td>
                            <td class="text-c">值3</td>
                            <td class="text-c">值4</td>
                            <td class="text-c">值5</td>
                            <td>
                                <input type="button" class="btn btn-success" value="查看" onclick="doLayer('测试', 'xxx-edit.jsp')" />
                                <input type="button" class="btn btn-warning" value="删除" />
                            </td>
                        </tr>
                        <tr class="text-c">
                            <td class="text-c">值1</td>
                            <td class="text-c">值2</td>
                            <td class="text-c">值3</td>
                            <td class="text-c">值4</td>
                            <td class="text-c">值5</td>
                            <td>
                                <input type="button" class="btn btn-success" value="查看" onclick="doLayer('测试', 'xxx-edit.jsp')" />
                                <input type="button" class="btn btn-warning" value="删除" />
                            </td>
                        </tr>
                        <tr class="text-c">
                            <td class="text-c">值1</td>
                            <td class="text-c">值2</td>
                            <td class="text-c">值3</td>
                            <td class="text-c">值4</td>
                            <td class="text-c">值5</td>
                            <td>
                                <input type="button" class="btn btn-success" value="查看" onclick="doLayer('测试', 'xxx-edit.jsp')" />
                                <input type="button" class="btn btn-warning" value="删除" />
                            </td>
                        </tr>
                        <tr class="text-c">
                            <td class="text-c">值1</td>
                            <td class="text-c">值2</td>
                            <td class="text-c">值3</td>
                            <td class="text-c">值4</td>
                            <td class="text-c">值5</td>
                            <td>
                                <input type="button" class="btn btn-success" value="查看" onclick="doLayer('测试', 'xxx-edit.jsp')" />
                                <input type="button" class="btn btn-warning" value="删除" />
                            </td>
                        </tr>
                        <tr class="text-c">
                            <td class="text-c">值1</td>
                            <td class="text-c">值2</td>
                            <td class="text-c">值3</td>
                            <td class="text-c">值4</td>
                            <td class="text-c">值5</td>
                            <td>
                                <input type="button" class="btn btn-success" value="查看" onclick="doLayer('测试', 'xxx-edit.jsp')" />
                                <input type="button" class="btn btn-warning" value="删除" />
                            </td>
                        </tr>
                        <tr class="text-c">
                            <td class="text-c">值1</td>
                            <td class="text-c">值2</td>
                            <td class="text-c">值3</td>
                            <td class="text-c">值4</td>
                            <td class="text-c">值5</td>
                            <td>
                                <input type="button" class="btn btn-success" value="查看" onclick="doLayer('测试', 'xxx-edit.jsp')" />
                                <input type="button" class="btn btn-warning" value="删除" />
                            </td>
                        </tr>
                        <tr class="text-c">
                            <td class="text-c">值1</td>
                            <td class="text-c">值2</td>
                            <td class="text-c">值3</td>
                            <td class="text-c">值4</td>
                            <td class="text-c">值5</td>
                            <td>
                                <input type="button" class="btn btn-success" value="查看" onclick="doLayer('测试', 'xxx-edit.jsp')" />
                                <input type="button" class="btn btn-warning" value="删除" />
                            </td>
                        </tr>
                        <tr class="text-c">
                            <td class="text-c">值1</td>
                            <td class="text-c">值2</td>
                            <td class="text-c">值3</td>
                            <td class="text-c">值4</td>
                            <td class="text-c">值5</td>
                            <td>
                                <input type="button" class="btn btn-success" value="查看" onclick="doLayer('测试', 'xxx-edit.jsp')" />
                                <input type="button" class="btn btn-warning" value="删除" />
                            </td>
                        </tr>
	                </tbody>
	            </table>
	            <div style="margin-top: 15px">
	            	<input type="button" value="首页" class="btn" />
	                <input type="button" value="上一页" class="btn" />
	                1/1
					<input type="hidden" value="1" />
					<input type="button" value="下一页" class="btn" />
	                <input type="button" value="最后" class="btn" />
	                <input type="text" style="width: 30px;" value="1" class="input-text" />
	                <input type="button" value="跳转到" class="btn" />
	            </div>
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