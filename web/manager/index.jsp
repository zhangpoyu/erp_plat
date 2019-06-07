<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
	    <meta name="renderer" content="webkit|ie-comp|ie-stand" />
	    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	    <meta http-equiv="Cache-Control" content="no-siteapp" />
	    <link rel="Bookmark" href="/favicon.ico" />
	    <link rel="Shortcut Icon" href="/favicon.ico" />
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/h-ui/css/H-ui.min.css" />
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/h-ui.admin/css/H-ui.admin.css" />
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/Hui-iconfont/1.0.7/iconfont.css" />
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/icheck/icheck.css" />
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/h-ui.admin/skin/default/skin.css" id="skin" />
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/h-ui.admin/css/style.css" />
	    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/mycss.css" />
	    <title>标题内容</title>
    </head>
    <body>
    	
    	<header class="navbar-wrapper">
            <div class="navbar navbar-fixed-top">
                <div class="container-fluid cl">
                    <a class="logo navbar-logo f-l mr-10 hidden-xs" href="/about.html">
                        xxxx管理平台
                    </a>
                    <a class="logo navbar-logo-m f-l mr-10 visible-xs" href="/about.html">H-ui</a>
                    <span class="logo navbar-slogan f-l mr-10 hidden-xs">
                        1.0.0.0
                    </span>
                    <a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>
                    <nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
                        <ul class="cl">
                            <li style="padding-right: 10px">
                                18846457728
                            </li>
                            <li>
                                <a href="<%=request.getContextPath()%>/logout"><input type="button" value="退出" class="hl_manager_btn_exit"/></a>
                            </li>
                            <li id="Hui-skin" class="dropDown right dropDown_hover"><a href="javascript:;" class="dropDown_A" title="换肤"><i class="Hui-iconfont" style="font-size: 18px">&#xe62a;</i></a>
                                <ul class="dropDown-menu menu radius box-shadow">
                                    <li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
                                    <li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
                                    <li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
                                    <li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
                                    <li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
                                    <li><a href="javascript:;" data-val="orange" title="绿色">橙色</a></li>
                                </ul>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </header>
        <aside class="Hui-aside">
            <input runat="server" id="divScrollValue" type="hidden" value="" />
            <div class="menu_dropdown bk_2">

                <c:forEach items="${privGroups}" var="group">
                    <dl id="menu-system">
                        <dt>
                            <i class="Hui-iconfont">&#xe62e;</i>${group.text}
                            <i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
                        </dt>
                        <dd>
                            <ul>
                                <c:forEach items="${privs}" var="priv">
                                    <c:if test="${(group.id eq priv.gid) and (priv.url != null)}">
                                        <li><a _href='${pageContext.request.contextPath}/${priv.url}' data-title='${priv.text}' href="javascript:void(0)">${priv.text}</a></li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </dd>
                    </dl>
                </c:forEach>
            </div>
        </aside>
        <div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onclick="displaynavbar(this)"></a></div>
        <div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onclick="displaynavbar(this)"></a></div>
        <section class="Hui-article-box">
            <div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
                <div class="Hui-tabNav-wp">
                    <ul id="min_title_list" class="acrossTab cl">
                        <li class="active"><span title="主页" data-href="welcome.html">主页</span><em></em></li>
                    </ul>
                </div>
                <div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a></div>
            </div>
            <div id="iframe_box" class="Hui-article">
                <div class="show_iframe">
                    <div style="display: none" class="loading"></div>
                    <iframe id="iframeRight" src="${pageContext.request.contextPath}/manager/main.jsp"></iframe>
                </div>
            </div>
        </section>
        <script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/1.9.1/jquery.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/lib/layer/2.1/layer.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/css/h-ui/js/H-ui.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/css/h-ui.admin/js/H-ui.admin.js"></script>
        
 	</body>
</html>