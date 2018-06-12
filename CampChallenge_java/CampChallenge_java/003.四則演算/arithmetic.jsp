<%-- 
    Document   : arithmetic
    Created on : 2018/06/12, 14:47:05
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
           final int BASE = 100;
           int num=6;
            int add= BASE+num;
            int sub=BASE-num;
            int mult=BASE*num;
            int div=BASE/num;
            int mod=BASE%num;
             out.print("足し算の結果は"+add+"<br>");
             out.print("引き算の結果は"+sub+"<br>");
             out.print("掛け算の結果は"+mult+"<br>");
             out.print("割り算の結果は"+div+"<br>");
             out.print("剰余の結果は"+mod+"<br>");

/*インプリメントの前置と後置の違い確認*/
        int i=5;
             out.print( i+ "<br>"); //i=5
             out.print( ++i + "<br>"); //i=6
        int j=i++;
             out.print( j+"<br>" );//j=6 i=i+1
             out.print(i+"<br>");//i=7
        int k=++i;
             out.print(k+"<br>");//k=8
             out.print(i+"<br>");//k=8
            %>
    </body>
</html>
