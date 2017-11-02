/*
 * Macewan University CMPT 305 Professor: Brian Brookwell
 */
package lab4Q2;

import java.awt.Rectangle;

/**
 *
 * @author adriedger
 */
public class HandleRect {
    
    private Rectangle rect;
    
    public HandleRect(Rectangle r){
        this.rect = r;
    }

    public int getX() {return rect.x;}

    public int getY() {return rect.y;}

    public void move(int currentX, int currentY) {
        rect.x = currentX;
        rect.y = currentY;
    }

    int getHeight() {return rect.height;}

    int getWidth() {return rect.width;}

    void resize(int currentHeight, int currentWidth) {
        rect.height = currentHeight;
        rect.width = currentWidth;
    }
    
}
