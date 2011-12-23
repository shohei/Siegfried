package first;

import javax.swing.*;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.tree.DefaultMutableTreeNode;


//機能空間におけるツリーを定義するクラス


public class TreeTest extends JComponent{	
	
/*
	public static void main(String[] args){
    TreeTest frame = new TreeTest();

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(10, 10, 800, 600);
    frame.setTitle("タイトル");
    frame.setVisible(true);
  }
*/

  //初期状態に全ノードを展開する関数を定義しておく　http://terai.xrea.jp/Swing/ExpandAllNodes.html
  private void expandAll(JTree tree) {
	  int row = 0;
	  while(row<tree.getRowCount()) {
	    tree.expandRow(row);
	    row++;
	  }
	}
	private void collapseAll(JTree tree) {
	  int row = tree.getRowCount()-1;
	  while(row>=0) {
	    tree.collapseRow(row);
	    row--;
	  }
	}

	
	
public JTree GetJTree(){
    DefaultMutableTreeNode root = new DefaultMutableTreeNode("非電化地域における冷蔵庫");

    DefaultMutableTreeNode o1  = new DefaultMutableTreeNode("冷やす（熱を移動させる）");
    	DefaultMutableTreeNode o11 = new DefaultMutableTreeNode("対流による熱交換");
    	DefaultMutableTreeNode o12 = new DefaultMutableTreeNode("伝導による熱交換");
    		DefaultMutableTreeNode o121 = new DefaultMutableTreeNode("低温源");
    			DefaultMutableTreeNode o1211 = new DefaultMutableTreeNode("空気圧縮");
    				DefaultMutableTreeNode o12111 = new DefaultMutableTreeNode("スターリング冷凍機");
    				DefaultMutableTreeNode o12112 = new DefaultMutableTreeNode("圧縮機（一般的な冷蔵庫）");
    			DefaultMutableTreeNode o1212 = new DefaultMutableTreeNode("熱電効果");
   					DefaultMutableTreeNode o12121 = new DefaultMutableTreeNode("熱電素子（ペルティエ素子）");
   				DefaultMutableTreeNode o1213 = new DefaultMutableTreeNode("化学的吸熱反応");
   					DefaultMutableTreeNode o12131 = new DefaultMutableTreeNode("化学反応（ex.尿素＋硝酸アンモニウム）");
   					DefaultMutableTreeNode o12132 = new DefaultMutableTreeNode("潜熱利用");
    		DefaultMutableTreeNode o122 = new DefaultMutableTreeNode("対流促進");
    			DefaultMutableTreeNode o1221 = new DefaultMutableTreeNode("ファン");    			
    DefaultMutableTreeNode o2 = new DefaultMutableTreeNode("ものを入れる（容積を有する）");
    	DefaultMutableTreeNode o21 = new DefaultMutableTreeNode("３次元立体形状");
    		DefaultMutableTreeNode o211 = new DefaultMutableTreeNode("直方体");
    		DefaultMutableTreeNode o212 = new DefaultMutableTreeNode("球体");
    		DefaultMutableTreeNode o213 = new DefaultMutableTreeNode("錐体");
    DefaultMutableTreeNode o3 = new DefaultMutableTreeNode("密閉する");
    	DefaultMutableTreeNode o31 = new DefaultMutableTreeNode("閉じた立体");
    
    root.add(o1);
    root.add(o2);
    root.add(o3);
   
    o1.add(o11);
    o1.add(o12);
    	o12.add(o121);
    		o121.add(o1211);
    			o1211.add(o12111);
    			o1211.add(o12112);    	
    		o121.add(o1212);
    			o1212.add(o12121);
    		o121.add(o1213);
    			o1213.add(o12131);
    			o1213.add(o12132);
    	o12.add(o122);
    		o122.add(o1221);
    o2.add(o21);
    	o21.add(o211);
    	o21.add(o212);
    	o21.add(o213);
    o3.add(o31);

    JTree tree = new JTree(root);
    tree.setEditable(true);
    //ノードを初期状態で全部展開（上で定義した関数）
    expandAll(tree);
    
    System.out.println("foobar");
    
    JTextField text = new JTextField();
    text.setFont(new Font("ＭＳ ゴシック", Font.BOLD, 16));
    text.setPreferredSize(new Dimension(300, 500));

    DefaultCellEditor editor = new DefaultCellEditor(text);
    tree.setCellEditor(editor);
    
    return tree;

    //JScrollPane scrollPane = new JScrollPane();
    //scrollPane.getViewport().setView(tree);
    //scrollPane.setPreferredSize(new Dimension(300, 500));

    //JPanel p = new JPanel();
    //p.add(scrollPane);

    //getContentPane().add(p, BorderLayout.CENTER);
  }
}
