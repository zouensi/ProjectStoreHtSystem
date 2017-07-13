<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div style="padding: 10px 60px 20px 60px">
		<input type="hidden" id="cid"  name="cid" value=<%=request.getParameter("cid") %>>
		<form id="category_fupdate" method="post">
			<table cellpadding="5">
				<tr>
					<td>分类名称:</td>
					<td><input id="cname" class="easyui-textbox" type="text" name="name" value=<%=request.getParameter("cname") %>
						data-options="required:true"></input></td>
				</tr>
			</table>
		</form>
		<div style="text-align: center; padding: 5px;margin-top: 20px">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="submitForm()">更新</a> <a href="javascript:void(0)"
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
				data:"method=updateCategory&cname="+$("#cname").val()+"&cid="+$("#cid").val(),
				success:function(msg) {
					$("#category_dd").dialog("close","close");
					if(msg=="ok") {
						$.messager.show({
							title : '提示框',
							msg : '亲,更新信息成功!',
							timeout : 2000,
							showType : 'fade'
						});
						$('#category_table')
						.datagrid("reload",true); 
					}else {
						alert("更新信息失败");
					}
				},
				error:function(msg) {
					alert("error更新信息失败");
				}
			});
		}
		function clearForm() {
			$('#category_fupdate').form('clear');
		}
	</script>
</body>
</html>