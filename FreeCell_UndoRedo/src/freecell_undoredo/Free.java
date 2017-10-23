/*
 * Macewan University CMPT 305 Professor: Brian Brookwell
 */
package freecell_undoredo;

import java.util.ArrayList;

/**
 * Free class is a subclass of Cell, represents free cells in FreeCell
 * @author Andre Driedger 
 */
public class Free extends Cell {
    
    public Free(String name){
       super(new ArrayList<>(), name);
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
     * @return true if stack is empty
     */
    @Override
    public boolean canMoveTo(Card moving){
        return super.isEmpty();
    }
    
    /**
     * @return new deep copy of Free cell
     */
    @Override
    public Free deepCopy(){
        Free copy = new Free("");
        super.copyElements(copy);
        return copy;
    } 
}
