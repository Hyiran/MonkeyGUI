package Monkey_GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Monkey_Methods.Methods;
import Monkey_Middle.Middle_Close_Java;
import Monkey_Middle.Middle_Close_adb;
import Monkey_Monitor.ThreadPool;

public class GUI_main extends JFrame {
	// private JComboBox nameJComboBox;
	private JLabel pictureJLabel;
	private JButton RegularKey_RegularTime, RegularKey_RandomTime,
			RandomKey_RegularTime, RandomKey_RandomTime;
	private JLabel Android_Name,Department_Name;
	private JPanel pane = null;
	private Thread thread = null;
	private GUI_Move_Label label = null;

	Methods method = new Methods();

	public GUI_main() {

		createUserInterface();
		// TODO Auto-generated constructor stub
	}

	private String createUserInterface() {

		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		// 获取最大窗口
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle bounds = new Rectangle(screenSize);
		Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(
				getGraphicsConfiguration());
		bounds.x += insets.left;
		bounds.y += insets.top;
		bounds.width -= insets.left + insets.right;
		bounds.height -= insets.top + insets.bottom;
		System.out.println("窗口总大小：" + bounds.x + "   " + bounds.y + "   "
				+ bounds.width + "   " + bounds.height);
		
		
		//滚动
		pane = new JPanel();
		pane.setBounds(bounds.x + bounds.width / 18, bounds.y
				  , (bounds.width/18)*10, bounds.height / 10);
		pane.setOpaque(false);
		pane.setLayout(null);
		contentPane.add(pane);
		label = new GUI_Move_Label("提示：推荐使用1920x1080的电脑屏幕分辨率使用此软件，若低于此分辨率，将可能导致软件内部部分字体显示不全。");
		label.setFont(new Font("楷体", Font.BOLD, bounds.height / 30));
		label.setForeground(Color.BLUE);
		label.setBounds(0, 0, (bounds.width/3)*2, bounds.height / 20);
		label.setOpaque(false);
		pane.add(label);
		thread = new Thread(label);
		thread.start();
		
		  // 获取命名
		Android_Name= new JLabel("安卓自动化GUI工具");
		Android_Name.setBounds(bounds.x + bounds.width / 4, bounds.y +
		  bounds.height / 10, bounds.width, bounds.height / 5);
		Android_Name.setFont(new Font("楷体", Font.BOLD, bounds.height / 15));
		Android_Name.setForeground(new Color(0x12, 0x12, 0x12)); add(Android_Name);
		
		  // 获取部门名称
		Department_Name= new JLabel("系统集成部");
		Department_Name.setBounds(bounds.x + (bounds.width / 30)*16, bounds.y +
		bounds.height / 6, bounds.width, bounds.height / 5);
		Department_Name.setFont(new Font("楷体", Font.BOLD, bounds.height / 35));
		Department_Name.setForeground(new Color(0x12, 0x12, 0x12)); add(Department_Name);
		 

		// 固定键值、固定时间测试
		RegularKey_RegularTime = new JButton("固定键值、固定时间测试");
		RegularKey_RegularTime.setBounds(bounds.x + (bounds.width / 48) * 16,
				bounds.y + bounds.height / 3, (bounds.width / 25) * 6,
				bounds.height / 13);
		RegularKey_RegularTime.setContentAreaFilled(true);
		; // 此颜色值随便设置，只起占位作用，但是必须加上此句，否则不会出现透明背景效果。
		RegularKey_RegularTime.setFont(new Font("楷体", Font.BOLD,
				bounds.height / 35));
		RegularKey_RegularTime.setForeground(Color.BLUE);
		RegularKey_RegularTime.setFocusPainted(false);
		contentPane.add(RegularKey_RegularTime);
		RegularKey_RegularTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				RegularKey_RegularTimeJButtonActionPerformed(event);
			}
		});

		// 固定键值、随机时间测试
		RegularKey_RandomTime = new JButton("固定键值、随机时间测试");
		RegularKey_RandomTime.setBounds(bounds.x + (bounds.width / 48) * 17,
				bounds.y + (bounds.height / 9)*4, (bounds.width / 25) * 6,
				bounds.height / 13);
		RegularKey_RandomTime.setContentAreaFilled(true);
		; // 此颜色值随便设置，只起占位作用，但是必须加上此句，否则不会出现透明背景效果。
		RegularKey_RandomTime.setFont(new Font("楷体", Font.BOLD,
				bounds.height / 35));
		RegularKey_RandomTime.setForeground(Color.BLUE);
		RegularKey_RandomTime.setFocusPainted(false);
		contentPane.add(RegularKey_RandomTime);
		RegularKey_RandomTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				RegularKey_RandomTimeJButtonActionPerformed(event);
			}

		});

		// 随机键值、固定时间测试
		RandomKey_RegularTime = new JButton("随机键值、固定时间测试");
		RandomKey_RegularTime.setBounds(bounds.x + (bounds.width / 48) * 18,
				bounds.y + (bounds.height / 9)*5, (bounds.width / 25) * 6,
				bounds.height / 13);
		RandomKey_RegularTime.setContentAreaFilled(true);
		// 此颜色值随便设置，只起占位作用，但是必须加上此句，否则不会出现透明背景效果。
		RandomKey_RegularTime.setFont(new Font("楷体", Font.BOLD,
				bounds.height / 35));
		RandomKey_RegularTime.setForeground(Color.BLUE);
		RandomKey_RegularTime.setFocusPainted(false);
		contentPane.add(RandomKey_RegularTime);
		RandomKey_RegularTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				RandomKey_RegularTimeJButtonActionPerformed(event);
			}


		});

		

		// 随机键值、随机时间测试
		RandomKey_RandomTime = new JButton("随机键值、随机时间测试");
		RandomKey_RandomTime.setBounds(bounds.x + (bounds.width / 48) * 19,
				bounds.y + (bounds.height / 9)*6, (bounds.width / 25) * 6,
				bounds.height / 13);
		RandomKey_RandomTime.setContentAreaFilled(true);
		; // 此颜色值随便设置，只起占位作用，但是必须加上此句，否则不会出现透明背景效果。
		RandomKey_RandomTime.setFont(new Font("楷体", Font.BOLD,
				bounds.height / 35));
		RandomKey_RandomTime.setForeground(Color.BLUE);
		RandomKey_RandomTime.setFocusPainted(false);
		contentPane.add(RandomKey_RandomTime);
		RandomKey_RandomTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				RandomKey_RandomTimeJButtonActionPerformed(event);
			}



		});
		
		
		// 创建背景图片
		/*Image imgbackground = Toolkit.getDefaultToolkit().getImage(
				"Android-back-up.jpg");*/
		Image imgbackground = Toolkit.getDefaultToolkit().getImage(
				GUI_main.class.getClassLoader().getResource(
                "Android-back-up.jpg"));
		
		Image imgbackgroundbig = imgbackground.getScaledInstance(
				(bounds.width / 3) * 2, (bounds.height / 5) * 4,
				Image.SCALE_SMOOTH);
		pictureJLabel = new JLabel();
		pictureJLabel.setBounds(0, 0, (bounds.width / 3) * 2,
				(bounds.height / 5) * 4);
		pictureJLabel.setIcon(new ImageIcon(imgbackgroundbig));
		contentPane.add(pictureJLabel);

		setTitle("欢迎使用安卓GUI测试工具-V1.3");
		// setSize(380, 350);
		setBounds(bounds.x + bounds.width / 6, bounds.y + bounds.height / 10,
				(bounds.width / 3) * 2, (bounds.height / 5) * 4);
		// this.getContentPane().setBackground(Color.cyan);
		setResizable(false); // 将最大化按钮设置为不可用
		Image img = Toolkit.getDefaultToolkit().getImage(
				GUI_main.class.getClassLoader().getResource(
						"Tray.png"));
		this.setIconImage(img);// 设置窗口左上角图标
		

		return "";
	}


	private void RegularKey_RegularTimeJButtonActionPerformed(ActionEvent event) {
		RegularKey_RegularTime.setEnabled(false);
		RegularKey_RandomTime.setEnabled(false);
		RandomKey_RegularTime.setEnabled(false);
		RandomKey_RandomTime.setEnabled(false);
		new ThreadPool();
		GUI_RegularKey_RegularTime gui_RegularKey_RegularTime = new GUI_RegularKey_RegularTime();
		gui_RegularKey_RegularTime.GetObject(gui_RegularKey_RegularTime);
		gui_RegularKey_RegularTime.setVisible(true);
		gui_RegularKey_RegularTime.setDefaultCloseOperation(EXIT_ON_CLOSE);
		gui_RegularKey_RegularTime.addWindowListener(new WindowAdapter() {  
			public void windowClosing(WindowEvent e) {  
			super.windowClosing(e);  
			//加入动作  
			System.out.println("要退出了");
			if (ThreadPool.ThreadPoolexecutor.isShutdown()==false) {
				ThreadPool.ThreadPoolexecutor.shutdownNow();
			}
			new Middle_Close_adb();
			new Middle_Close_Java();
			System.exit(0);
			 }   
			});
		setVisible(false);
		GUI_Move_Label.setRollset(false);
	}

	private void RegularKey_RandomTimeJButtonActionPerformed(
			ActionEvent event) {
		// TODO Auto-generated method stub
		RegularKey_RegularTime.setEnabled(false);
		RegularKey_RandomTime.setEnabled(false);
		RandomKey_RegularTime.setEnabled(false);
		RandomKey_RandomTime.setEnabled(false);
		
		new ThreadPool();
		GUI_RegularKey_RandomTime gui_RegularKey_RandomTime = new GUI_RegularKey_RandomTime();
		gui_RegularKey_RandomTime.GetObject(gui_RegularKey_RandomTime);
		gui_RegularKey_RandomTime.setVisible(true);
		gui_RegularKey_RandomTime.setDefaultCloseOperation(EXIT_ON_CLOSE);
		gui_RegularKey_RandomTime.addWindowListener(new WindowAdapter() {  
			public void windowClosing(WindowEvent e) {  
			super.windowClosing(e);  
			//加入动作  
			System.out.println("要退出了");
			if (ThreadPool.ThreadPoolexecutor.isShutdown()==false) {
				ThreadPool.ThreadPoolexecutor.shutdownNow();
			}
			new Middle_Close_adb();
			new Middle_Close_Java();
			System.exit(0);
			 }   
			});
		setVisible(false);
		GUI_Move_Label.setRollset(false);
	}

	private void RandomKey_RegularTimeJButtonActionPerformed(
			ActionEvent event) {
		RegularKey_RegularTime.setEnabled(false);
		RegularKey_RandomTime.setEnabled(false);
		RandomKey_RegularTime.setEnabled(false);
		RandomKey_RandomTime.setEnabled(false);
		
		new ThreadPool();
		GUI_RandomKey_RegularTime gui_RandomKey_RegularTime = new GUI_RandomKey_RegularTime();
		gui_RandomKey_RegularTime.GetObject(gui_RandomKey_RegularTime);
		gui_RandomKey_RegularTime.setVisible(true);
		gui_RandomKey_RegularTime.setDefaultCloseOperation(EXIT_ON_CLOSE);
		gui_RandomKey_RegularTime.addWindowListener(new WindowAdapter() {  
			public void windowClosing(WindowEvent e) {  
			super.windowClosing(e);  
			//加入动作  
			System.out.println("要退出了");
			if (ThreadPool.ThreadPoolexecutor.isShutdown()==false) {
				ThreadPool.ThreadPoolexecutor.shutdownNow();
			}
			new Middle_Close_adb();
			new Middle_Close_Java();
			System.exit(0);
			 }   
			});
		setVisible(false);
		GUI_Move_Label.setRollset(false);
	}
	private void RandomKey_RandomTimeJButtonActionPerformed(
			ActionEvent event) {
		RegularKey_RegularTime.setEnabled(false);
		RegularKey_RandomTime.setEnabled(false);
		RandomKey_RegularTime.setEnabled(false);
		RandomKey_RandomTime.setEnabled(false);
		new ThreadPool();
		// TODO Auto-generated method stub
		GUI_RandomKey_RandomTime gui_RandomKey_RandomTime = new GUI_RandomKey_RandomTime();
		gui_RandomKey_RandomTime.GetObject(gui_RandomKey_RandomTime);
		gui_RandomKey_RandomTime.setVisible(true);
		gui_RandomKey_RandomTime.setDefaultCloseOperation(EXIT_ON_CLOSE);
		gui_RandomKey_RandomTime.addWindowListener(new WindowAdapter() {  
			public void windowClosing(WindowEvent e) {  
			super.windowClosing(e);  
			//加入动作  
			System.out.println("要退出了");
			if (ThreadPool.ThreadPoolexecutor.isShutdown()==false) {
				ThreadPool.ThreadPoolexecutor.shutdownNow();
			}
			new Middle_Close_adb();
			new Middle_Close_Java();
			System.exit(0);
			 }   
			});
		setVisible(false);
		GUI_Move_Label.setRollset(false);
	}



	public static void main(String[] args) {
		// JFrame.setDefaultLookAndFeelDecorated(true);用window默认标题框
		GUI_main mian = new GUI_main();
		mian.setVisible(true);
		mian.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mian.addWindowListener(new WindowAdapter() {  
			public void windowClosing(WindowEvent e) {  
			super.windowClosing(e);  
			//加入动作  
			System.out.println("要退出了");
			System.exit(0);
			 }   
			});
	

	}

}
