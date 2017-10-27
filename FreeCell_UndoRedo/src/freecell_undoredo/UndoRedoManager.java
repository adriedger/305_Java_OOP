/*
 * Macewan University CMPT 305 Professor: Brian Brookwell
 */
package freecell_undoredo;

import java.util.ArrayList;
import java.util.List;
import freecell_undoredo.State.SavedState;

/**
 * Command design pattern class manages undo/redo of current game state.  
 * @author Andre Driedger
 */
public class UndoRedoManager { 
    private final List<SavedState> savedStates;
    private int currentIndex;
    private State currentState;
    
    /**
     * Class constructor.
     * @param state Initial game state (after deck is dealt into tableaus)
     */
    public UndoRedoManager(State state){
        this.currentState = state;
        savedStates = new ArrayList<>();
        currentIndex = 0;        
    }
    
    /**
     * @return true if there are saved states
     */
    public boolean canUndo() {
        return currentIndex > 0;
    }
    
    /**
     *
     * @return true if there are saved states ahead of current state
     */
    public boolean canRedo() {
        return currentIndex < savedStates.size() - 1;
    }
    
    /**
     * Revert to previous state if possible. Outputs to console legality of undo.
     */
    public void undo() {
        if (canUndo()) {
            currentState.setState(savedStates.get(--currentIndex));
            System.out.println("Undo");
        }
        else
            System.out.println("Cannot Undo");
    }
    
    /**
     * Go back to next state if possible. Outputs to console legality of redo.
     */
    public void redo() {
        if (canRedo()) {
            currentState.setState(savedStates.get(++currentIndex));
            System.out.println("Redo");
        }
        else
            System.out.println("Cannot Redo");
    }
    
    /**
     * Saves current state. Adds it to available undo list. Clears any redo states available.
     * @param savedState The deep copy of current state
     */
    public void save(SavedState savedState) {
        clearRedoList();
        savedStates.add(savedState);
        currentIndex = savedStates.size() - 1;    
    }  
    
    private void clearRedoList() {
        for (int i = savedStates.size() - 1; i > currentIndex; i--) {
            savedStates.remove(i); 
        }        
    }        
}
