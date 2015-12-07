<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.hanains.guestbook.dao.GuestBookDao" %>
<%@ page import="com.hanains.guestbook.vo.GuestBookVo" %>

<%
	request.setCharacterEncoding("UTF-8");

	String no = request.getParameter("no");
	String pass = request.getParameter("password");
	
	GuestBookVo vo = new GuestBookVo();
	vo.setNo(Long.parseLong(no));
	vo.setPassword(pass);
	
	GuestBookDao dao = new GuestBookDao();

	dao.Delete(vo);
	
	response.sendRedirect("/guestbook");
	
%>
