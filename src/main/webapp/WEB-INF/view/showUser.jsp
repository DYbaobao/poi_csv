<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'showUser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <center>
       <table width="450" border="1">
          <tr>
            <th scope="col">序号</th>
            <th scope="col">编号</th>
            <th scope="col">用户名</th>
            <th scope="col">年龄</th>
            <th scope="col">码值</th>
            <th scope="col">电话</th>
          </tr>
          
           <c:forEach begin="0" step="1" items="${users}" var="list" varStatus="users">
          <tr>
             <td>${users.count }</td>
             <td>${list.id }</td>
             <td>${list.userName }</td>
             <td>${list.age }</td>
             <td>${list.code }</td>
             <td>${list.phone }</td>
          </tr>
          </c:forEach>
       </table>
       <span>一共${page.pages }页</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>当前${page.pageNum }</span>
    
       <a href="user/List?page=1">第一页</a>
        <a href="user/List?page=${page.nextPage}">下一页</a>
        <a href="user/List?page=${page.prePage}">上一页</a>
        <a href="user/List?page=${page.pages}">最后页</a> 
    </center>
  </body>
</html>
