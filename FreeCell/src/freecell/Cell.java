/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freecell;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
    public boolean isEmpty() {return stack.isEmpty();}
    public Card getTop() {
        if(!this.isEmpty())
            return stack.get(stack.size()-1);
        else
            return null;
    }
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
            dest.stack.add(this.getTop());
            this.stack.remove(this.getTop());
            /*
            ListIterator litr = stack.listIterator();
            while(litr.hasNext()){
                Object obj = litr.next();
                if(obj.equals(this.getTop()))
                    litr.remove();
            }
            */
        }
        else
            System.out.println("Illegal Move");
    }
}
