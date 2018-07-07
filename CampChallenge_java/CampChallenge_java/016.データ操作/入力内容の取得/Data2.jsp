<%-- 
    Document   : Data2
    Created on : 2018/07/02, 13:45:38
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
            //HTMLの入力データの取得と表示
            request.setCharacterEncoding("UTF-8");

            String name =request.getParameter("human name");
            String gender =request.getParameter("gender");
            String hobby =request.getParameter("hobby");

            out.print("氏名："+ name+ "<br>");
            out.print("性別："+ gender+ "<br>");
            out.print("趣味："+ hobby);
        %>
    </body>
</html>
