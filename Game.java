package GameOfLifeApp;

import java.util.Scanner;
import java.util.Random;
import java.lang.String;

public class Game{
   int timeState;
   public Scanner sc = new Scanner(System.in);
   public Board board;

   public Game(Board board){
      this.board = board;
   }
   public Game(){
      this.timeState = 0;
      this.board = new Board();
      int n = 25;
      int m = 25;
      Random rd = new Random();
      for (int i = 0; i < n; ++i)
         for (int j = 0; j < m; ++j)
            this.board.cellMatrix[i][j].setState(rd.nextBoolean());
   }

   public Board getBoard() {
      return this.board;
   }

   public void printGame(){
      this.board.printBoard();
   }

   public void setBoard(Board board) {
      this.board = board;
   }
   
}