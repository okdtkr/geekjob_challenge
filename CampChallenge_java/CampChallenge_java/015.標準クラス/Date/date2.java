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
//現在の日時の表示
public class date2 {
    public static void main (String[] args) throws ParseException{
        Date now=new Date();
        
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy年MM月dd日 HH時mm分ss秒");
        String n =sdf.format(now);
        
        System.out.print(n);
    }
}
