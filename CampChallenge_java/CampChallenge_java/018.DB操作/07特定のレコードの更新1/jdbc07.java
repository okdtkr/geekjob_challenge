/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;
import java.sql.*;


/**
 *特定のレコードの更新
 * @author Takuro
 */
public class jdbc07 {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement st =null;
        ResultSet data =null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // MySQLに接続
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "OKADATAKURO", "OKDTKR");
            System.out.println("MySQLに接続できました。");
            
            st=con.prepareStatement("update profiles set name='東 卓朗' where profilesID =?");
            st.setInt(1,1);
            
            int result=st.executeUpdate();
            System.out.println("更新回数："+ result);

            st=con.prepareStatement("select* from profiles order by profilesID");
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
