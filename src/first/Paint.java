package first;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.*;
import java.awt.Color;
import java.awt.BasicStroke;
import java.awt.Dimension;

public class Paint extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//	大きさ取得
		Dimension wh = this.getSize();
		//	まんなかに線を引く
		g.drawLine(0,wh.height/2,wh.width,wh.height/2);

	}
}

