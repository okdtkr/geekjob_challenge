/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Date;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Takuro
 */
//タイムスタンプの表示
public class date4 {
    public static void main (String[] args) throws ParseException{
        SimpleDateFormat sdf1 =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1 = sdf1.parse("2015-01-01 00:00:00");
        SimpleDateFormat sdf2 =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d2 = sdf2.parse("2015-12-31 23:59:59");
        
        long l1 =d1.getTime();
        long l2 =d2.getTime();
        
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l2-l1);
    }
}
