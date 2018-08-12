/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Takuro
 */
public class Searchresult extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();
            request.setCharacterEncoding("UTF-8");//セッションに格納する文字コードをUTF-8に変更
            String accesschk = request.getParameter("ac");
            if(accesschk ==null || (Integer)session.getAttribute("ac")!=Integer.parseInt(accesschk)){
                throw new Exception("不正なアクセスです");
            }
            
            //フォームからの入力を取得
            String name = request.getParameter("name");
            String year = request.getParameter("year");
            String type = request.getParameter("type");
//            String tell = request.getParameter("tell");
            
            session.setAttribute("name", name);
            session.setAttribute("year", year);
            session.setAttribute("type", type);
//            session.setAttribute("tell", tell);
            System.out.println("Session updated!!");
            
            //ユーザー情報に対応したJavaBeansオブジェクトに格納していく    
            //フォームの入力値を格納      
            UserDataBeans userdata = new UserDataBeans();
            userdata.setName((String)session.getAttribute("name"));
            userdata.setYear((String)session.getAttribute("year"));

            userdata.setType((String)session.getAttribute("type"));
//            userdata.setTell((String)session.getAttribute("tell"));
//            userdata.setComment((String)session.getAttribute("comment"));
//            System.out.print("FormDBBeans updated");
            
            //UserDataBeansの各データをDB型変数に変換して格納
//            UserDataDTO userdto = new UserDataDTO();
//            FormatDbBeans.getInstance().Format(userdto, userdata);
//            UserDataDTO udto =new UserDataDTO();
//            ArrayList<UserDataDTO> list= new ArrayList<UserDataDTO>();
//            UserDataDAO.getInstance().search(userdata, udto);

//            ArrayList list=UserDataDAO.getInstance().search(userdata, udto);
            
            if(name.equals("")&&year.equals("")&&type==null){
                ArrayList list=UserDataDAO.getInstance().Allsearch();
                request.setAttribute("Data",list);
            }else{
                ArrayList list=UserDataDAO.getInstance().search(userdata);
                request.setAttribute("Data",list);
            }
            
            RequestDispatcher rd=request.getRequestDispatcher("/searchresult.jsp");
            rd.forward(request, response);
        } finally {
            out.close();
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Searchresult.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Searchresult.class.getName()).log(Level.SEVERE, null, ex);
        }
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
