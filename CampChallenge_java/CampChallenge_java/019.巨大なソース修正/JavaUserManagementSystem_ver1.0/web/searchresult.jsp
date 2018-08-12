<%-- 
    Document   : searchresult
    Created on : 2018/08/03, 17:35:32
    Author     : Takuro
--%>

<%@page import="jums.JumsHelper"%>
<%@page import="jums.UserDataDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jums.UserDataDAO" %>
<!DOCTYPE html>
<%
    ArrayList list = (ArrayList)request.getAttribute("Data");  
    request.setAttribute("Data",list);
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
            <% for(int i=0;i<list.size();i++){
                    UserDataDTO udd = (UserDataDTO)list.get(i); %>
            <tr>
                <td><a href="resultdetail"><%out.print(udd.getName());%></a></td>
                <td><% out.print(udd.getBirthday());%></td>
                <td><%out.print(udd.getType());%></td>
                <td><%out.print(udd.getNewDate());%></td>
            </tr>
            <% } %>
        </table>
        <form action="search" method="POST">
            <input type="submit" name="back" value="検索画面に戻る">
        </form>
        <br>
            <%=JumsHelper.getInstance().home()%>
    </body>
</html>
