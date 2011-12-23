
package first;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

class MainViewer extends JFrame implements ChangeListener {
	//JSplitPaneTest jspt = new JSplitPaneTest();
	JTable table = new JTable(3, 3);
	JTable table2 = new JTable(3,3);
	JTree tree = new JTree();
	JPanel panel = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	
	//RectTest f = new RectTest();

		
	public MainViewer() {
		//メニュー生成
		setJMenuBar(new MenuTest().getMenuTest());
		
		JTabbedPane tabbedPane = new JTabbedPane();
		JTabbedPane functionPane = new JTabbedPane();
		functionPane.add("機能空間", new FunctionSpace().getFunctionSpace());
		functionPane.add("製作プロセス",new ProcessView().getProcessView());
		//tabbedPane.add("機能空間", table);
		//tabbedPane.add("製作プロセス",table2);
		functionPane.add("非体系的知識記述平面",panel);
		tabbedPane.add("機能空間",functionPane);
		tabbedPane.add("問題空間",panel2);
		tabbedPane.add("構造空間",panel3);
		tabbedPane.add("材料空間",panel4);
		tabbedPane.add("環境空間",panel5);
		tabbedPane.addChangeListener(this);
		
		//return tabbedPane;
		
/* ルックアンドフィールを切り替えるステートメント
		String metal   = "javax.swing.plaf.metal.MetalLookAndFeel";
		String motif   = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
		String gtk     = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
		String nimbus  = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
		
		try {
            UIManager.setLookAndFeel(motif);
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }		
	*/	
        
        getContentPane().add(tabbedPane);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("FabKM: Fab Knowlegdge Manager");
		setSize(1000, 750);
		setLocation(200,50);
		setVisible(true);
	
		
		
		
	
	}
	public void stateChanged(ChangeEvent e) {
	}
	
		
	
	public static void main(String args[]) {
		new MainViewer();
	}
	
	
 }
