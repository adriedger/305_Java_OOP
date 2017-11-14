/*
 * Macewan University CMPT 305 Professor: Brian Brookwell
 */
package lab4Q2;

import java.util.ArrayList;
import java.util.List;

/**
 * Undo Manager of command design pattern
 *
 * @author adriedger
 */
public class UndoManager {
    private final List<Command> commands;
    

    public UndoManager(){
        this.commands = new ArrayList<>();
//        currentIndex = 0;        
    }
    

    public void add(Command c){
        commands.add(c);
    }
    

    public void undo(){
        if(commands.size() > 0){
            commands.get(commands.size()-1).undo();
            commands.remove(commands.size()-1);
        }
    }
         
}
