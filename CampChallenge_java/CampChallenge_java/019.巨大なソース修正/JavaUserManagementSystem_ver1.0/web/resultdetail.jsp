<%-- 
    Document   : resultdetail
    Created on : 2018/08/11, 12:56:13
    Author     : Takuro
--%>

<%@page import="jums.UserDataDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    ArrayList list = (ArrayList)request.getAttribute("Data");
    UserDataDTO udd =(UserDataDTO)list.get(0);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr>
                <th>名前</th>
                <th>生年</th>
                <th>種別</th>
                <th>登録日</th>
            </tr>
            <tr>
                <td><%out.print(udd.getUserID());%>></td>
                <td><%out.print(udd.getName());%>></td>
                <td><% out.print(udd.getBirthday());%></td>
                <td><% out.print(udd.getTell());%></td>
                <td><%out.print(udd.getType());%></td>
                <td><% out.print(udd.getComment());%></td>
                <td><%out.print(udd.getNewDate());%></td>
            </tr>
        </table>
    </body>
</html>
