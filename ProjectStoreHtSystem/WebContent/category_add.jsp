<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div style="padding: 10px 60px 20px 60px">
		<form id="category_ff" method="post">
			<table cellpadding="5">
				<tr>
					<td>分类名称:</td>
					<td><input id="cname" class="easyui-textbox" type="text" name="name"
						data-options="required:true"></input></td>
				</tr>
			</table>
		</form>
		<div style="text-align: center; padding: 5px;margin-top: 20px">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="submitForm()">添加</a> <a href="javascript:void(0)"
				class="easyui-linkbutton" onclick="clearForm()">清空信息</a>
		</div>
	</div>
	<script>
		function submitForm() {
			/* var params = "method=addCategory&cname="+$("#cname").val();
			var url = "${pageContext.request.contextPath}/CategoryServlet";
			$.post(params, url,function(msg) {
				alert(msg);
			}); */
			$.ajax({
				type:"post",
				url:"${pageContext.request.contextPath}/CategoryServlet",
				data:"method=addCategory&cname="+$("#cname").val(),
				success:function(msg) {
					$("#category_dd").dialog("close","close");
					if(msg=="ok") {
						$.messager.show({
							title : '提示框',
							msg : '亲,添加信息成功!',
							timeout : 2000,
							showType : 'fade'
						});
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
		function clearForm() {
			$('#category_ff').form('clear');
		}
	</script>
</body>
</html>