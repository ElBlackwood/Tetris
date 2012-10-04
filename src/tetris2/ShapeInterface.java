package tetris2;

import java.awt.Color;
import java.util.ArrayList;
/**
 *THIS IS ACTUALLY AN ABSTRACT CLASS, NOT AN INTERFACE
 *nb. interfaces can't have member attributes. 
 **/
public abstract class ShapeInterface {
	
	Color color = Color.black;
	boolean rotated = false;

	ArrayList<Integer> point1 = new ArrayList<Integer>();
	ArrayList<Integer> point2 = new ArrayList<Integer>();
	ArrayList<Integer> point3 = new ArrayList<Integer>();
	ArrayList<Integer> point4 = new ArrayList<Integer>();
	
	public abstract void moveDown();
	public abstract void moveLeft();
	public abstract void moveRight();
	public abstract void rotate();
	
	public void moveAllPointsDown(){
		zeroAllPoints();
		point1.set(0, point1.get(0) + 1);
		point2.set(0, point2.get(0) + 1);
		point3.set(0, point3.get(0) + 1);
		point4.set(0, point4.get(0) + 1);
	}
	
	public void moveAllPointsLeft(){
		zeroAllPoints();
		point1.set(1, point1.get(1) - 1);
		point2.set(1, point2.get(1) - 1);
		point3.set(1, point3.get(1) - 1);
		point4.set(1, point4.get(1) - 1);
	}
	
	public void moveAllPointsRight(){
		zeroAllPoints();
		point1.set(1, point1.get(1) + 1);
		point2.set(1, point2.get(1) + 1);
		point3.set(1, point3.get(1) + 1);
		point4.set(1, point4.get(1) + 1);
	}
	
	public void zeroAllPoints(){
		Tetris.boardArray[point1.get(0)][point1.get(1)] = 0;
		Tetris.boardArray[point2.get(0)][point2.get(1)] = 0;
		Tetris.boardArray[point3.get(0)][point3.get(1)] = 0;
		Tetris.boardArray[point4.get(0)][point4.get(1)] = 0;
	}

}