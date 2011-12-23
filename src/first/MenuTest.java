package first;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.UIManager;

import java.awt.Container;
import java.awt.BorderLayout;


class MenuTest extends JFrame{
  
	/*
	  public static void main(String args[]) throws Exception{

    MenuTest frame = new MenuTest("タイトル");
    frame.setVisible(true);
    
    
    // MacOSXでのJava実行環境用のシステムプロパティの設定.
    if (OSValidator.isMac()) {
        // JFrameにメニューをつけるのではなく、一般的なOSXアプリ同様に画面上端のスクリーンメニューにする.
        System.setProperty("apple.laf.useScreenMenuBar", "true");

        // スクリーンメニュー左端に表記されるアプリケーション名を設定する
        // (何も設定しないとクラス名になる。)
        System.setProperty(
                "com.apple.mrj.application.apple.menu.about.name",
                "MacJavaSample");
    }
    // システム標準のL&Fを設定.
    // MacOSXならAqua、WindowsXPならLuna、Vista/Windows7ならばAeroになる.
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    
  }
*/

	public JMenuBar getMenuTest(){
    //setTitle(title);
    //setBounds(100, 100, 300, 250);
    //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JMenuBar menubar = new JMenuBar();

    JMenu menu1 = new JMenu("File");
    JMenu menu2 = new JMenu("Edit");
    JMenu menu3 = new JMenu("View");
    JMenu menu4 = new JMenu("Advanced");
    JMenu menu5 = new JMenu("Tools");
    JMenu menu6 = new JMenu("Window");
    JMenu menu7 = new JMenu("Help");

    
    menubar.add(menu1);
    menubar.add(menu2);
    menubar.add(menu3);
    menubar.add(menu4);
    menubar.add(menu5);
    menubar.add(menu6);
    menubar.add(menu7);
    
    JMenuItem menuitem1 = new JMenuItem("New");
    JMenuItem menuitem2 = new JMenuItem("Open");
    JMenuItem menuitem3 = new JMenuItem("Close");

    menu1.add(menuitem1);
    menu1.add(menuitem2);
    menu1.add(menuitem3);

    setJMenuBar(menubar);
    return (menubar);
    //JPanel p = new JPanel();

    //JButton button = new JButton("button");
    //p.add(button);

    //Container contentPane = getContentPane();
    //contentPane.add(p, BorderLayout.CENTER);
  }
}