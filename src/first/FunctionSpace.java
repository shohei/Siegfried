package first;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;
import java.awt.BorderLayout;

public class FunctionSpace extends JFrame{

/*
  public static void main(String[] args){
    FunctionSpace frame = new FunctionSpace();

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(10, 10, 800, 600);
    frame.setTitle("FuncionSpace");
    frame.setVisible(true);
  }
*/
  
 public JSplitPane getFunctionSpace(){
    JSplitPane splitpane = new JSplitPane();
    
    TreeTest tree = new TreeTest();//うまくTreeTestが生成されてないっぽい
    JTree jtree = tree.GetJTree();
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.getViewport().setView(jtree);
    scrollPane.setPreferredSize(new Dimension(400, 600));
    //leftPanel.add(new JButton("button1"));
    JPanel leftPanel = new JPanel();
    leftPanel.add(scrollPane);
    
    DrawTest draw = new DrawTest();
    JPanel rightpane = draw.getJPanel("tree");    
    JPanel rightPanel = new JPanel();
    JScrollPane scrollpane_r = new JScrollPane();
    scrollpane_r.getViewport().setView(rightpane);
    scrollpane_r.setPreferredSize(new Dimension(400, 600));
    //scrollpane_r.add(rightpane);
    //rightPanel.add(draw.getJLabel());
    //rightPanel.add(new JTextField("", 10));
    rightPanel.add(scrollpane_r);
    
    splitpane.setLeftComponent(leftPanel);
    splitpane.setRightComponent(rightPanel);
    
    
    return splitpane;
    //JScrollPane scrollpane_main = new JScrollPane();
    //return scrollpane_main;
    //System.out.println("hogehge");
    //一時的に待避
    //getContentPane().add(splitpane, BorderLayout.CENTER);
  }
}