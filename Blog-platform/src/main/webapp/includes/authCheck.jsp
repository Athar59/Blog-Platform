<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("userId") == null) {
        String query = request.getQueryString();
        String redirectTo = request.getRequestURI() + (query != null ? "?" + query : "");
        response.sendRedirect("login.jsp?msg=Please+login+first&redirect=" + java.net.URLEncoder.encode(redirectTo, "UTF-8"));
        return;
    }
%>
