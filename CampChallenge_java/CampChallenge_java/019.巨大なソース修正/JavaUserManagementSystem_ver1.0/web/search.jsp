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
        <title>登録情報検索</title>
    </head>
    <body>
        <%
            String name =(String)session.getAttribute("name");
            String year =(String)session.getAttribute("year");
            String type =(String)session.getAttribute("type");
            
            if(name==null){
                name="";
            }
            if(year==null){
                year="";
            }
            
            if(type==null){
                type="";
            }
       %>
    <form action="searchresult" method="GET">
       名前:
       <input type="text" name="name" value="<% out.print(name);%>">
        <br><br>

        生年:
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
               %>
               >営業<br>
        <input type="radio" name="type" value="3"
                <%
                   if(type.equals("3")){
                       out.print("checked");
                   }
               %>
               >その他<br>
        <br>
        <input type="hidden" name="ac"  value="<%= hs.getAttribute("ac")%>">
        <input type="submit" name="btnSubmit" value="検索">
    </form>
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
