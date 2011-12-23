package first;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.JPanel;

//機能空間におけるツリーを右のパネルに描画するクラス

public class RectTest extends JPanel {

/*
  class RectComponent extends JComponent{
	  @Override
	  public void paintComponent(Graphics g){
		  g.drawLine(10,15,150,90);
		  g.drawRect(10,15,150,90);
		  g.setColor(Color.BLACK);
	  }
  
  }
*/

	public RectTest() {
	    //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	  }

  
 
  public void paint(Graphics g){
    super.paint(g);
    Graphics2D g2 = (Graphics2D)this.getGraphics();
    Rectangle rect = new Rectangle();
    rect.setRect(30d,50d,100d,100d);
    g2.setColor(Color.BLACK);
    g2.draw(rect);
  }
  
  
  /*
  public static void main(String[] args) {
    JFrame f = new RectTest();
    f.setTitle("Swingサンプル（四角形の描画）");
    f.setSize(200,200);
    f.setBackground(Color.WHITE);
    f.setVisible(true);
  }
  */

}