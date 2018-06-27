/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package class3;

import java.util.ArrayList;

/**
 *
 * @author Takuro
 */
public class User extends Human {
    //メソッド宣言
    public int open(){     
        int total=0;
        for(int i=0; i<myCards.size();i++){
            if(myCards.get(i)>10){
                myCards.set(i,10);
            }
            total+=myCards.get(i);
        }       
        return total;
    }
    public void setCard(ArrayList<Integer> a){
        for (int i=0; i<a.size(); i++){
            myCards.add(a.get(i));
        }
    }
    public boolean checkSum(){
        int total=0;
        for(int i=0; i<myCards.size();i++){
            if(myCards.get(i)>10){
                myCards.set(i,10);
            }
            total+=myCards.get(i);
        }
        if(total<17){
            return true;        
        }else{
            return false;
        }       
    }
}
