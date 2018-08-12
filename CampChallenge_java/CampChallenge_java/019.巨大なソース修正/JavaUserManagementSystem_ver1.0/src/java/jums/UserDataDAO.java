package jums;

/**
 * ユーザー情報を格納するテーブルに対しての操作処理を包括する
 * DB接続系はDBManagerクラスに一任
 * 基本的にはやりたい1種類の動作に対して1メソッド
 * @author hayashi-s
 */
import base.DBManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class UserDataDAO {
    
    //インスタンスオブジェクトを返却させてコードの簡略化
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    
    /**
     * データの挿入処理を行う。現在時刻は挿入直前に生成
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    
//フォームに入力した値をDBに対応できる形に変える  
    public void Format(UserDataDTO ud,UserDataBeans udb) throws ParseException{
        ud.setName(udb.getName());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
        Date s=sdf.parse(udb.getYear()+"/"+udb.getMonth()+"/"+udb.getDay());
        ud.setBirthday(s);
        ud.setType(Integer.parseInt(udb.getType()));
        ud.setTell(udb.getTell());
        ud.setComment(udb.getComment());
    }
//データ情報を新規登録する    
    public void insert(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO user_t(name,birthday,tell,type,comment,newDate) VALUES(?,?,?,?,?,?)");
            st.setString(1, ud.getName());
            st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            st.setString(3, ud.getTell());
            st.setInt(4, ud.getType());
            st.setString(5, ud.getComment());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("insert completed");
            
            st.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
//第一段階の課題では不要のメソッドでした。検索用のメソッドです。    
    public ArrayList search(UserDataBeans ud)throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        ResultSet data=null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("select * from user_t where name=? or birthday like ? or type=?");
            st.setString(1, ud.getName());
            st.setString(2, "%"+ud.getYear()+"%");//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            st.setInt(3, Integer.parseInt(ud.getType()));
            data=st.executeQuery();
            
            ArrayList<UserDataDTO> list =new ArrayList<UserDataDTO>();
            
            while(data.next()){
                int Id=data.getInt("userID");
                String Name=data.getString("name");
                Date Birthday = data.getDate("birthday");
                String Tell =data.getString("tell");
                int Type = data.getInt("type");
                String Comment = data.getString("comment");
                Timestamp NewDate=data.getTimestamp("newDate");

                UserDataDTO udto =new UserDataDTO();
                udto.setUserID(Id);
                udto.setName(Name);
                udto.setBirthday(Birthday);
                udto.setTell(Tell);
                udto.setType(Type);
                udto.setComment(Comment);
                udto.setNewDate(NewDate);
                list.add(udto);
            }
            
            System.out.println(list);
            System.out.println("search completed");
            st.close();
            data.close();
            
            return list;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    public ArrayList Allsearch()throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        ResultSet data=null;
        try{
            con = DBManager.getConnection();
//            ArrayList<UserDataDTO> list=new ArrayList<UserDataDTO>();
            st =  con.prepareStatement("select * from user_t");
            data=st.executeQuery();
            
            ArrayList<UserDataDTO> list =new ArrayList<UserDataDTO>();
            
            while(data.next()){
                int Id=data.getInt("userID");
                String Name=data.getString("name");
                Date Birthday = data.getDate("birthday");
                String Tell =data.getString("tell");
                int Type = data.getInt("type");
                String Comment = data.getString("comment");
                Timestamp NewDate=data.getTimestamp("newDate");

                UserDataDTO udto =new UserDataDTO();
                udto.setUserID(Id);
                udto.setName(Name);
                udto.setBirthday(Birthday);
                udto.setTell(Tell);
                udto.setType(Type);
                udto.setComment(Comment);
                udto.setNewDate(NewDate);
                list.add(udto);
            }
            
            System.out.println(list);
            System.out.println("search completed");
            st.close();
            data.close();
            
            return list;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
}
