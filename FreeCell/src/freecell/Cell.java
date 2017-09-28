/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freecell;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andre
 */
public class Cell {
    
    private List<Card> stack;
    private String name;
    
    public Cell(List<Card> start, String name){
        stack = new ArrayList<>();
        for (Card c : start)
            stack.add (c);        
        this.name = name;
    }
    
    public int getSize() {return stack.size();}
    public Card getCard(int num) {return stack.get(num);}
    public String getName() {return name;}
    public boolean isEmpty() {return stack.isEmpty();}
    public Card getTop() {
        if(!this.isEmpty())
            return stack.get(stack.size()-1);
        return null;
    }
    @Override
    public String toString() {
        String out = this.getName() + "----" + this.getSize() + ": ";         
        for(Card c : stack)
            out = out + c.toString() + ", ";
        return out;
    }
    
    public boolean canMoveFrom(){
        return false;
    }
    public boolean canMoveTo(Card moving){
        return false;
    }
    public void move(Cell dest){
        if(this.canMoveFrom() && dest.canMoveTo(this.getTop())){            
            System.out.println("Succesfull Move!");
            Card c = this.getTop();
            dest.stack.add(c);
            this.stack.remove(c);
        }
        else
            System.out.println("Illegal Move");
    }
}
