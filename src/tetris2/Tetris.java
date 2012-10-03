package tetris2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

public class Tetris implements ActionListener{

	public static int[][] boardArray = new int[20][10];
	public static final String[] shapes = new String[] {"STICK","BLOCK","TRIDENT"};
	public static ShapeInterface currentShape;
	public static boolean spawning = true;
	public Gui g;
	public static int score = 0;
	//typing shit to try to commit
	
	public static void main(String[] args) {							//TO DO:
		Tetris main = new Tetris();										//-Implement moves for STICK.
		main.g = new Gui();												//-Randomize what shape is chosen next.
																		//-Implement more shapes.
	    EventQueue.invokeLater(new Runnable() {							//-rotation.
	        @Override													//-death.
	        public void run() {          	
	          Tetris object = new Tetris(); 
	          object.launch();
	        }
	      });
	}

	
	public int[][] arrayInit(int[][] listo) {
		for (int row = 0; row < 20; row++) {
			for (int col = 0; col < 10; col++) {
				listo[row][col] = 0;
			}
		}
		return listo;
	}

	public void displayBoard() {

		for (int i = 0; i < 20; i++) {
			System.out.println();
			for (int j = 0; j < 10; j++) {
				System.out.printf(" %s", boardArray[i][j]);
			}

		}
		System.out.println();
		System.out.println("--------------------");
	}
	
	public void launch(){
		//initialise the board array
		arrayInit(boardArray);
		//calls actionPerformed() every second
		Timer timer = new Timer(100, this);
		timer.start();
		
	}
	
	public void spawnShape(){
		//choose a random shape from shapes list
		Random r = new Random();
		int randomInt = r.nextInt(2);
		//call shape class and return the shape.
		
		//check for complete rows:		shapes[randomInt]
		checkCompleteRows();
		
		switch (randomInt){
			case 0: currentShape = new BlockShape();
					break;
			case 1: currentShape = new StickShape();
					break;
		}

	}
	//put 1's in the array where the shape is now
	public void reComputeBoard(){

		updateBoard(currentShape.point1.get(0), currentShape.point1.get(1));
		updateBoard(currentShape.point2.get(0), currentShape.point2.get(1));
		updateBoard(currentShape.point3.get(0), currentShape.point3.get(1));
		updateBoard(currentShape.point4.get(0), currentShape.point4.get(1));
	}
	
	public void updateBoard(int column, int row){
		try{
		boardArray[column][row] = 1;
		}catch(ArrayIndexOutOfBoundsException e){
			
		}
		
	}
	private void checkCompleteRows(){
		for (int row=0; row<20;row++){
			boolean runOfOnes = true;
			for (int col=0; col<10;col++){
				if (boardArray[row][col]==1 && runOfOnes){
					if (col == 9){
						score+=10;									//this is where the score is incremented, 10 points per row cleared
						Gui.scoreInfo.setBackground(Color.YELLOW);
						Gui.scoreInfo.setText("Score: "+score);
						//if row is complete, loop through boardArray from that row making points equal to the one above them.
						for (int rowNew=row; rowNew>0;rowNew--){
							for (int colNew =0; colNew<10; colNew++){
								
								boardArray[rowNew][colNew] = boardArray[rowNew-1][colNew];
							}
						}
						
					}
				}else{
					runOfOnes = false;
				}
			}
		}
	}
	//verbose output of positions in shape
	private void printPoints(){
		System.out.printf("Point 1 (%s,%s)",currentShape.point1.get(0), currentShape.point1.get(1));
		System.out.printf("Point 2 (%s,%s)",currentShape.point2.get(0), currentShape.point2.get(1));
		System.out.printf("Point 3 (%s,%s)",currentShape.point3.get(0), currentShape.point3.get(1));
		System.out.printf("Point 4 (%s,%s)",currentShape.point4.get(0), currentShape.point4.get(1));
	}
	
	//paint the shapes on the GUI.
	private void updateGui(){
		//for points in shape paint them their color.
			try {
				Gui.labelArray[currentShape.point1.get(0)][currentShape.point1.get(1)].setBackground(currentShape.color);
				Gui.labelArray[currentShape.point2.get(0)][currentShape.point2.get(1)].setBackground(currentShape.color);
				Gui.labelArray[currentShape.point3.get(0)][currentShape.point3.get(1)].setBackground(currentShape.color);
				Gui.labelArray[currentShape.point4.get(0)][currentShape.point4.get(1)].setBackground(currentShape.color);
			} catch (ArrayIndexOutOfBoundsException e) {
				//do nothing.
			}
		//paint the non shape areas black. without this loop shapes leave a trail of color where they have been.
		for (int row=0; row<20; row++){
			for (int col=0; col<10; col++){
				if (boardArray[row][col] == 0){
					Gui.labelArray[row][col].setBackground(Color.BLACK);
				}
				else{
					
				}
			}//end for j
		}//end for i
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (spawning==true){
			spawnShape();
			try {
				Thread.sleep(300);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			spawning = false;
		} else{
			currentShape.moveDown();
		}
		
		
		reComputeBoard();
		updateGui();
		//displayBoard();
		
	}

}
