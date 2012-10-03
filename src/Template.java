import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Template implements KeyListener, ActionListener {

// ADDED	
public static int [][] boardArray = new int[20][10];
//***

  private class Block {
    public int x;
    public int y;
  }

  private class DrawPanel extends JPanel {

    @Override
    //creation of UI - gameboard and 1 block piece
    public void paint(Graphics g) {
      g.setColor(Color.BLACK);
      g.fillRect(0, 0, 160, 320);

      g.setColor(Color.RED);
      g.fillRect(block.x, block.y, 16, 16);
      g.setColor(Color.ORANGE);
      g.drawRect(block.x, block.y, 15, 15);
    }

    @Override
    public void update(Graphics g) {
      paint(g);
    }    
  }//Draw Panel class
  
//ADDED	
  public int[][] arrayInit(int[][] listo){
	  for (int row=0; row < 20; row++) {
	      for (int col=0; col < 10; col++) {
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

  //get array index from UI coordinates.
  public int coords(int coord){
	return (coord/16)-1;
  }
  //updates board
  public void updateBoard(int column, int row){
	  if (coords(column)>0 && coords(column)<19){
	  boardArray[coords(column-1)][coords(row-1)]=0;
	  boardArray[coords(column-1)][coords(row+1)]=0;
	  boardArray[coords(column-1)][coords(row)]=0;
	  boardArray[coords(column)][coords(row)]=1;
	  }
  }
  
  private DrawPanel drawPanel = new DrawPanel();
  private Block block = new Block();

  public void launch() {    

	  
	arrayInit(boardArray);
	
	
    block.x = 80;
    boardArray[0][coords(80)] = 1;
    displayBoard();
    drawPanel.setPreferredSize(new Dimension(160, 320));

    JFrame frame = new JFrame();
    frame.addKeyListener(this);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(drawPanel);
    frame.setResizable(false);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

    Timer timer = new Timer(1000, this);
    timer.start();
  }

  @Override
  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      if (block.x > 0) {
        block.x -= 16;
      }
    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
      if (block.x < 144) {
        block.x += 16;
      }
    } 
//    else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
//        if (block.y < 304) {
//            block.y += 16;										//down key speedup functionality
//          }
//        }

    drawPanel.invalidate();
    drawPanel.repaint();
  }

  @Override
  public void keyReleased(KeyEvent e) {
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }

  @Override
  public void actionPerformed(ActionEvent e) {
	
    block.y += 16;
    
    //if block is hitting the floor:
    if (block.y >= 320) {
      block.y = 0;
    }
    
    updateBoard(block.y,block.x);
    displayBoard();
    drawPanel.invalidate();
    drawPanel.repaint();
  }

  // main - creation of block object to call the launch method on
  public static void main(String... args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {          	
        Template block = new Template();    
        block.launch();
      }
    });
  }
}