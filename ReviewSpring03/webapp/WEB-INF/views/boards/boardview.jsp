<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시물 조회</title>
</head>
<body>
  	<table border="1" cellpadding="0" cellspacing="0" width="500" align ="center" >
  	<caption><h2>게시물 내용보기</h2></caption> 
  		<tr>
   			<td width="100" height="30" align="center">게시판 이름</td>
   			<td height="30" colspan="3">${ menu_id }</td> 
  		</tr>   
  		<tr>
		   <td width="100" height="30" align="center">작성자</td>
		   <td width="150" height="30">${ boardVo.writer }</td> 
		   <td width="100" height="30" align="center">작성일</td>
		   <td width="150" height="30">${ boardVo.regdate }</td> 
  		</tr>
  		<tr>
		   <td width="100" height="30" align="center">글번호</td>
		   <td width="150" height="30">${ boardVo.bnum }</td> 
		   <td width="100" height="30" align="center">조회수</td>
		   <td width="150" height="30">${ boardVo.readcount }</td> 
  		</tr>
  		<tr>
		   <td width="100" height="30" align="center">제목</td>
		   <td width="400" height="30" colspan="3">${ boardVo.title }</td> 
  		</tr>
  		<tr> 
  			<td width="100" height="30" align="center">내용</td>
   			<td width="500" height="300" colspan="3" valign="top">${ boardVo.cont }</td> 
  		</tr>
  		<tr>   
   			<td width="500" height="30" colspan="4">
     			<a href="/Board/WriteForm?menu_id=${boardVo.menu_id}&bnum=0&lvl=0&step=0&nref=0&nowpage=1&pagegrpnum=1">새글쓰기</a>
			    <a href="/Board/WriteForm?menu_id=${boardVo.menu_id}&bnum=${boardVo.bnum}&lvl=${boardVo.lvl}&step=${boardVo.step}&nref=${boardVo.nref}">답글쓰기</a>
			    <a href="/Board/List?menu_id=${boardVo.menu_id}&nowpage=1&pagecount=5&pagegrpnum=1">목록</a>
			    <a href="/Board/UpdateForm?idx=${boardVo.idx}&menu_id=${menu_id}">수정</a>
			    <a href="/Board/Delete?idx=${boardVo.idx}&menu_id=${boardVo.menu_id}">삭제</a>
   			</td> 
  		</tr>
  	</table>
</body>
</html>





