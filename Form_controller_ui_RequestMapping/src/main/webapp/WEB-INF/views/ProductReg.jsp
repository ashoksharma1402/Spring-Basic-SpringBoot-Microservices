<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to Product Registration</title>
</head>
<body>
<form action="saveP" method="POST">
<pre>
ID:<input type="text" name="prodId"/><br>
CODE:<input type="text" name="prodCode"/><br>
COST:<input type="text" name="prodCost"/><br>

MODEL:<input type="radio" name="prodModel" value="HIGH">HIGH
      <input type="radio" name="prodModel" value="MID">MID
      <input type="radio" name="prodModel" value="LOW">LOW
      <input type="submit" value="add product"/>
</pre>

</form>
</body>
</html>