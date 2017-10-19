/*
 * Macewan University CMPT 305 Professor: Brian Brookwell
 */
package freecell_undoredo;

import java.util.ArrayList;
import java.util.List;
import freecell_undoredo.State.SavedState;

/**
 *
 * @author adriedger
 */
public class UndoRedoManager { 
    private final List<SavedState> savedStates;
    private int currentIndex;
    private State currentState;
    
    public UndoRedoManager(State state){
        this.currentState = state;
        savedStates = new ArrayList<>();
        currentIndex = 0;        
    }
    
    public boolean canUndo() {
        return currentIndex > 0;
    }
    
    public boolean canRedo() {
        return currentIndex < savedStates.size() - 1;
    }
    
    public void undo() {
        if (canUndo()) {
            currentState.setState(savedStates.get(--currentIndex));
            System.out.println("Undo " + currentIndex);
        }
        else
            System.out.println("Cannot Undo");
    }
    
    public void redo() {
        if (canRedo()) {
            currentState.setState(savedStates.get(++currentIndex));
            System.out.println("Redo " + currentIndex);
        }
        else
            System.out.println("Cannot Redo");
    }
    
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
