<%@page import="com.pojo.Books"%>
<%@page import="java.util.List"%>
<%@page import="com.model.BLManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Welcome , <c:out value="${em.name}"></c:out>
<a href="LogoutServlet">Logout</a>

<%
BLManager bl=new BLManager();
List<Books> blist=bl.showAllBooks();
HttpSession s=request.getSession();
s.setAttribute("blist", blist);
%>
<table width="100%" border="1">
<tr>
<th>BID</th>
<th>Book Id</th>
<th>Book Name</th>
<th>Author Name</th>
<th>Price</th>
</tr>

<c:forEach items="${blist}" var="b">
<tr>
<td><c:out value="${b.bid}"></c:out></td>
<td><c:out value="${b.bookId}"></c:out></td>
<td><c:out value="${b.bookname}"></c:out></td>
<td><c:out value="${b.authorName}"></c:out></td>
<td><c:out value="${b.price}"></c:out></td>
<td><a href="BuyNowServlet?bid=${b.bid}">Buy Now</a></td>
</c:forEach>
</tr>
</table>
</body>
</html>