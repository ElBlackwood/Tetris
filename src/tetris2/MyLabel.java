package tetris2;

import java.awt.Label;
import java.util.ArrayList;

public class MyLabel extends Label{
	
	ArrayList<Integer> coord = new ArrayList<Integer>();
	
	public MyLabel(int row, int column){
		coord.add(column);
		coord.add(row);
		//coord.set(0, row);
		//coord.set(1, column);
	}

}
