/*
 * Macewan University CMPT 305 Professor: Brian Brookwell
 */
package freecell_undoredo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andre Driedger 
 * Tableau class is a subclass of Cell, represents tableau cells in FreeCell
 */
public class Tableau extends Cell {
    
    public Tableau(List<Card> start, String name) {
        super(start, name);
    }
    
    /**
     * @return true if there are cards in the stack
     */
    @Override
    public boolean canMoveFrom(){
        return super.getSize() > 0;        
    }
    /**
     * @param moving Card to check if move to cell is legal
     * @return true if the moving card is the next less in rank and a different color
     * or if the destination cell is empty
     */
    @Override
    public boolean canMoveTo(Card moving){
        return super.isEmpty() || (moving.getRank().isNextLess(super.getTop()) && moving.getSuit().isDiffColor(super.getTop()));
    }

    /**
     * @return Top Card of the substack (stack of cards which match the Solitaire 
     * stack pattern of next less rank and alternating colors)
     */
    @Override
    public Card getSubstackTop() {
        int count = super.getSize() - 1;
        Card current = super.getCard(count);
        if(count == 0)
            return current;
        Card next = super.getCard(count - 1);
        while(current.getRank().isNextLess(next) && current.getSuit().isDiffColor(next) && count != 0){
            count --;
            current = super.getCard(count);
            if(count == 0)
                return current;
            next = super.getCard(count - 1);                  
        }
        return current;       
    }
    
    @Override
    public Tableau deepCopy(){
        Tableau copy = new Tableau(new ArrayList<>(), "");
        super.copyElements(copy);
        return copy;
    }    
}