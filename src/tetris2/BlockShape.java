package tetris2;

import java.awt.Color;

public class BlockShape extends ShapeInterface{

	
	public BlockShape() {
											   ///////////
											   // 1 | 2 //
			point1.add(0, 0);				   //---|---//
			point1.add(1, 5);				   // 3 | 4 //
			point2.add(0, 0); 				   ///////////
			point2.add(1, 6);
			point3.add(0, 1);
			point3.add(1, 5);
			point4.add(0, 1);
			point4.add(1, 6);
			color = Color.red;
	}
	
	public void moveDown(){
		// check there is space on the board to move to(ie not off the end
		// of the board and next space is not a shape already)
		if (point3.get(0) < 19
				&& Tetris.boardArray[point3.get(0) + 1][point3.get(1)] != 1
				&& Tetris.boardArray[point4.get(0) + 1][point4.get(1)] != 1) {
			// 0's the points behind the object
			moveAllPointsDown();
		} else {
			Tetris.spawning = true;
		}
	}
	public void moveRight(){
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
					zeroAllPoints();
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
	public void moveLeft(){
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

	@Override
	public void rotate() {
		// TODO Auto-generated method stub
		
	}

}
