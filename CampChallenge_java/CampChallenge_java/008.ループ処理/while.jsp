<%-- 
    Document   : whike
    Created on : 2018/06/15, 10:56:35
    Author     : Takuro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            float result=1000;
            while(!(result<=100)){
              result /=2;
            }
            out.print(result);
        %>
    </body>
</html>
