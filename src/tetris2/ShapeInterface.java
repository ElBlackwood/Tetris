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
	
	void moveDown() {
	}
	void moveLeft() {
	}
	void moveRight() {
	}
	void rotate() {
	}
}
