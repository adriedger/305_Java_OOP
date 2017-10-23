/*
 * Macewan University CMPT 305 Professor: Brian Brookwell
 */
package freecell_undoredo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Cell class is the parent class of the different Cells types in FreeCell.
 * @author Andre Driedger
 */
public class Cell {
    
    private List<Card> stack;
    private String name;
    
    /**
     * Class Constructor.
     * @param start List of cards dealt into cell when game starts
     * @param name 2 char string name of the Cell 
     */
    public Cell(List<Card> start, String name){
        stack = new ArrayList<>();
        for (Card c : start)
            stack.add (c);        
        this.name = name;
    }
    
    public int getSize() {return stack.size();}
    
    /**
     * @param num index of where you want to get Card in 
     * @return Card at index
     */
    public Card getCard(int num) {return stack.get(num);}
    
    public String getName() {return name;}
    
    /**
     * @return true if Cell is empty
     */
    public boolean isEmpty() {return stack.isEmpty();}
    
    /**
     * @return Card at the top of stack (bottom-most facing the player)
     */
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
    
    /**
     * @return true if Cell is a Tableau
     */
    public boolean isTableau(){return this.getName().charAt(0) == 'T';}
    
    /**
     * This method checks if attempted move is a legal move.
     * If its not a legal move, does nothing. If its a legal move, it moves the card(s).
     * If the origin and destination Cells are both Tableaus and legal, 
     * this method moves the substack instead of the single card.
     * @param dest The destination Cell of attempted move
     * @return true if legal move, false if not 
     */
    public boolean move(Cell dest){
        if(this.isTableau() && dest.isTableau()){
            if(this.canMoveFrom() && dest.canMoveTo(this.getSubstackTop())){
                this.stackAddRemove(dest);
                return true;
            }
        }
        else{
            if(this.canMoveFrom() && dest.canMoveTo(this.getTop())){            
                Card c = this.getTop();
                dest.stack.add(c);
                this.stack.remove(c);
                return true;
            }
        }
        return false;
    }
    
    /**
     * This method removes the substack (stack of cards which match the Solitaire 
     * stack pattern of next less rank and alternating colors) and appends it to 
     * destination Cell.
     * @param dest The destination Cell of the stack move
     */
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
    
    /**
     * Deep copies Cell name and all cards within Cell stack into new Cell copy
     * @param copy New Cell to be copied
     */
    public void copyElements(Cell copy){
        List<Card> stackCopy = new ArrayList<>();
        for(Card c : this.stack){
            Card temp = c.deepCopy();
            stackCopy.add(temp);
        }
        copy.stack = stackCopy;
        copy.name = this.name;
    }
    
    public Cell deepCopy(){return this;}
}