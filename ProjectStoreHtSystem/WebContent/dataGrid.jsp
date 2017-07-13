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
</head>
<body>
	<table class="easyui-datagrid" id="category_table"
		data-options="fit:true">
	</table>
	<div id="category_dd">Dialog Content.</div>  
	<script type="text/javascript">
		/* 放在操作备操作标签的下面 */
		$(function() {
			$('#category_table')
					.datagrid(
							{
								url : '${pageContext.request.contextPath}/CategoryServlet?method=findCategorys',
								columns : [ [ {
									field : 'cid',
									title : '类型id',
									width : 400
								}, {
									field : 'cname',
									title : '类型名称',
									width : 400
								}, {
									field : 'haha',
									title : '操作',
									width : 350,
									formatter : function(value, row, index) {
										/* 拼接触发时间的时候后面就不要加''了 */
										return "<a href=# onclick=delInfo('"+row.cid+"')>删除</a>||<a href='#' onclick=updateInfo('"+row.cid+"','"+row.cname+"')>修改</a>";
									}
								} ] ],
								/* 请求成功回调 */
								onLoadSuccess : function(data) {
								},
								/* 请求失败回调 */
								onLoadError : function(data) {
									$.messager.show({
										title : '提示框',
										msg : '亲,信息加载失败!',
										timeout : 2000,
										showType : 'fade'
									});
								},
								/* 列表上面的按钮栏 */
								toolbar : [ {
									iconCls : 'icon-edit',
									handler : function() {
										$('#category_dd').dialog({    
										    title: '添加信息',    
										    width: 400,    
										    height: 200,    
										    closed: false,    
										    href: 'category_add.jsp',    
										    modal: true   
										});  
										//alert('编辑按钮')
									}
								}, '-', {
									iconCls : 'icon-help',
									handler : function() {
										alert('请求帮助')
									}
								} ],
								pagination : true,
								pagePosition : 'bottom',
								pageNumber : 1,
								pageSize : 5,
								pageList : [ 5, 10, 15, 20, 25 ],
								fit:true
							});
		})
		
	</script>
	<script type="text/javascript">
		function delInfo(cid) {
			$.ajax({
				type:"post",
				url:"${pageContext.request.contextPath}/CategoryServlet",
				data:"method=deleteByCid&cid="+cid,
				success:function(msg) {
					if(msg=="ok") {
						$.messager.show({
							title : '提示框',
							msg : '亲,信息删除成功!',
							timeout : 2000,
							showType : 'fade'
						});
						//重新加载页面信息
						$('#category_table')
						.datagrid("reload",true);
					}else {
						alert("类型下面有商品无法删除");
					}
					
				},
				error:function(msg) {
					alert("error类型下面有商品无法删除");
				}
			});
		}
		function updateInfo(cid,cname) {
			$('#category_dd').dialog({    
			    title: '添加信息',    
			    width: 400,    
			    height: 200,    
			    closed: false,    
			    href: 'category_update.jsp?cname='+cname+"&cid="+cid,    
			    modal: true   
			}); 
		}
	</script>
</body>
</html>
