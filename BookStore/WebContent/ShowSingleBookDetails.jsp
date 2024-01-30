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
<c:out value="${book.bookId}"></c:out>
<c:out value="${book.bookname}"></c:out>
<c:out value="${book.authorName}"></c:out>
<c:out value="${book.price}"></c:out>

<form action="ConfirmServlet" method="post">
<input type="submit" value="Confirm">
</form>

</body>
</html>