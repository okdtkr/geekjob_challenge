
<%@page import="jums.UserDataBeans"%>
<%@page import="jums.JumsHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();  //AccessCheckの受け渡し
    UserDataBeans udb=(UserDataBeans)session.getAttribute("BackToSearchResult");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>削除結果画面</title>
    </head>
    <body>
    <h1>削除確認</h1>
    削除しました。<br>
    <form action="SearchResult?name=<%= udb.getName()%>&year=<%=udb.getYear()%>&type=<%=udb.getType()%>&btnSubmit=検索" method="POST">
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="検索結果画面に戻る">
    </form>
    <%=jh.home()%>
    </body>
    
</html>
