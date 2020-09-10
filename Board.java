package GameOfLifeApp;
import java.util.Arrays;
import java.lang.Math.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Board extends Cell{
   public int numRows;
   public int numCols;
   public Cell[][] cellMatrix;
   public GridPane gridPane;



   public Board(){
      super();
      this.numRows = 25;
      this.numCols = 25;
      this.gridPane = new GridPane();
      this.gridPane.setHgap(1);
      this.gridPane.setVgap(1);
      this.gridPane.setStyle("-fx-background-color: grey;");
      Cell[][] cellMatrix = new Cell[numRows][numCols];
      for(int i=0; i<numRows; ++i){
         for(int j=0; j<numCols; ++j){
            Cell	cell	= new Cell();
            cellMatrix[i][j]=cell;
         }
      }
      for(int y=0; y<25; y++)
         for(int x=0; x<25; x++)
            this.gridPane.add(cellMatrix[y][x].rectangle, x, y,1,1);
      this.cellMatrix	= cellMatrix;
   }


   public Cell[][] getCellMatrix(){
      return this.cellMatrix;
   }



   public void printBoard(){
      for(int i = 0; i< numRows; ++i){
      
         for(int	j =0; j< numCols; ++j){
            if(this.cellMatrix[i][j].isAlive()==true)
               System.out.print("*  ");
            else
               System.out.print("-  ");
         }
          
         System.out.println();
      }
   }
   
   
   public int numNeighbors(int i, int j){
      Cell[] neighbors = {cellMatrix[Math.floorMod((i-1),numCols)][Math.floorMod((j-1), numRows)],
         cellMatrix[Math.floorMod((i-1),numCols)][Math.floorMod((j),numRows)],
         cellMatrix[Math.floorMod((i-1),numCols)][Math.floorMod((j+1),numRows)],
         cellMatrix[Math.floorMod((i), numCols)][Math.floorMod((j-1),numRows)],
         cellMatrix[Math.floorMod((i), numCols)][Math.floorMod((j+1),numRows)],
         cellMatrix[Math.floorMod((i+1), numCols)][Math.floorMod((j-1),numRows)],
         cellMatrix[Math.floorMod((i+1), numCols)][Math.floorMod((j),numRows)],
         cellMatrix[Math.floorMod((i-1), numCols)][Math.floorMod((j+1),numRows)]};
      int aliveNeighbors=0;
      for(int k=0; k<8; ++k)
         if(neighbors[k].isAlive() == true){
            aliveNeighbors += 1;
         }
          
      return aliveNeighbors;  
   }
   
   public void nextState(){
      Board newBoard = new Board();
      for(int i = 0; i < numRows; ++i){
         for(int j = 0; j< numCols; ++j){
            if(this.cellMatrix[i][j].isAlive() == true){
               if(numNeighbors(i,j) < 2){
                  newBoard.cellMatrix[i][j].setState(false);
               }
               else if(numNeighbors(i,j) == 2 || numNeighbors(i,j) == 3)
                  newBoard.cellMatrix[i][j].setState(true);
                    
               else if(numNeighbors(i,j) > 3)
                  newBoard.cellMatrix[i][j].setState(false);
            }
               
            else{
               if(numNeighbors(i,j) == 3)
                  newBoard.cellMatrix[i][j].setState(true);
               else
                  newBoard.cellMatrix[i][j].setState(false);
            }
             
                  
         }
      }
      this.cellMatrix = newBoard.cellMatrix;
      
   
   }
   
   public int numCells(){
      int nLiving = 0;
      for(int i = 0; i< numRows; ++i)
         for(int j =0; j< numCols; ++j)
            if(this.cellMatrix[i][j].isAlive()==true)
               nLiving +=1;
      return nLiving;          
   }

   public GridPane getGridPane(){
      return this.gridPane;
   }
   
   public int numLiving(){
      int numLiving =0;
      for(int i=0; i<25; i++)
         for (int j=0; j<25; ++j)
            if(this.getCellMatrix()[i][j].isAlive())
               numLiving++;
      return numLiving;
   }
}
