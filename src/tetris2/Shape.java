package tetris2;

import java.awt.Color;

import java.util.ArrayList;

public class Shape{

	// type of the shape.
	Color color;
	boolean rotated;
	String type;
	// arrays of length 2, for X and Y.
	ArrayList<Integer> point1 = new ArrayList<Integer>();
	ArrayList<Integer> point2 = new ArrayList<Integer>();
	ArrayList<Integer> point3 = new ArrayList<Integer>();
	ArrayList<Integer> point4 = new ArrayList<Integer>();

	// first element in point is DOWN direction
	// second element in the point is ALONG direction

	// constructor
	public Shape(String type) {				  
		this.type = type;
	}

	public synchronized void moveDown() {
		if (type.equals("BLOCK")) {
			// check there is space on the board to move to(ie not off the end
			// of the board and next space is not a shape already)
			if (point3.get(0) < 19
					&& Tetris.boardArray[point3.get(0) + 1][point3.get(1)] != 1
					&& Tetris.boardArray[point4.get(0) + 1][point4.get(1)] != 1) {
				// 0's the points behind the object
				Tetris.boardArray[point1.get(0)][point1.get(1)] = 0;
				Tetris.boardArray[point2.get(0)][point2.get(1)] = 0;
				point1.set(0, point1.get(0) + 1);
				point2.set(0, point2.get(0) + 1);
				point3.set(0, point3.get(0) + 1);
				point4.set(0, point4.get(0) + 1);
			} else {
				Tetris.spawning = true;
			}
		}// end BLOCK
		else if (type.equals("STICK")) {
			if (rotated) {
				if (point4.get(0) < 19
						&& Tetris.boardArray[point1.get(0) + 1][point1.get(1)] != 1
						&& Tetris.boardArray[point2.get(0) + 1][point2.get(1)] != 1
						&& Tetris.boardArray[point3.get(0) + 1][point3.get(1)] != 1
						&& Tetris.boardArray[point4.get(0) + 1][point4.get(1)] != 1) {
					Tetris.boardArray[point1.get(0)][point1.get(1)] = 0;
					Tetris.boardArray[point2.get(0)][point2.get(1)] = 0;
					Tetris.boardArray[point3.get(0)][point3.get(1)] = 0;
					Tetris.boardArray[point4.get(0)][point4.get(1)] = 0;
					point1.set(0, point1.get(0) + 1);
					point2.set(0, point2.get(0) + 1);
					point3.set(0, point3.get(0) + 1);
					point4.set(0, point4.get(0) + 1);

				}else{
					Tetris.spawning = true;
					
				}
				
			}
			else if (point4.get(0) < 19
					&& Tetris.boardArray[point4.get(0) + 1][point4.get(1)] != 1) {
				// 0 points behind shape
				try {
					Tetris.boardArray[point1.get(0)][point1.get(1)] = 0;

				} catch (ArrayIndexOutOfBoundsException e) {
					// will be out of bounds for first 2 downward moves, don't
					// care.
				}
				point1.set(0, point1.get(0) + 1);
				point2.set(0, point2.get(0) + 1);
				point3.set(0, point3.get(0) + 1);
				point4.set(0, point4.get(0) + 1);
			} else {
				Tetris.spawning = true;

			}

		}

	}

