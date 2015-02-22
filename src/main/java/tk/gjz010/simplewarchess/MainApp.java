package tk.gjz010.simplewarchess;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import tk.gjz010.simplewarchess.gameplay.units.Fighter;
import tk.gjz010.simplewarchess.gameplay.units.Unit;
import static tk.gjz010.simplewarchess.helper.Const.*;
import tk.gjz010.simplewarchess.helper.Tileset;
import tk.gjz010.simplewarchess.ui.UnitView;


public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Group root=new Group();
        GameCanvas g=new GameCanvas(WIDTH,HEIGHT);
        root.getChildren().add(g);
        Unit u=new Fighter(null,10,10);
        u.setDirection(2);
        UnitView uv=new UnitView(u);
        root.getChildren().add(uv);
        
        uv.setOnMouseClicked(new EventHandler(){

            @Override
            public void handle(Event event) {
               ((UnitView)(event.getSource())).flipChosen();
            }
        
        });
        Scene scene = new Scene(root,WIDTH,HEIGHT);
        //scene.getStylesheets().add("/styles/Styles.css");
        stage.setTitle("SimpleWarchess");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
private class GameCanvas extends Canvas {  
    private GraphicsContext gc;  
    private Tileset tile;
    public GameCanvas(double width, double height){  
        super(width, height);  
        tile=new Tileset(new Image("/images/tileset.png"));
        gc = getGraphicsContext2D();  
        draw(gc);  
    }  
      
    public void draw(GraphicsContext gc){  
        drawTestTiles(gc);
        drawGrid(gc);

        
        //u.draw(gc);
    }  
    private void drawGrid(GraphicsContext gc){
        double h=this.getHeight();
        double w=this.getWidth();
        gc.setStroke(Color.GREY);
        gc.setLineWidth(1);
        for(int i=1;i*UNIT_LENGTH<=w;i++){
        gc.strokeLine(i*UNIT_LENGTH,0,i*UNIT_LENGTH,h);
        
        }
        for(int i=1;i*UNIT_LENGTH<=h;i++){
        gc.strokeLine(0,i*UNIT_LENGTH,w,i*UNIT_LENGTH);
        }
    }
    private void drawTestTiles(GraphicsContext gc){
                Image clip=tile.getClip(0, 0);

         double h=this.getHeight();
        double w=this.getWidth();
        for(int i=0;i*UNIT_LENGTH<=w;i++){
            for(int j=0;j*UNIT_LENGTH<=h;j++){
                gc.drawImage(clip, i*UNIT_LENGTH, j*UNIT_LENGTH);
            }
        }
    }
    }
}
