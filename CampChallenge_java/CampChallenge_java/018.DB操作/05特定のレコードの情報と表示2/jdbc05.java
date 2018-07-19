/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;
import java.sql.*;


/**
 *特定のレコードの情報取得と表示
 * @author Takuro
 */
public class jdbc05 {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement st =null;
        ResultSet data =null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // MySQLに接続
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "OKADATAKURO", "OKDTKR");
            System.out.println("MySQLに接続できました。");
            
            st=con.prepareStatement("select * from profiles where name like ? ");
            st.setString(1,"%茂%");

            data=st.executeQuery();
            while(data.next()){
                System.out.print(data.getString("profilesID")+" ");
                System.out.print(data.getString("name")+" ");
                System.out.print(data.getString("tell")+" ");
                System.out.print(data.getString("age")+" ");
                System.out.println(data.getString("birthday")+" ");
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
