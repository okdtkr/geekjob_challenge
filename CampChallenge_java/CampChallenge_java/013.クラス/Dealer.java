/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package class3;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Takuro
 */
public class Dealer extends Human {
    protected ArrayList<Integer> cards= new ArrayList<>(); //フィールド宣言山札    
    
    //メソッド宣言
    public Dealer(){ //コンストラクタなので戻り値の定義は不要
        for(int i=1; i<=4; i++){
            for (int j=1; j<=13; j++){
                cards.add(j);
            }
        }
//        for(int k=0; k<cards.size(); k++){
//            if(cards.get(k)>10){
//                cards.set(k, 10);
//            }
//        }
    }
    public ArrayList<Integer> deal(){
        ArrayList<Integer> hand=new ArrayList<>();
        Random rand = new Random();
        for(int n=0;n<=1;n++){
            Integer index = rand.nextInt(cards.size()); 
            int i=cards.get(index);
            cards.remove(i);
            hand.add(n,i);
        }        
        return hand;
    }
    
    public ArrayList<Integer> hit(){
        Random rand = new Random();
        Integer index = rand.nextInt(cards.size());
        int i=cards.get(index);
        ArrayList<Integer> hand=new ArrayList<Integer>();
        cards.remove(i);
        hand.add(i);
        return hand;
        }
    
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

