/*
 * Macewan University CMPT 305 Professor: Brian Brookwell
 */
package freecell_undoredo;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains the current game state. All the cells and their methods.
 * @author Andre Driedger
 */
public class State {
    
    private List<Cell> cells = new ArrayList<>();
    private UndoRedoManager undoRedoManager;
    
    /**
     * Class Constructor. Tableau cells get dealt cards from deck.
     * @param deck shuffled deck of 52 cards
     */
    public State(List<Card> deck){
        cells.add(new Tableau(deck.subList(0, 7), "T0"));
        cells.add(new Tableau(deck.subList(7, 14), "T1"));
        cells.add(new Tableau(deck.subList(14, 21), "T2"));
        cells.add(new Tableau(deck.subList(21, 28), "T3"));
        cells.add(new Tableau(deck.subList(28, 34), "T4"));
        cells.add(new Tableau(deck.subList(34, 40), "T5"));
        cells.add(new Tableau(deck.subList(40, 46), "T6"));
        cells.add(new Tableau(deck.subList(46, 52), "T7"));
        cells.add(new Free("F0"));
        cells.add(new Free("F1"));
        cells.add(new Free("F2"));
        cells.add(new Free("F3"));
        cells.add(new Home("H0"));
        cells.add(new Home("H1"));
        cells.add(new Home("H2"));
        cells.add(new Home("H3"));
        
        urManager().save(new SavedState(cells));
    }
    
    /**
     * @param name String to compare with Cell names
     * @return Cell which matches input string or a new generic Cell (leads to Illegal Move)
     */
    private Cell getCell(String name){
        for(Cell c: cells){
            if(name.equals(c.getName()))
                return c;        
        }
        return new Cell(new ArrayList<>(), "null");
    }
        
    /**
     * Attempts to move card/substack. Outputs to console the legality of move
     * @param origin Cell name of the move origin
     * @param dest Cell name of the destination of the move attempt
     */
    public void move(String origin, String dest){
        if(this.getCell(origin).move(this.getCell(dest))){
            System.out.println("Successful Move!");
            urManager().save(new SavedState(cells));
        }
        else
            System.out.println("Illegal Move");
    }
    
    /**
     * Outputs to console contents of each Cell.
     */
    public void printState(){                
        for(Cell c : cells)
            System.out.println(c.toString());                       
    }
    
    /**
     * @return true if all FreeCell stacks are complete
     */
    public boolean winCheck(){
        return ((Home)cells.get(12)).isComplete() && ((Home)cells.get(13)).isComplete() &&
                ((Home)cells.get(14)).isComplete() && ((Home)cells.get(15)).isComplete();
    }
    
    public void setState(SavedState state) {
        this.cells = state.getSavedState();
    }
    
    private UndoRedoManager urManager() {
        if (undoRedoManager == null) {
            System.out.println("Undo/Redo Manager Initialized");
            undoRedoManager = new UndoRedoManager(this);
        }
        return undoRedoManager;
    }
    
    public void undo() {
        urManager().undo();
    }
    
    public void redo() {
        urManager().redo();
    }
    
    public static class SavedState {
        private List<Cell> savedState = new ArrayList<>();
        
        private SavedState(List<Cell> cells){
            for(Cell c : cells){
                Cell copy = c.deepCopy();
                savedState.add(copy);
            }            
        }
        
        private List<Cell> getSavedState() {return savedState;}
    }
}
