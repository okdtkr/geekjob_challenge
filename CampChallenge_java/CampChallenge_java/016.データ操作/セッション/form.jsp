<%-- 
    Document   : form
    Created on : 2018/07/06, 16:30:43
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
        <%@ page import= "javax.servlet.http.HttpSession"%>
        <%
            HttpSession hs =request.getSession();
            String name =(String)hs.getAttribute("Name");
            String gender =(String)hs.getAttribute("Gender");
            String hobby =(String)hs.getAttribute("Hobby");

            if(name==null){
                name="";
            }
            if(gender==null){
                gender="";
            }
            if(hobby==null){
                hobby="";
            }
       %>

       <form action="./submit" method="post">
        名前
       <input type="text" name="human name" value=<%out.print(name);%>><br>
        
        性別
        <input type='radio' name='gender' id='male' value='男'
               <%
                   if(gender.equals("男")){
                       out.print("checked");
                   }
               %>
               >男
        
        <input type='radio' name='gender' id='female' value='女'
               <%
                   if(gender.equals("女")){
                       out.print("checked");
                   }
               %>
               >女
        <br>
        
        趣味
        <textarea name="hobby"><%out.print(hobby);%></textarea><br>
                
        <input type="submit" name="btnSubmit" value="登録">
        </form>
    </body>
</html>
