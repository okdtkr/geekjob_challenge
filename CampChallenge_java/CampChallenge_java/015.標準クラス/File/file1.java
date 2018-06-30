/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;
import java.io.*;
/**
 *
 * @author Takuro
 */
public class file1 {
    public static void main(String[] args){
        try{
            File fp = new File("myprofile.txt");

            FileWriter fw = new FileWriter(fp);
            fw.write("私の名前は岡田卓朗です!!!");
            fw.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}