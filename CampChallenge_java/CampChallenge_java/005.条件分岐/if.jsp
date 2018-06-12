<%-- 
    Document   : if
    Created on : 2018/06/12, 18:42:32
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
            /*変数の宣言と表示（if文）*/
          int num =1 ;
          if(num ==1){
              out.print("1です!");     
          }else if(num==2){
              out.print("プログラミングキャンプ!");
          }else{
              out.print("その他です!");
          }
        %>
     
    </body>
</html>
