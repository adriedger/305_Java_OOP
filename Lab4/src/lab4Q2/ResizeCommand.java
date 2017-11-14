/*
 * Macewan University CMPT 305 Professor: Brian Brookwell
 */
package lab4Q2;

/**
 * Command design pattern implementation handles resizing of HandleRect objects
 *
 * @author adriedger
 */
public class ResizeCommand implements Command{
    
    private HandleRect rect;
    private int previousHeight;
    private int previousWidth;
    private int currentHeight;
    private int currentWidth;
    
    public ResizeCommand(HandleRect r, int w, int h){
        this.rect = r;
        this.currentHeight = h;
        this.currentWidth = w;        
    }
    
    @Override
    public void execute(){
        previousHeight = rect.getHeight();
        previousWidth = rect.getWidth();
        rect.resize(currentHeight, currentWidth);
    }
    
    @Override
    public void undo(){
        rect.resize(previousHeight, previousWidth);
    }  
    
}
