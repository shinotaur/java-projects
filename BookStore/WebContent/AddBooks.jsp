<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3 style="text-align: center;">Add Books</h3>
<form action="AddBookServlet" method="post" style="text-align: center;">
Enter Book Id : <input type="text" name="bid"><br><br>
Enter Book Name : <input type="text" name="bname"><br><br>
Enter Author Name : <input type="text" name="aname"><br><br>
Enter Price : <input type="text" name="price"><br><br>
<input type="submit" value="Add Book">
</form>
</body>
</html>