<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1>파일 업로드 Form</h1>
<h3>Commons Fileupload</h3>
<hr>

<!-- enctype : encoding type, 인코딩 방식 -->
<!-- <form>으로 전송하는 데이터의 형식을 정의한다 -->
<!-- 기본값은 application/x-www/form-url-encoded -->

<!-- 파일 업로드를 하려면  multipart/form-data를 사용해야 한다 -->
<form action="/commons/fileupload" method="post" 
	enctype="multipart/form-data">
<!-- 	enctype="application/x-www-form-urlencoded"> -->
<fieldset style="width: 280px;">
			<legend> 파일 업로드 </legend>	
	<label>제목 : <input type="text" name = "title" /></label><br>
	<label>제목 : <input type="text" name = "bce" /></label><br>
	<label>제목 : <input type="text" name = "cawa" /></label><br>
	<label>제목 : <input type="text" name = "ggt" /></label><br>
	<label>제목 : <input type="text" name = "test" /></label><br>
	
	<label>파일 : <input type="file" name = "upfile" /></label><br>
		
	<button>전송</button>
      </fieldset>		
</form>
<hr>

<a href="/commons/fileupload/list"><button>리스트</button></a>

</body>
</html>