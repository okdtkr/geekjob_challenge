/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package character;
//文字数の取得
/**
 *
 * @author Takuro
 */
public class character2 {
    public static void main(String[] args){    
        String mail="okadatakuro@g.vo.com";
        int n=mail.indexOf("@") +1;
        String s=mail.substring(n);

        System.out.println(mail.substring(n));
        System.out.println(s.length());
    }
}
