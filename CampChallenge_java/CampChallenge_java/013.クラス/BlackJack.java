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
public class BlackJack {
    public static void main(String[] args){
        Dealer d=new Dealer();        //山札が用意される
        User u =new User();        
        
        /*
        ・最初の手札(DealerとUser)
        ・最終的な手札の合計
        ・勝敗
        */
        //最初の手札
        d.setCard(d.deal());
        u.setCard(d.deal());
        System.out.println("最初の手札");
        System.out.println("ディーラー"+d.myCards);
        System.out.println("プレイヤー"+u.myCards);
        
        //引くか引かないか
        System.out.println("");
        System.out.println("スタンドorヒット");
        
        //ディーラー
        System.out.println("");
        System.out.println("ディーラー");
        while(d.checkSum()){
            System.out.println("ヒット");
            d.setCard(d.hit());
            System.out.println(d.myCards);
        }
            System.out.println("スタンド");
                
        //プレイヤー
        System.out.println("");
        System.out.println("プレイヤー");
        while(u.checkSum()){
            System.out.println("ヒット");
            u.setCard(d.hit());
            System.out.println(u.myCards);
        }
            System.out.println("スタンド");
            
        //引いた後の手札
        System.out.println("");
        System.out.println("引いた後の手札");

        System.out.print("ディーラー"+d.myCards);
        System.out.println("プレイヤー"+u.myCards);
        int pd=d.open(); 
        int pu=u.open();
        System.out.print("ディーラーの手札の合計："+pd);
        System.out.print("プレイヤーの手札の合計："+pu);
        
        //勝敗
        System.out.println("");
        System.out.println("勝敗");
        
        if(pd>21 && pu>21){
            System.out.print("両者とも21を超えたのでプッシュです");
        }else if(pd>21 && pu<=21){
            System.out.println("ディーラーはバストしました。");
            System.out.print("プレイヤーの勝ち");
        }else if(pu>21 && pd<=21){
            System.out.println("プレイヤーはバストしました。");
            System.out.print("ディーラーの勝ち");
        }else{
            if(pd>pu){
                    System.out.print("ディーラーの勝ち");
                }else if(pd<pu){
                    System.out.print("プレイヤーの勝ち");
                }else{
                    System.out.print("プッシュ");
                }
            }
    }
}
