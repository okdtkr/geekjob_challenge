<%-- 
    Document   : for2
    Created on : 2018/06/14, 18:01:31
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
        int result=0;
            for(int i=0;i<=100;i++){
                result=result +i;
            }
            out.print(result);
        %>
    </body>
</html>
