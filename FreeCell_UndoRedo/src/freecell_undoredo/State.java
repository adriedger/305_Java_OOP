/*
 * Macewan University CMPT 305 Professor: Brian Brookwell
 */
package freecell_undoredo;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Andre Driedger
 * Contains the game state -> all the cells and their methods 
 */
public class State {
    
    private List<Cell> Cells = new ArrayList<>();
    private UndoRedoManager undoRedoManager;
    
    /**
     * @param deck shuffled deck of 52 cards
     * All 8 Tableaus get dealt cards from deck
     */
    public State(List<Card> deck){
        Cells.add(new Tableau(deck.subList(0, 7), "T0"));
        Cells.add(new Tableau(deck.subList(7, 14), "T1"));
        Cells.add(new Tableau(deck.subList(14, 21), "T2"));
        Cells.add(new Tableau(deck.subList(21, 28), "T3"));
        Cells.add(new Tableau(deck.subList(28, 34), "T4"));
        Cells.add(new Tableau(deck.subList(34, 40), "T5"));
        Cells.add(new Tableau(deck.subList(40, 46), "T6"));
        Cells.add(new Tableau(deck.subList(46, 52), "T7"));
        Cells.add(new Free("F0"));
        Cells.add(new Free("F1"));
        Cells.add(new Free("F2"));
        Cells.add(new Free("F3"));
        Cells.add(new Home("H0"));
        Cells.add(new Home("H1"));
        Cells.add(new Home("H2"));
        Cells.add(new Home("H3"));
        
        urManager().save(new SavedState(Cells));
    }
    
    /**
     * @param name String to compare with Cell names
     * @return Cell which matches input string
     */
    private Cell getCell(String name){
        Cell cell = Cells.get(0);
        for(Cell c: Cells){
            if(name.equals(c.getName()))
                cell = c;        
        }
        return cell;
    }
        
    /**
     * @param origin Cell name of the move origin
     * @param dest Cell name of the destination of the move attempt
     */
    public void move(String origin, String dest){
        this.getCell(origin).move(this.getCell(dest));        
    }
    
    /**
     * Prints the contents of each Cell
     */
    public void printState(){                
        for(Cell c : Cells)
            System.out.println(c.toString());                       
    }
    
    /**
     * @return true if all FreeCell stacks are complete
     */
    public boolean winCheck(){
        return ((Home)Cells.get(12)).isComplete() && ((Home)Cells.get(13)).isComplete() &&
                ((Home)Cells.get(14)).isComplete() && ((Home)Cells.get(15)).isComplete();
    }
    
    public void setState(SavedState state) {
        this.Cells = state.getSavedState();
    }
    
    private UndoRedoManager urManager() {
        if (undoRedoManager == null) {
            undoRedoManager = new UndoRedoManager(this);
        }
        return undoRedoManager;
    }
    
    public boolean canUndo() {
        return urManager().canUndo();
    }
    
    public boolean canRedo() {
        return urManager().canRedo();
    }
    
    public void undo() {
        urManager().undo();
    }
    
    public void redo() {
        urManager().redo();
    }
    
    public static class SavedState {
        private List<Cell> savedState = new ArrayList<>();
        
        private SavedState(List<Cell> state){
            savedState = copyState(state);            
        }
        
        private List<Cell> getSavedState() {
            return copyState(savedState);            
        }
        
        private List<Cell> copyState(List<Cell> state) {
            List<Cell> clonedState = new ArrayList<>();
            
            for(Cell c : state){
                clonedState.add(c);
            }
            
            return clonedState;
        }        
    }
}
