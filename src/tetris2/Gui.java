package tetris2;

import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gui extends JFrame implements KeyListener {
	JPanel p;
	public static MyLabel labelArray[][] = new MyLabel[20][10];
	public static JLabel scoreInfo;
	
	public Gui(){
		super("Tetris");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		
		p = new JPanel(new GridLayout(20,10,1,1));
		JPanel score = new JPanel();
		scoreInfo = new JLabel("Score: 0",JLabel.CENTER);
		scoreInfo.setFont(new Font("Serif", Font.BOLD, 18));
		scoreInfo.setPreferredSize(new Dimension(100,35));
		scoreInfo.setOpaque(true);
		score.add(scoreInfo);
		
		for (int i=0; i<20; i++){
			for (int j=0; j<10; j++){
				MyLabel label = new MyLabel(i,j);
				labelArray[i][j] = label;
				label.setBackground(Color.BLACK);
				p.add(labelArray[i][j]);
			}
		}
		this.addKeyListener(this);
		add(p, BorderLayout.CENTER);
		
		add(score, BorderLayout.SOUTH);
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
	    if (arg0.getKeyCode() == KeyEvent.VK_LEFT ) {
		      Tetris.currentShape.moveLeft();
		      //System.out.println("Move Left Performed!");
		      }
	    if (arg0.getKeyCode() == KeyEvent.VK_RIGHT ) {
		      Tetris.currentShape.moveRight();
		     
		      }
	    if (arg0.getKeyChar() == KeyEvent.VK_SPACE){
	    	Tetris.currentShape.rotate();
	    	
	    }
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}