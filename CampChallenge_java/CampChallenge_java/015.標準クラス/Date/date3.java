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
public class date3 {
    public static void main (String[] args) throws ParseException{
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = sdf.parse("2016-11-04 10:00:00");
        String s =sdf.format(d);
        
        System.out.println(d.getTime());
        System.out.println(s);
    }
}
