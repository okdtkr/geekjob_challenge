<%-- 
    Document   : array1
    Created on : 2018/06/13, 14:08:50
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
         <%@ page import="java.util.ArrayList" %>
        <%
            ArrayList<String>scores=new ArrayList<String>();
            scores.add("10");
            scores.add("100");
            scores.add("soeda");
            scores.add("hayashi");
            scores.add("-20");
            scores.add("118");
            scores.add("END");
            
            for(int i = 0; i<scores.size(); i++){
                out.print(scores.get(i));
            }
        %>
    </body>
</html>
