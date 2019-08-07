<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<link rel="stylesheet" href="/css/common.css" />
<script src="/js/writeform.js"></script>
</head>
<body>
	<form action="/Board/Write" method="post" id="frmWrite">
	<input type="hidden" name="menu_id"     value="${ boardVo.menu_id }" />
	<input type="hidden" name="bnum"        value="${ boardVo.bnum }" />
	<input type="hidden" name="lvl"         value="${ boardVo.lvl }" />
	<input type="hidden" name="step"        value="${ boardVo.step }" />
	<input type="hidden" name="nref"        value="${ boardVo.nref }" />
	<input type="hidden" name="nowpage"     value="${ boardVo.nowpage }" />
	<input type="hidden" name="pagegrpnum"  value="${ boardVo.pagegrpnum }" />
	
		<table>
			<caption>글쓰기</caption>
			<tr>
				<td style="width:100px">게시판아이디</td>
				<td><input type="text" value="${ menu_id }" style="width:250px" /></td>
			</tr>
			<tr>
				<td style="width:100px">작성자</td>
				<td><input type="text" name="writer" id="writer" style="width:250px" /></td>
			</tr>
			<tr>
				<td style="width:100px">제목</td>
				<td><input type="text" name="title" id="title" style="width:250px" /></td>
			</tr>
			<tr>
				<td style="width:100px">내용</td>
				<td><textarea name="cont" id="cont" style="width:400px; height:150px"></textarea></td>
			</tr>
			<tr>
				<td style="text-align:center" colspan="2">
					<input type="submit" value="작성" id="btn1" />
					<a href="/Board/List?menu_id=${ menu_id }">목록</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>