<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>
<%
    HttpSession hs = request.getSession();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>
        <%
            String name =(String)session.getAttribute("name");
            String year =(String)session.getAttribute("year");
            String month =(String)session.getAttribute("month");
            String day =(String)session.getAttribute("day");
            String type =(String)session.getAttribute("type");
            String tell =(String)session.getAttribute("tell");
            String comment =(String)session.getAttribute("comment");

            if(name==null){
                name="";
            }
            if(year==null){
                year="";
            }
            if(month==null){
                month="";
            }
            if(day==null){
                day="";
            }
            if(type==null){
                type="";
            }
            if(tell==null){
                tell="";
            }
            if(comment==null){
                comment="";
            }
       %>
    <form action="insertconfirm" method="POST">
        名前:
        <input type="text" name="name" value="<%out.print(name);%>">
        <br><br>

        生年月日:
        <select name="year">
            <option value="">----</option>
            <%
            for(int i=1950; i<=2010; i++){ %>
            <option value="<%=i%>"
            <%
                if(year.equals(String.valueOf(i))){
                    out.print("selected");
                }
            %>>
            <%=i%></option>
            <% } %>
        </select>年
        <select name="month">
            <option value="">--</option>
            <%
            for(int i = 1; i<=12; i++){ %>
            <option value="<%=i%>"
            <%
                if(month.equals(String.valueOf(i))){
                    out.print("selected");
                }
            %>>
            <%=i%></option>
            <% } %>
        </select>月
        <select name="day">
            <option value="">--</option>
            <%
            for(int i = 1; i<=31; i++){ %>
            <option value="<%=i%>"
            <%
                if(day.equals(String.valueOf(i))){
                    out.print("selected");
                }
            %>>
            <%=i%></option>
            <% } %>
        </select>日
        <br><br>

        種別:
        <br>
        <input type="radio" name="type" value="1" 
               <%
                   if(type.equals("1")){
                       out.print("checked");
                   }
               %>
               >エンジニア<br>
        <input type="radio" name="type" value="2"
               <%
                   if(type.equals("2")){
                       out.print("checked");
                   }
               %>>営業<br>
        <input type="radio" name="type" value="3"
               <%
                   if(type.equals("3")){
                       out.print("checked");
                   }
               %>
               >その他<br>
        <br>

        電話番号:
        <input type="text" name="tell" value="<%out.print(tell);%>">
        <br><br>

        自己紹介文
        <br>
        <textarea name="comment" rows=10 cols=50 style="resize:none" wrap="hard"><%out.print(comment);%></textarea><br><br>

        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="確認画面へ">
    </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
