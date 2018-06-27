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
public abstract class Human {
    protected ArrayList<Integer> myCards = new ArrayList<>(); //フィールド宣言手札
    abstract public int open();
    abstract public void setCard(ArrayList<Integer> a);       
    abstract public boolean checkSum();
}
