package tetris2;

import java.awt.Color;

public class ZShape extends ShapeInterface{

	public ZShape() {
		point1.add(0,0);
		point1.add(1,4);			// 1  |  2 //
		point2.add(0,0);				//|  3  | 4 //
		point2.add(1, 5);
		point3.add(0, 1);
		point3.add(1, 5);
		point4.add(0, 1);
		point4.add(1, 6);
		color = Color.ORANGE;
	}

	@Override
	public void moveDown() {
		if (rotated) {
			if (point4.get(0) < 19
					&& Tetris.boardArray[point2.get(0) + 1][point2.get(1)] != 1
					&& Tetris.boardArray[point4.get(0) + 1][point4.get(1)] != 1) {
				moveAllPointsDown();

			}else{
				Tetris.spawning = true;
			}

		} else {
			if (point3.get(0) < 19
					&& Tetris.boardArray[point1.get(0) + 1][point1.get(1)] != 1
					&& Tetris.boardArray[point3.get(0) + 1][point3.get(1)] != 1
					&& Tetris.boardArray[point4.get(0) + 1][point4.get(1)] != 1) {
				moveAllPointsDown();
			}else{
				Tetris.spawning = true;
			}
		}
		
	}

	@Override
	public void moveLeft() {
		try {
			if (rotated) {
				if (point3.get(1) >= 0
						&& Tetris.boardArray[point1.get(0)][point1.get(1) - 1] != 1
						&& Tetris.boardArray[point3.get(0)][point3.get(1) - 1] != 1
						&& Tetris.boardArray[point4.get(0)][point4.get(1) - 1] != 1) {
					moveAllPointsLeft();
				}
				
			} else {
				if (Tetris.boardArray[point1.get(0)][point1.get(1) - 1] != 1
						&& Tetris.boardArray[point3.get(0)][point3.get(1) - 1] != 1) {
					moveAllPointsLeft();
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			//Do nothing. Note this try catch is encompassing the entire method body. Other classes encompass each if separately.
		}

	}

	@Override
	public void moveRight() {
		try {
			if (rotated) {
				if (point2.get(1) < 10
						&& Tetris.boardArray[point1.get(0)][point1.get(1) + 1] != 1
						&& Tetris.boardArray[point2.get(0)][point2.get(1) + 1] != 1
						&& Tetris.boardArray[point4.get(0)][point4.get(1) + 1] != 1) {
					moveAllPointsRight();
				}
			} else {
				if (point4.get(1) < 10
						&& Tetris.boardArray[point4.get(0)][point4.get(1) + 1] != 1
						&& Tetris.boardArray[point2.get(0)][point2.get(1) + 1] != 1) {
					moveAllPointsRight();
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			//do nothing, just can't move.
		}

	}

	@Override
	public void rotate() {
		if (rotated){
			//maybe need to add check for nothing below point 2 as that is where point 4 will end up.
			//although this should be covered by the moveDown() method, which check for things below and stops, spawning new shape.
			if(point3.get(1)>0 &&Tetris.boardArray[point3.get(0)][point3.get(1)-1]!=1){
				zeroAllPoints();
				point1.set(0, point1.get(0)+1);
				point1.set(1, point1.get(1)-2);
				point2.set(0, point2.get(0));
				point2.set(1, point2.get(1)-1);
				point3.set(0, point3.get(0)+1);
				point3.set(1, point3.get(1));
				point4.set(0, point4.get(0));
				point4.set(1, point4.get(1)+1);
				Tetris.currentShape.rotated = !Tetris.currentShape.rotated;
			}
			
		}else{
			//no need to check for edges as rotated shape takes up less space
			//so just set points.
			zeroAllPoints();
			point1.set(0,point1.get(0)-1);
			point1.set(1, point1.get(1)+2);
			point2.set(0, point2.get(0));
			point2.set(1, point2.get(1)+1);
			point3.set(0, point3.get(0)-1);
			point3.set(1, point3.get(1));
			point4.set(0, point4.get(0));
			point4.set(1, point4.get(1)-1);
			Tetris.currentShape.rotated = !Tetris.currentShape.rotated;
		}

	}

}
