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
        String result="";
            for(int i=1;i<=30;i++){
                result=result +"A";
            }
            out.print(result);
        %>
    </body>
</html>
