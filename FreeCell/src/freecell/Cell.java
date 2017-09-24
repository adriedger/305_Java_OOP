/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freecell;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Andre
 */
public class Cell {
    
    private List<Card> stack;
    private String name;
    
    public Cell(List<Card> start, String name){
        stack = start;
        this.name = name;
    }
    
    public int getSize() {return stack.size();}
    public Card getCard(int num) {return stack.get(num);}
    public String getName() {return name;}
    public void printStack() {
        if(stack.isEmpty()){
            System.out.println("Empty");
        }
        else{            
            for(Card c : stack)
                c.print();
        }
    }
}
