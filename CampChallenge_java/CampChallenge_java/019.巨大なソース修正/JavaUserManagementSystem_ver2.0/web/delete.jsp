<%@page import="jums.UserDataBeans"%>
<%@page import="jums.JumsHelper"
        import="jums.UserDataDTO" %>
<%
    JumsHelper jh = JumsHelper.getInstance();
    HttpSession hs = request.getSession();
//    UserDataBeans udb=(UserDataBeans)session.getAttribute("userdata");
    UserDataDTO udd = (UserDataDTO)hs.getAttribute("ResultData");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h1>削除確認</h1>
    以下の内容を削除します。よろしいですか？<br>
    名前:<%= udd.getName()%><br>
    生年月日:<%= udd.getBirthday()%><br>
    種別:<%= udd.getType()%><br>
    電話番号:<%= udd.getTell()%><br>
    自己紹介:<%= udd.getComment()%><br>
    登録日時:<%= udd.getNewDate()%><br>
    
    <form action="DeleteResult" method="POST">
      <input type="submit" name="YES" value="はい"style="width:100px">
      <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
    </form>
    <form action="ResultDetail?id=<%out.print(udd.getUserID());%>" method="POST">
      <input type="submit" name="NO" value="いいえ"style="width:110px">
    </form>
    </body>
    <%=jh.home()%>
</html>
