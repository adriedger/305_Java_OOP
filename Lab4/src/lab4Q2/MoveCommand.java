/*
 * Macewan University CMPT 305 Professor: Brian Brookwell
 */
package lab4Q2;

/**
 *
 * @author adriedger
 */
public class MoveCommand implements Command{
 
    private HandleRect rect;
    private int previousX;
    private int previousY;
    private int currentX;
    private int currentY;
    
    public MoveCommand(HandleRect r, int x, int y){
        this.rect = r;
        this.currentX = x;
        this.currentY = y;        
    }
    
    @Override
    public void execute(){
        previousX = rect.getX();
        previousY = rect.getY();
        rect.move(currentX, currentY);
    }
    
    @Override
    public void undo(){
        rect.move(previousX, previousY);
    }    
}
