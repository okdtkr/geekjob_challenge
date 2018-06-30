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
//タイムスタンプの作成
public class date1 {
    public static void main (String[] args) throws ParseException{
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy/MM/dd");
        Date d = sdf.parse("2016/01/01");
        System.out.print(d.getTime());
    }
}
