package tetris2;

import java.awt.Color;

public class LShape extends ShapeInterface{

	
	public LShape(){	

			point1.add(0, -2);						///////
			point1.add(1, 4); 						// 1 //
			point2.add(0, -1);						// - //
			point2.add(1, 4);						// 2 //
			point3.add(0, 0); 						// - //
			point3.add(1, 4); 						// 3 //
			point4.add(0, 0);					    // - //
			point4.add(1, 5); 						// 4 //
			color = Color.YELLOW; 					///////

	}
	
	//Line clearing not working correctly for L shape

	public void moveDown() {

		if (rotated) {
			//NEEDS CHANGED FOR DIFFERENT ROTATIONS OF L
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

			} else {
				Tetris.spawning = true;
			}

		} else if (point3.get(0) < 19 && point4.get(0) <19
				&& Tetris.boardArray[point3.get(0) + 1][point4.get(1)] != 1
				&& Tetris.boardArray[point4.get(0) + 1][point4.get(1)] != 1) {
			// 0 points behind shape
			try {
				Tetris.boardArray[point1.get(0)][point1.get(1)] = 0;
				Tetris.boardArray[point4.get(0)][point4.get(1)] = 0;

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

	public void moveLeft() {
		if (rotated) {
			try {
				if (point1.get(0) >= 0
						&& Tetris.boardArray[point4.get(0)][point4.get(1) - 1] != 1) {
					Tetris.boardArray[point1.get(0)][point1.get(1)] = 0;
					point1.set(1, point1.get(1) - 1);
					point2.set(1, point2.get(1) - 1);
					point3.set(1, point3.get(1) - 1);
					point4.set(1, point4.get(1) - 1);
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				//do nothing
			}
		} else {
			try {
				if (point1.get(0) >= 0
						&& Tetris.boardArray[point1.get(0)][point1.get(1) - 1] != 1
						&& Tetris.boardArray[point2.get(0)][point2.get(1) - 1] != 1
						&& Tetris.boardArray[point3.get(0)][point3.get(1) - 1] != 1
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
					//no need
			}
		}

		Gui.scoreInfo.setBackground(Color.WHITE);
	}

	public void moveRight() {
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

	public void rotate() {
		}

	
	private void rotateLLeft() {
	}

	private void rotateLRight() {
}
}