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
		if (rotated){

		} else {
			if (point3.get(0) < 19
					&& Tetris.boardArray[point1.get(0) + 1][point1.get(1)] != 1
					&& Tetris.boardArray[point2.get(0) + 1][point2.get(1)] != 1
					&& Tetris.boardArray[point4.get(0) + 1][point4.get(1)] != 1) {

			}
		}
		
	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub

	}

	@Override
	public void rotate() {
		// TODO Auto-generated method stub

	}

}
