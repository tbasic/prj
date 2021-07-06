<%@page import="notice.vo.Notice"%>
<%@page import="notice.dao.NoticeDao"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<%
//업데이트 처리
String title=request.getParameter("title");
String content=request.getParameter("content");

String seq=request.getParameter("c");

NoticeDao dao=new NoticeDao();
//int af=dao.update(title, content, seq);
Notice n=new Notice();
n.setSeq(seq);
n.setTitle(title);
n.setContent(content);

int af=dao.update(n);

if(af>0)
	response.sendRedirect("noticeDetail.jsp?c="+seq);
else
	out.write("수정오류");

%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>noticeEditProc.jsp</h3>

<%=seq %>
</body>
</html>