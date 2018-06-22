/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Takuro
 */
public class class1 {
    public static void main(String[] args){
         Profile hito = new Profile();
            hito.setProfile("岡田","男");
            System.out.println(hito.name);
            System.out.println(hito.jender);
    }
}
class Profile {
        public String name="";
        public String jender="";
        public void setProfile(String n,String j){
            this.name=n;
            this.jender=j;
        }    
    }

