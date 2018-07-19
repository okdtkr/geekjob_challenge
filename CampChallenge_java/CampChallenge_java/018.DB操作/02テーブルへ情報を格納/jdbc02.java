/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;
import java.sql.*;


/**
 *テーブルへ情報を格納
 * @author Takuro
 */
public class jdbc02 {
    public static void main(String[] args) {
        Connection con = null;
        Statement stm =null;
//        PreparedStatement st =null;
        ResultSet data =null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // MySQLに接続
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "OKADATAKURO", "OKDTKR");
            System.out.println("MySQLに接続できました。");
            
            stm=con.createStatement();
            int result=stm.executeUpdate("insert into profiles values(3,'鈴木 実','080-5566-7788',24,'2000-12-24')");
//            st=con.prepareStatement("insert into profiles values(3,'鈴木 実','080-5566-7788',24,'2000-12-24')");
//            int result= st.executeUpdate();
            System.out.println("更新回数："+ result);
            
            data.close();
            stm.close();
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
