/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *フォームからデータを挿入
 * @author Takuro
 */
public class jdbc09 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        request.setCharacterEncoding("UTF-8");
        
        String id =request.getParameter("id"); //int型にしたい
        String name =request.getParameter("human name");    
        String tell =request.getParameter("tellnumber");
        String age =request.getParameter("age"); //int型にしたい
        String birth =request.getParameter("birth"); //date1型にしたい
        
        Connection con = null;
        PreparedStatement st =null;
        ResultSet data =null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // MySQLに接続
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "OKADATAKURO", "OKDTKR");
            out.println("MySQLに接続できました。"+"<br>");
            
            
            st=con.prepareStatement("insert into profiles values(?,?,?,?,?)");
           //ArrayList型にid,name..birthの配列を格納すればfor処理で記述できる?
            st.setString(1,id);
            st.setString(2,name);
            st.setString(3,tell);
            st.setString(4,age);
            st.setString(5,birth);
            
            int result=st.executeUpdate();
            out.print("更新回数："+ result+"<br>");


            st=con.prepareStatement("select* from profiles order by profilesID");
            data=st.executeQuery();
            while(data.next()){
                out.print(data.getString("profilesID")+" ");
                out.print(data.getString("name")+" ");
                out.print(data.getString("tell")+" ");
                out.print(data.getString("age")+" ");
                out.println(data.getString("birthday")+"<br>");
            }
            
            data.close();
            st.close();
            con.close();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            System.out.println("JDBCドライバのロードに失敗しました。");
        } catch (SQLException e) {
            System.out.println("MySQLに接続できませんでした。");
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println("MySQLのクローズに失敗しました。");
                }
            }
        }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
