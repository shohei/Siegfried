package first;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.util.HashMap;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.border.*;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.*;
import java.awt.BasicStroke;



class DrawTest extends JFrame{
  
	/*
	public static void main(String args[]){
    DrawTest frame = new DrawTest("タイトル");
    frame.setVisible(true);
    
  }
  */

	public static JLabel getJLabel() {
		return new JLabel("Input");
	}
	
  public JPanel getJPanel(String title){
    setTitle(title);
    setBounds(100, 100, 1000, 700);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //JPanelにしたら使えなくなった
	int framewidth = getWidth();
    int frameheight = getHeight();
    
/*
    String root = "非電化地域で用いる冷蔵庫";
  
    String func0 = "冷やす=熱を移動させる";
      String func0_0 = "対流による熱交換";
        String func0_0_0 = "低温源";
          String func0_0_0_0 = "空気圧縮";
            String func0_0_0_0_0 = "スターリング冷凍機";
            String func0_0_0_0_1 = "圧縮機（一般的な冷蔵庫）";
          String func0_0_0_1 = "熱電効果";
            String func0_0_0_1_0 = "熱電素子(ペルティエ素子)";
          String func0_0_0_2 = "化学的吸熱反応";
            String func0_0_0_2_0 = "化学反応（ex.尿素＋硝酸アンモニウム）";
            String func0_0_0_2_1 = "潜熱利用（熱放散ジェル（高含水基材））";
        String func0_0_1 = "対流促進" ;
          String func0_0_1_0 = "ファン";
      String func0_1 = "伝導による熱交換";      
          
    String func1 = "ものを入れる（容積を有する）";
      String func1_0 = "３次元形状";
        String func1_0_0 ="直方体";
        String func1_0_1 = "球体";
        String func1_0_2 = "錐体";
    
    String func2 = "密閉する";
      String func2_0 = "閉じた立体";
    	
    HashMap<String,String> map = new HashMap<String,String>();
      map.put("非電化地域で用いる冷蔵庫","冷やす=熱を移動させる");
      map.put("非電化地域で用いる冷蔵庫","ものを入れる（容積を有する）"); 
      map.put("非電化地域で用いる冷蔵庫","密閉する");
*/
      
    
    JPanel p = new JPanel();
    //p.setBounds(0, 0, 1000, 1000);
    //Layoutを無効にする。setBoundsでJLabelの座標を指定
    p.setLayout(null);  

    //第一階層
    //要素数element=1(root)
    int x_first = 5;
    int x_second = 200;
    
    JLabel label1 = new JLabel("<html>非電化地域で<p>用いる冷蔵庫</html>");
    LineBorder border_red = new LineBorder(Color.RED, 2, true);
    label1.setBorder(border_red);
    //用法　setBounds(x,y,width,height)
    Dimension d1 = label1.getPreferredSize();
    //label1.setPreferredSize(new Dimension(d.width, d.height));
    label1.setBounds(x_first,(frameheight-d1.height)/2 -50,d1.width,d1.height);
    p.add(label1);

    
    //描画コンポーネント Paint
    Paint l1 = new Paint();
    l1.setSize((x_second-(x_first+d1.width))/2,d1.height);
    l1.setLocation(x_first+d1.width,(frameheight-d1.height)/2 -50);
    p.add(l1);
    
    
    //第二階層
    //要素数element=3 second_layer.lengthで取得
    String[] second_layer = {"<html>冷やす<p>=熱を移動させる</html>","<html>ものを入れる<p>（容積を有する）</html>","<html>密閉する</html>"};
   
    for(int i = 0;i<second_layer.length; i++){
        LineBorder border_blue = new LineBorder(Color.BLUE, 2, true); 
        JLabel label = new JLabel(second_layer[i]);
        label.setBorder(border_blue);
        Dimension d = label.getPreferredSize();
        label.setBounds(x_second,(i+1)*(frameheight/(3+1)-d.height/2) ,d.width,d.height);    	
        p.add(label);
    
        //描画コンポーネント Paint
        Paint l = new Paint();
        l.setSize((x_second-(x_first+d1.width))/2,d1.height);
        //第二階層の場合はlocationだけ指定する
        l.setLocation((x_first+d1.width)+(x_second-(x_first+d1.width))/2,(i+1)*(frameheight/(3+1)-d.height/2) );
        p.add(l);

    }

    return p;
    //Container contentPane = getContentPane();
    //contentPane.add(p);
    
  
  
  }
}
