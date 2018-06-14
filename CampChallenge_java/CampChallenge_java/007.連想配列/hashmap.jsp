<%-- 
    Document   : hashmap
    Created on : 2018/06/14, 11:36:53
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
        <%@ page import="java.util.HashMap" %>
        <%
            HashMap<String,String>a=new HashMap<String,String>();
             a.put("1", "AAA"); 
             a.put("hello", "world");
             a.put("soeda", "33");
             a.put("20", "20");
             
            out.print(a.get("1"));
            out.print(a.get("hello"));
            out.print(a.get("soeda"));
            out.print(a.get("20"));
        %>
    </body>
</html>
