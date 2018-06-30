/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character;
//バイト数と文字数の取得
/**
 *
 * @author Takuro
 */
public class character1 {
    public static void main(String[] args){
        String myname = "岡田卓朗";
        
        System.out.println(myname.getBytes().length);
        System.out.println(myname.length());
    }
}