	/**
	 * moveLeft() and moveRight() both check below them because without out it
	 * was bugging. The current implementaion means there is no scope to "slide"
	 * blocks once they touch something on the bottom side. The Bug was: when a
	 * block landed and it was slid left or right, half of it would disappear!
	 */
	public synchronized void moveLeft() {
		if (type.equals("BLOCK")) {
			try {
				// check for blocks and left wall
				if (point1.get(0) >= 0
						&& Tetris.boardArray[point3.get(0)][point3.get(1) - 1] != 1
						&& Tetris.boardArray[point1.get(0)][point1.get(1) - 1] != 1
						&& Tetris.boardArray[point3.get(0) + 1][point3.get(1)] != 1
						&& Tetris.boardArray[point4.get(0) + 1][point4.get(1)] != 1) {
					// 0's the points behind the object
					Tetris.boardArray[point2.get(0)][point2.get(1)] = 0;
					Tetris.boardArray[point4.get(0)][point4.get(1)] = 0;
					point1.set(1, point1.get(1) - 1);
					point2.set(1, point2.get(1) - 1);
					point3.set(1, point3.get(1) - 1);
					point4.set(1, point4.get(1) - 1);
				} else {
					// do nothing since we can't move.
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				// no need to handle exception, it does nothing
			}
		}
		if (type.equals(("STICK"))) {
			if (rotated){
				try {
					if (point1.get(0)>=0 && Tetris.boardArray[point4.get(0)][point4.get(1)-1]!=1){
						Tetris.boardArray[point1.get(0)][point1.get(1)] = 0;
						point1.set(1, point1.get(1) - 1);
						point2.set(1, point2.get(1) - 1);
						point3.set(1, point3.get(1) - 1);
						point4.set(1, point4.get(1) - 1);
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					//do nothing
				}
			}
			else{
			try {
				if (point1.get(0) >= 0
						&& Tetris.boardArray[point1.get(0)][point1.get(1) - 1] != 1
						&& Tetris.boardArray[point2.get(0)][point2.get(1) - 1] != 1
						&& Tetris.boardArray[point3.get(0)][point3.get(1) - 1] != 1
						&& Tetris.boardArray[point4.get(0)][point4.get(1) - 1] != 1
						&& Tetris.boardArray[point4.get(0) + 1][point4.get(1)] != 1) {
					Tetris.boardArray[point1.get(0)][point1.get(1)] = 0;
					Tetris.boardArray[point2.get(0)][point2.get(1)] = 0;
					Tetris.boardArray[point3.get(0)][point3.get(1)] = 0;
					Tetris.boardArray[point4.get(0)][point4.get(1)] = 0;
					point1.set(1, point1.get(1) - 1);
					point2.set(1, point2.get(1) - 1);
					point3.set(1, point3.get(1) - 1);
					point4.set(1, point4.get(1) - 1);

				}

			} catch (ArrayIndexOutOfBoundsException e) {

			}
		}
		}
		Gui.scoreInfo.setBackground(Color.WHITE);
	}

	public synchronized void moveRight() {
		if (type.equals("BLOCK")) {
			try {
				if (point2.get(1) < 10) {// changed the get(0) to a get(1) and
											// it
											// stopped crashing, discuss....
					if (Tetris.boardArray[point4.get(0)][point4.get(1) + 1] != 1
							&& Tetris.boardArray[point2.get(0)][point2.get(1) + 1] != 1
							&& Tetris.boardArray[point3.get(0) + 1][point3
									.get(1)] != 1
							&& Tetris.boardArray[point4.get(0) + 1][point4
									.get(1)] != 1) {
						// 0's the points behind the object
						Tetris.boardArray[point1.get(0)][point1.get(1)] = 0;
						Tetris.boardArray[point3.get(0)][point3.get(1)] = 0;
						point1.set(1, point1.get(1) + 1);
						point2.set(1, point2.get(1) + 1);
						point3.set(1, point3.get(1) + 1);
						point4.set(1, point4.get(1) + 1);
					} else {

					}
				} else {

					// do nothing since we can't move.
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				// no need to handle exception, it does nothing
			}
		}
		if (type.equals("STICK")) {
			if (rotated){
				try {
					if (point1.get(0)>=0 && Tetris.boardArray[point1.get(0)][point1.get(1)+1]!=1){
						Tetris.boardArray[point4.get(0)][point4.get(1)] = 0;
						point1.set(1, point1.get(1) + 1);
						point2.set(1, point2.get(1) + 1);
						point3.set(1, point3.get(1) + 1);
						point4.set(1, point4.get(1) + 1);
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					//do nothing
				}
			}
			else{
			try {
				if (point1.get(1) < 10
						&& Tetris.boardArray[point1.get(0)][point1.get(1) + 1] != 1
						&& Tetris.boardArray[point2.get(0)][point2.get(1) + 1] != 1
						&& Tetris.boardArray[point3.get(0)][point3.get(1) + 1] != 1
						&& Tetris.boardArray[point4.get(0)][point4.get(1) + 1] != 1
						&& Tetris.boardArray[point4.get(0) + 1][point4.get(1)] != 1) {
					Tetris.boardArray[point1.get(0)][point1.get(1)] = 0;
					Tetris.boardArray[point2.get(0)][point2.get(1)] = 0;
					Tetris.boardArray[point3.get(0)][point3.get(1)] = 0;
					Tetris.boardArray[point4.get(0)][point4.get(1)] = 0;
					point1.set(1, point1.get(1) + 1);
					point2.set(1, point2.get(1) + 1);
					point3.set(1, point3.get(1) + 1);
					point4.set(1, point4.get(1) + 1);
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				//no need to catch
			}
		}
		}
		Gui.scoreInfo.setBackground(Color.WHITE);
	}
	
	public synchronized void rotate(){
		if (type.equals("STICK")){
			
			try {
				if (rotated){
					rotateStickRight();
				}
				else{
					rotateStickLeft();
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				//don't rotate
			}
		}
	}

	private void rotateStickLeft() {
		if (point4.get(1) - 2 > 0
				&& Tetris.boardArray[point1.get(0) + 1][point1.get(1) + 1] != 1
				&& Tetris.boardArray[point3.get(0) - 1][point3.get(1) - 1] != 1
				&& Tetris.boardArray[point4.get(0) - 2][point4.get(1) - 2] != 1) {//check that there is space to rotate left
			Tetris.boardArray[point1.get(0)][point1.get(1)] = 0;
			Tetris.boardArray[point2.get(0)][point2.get(1)] = 0;
			Tetris.boardArray[point3.get(0)][point3.get(1)] = 0;
			Tetris.boardArray[point4.get(0)][point4.get(1)] = 0;

			Tetris.boardArray[point1.get(0) + 1][point1.get(1) + 1] = 1;
			Tetris.boardArray[point2.get(0)][point2.get(1)] = 1;
			Tetris.boardArray[point3.get(0) - 1][point3.get(1) - 1] = 1;
			Tetris.boardArray[point4.get(0) - 2][point4.get(1) - 2] = 1;

			point1.set(0, point1.get(0) + 1);
			point1.set(1, point1.get(1) + 1);
			point3.set(0, point3.get(0) - 1);
			point3.set(1, point3.get(1) - 1);
			point4.set(0, point4.get(0) - 2);
			point4.set(1, point4.get(1) - 2);
			Tetris.currentShape.rotated = !Tetris.currentShape.rotated;//invert rotated value;

		}
	}

	private void rotateStickRight() {
		int distanceChecker = 9;   //distance checker checks the column point 1 is in.
		if (rotated){			   //if p1 is in 10 and shape is flat, it can still rotate to horizontal again
			distanceChecker = 10;
		}
		if (point1.get(1) < distanceChecker
				&& Tetris.boardArray[point3.get(0) + 1][point3.get(1) + 1] != 1
				&& Tetris.boardArray[point4.get(0) + 2][point4.get(1) + 2] != 1
				&& Tetris.boardArray[point1.get(0) - 1][point1.get(1) - 1] != 1) {
			Tetris.boardArray[point1.get(0)][point1.get(1)] = 0;
			Tetris.boardArray[point2.get(0)][point2.get(1)] = 0;
			Tetris.boardArray[point3.get(0)][point3.get(1)] = 0;
			Tetris.boardArray[point4.get(0)][point4.get(1)] = 0;

			Tetris.boardArray[point1.get(0) - 1][point1.get(1) - 1] = 1;
			Tetris.boardArray[point2.get(0)][point2.get(1)] = 1;
			Tetris.boardArray[point3.get(0) + 1][point3.get(1) + 1] = 1;
			Tetris.boardArray[point4.get(0) + 2][point4.get(1) + 2] = 1;

			point1.set(0, point1.get(0) - 1);
			point1.set(1, point1.get(1) - 1);
			point3.set(0, point3.get(0) + 1);
			point3.set(1, point3.get(1) + 1);
			point4.set(0, point4.get(0) + 2);
			point4.set(1, point4.get(1) + 2);
			Tetris.currentShape.rotated = !Tetris.currentShape.rotated;//invert rotated value;
		}
	}
}
