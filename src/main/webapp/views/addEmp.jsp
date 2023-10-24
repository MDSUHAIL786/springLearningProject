<%--
  Created by IntelliJ IDEA.
  User: mdsuhail.saifi
  Date: 10/24/2023
  Time: 4:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=ISO-8859-1" language="java" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
</head>
<body>
<!-- following is the use of scriplet we can use only one jstl or scriplet to use data coming from controller-->
<%--<%--%>
<%--    String name = (String) request.getAttribute("name");--%>
<%--    int[] arr=(int[]) request.getAttribute("list");--%>
<%--%>--%>

<h1>hello g</h1>
<%--<h1>hello g your name is <%=name%>--%>
<%--    <%--%>
<%--        for(int i=0;i<arr.length;i++)--%>
<%--        {--%>
<%--            out.println(arr[i]);--%>
<%--        }--%>
<%--    %>--%>
<%--</h1>--%>

<br>
<h1>using jsp expression : ${name}</h1>
<h1>using jsp expression : ${list}</h1>

<!-- following is the use of jstl first add dependency and then taglib statement then use -->
<c:forEach var="i" items="${list}">
    <h1>${i}</h1>
</c:forEach>
</body>
</html>
