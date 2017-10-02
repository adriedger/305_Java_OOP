/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freecell;

import java.util.ArrayList;
import java.util.Collections;
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
    public Card getTop() {return stack.get(stack.size()-1);}
    public Card getSubstackTop(){return null;}
    
    @Override
    public String toString() {
        String out = this.getName() + ": ";         
        for(Card c : stack)
            out = out + c.toString() + " ";
        return out;
    }
    
    public boolean canMoveFrom(){return false;}
    public boolean canMoveTo(Card moving){return false;}
    
    public void move(Cell dest){
        if(this.getName().charAt(0) == 'T' && dest.getName().charAt(0) == 'T'){
            if(this.canMoveFrom() && dest.canMoveTo(this.getSubstackTop())){
                System.out.println("Succesfull Move!");
                this.stackAddRemove(dest);
            }
            else
                System.out.println("Illegal Move");
        }
        else{
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
    
    private void stackAddRemove(Cell dest){
        List<Card> movingStack = new ArrayList<>();
        int count = this.getSize() - 1;
        Card current = this.getCard(count);
        Card next = current;
        if(count != 0)
                next = this.getCard(count - 1);
        this.stack.remove(count);
        movingStack.add(current);
        while(current.getRank().isNextLess(next) && current.getSuit().isDiffColor(next) && count!=0){
            count --;
            current = this.getCard(count);
            if(count != 0)
                next = this.getCard(count - 1);
            this.stack.remove(count);
            movingStack.add(current);           
        }
        Collections.reverse(movingStack);
        dest.stack.addAll(movingStack);
    }
}
