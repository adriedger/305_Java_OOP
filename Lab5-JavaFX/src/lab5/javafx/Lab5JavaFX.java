/*
 * Macewan University CMPT 305 Professor: Brian Brookwell
 */
package lab5.javafx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * Lab 5-JavaFX. This class launches a scene with 5 circle objects drawn.
 * When the user clicks on a circle, the selected circle will highlighted. It 
 * remains highlighted until it is clicked a second time.  It is possible 
 * to have several objects highlighted at the same time. When the user drags a 
 * circle, the circle follows the mouse movement. Cannot drag a circle outside
 * the window.
 *
 * @author Andre Driedger
 */
public class Lab5JavaFX extends Application {

    double currentX, currentY;
    Paint highlight;
    
    private Circle createCircle(double x, double y, double r, Color color) {
              
        Circle circle = new Circle(x, y, r, color);
        circle.setStroke(Color.BLACK);
        
        circle.setOnMousePressed((event) -> {
            currentX = event.getSceneX();
            currentY = event.getSceneY();
            Circle c = (Circle)(event.getSource());
            highlight = c.getStroke();
            
            if(highlight == Color.BLACK)
                c.setStroke(Color.RED);
            else
                c.setStroke(Color.BLACK);
            c.toFront();
        });
        
        circle.setOnMouseDragged((event) -> {
            double offsetX = event.getSceneX() - currentX;
            double offsetY = event.getSceneY() - currentY;

            Circle c = (Circle)(event.getSource());
            c.setStroke(Color.RED);
            
            c.setCenterX(c.getCenterX() + offsetX);
            c.setCenterY(c.getCenterY() + offsetY);
            
            if(event.getSceneX() > 500)
                c.setCenterX(500);
            if(event.getSceneX() < 0)
                c.setCenterX(0);
            if(event.getSceneY() > 260)
                c.setCenterY(260);
            if(event.getSceneY() < 0)
                c.setCenterY(0);

            currentX = event.getSceneX();
            currentY = event.getSceneY();
        });
        return circle;
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 500, 260);

        Circle circle1 = createCircle(100, 50, 30, Color.SILVER);
        Circle circle2 = createCircle(50, 150, 30, Color.SILVER);
        Circle circle3 = createCircle(150, 100, 30, Color.SILVER);
        Circle circle4 = createCircle(250, 100, 30, Color.SILVER);
        Circle circle5 = createCircle(300, 150, 30, Color.SILVER);
        
        root.getChildren().add(circle1);
        root.getChildren().add(circle2);
        root.getChildren().add(circle3);
        root.getChildren().add(circle4);
        root.getChildren().add(circle5);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * Main function of Lab5. Launches JavaFX scene
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}

