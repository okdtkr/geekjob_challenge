/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package class2;

/**
 *
 * @author Takuro
 */
class Profile {
        public String name="";
        public String jender="";
        public void setProfile(String n,String j){
            this.name=n;
            this.jender=j;
        }    
    }

class clone extends Profile{
    void clear(){
        this.name=null;
        this.jender=null;
    }
}

public class class2 {
    public static void main(String[] args){
         clone reset = new clone();
         reset.setProfile("岡田","男");     //nameに岡田、jenderに男を代入
         
         reset.clear();     //clearメソッド呼び出し。nameとjenderにnullを代入
         System.out.println(reset.name);
         System.out.println(reset.jender);
    }
}

