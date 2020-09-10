package GameOfLifeApp;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.layout.*;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Button;
import javafx.event.*;
import javafx.scene.paint.Color;
import java.util.Arrays;

public class GridPaneEx extends Application{
   public Game game = new Game();
   public  Board board = game.getBoard();

   
   @ Override
   public void start(Stage stage){
      GridPane root = new GridPane();
      root.setStyle("-fx-background-color: gray;");
      Button button = new Button();
      Button reset = new Button();
      button.setMinWidth(50);
      reset.setText("Reset");
      reset.setMinWidth(50);
      button.setText("Step");
      
      
      Text numLiving = new Text("Living Cells: "+game.board.numLiving());
      button.setOnAction(
         new EventHandler<ActionEvent>() {
            @ Override
            public void handle(ActionEvent event) {
               board.nextState();
               game.setBoard(board);                    
               for (int i = 0; i < 25; i++) {
                  for (int j = 0; j < 25; j++) {
                     if ((board.getCellMatrix())[i][j].isAlive()){
                        root.add(new Rectangle(8, 8, Color.BLACK), i+1, j+1);
                     }
                     else{
                        root.add(new Rectangle(8,8, Color.WHITE),i+1,j+1);
                       
                     }
                  }
               }
               numLiving.setText("Living Cells: "+game.board.numLiving());
                           
            }
         });
      
      reset.setOnAction(
         new EventHandler<ActionEvent>() {
            @ Override
            public void handle(ActionEvent event) {
               Game newGame = new Game();
               game = newGame;
               board = game.getBoard();
               game.setBoard(game.getBoard());
               Board board = game.getBoard();         
               for (int i = 0; i < 25; i++) {
                  for (int j = 0; j < 25; j++) {
                     if ((board.getCellMatrix())[i][j].isAlive()){
                        root.add(new Rectangle(8, 8, Color.BLACK), i+1, j+1);
                     }
                     else{
                        root.add(new Rectangle(8,8, Color.WHITE),i+1,j+1);
                       
                     }
                  }
               }
               numLiving.setText("Living Cells: "+game.board.numLiving());
                           
            }
         });
           
      for(int i=0; i<25; ++i){
         RowConstraints row = new RowConstraints(10);
         ColumnConstraints col = new ColumnConstraints(10);
         root.getRowConstraints().add(row);
         root.getColumnConstraints().add(col);
      
      }
      
      for (int i = 0; i < 25; i++) {
         game = new Game();
         board = game.getBoard();
         for (int j = 0; j < 25; j++) {
            if (board.getCellMatrix()[i][j].isAlive())
               root.add(new Rectangle(8, 8, Color.BLACK), i+1, j+1);
                     
            else
               root.add(new Rectangle(8,8, Color.WHITE),i+1,j+1);
         }
      
      }
      
   
      root.add(numLiving,17,27);
      root.add(button,1,27);     
      root.add(reset,6,27);         
    
      Scene scene = new Scene(root,270,300);
      stage.setScene(scene);
      stage.setTitle("Conway's Game of Life");
      stage.initStyle(StageStyle.UTILITY);
      stage.show();
   
   }
      
}