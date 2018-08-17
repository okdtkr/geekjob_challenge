<%@page import="java.util.ArrayList"%>
<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    ArrayList list = (ArrayList)request.getAttribute("resultData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS検索結果画面</title>
    </head>
    <body>
        <%if(list.size()!=0){%>
        <h1>検索結果</h1>
        <table border=1>
            <tr>
                <th>名前</th>
                <th>生年</th>
                <th>種別</th>
                <th>登録日時</th>
            </tr>

            <% for(int i=0;i<list.size();i++){
                    UserDataDTO udd = (UserDataDTO)list.get(i);%>
            <tr>
                <td><a href="ResultDetail?id=<%= udd.getUserID()%>"><%=udd.getName()%></a></td>
                <td><%=udd.getBirthday()%></td>
                <td><%=udd.getType()%></td>
                <td><%=udd.getNewDate()%></td>
            </tr>
            <% } %>
        </table>
        <% }else{ %>
            <h3>該当する検索結果はありませんでした</h3>
        <% } %>
        <br>
    </body>
    <a href="Search" >検索画面に戻る</a>
    <br>
    <%=jh.home()%>
</html>
