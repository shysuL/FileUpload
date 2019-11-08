<%@page import="dto.UploadFile"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	List<UploadFile> fList = (List) request.getAttribute("list");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type = "text/css">
table{
	border-collapse: collapse;
	border:1px solid #ccc;
}
td{
	border-top: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
	padding : 5px 10px;
	background: ivory;
}
td:hover{
	background: #ccf;
}

</style>
</head>
<body>
	<h1>listlistlist</h1>
	<hr>

<% System.out.println(fList.size()); %>

	<table border ="1">
	<tr>
		<th>파일 번호</th>
		<th>기존 파일명</th>
		<th>저장 파일명</th>
	</tr>
		<%
			for (int i = 0; i < fList.size(); i++) {
	%> 
		<tr>
			<td><%=fList.get(i).getFileno()%></td>
			<td><a href="/upload/<%=fList.get(i).getStoredName()%>"><%=fList.get(i).getOriginName()%>></a></td>
			<td><%=fList.get(i).getStoredName()%></td>

		</tr>
		<%
			}
		%>
</table>
		<hr>
		<a href="/commons/fileupload"><button>파일 업로드</button></a>
</body>
</html>