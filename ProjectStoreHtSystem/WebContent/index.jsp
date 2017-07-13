<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/icon.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/demo.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
<title>商城后台管理系统</title>
<script type="text/javascript">
	function addTabFn() {
		/* 判断选项卡是否存在 */
		var flag = $("#category_tabs").tabs('exists','商品分类列表');
		/* 不存进行添加 */
		if(!flag) {
			$("#category_tabs").tabs('add',{
				title: '商品分类列表',
				selected: true,
				closable:true,
				href:'dataGrid.jsp'
			});
		}else {
			$("#category_tabs").tabs("select","商品分类列表");
		}
		/* 存在选中 */
	}
</script>
</head>
<body class="easyui-layout">
	<div data-options="region:'north',title:'主题',split:true"
		style="height: 160px;">
		<img src="${pageContext.request.contextPath}/img/bg.jpg" width="100%">
	</div>
	<div data-options="region:'west',title:'导航栏',split:true"
		style="width: 200px;">
		<div id="aa" class="easyui-accordion" data-options="fit:true,border:0">
			<div title="商品管理">
				 <!-- 树 -->
	           <ul id="category_tree" class="easyui-tree">   
				    <li>   
				        <span>商品分类管理</span>
				        <ul>
				        	<li>
				        		<span><a href="#" onclick="addTabFn()">商品分类列表</a></span>
				        	</li>
				        </ul>   
				    </li>   
					<li>   
				        <span>商品信息管理</span>  
				        <ul>
				        	<li>
				        		<span><a href="#">商品信息列表</a></span>
				        	</li>
				        </ul> 
				    </li>   
				</ul>    
			</div>
			<div title="用户管理">content2</div>
			<div title="仓库管理">content3</div>
		</div>
	</div>
	<div data-options="region:'center'"
		style="padding: 5px; background: #eee;">
		<div id="category_tabs" class="easyui-tabs" style="width:500px;height:250px;" data-options="fit:true">   
		    <div title="欢迎界面" style="padding:20px;text-align:true">   
		        	欢迎管理员   
		    </div> 
		   <!--  用js动态添加tab  --> 
		</div> 	
	</div>
</body>
</html>