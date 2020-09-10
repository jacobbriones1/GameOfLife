package GameOfLifeApp;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Cell{
   private boolean alive;
   public int size = 12;
   public Rectangle rectangle;
   public Color state;


   public Cell(){
      this.alive = false;
      this.rectangle = new Rectangle(20,20);
      this.state = Color.BLACK;
      this.rectangle.setFill(state);
   }
   
   public boolean isAlive(){
      return this.alive;
   }
   
   public void setState(boolean TF){
      this.alive = TF;
      if(TF == true)
         this.state = Color.WHITE;
      else
         this.state = Color.BLACK;
      this.rectangle.setFill(state);
   }

   public Rectangle getRectangle(){
      return this.rectangle;
   }


   
}