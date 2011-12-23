package first;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.awt.event.*;
import java.awt.Insets;
import java.awt.GridLayout;
//製作プロセスを描画するクラス

public class ProcessView extends JFrame {

	public class RowHeaderTable extends JTable {
			public RowHeaderTable(String data[][], Object[] columnNames) {
				super(data, columnNames);
	}
	

		/*	public RowHeaderTable(Object data[][], Object[] columnNames) {
			super(data, columnNames);
		}
		*/
	}

	JPanel p;
	GridBagLayout layout;
	GridBagConstraints gbc;
	RowHeaderTable table1;
	String[] columnNames = { "概要", "値" };
	//Object[][] data;
	String[][] data;
	/*
	 * ２次元配列dataの初期化 Object[][] data = { { "材料", "ステンレス棒、スチールウール" }, { "仕様工具",
	 * "金のこ" }, { "プロセス（操作）", "ステンレス棒を切断、スチールウールを巻く" }, { "注意点", "中心をきつく巻く" }, {
	 * "設計者の意図", "摩擦率、表面積からスチールウールを利用" }, { "カスタマイズに関する知識", "試験管の容積を変える" } };
	 */
	ImageIcon icon1;
	int tableShown;

	//コンストラクタ
	public ProcessView() {
		p = new JPanel();
		layout = new GridBagLayout();
		p.setLayout(layout);
		gbc = new GridBagConstraints();
		//data = new ReadText("./txt/file.txt").getData();
		//icon1 = new ImageIcon("./img/apple.png");

	}

//ボタンとテーブルの位置を関連づけるために一つのクラスにまとめた	
public class BtnandTable{
	//グローバル変数を宣言
	JButton btn;
	JScrollPane sp;
	int btn_gx;
	int btn_gy;
	JLabel label1;
	ImageIcon btn_icon;
	//コンストラクタ　btnとspのコンフィグレーション
	BtnandTable(int gx,int gy, String img_file,String howto_file,String component_name ){
		btn_gx = gx;
		btn_gy = gy;
		btn_icon = new ImageIcon("./img/stirling/"+img_file);
		//btn_icon = icon1;
		data = new ReadText("./txt/howto/"+howto_file).getData();
		//デバッグ
		new ReadText("./txt/howto/"+howto_file).showData();

		
		btn = new JButton(component_name);

		table1 = new RowHeaderTable(data, columnNames);
		sp = new JScrollPane(table1);
		label1 = new JLabel(btn_icon);
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		DefaultTableColumnModel columnModel = (DefaultTableColumnModel) table1
				.getColumnModel();
		TableColumn column = null;
		column = columnModel.getColumn(0);
		column.setPreferredWidth(150);
		column = columnModel.getColumn(1);
		column.setPreferredWidth(300);
		sp.setPreferredSize(new Dimension(300, 150));

		//ここでボタンのGridBagLayoutを定義
		gbc.gridx = btn_gx;
		gbc.gridy = btn_gy-1;
		gbc.fill = GridBagConstraints.NONE;		
		layout.setConstraints(btn, gbc);
		
		//ここでテーブルと画像のGridBagLayoutを定義
		gbc.gridx = btn_gx;
		gbc.gridy = btn_gy;
		layout.setConstraints(sp, gbc);
		gbc.gridx = btn_gx;
		gbc.gridy = btn_gy;
		layout.setConstraints(label1, gbc);
		
		btn.addActionListener(new btnListener(btn_gx, btn_gy,sp,label1));		
	}

	public void showBtn(){
		p.add(btn);		
	}
	
	public void showTable(){	
		p.add(sp);
	}
	/*
	public void setIcon(String imgPath) {
		icon1 = new ImageIcon(imgPath);
	}*/

	public void showIcon(){
		p.add(label1);
	}
	
}

public class btnListener implements ActionListener {
	int btn_gx;
	int btn_gy;	
	JScrollPane btn_sp;
	JLabel btn_label1;
	
	btnListener(int gx,int gy,JScrollPane sp,JLabel label1){
		btn_gx = gx;
		btn_gy = gy;
		btn_sp = sp; 
		btn_label1=label1;
	}
	
	public void actionPerformed(ActionEvent e) {
		p.repaint();
		gbc.gridx = btn_gx;
		gbc.gridy = btn_gy;
		layout.setConstraints(btn_sp, gbc);			
		layout.setConstraints(btn_label1,gbc);
		
		if (tableShown == 1) {
			p.remove(btn_sp);
			p.add(btn_label1);
			tableShown = 0;
		} else {
			p.remove(btn_label1);
			p.add(btn_sp);
			tableShown = 1;
		}
		p.revalidate();
	}
}

	public void showComponent(String component_name, int gy) {
		JLabel label = new JLabel("スターリングエンジンの製作プロセス");
		LineBorder border_red = new LineBorder(Color.RED, 2, true);
		label.setBorder(border_red);
		gbc.gridx = 0;
		gbc.gridy = 0;
		layout.setConstraints(label, gbc);
		p.add(label);

		JLabel comp_label = new JLabel(component_name);
		gbc.gridx = 0;
		gbc.gridy = gy;		
		layout.setConstraints(comp_label, gbc);
		p.add(comp_label);
		}

	public JScrollPane getProcessView() {
		//コンポーネントを表示
		tableShown = 0; //フラグを設定 (1：テーブル 0：画像)
		ReadText rt = new ReadText("./txt/process/stirling_process.txt");
		//ReadText rt = new ReadText("./txt/process/stirling_process_debug.txt");
		//Object[][] rtdata = rt.getData();
		String[][] rtdata = rt.getData();
		
		for(int i =0;i<rt.getCount1();i++){
			String img_file = rtdata[i][0];
			String howto_file = rtdata[i][3];
			String component_name = rtdata[i][4];
			/*
				String img_file = rtdata[i][0].toString();
				String howto_file = rtdata[i][3].toString();
				String component_name = rtdata[i][4].toString();
				*/
				//Object型（参照型）からint（プリミティブ型）への直接変換はできないので
				//一度toString()で文字列に変換してからラッパークラスのIntegerを用いて変換する
				//int gx = new Integer(rtdata[i][1].toString()).intValue();
				//int gy = new Integer(rtdata[i][2].toString()).intValue();
			int gx = new Integer(rtdata[i][1]).intValue();
			int gy = new Integer(rtdata[i][2]).intValue();
			//System.out.println(img_file+":"+gx+":"+gy);
				//icon1 = new ImageIcon("./img/stirling/"+img_file);
				BtnandTable bt = new BtnandTable(gx,gy,img_file,howto_file,component_name);
				//showComponent(component_name, gy);
				bt.showBtn();
			if(tableShown==0){
				bt.showIcon();			
			}
			if(tableShown==1){
				bt.showTable();							
			}
			
		}
		

		JScrollPane scrollpane = new JScrollPane(p);
		return scrollpane;
	}
}