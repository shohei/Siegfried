package first;

import javax.swing.*;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.io.*;


//写真のアップロードのテスト

public class PhotoUpload extends JFrame implements ActionListener{

  JPanel p = new JPanel();

  public static void main(String[] args){
    PhotoUpload frame = new PhotoUpload();

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(10, 10, 1000, 800);
    frame.setTitle("タイトル");
    frame.setVisible(true);
  }

  PhotoUpload(){
    JButton button = new JButton("file select");
    button.addActionListener(this);
    JPanel buttonPanel = new JPanel();
    buttonPanel.add(button);

    //p = new JPanel();
    //textarea.setLineWrap(true);

    //JScrollPane scrollpane = new JScrollPane(p);
    //scrollpane.setPreferredSize(new Dimension(120, 120));

    //JPanel viewPanel = new JPanel();
    //viewPanel.add(scrollpane);

    //getContentPane().add(viewPanel, BorderLayout.CENTER);
    getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
  }

  public void actionPerformed(ActionEvent e){
	  System.out.println("hogehoge");
	  JFileChooser filechooser = new JFileChooser();
    int selected = filechooser.showOpenDialog(this);
    if (selected == JFileChooser.APPROVE_OPTION){
    	File file = filechooser.getSelectedFile();
      if (checkBeforeReadfile(file)){
    	ImageIcon icon1 = new ImageIcon(file.getAbsolutePath());
	    JLabel label1 = new JLabel(icon1);
	    p.add(label1);
	    Container contentPane = getContentPane();
	    contentPane.add(p, BorderLayout.CENTER);
	    contentPane.validate();//どうやってフレームを更新させる？？
      }else{
	  System.out.println("ファイルが見つからないか開けません");
	}
    }
  }

  private static boolean checkBeforeReadfile(File file){
    if (file.exists()){
      if (file.isFile() && file.canRead()){
        return true;
      }
    }

    return false;
  }
}




/*
class PhotoUpload extends JFrame{
  public static void main(String args[]){
    PhotoUpload frame = new PhotoUpload("タイトル");
    frame.setVisible(true);
  }

  PhotoUpload(String title){
    setTitle(title);
    setBounds(100, 100, 500, 500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel p = new JPanel();
    ImageIcon icon1 = new ImageIcon("./img/apple.png");
    JLabel label1 = new JLabel(icon1);
    p.add(label1);
    Container contentPane = getContentPane();
    contentPane.add(p, BorderLayout.CENTER);
  }
}

*/