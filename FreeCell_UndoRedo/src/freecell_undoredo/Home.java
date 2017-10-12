/*
 * Macewan University CMPT 305 Professor: Brian Brookwell
 */
package freecell_undoredo;

import java.util.ArrayList;

/**
 *
 * @author Andre Driedger 
 * Home class is a subclass of Cell, represents home cells in FreeCell
 */
public class Home extends Cell {
    
    public Home(String name){
       super(new ArrayList<>(), name);
    }
    
    /**
     * @return true if there are 13 Cards in stack
     */
    public boolean isComplete(){
        return super.getSize() == 13;
    }
    
    /**
     * @param moving Card to check if move to cell is legal
     * @return true if stack is empty and the moving Card is an ace, or the destination
     * card is the next less and the same Suit as the moving Card
     */
    @Override
    public boolean canMoveTo(Card moving){
        if(super.isEmpty()){
            return moving.getRank().getValue() == 1;
        }
        return super.getTop().getRank().isNextLess(moving) && super.getTop().getSuit().isSameSuit(moving);
    }
}
