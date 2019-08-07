<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="/css/common.css" />
</head>
<body>
  <h2 style="text-align:center">Home</h2>
  <table style="width:100px">
  	<tr>
  		<td style="height:30px; text-align:center">
  			<a href="/Board/List?menu_id=MENU01&nowpage=1&pagecount=5&pagegrpnum=1">목록보기</a>
  		</td>
  	</tr>
  	<tr>
  		<td style="height:30px; text-align:center">
  			<a href="/Board/WriteForm?menu_id=MENU01&nowpage=1&pagecount=5&pagegrpnum=1">글쓰기</a>
  		</td>
  	</tr>
  	<tr>
  		<td style="height:30px; text-align:center">
  			<a href="/Menu/List">메뉴보기</a>
  		</td>
  	</tr>
  	<tr>
  		<td style="height:30px; text-align:center">
  			<a href="/Pds/List?menu_id=MENU01&nowpage=1&pagecount=5&pagegrpnum=1">자료실</a>
  		</td>
  	</tr>
  </table>
  <br/>
  <br/>
  
  <table style="width:100px">
  	<tr>
  		<td style="height:30px; text-align:center">
			<a href="/login">로그인</a>
  		</td>
  	</tr>
  </table>
</body>
</html>