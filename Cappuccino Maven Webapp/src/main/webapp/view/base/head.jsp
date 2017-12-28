
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/view/";
%>
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.min.css?v=1.2" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/plugins/iCheck/custom.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/plugins/chosen/chosen.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/plugins/jasny/jasny-bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/plugins/daterangepicker/daterangepicker-bs3.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/plugins/flags/flags.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/plugins/jvectormap/jquery-jvectormap.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/plugins/spectrum/spectrum.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/animate.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/common.css" />
<!-- Mainly scripts -->
<script type="text/javascript" src="<%=basePath%>js/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/plugins/jquery-ui/jquery-ui.min.js"></script>

<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/plugins/metisMenu/jquery.metisMenu.js"></script>
<!-- Peity -->
<script type="text/javascript" src="<%=basePath%>js/plugins/peity/jquery.peity.min.js"></script>
<!-- Custom and plugin javascript -->
<script type="text/javascript" src="<%=basePath%>js/inspinia.js"></script>
<script type="text/javascript" src="<%=basePath%>js/common.js"></script>
<!-- Custom and plugin javascript -->
<script type="text/javascript" src="<%=basePath%>js/Chart.min.js"></script>


