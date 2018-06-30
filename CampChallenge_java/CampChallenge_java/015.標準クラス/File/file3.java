/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util. Random; 
/**
 *
 * @author Takuro
 */
public class file3 {
    public static void main(String[] args){
        Date start=new Date();
        SimpleDateFormat st =new SimpleDateFormat("yyyy年MM月dd日 HH時mm分ss秒");
        String s =st.format(start);

        Random r =new Random();
        System.out.print(r.nextDouble());
        
        Date finish=new Date();
        SimpleDateFormat fin =new SimpleDateFormat("yyyy年MM月dd日 HH時mm分ss秒");
        String f =fin.format(finish);

        try{
            File file = new File("標準クラスを利用した処理生成.txt");
            FileWriter fw = new FileWriter(file);

            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("処理内容：乱数の生成");
            bw.newLine();
            bw.write("処理の開始："+s);
            bw.newLine();
            bw.write("処理の終了："+f);
            
            bw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
