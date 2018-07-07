<%-- 
    Document   : query_string_input
    Created on : 2018/07/02, 15:09:57
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
        <form action ="query_string_output.jsp" method="get">
            <select name="type">
                <option value="1">雑貨
                <option value="2">生鮮食品
                <option value="3">その他
            </select>
            数量<input type="text" name="count">
            総額<input type="text" name="total">
            <input type="submit" name="btnSubmit">
        </form>
    </body>
</html>
