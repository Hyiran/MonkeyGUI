package Monkey_GUI;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.swing.*;

import Monkey_Generate_Python.Generate_Python_write;
import Monkey_Generate_Python.Monkey_KEY;
import Monkey_Methods.Methods;
import Monkey_Middle.Middle_exec_monitor;
import Monkey_Middle.Middle_exec_python;
import Monkey_Middle.Middle_param;
import Monkey_Monitor.Monitor_BOXLog_Control;
import Monkey_Monitor.Monitor_Log_Compare;
import Monkey_Monitor.ThreadPool;

public class GUI_RandomKey_RegularTime_SuccessSet extends JFrame implements
		Runnable {
	// private JComboBox nameJComboBox;
	private JPanel userJPanel;
	private JLabel pictureJLabel;
	private JButton okJButton, cancelJButton;
	private JLabel ToolsPath, IP_Port, Message,KeySet, KeySet2, LoopC, LoopTy, LoopTi;

	private static String name1;
	private String password1;
	private String user;

	private String use = "aaa";

	private ImageIcon myImageIcon;

	Methods method = new Methods();

	public GUI_RandomKey_RegularTime_SuccessSet() {
		createUserInterface();
		// TODO Auto-generated constructor stub
	}

	public void run() {
		// createUserInterface();
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

		userJPanel = new JPanel();
		Rectangle boundsuserJPanel1 = new Rectangle(screenSize);
		boundsuserJPanel1.x = bounds.x;
		boundsuserJPanel1.y = bounds.y + bounds.height / 8;
		boundsuserJPanel1.width = (bounds.width / 3) * 2;
		boundsuserJPanel1.height = (bounds.height / 3) * 1;
		userJPanel.setBounds(boundsuserJPanel1);
		// userJPanel.setBackground(Color.yellow);
		userJPanel.setBorder(BorderFactory.createEtchedBorder()); // 显示一圈边儿
		userJPanel.setOpaque(false);// 设置背景透明
		userJPanel.setLayout(null);
		contentPane.add(userJPanel);

		// 标题显示
		Message = new JLabel("设置信息确认" );
		Message.setBounds(bounds.x + (bounds.width / 4) * 1,
								bounds.y, (bounds.width / 5) * 4,
								(bounds.height / 30) * 4);
		Message.setFont(new Font("楷体", Font.BOLD,
						boundsuserJPanel1.height / 7));
		Message.setForeground(Color.BLUE);
		contentPane.add(Message);

		// 获取路径
		ToolsPath = new JLabel("tools文件夹路径为：" + Middle_param.getToolsPath());
		ToolsPath
				.setBounds(boundsuserJPanel1.x + boundsuserJPanel1.width / 50,
						bounds.y, boundsuserJPanel1.width,
						boundsuserJPanel1.height / 7);
		ToolsPath.setFont(new Font("楷体", Font.BOLD,
				boundsuserJPanel1.height / 13));
		ToolsPath.setForeground(new Color(0x57, 0x57, 0x57));
		userJPanel.add(ToolsPath);

		// 获取IP端口
		IP_Port = new JLabel("adb连接的设备IP端口为：" + Middle_param.getIp_Port());
		Rectangle IP_Port1 = new Rectangle(screenSize);
		IP_Port1.y = bounds.y + (boundsuserJPanel1.height / 7);
		IP_Port.setBounds(boundsuserJPanel1.x + boundsuserJPanel1.width / 50,
				IP_Port1.y, boundsuserJPanel1.width,
				boundsuserJPanel1.height / 7);
		IP_Port.setFont(new Font("楷体", Font.BOLD, boundsuserJPanel1.height / 13));
		IP_Port.setForeground(new Color(0x57, 0x57, 0x57));
		userJPanel.add(IP_Port);

		// 取的键值
		HashMap Map = new HashMap();
		String MapValue = "";
		Map = Middle_param.getMap();
		for (int i = 1; i <= Map.size(); i++) {
			MapValue = MapValue
					+ method.HashKeyget(Monkey_KEY.SetMapKey(), Map.get(i))
							.toString() + "+";
		}
		MapValue = MapValue.substring(0, MapValue.lastIndexOf("+"));
		int position = MapValue.length();
		String KeySetStr1;
		String KeySetStr2;
		if (MapValue.length() > 45) {
			String temp = MapValue.substring(0, 43);
			position = temp.lastIndexOf("+");
			KeySetStr1 = MapValue.substring(0, position);
			KeySetStr2 = MapValue.substring(position);
		} else {

			KeySetStr1 = MapValue;
			KeySetStr2 = "";
		}

		KeySet = new JLabel("随机的键值有：" + Map.size() + "个，分别是："
				+ KeySetStr1);
		Rectangle KeySet1 = new Rectangle(screenSize);
		KeySet1.y = IP_Port1.y + (boundsuserJPanel1.height / 7);
		KeySet.setBounds(boundsuserJPanel1.x + boundsuserJPanel1.width / 50,
				KeySet1.y, boundsuserJPanel1.width,
				boundsuserJPanel1.height / 7);
		KeySet.setFont(new Font("楷体", Font.BOLD, boundsuserJPanel1.height / 13));
		KeySet.setForeground(new Color(0x57, 0x57, 0x57));
		userJPanel.add(KeySet);

		KeySet2 = new JLabel(KeySetStr2);
		Rectangle KeySet3 = new Rectangle(screenSize);
		KeySet3.y = KeySet1.y + (boundsuserJPanel1.height / 7);
		KeySet2.setBounds(boundsuserJPanel1.x + boundsuserJPanel1.width / 50,
				KeySet3.y, boundsuserJPanel1.width,
				boundsuserJPanel1.height / 7);
		KeySet2.setFont(new Font("楷体", Font.BOLD, boundsuserJPanel1.height / 13));
		KeySet2.setForeground(new Color(0x57, 0x57, 0x57));
		userJPanel.add(KeySet2);

		// 循环次数
		String Looptype;
		if (Middle_param.getLoopcount() <= 0) {
			Looptype = "循环方式为：无限循环";
		} else {
			Looptype = "循环方式为：循环" + Middle_param.getLoopcount() + "次";
		}
		LoopC = new JLabel(Looptype);
		Rectangle LoopC1 = new Rectangle(screenSize);
		LoopC1.y = KeySet3.y + (boundsuserJPanel1.height / 7);
		LoopC.setBounds(boundsuserJPanel1.x + boundsuserJPanel1.width / 50,
				LoopC1.y, boundsuserJPanel1.width, boundsuserJPanel1.height / 7);
		LoopC.setFont(new Font("楷体", Font.BOLD, boundsuserJPanel1.height / 13));
		LoopC.setForeground(new Color(0x57, 0x57, 0x57));
		userJPanel.add(LoopC);

		// 循环时间

		LoopTi = new JLabel("循环时间为：" + Middle_param.getRegularTimeCode()+"秒");
		Rectangle LoopTi1 = new Rectangle(screenSize);
		LoopTi1.y = LoopC1.y + (boundsuserJPanel1.height / 7);
		LoopTi.setBounds(boundsuserJPanel1.x + boundsuserJPanel1.width / 50,
				LoopTi1.y, boundsuserJPanel1.width,
				boundsuserJPanel1.height / 7);
		LoopTi.setFont(new Font("楷体", Font.BOLD, boundsuserJPanel1.height / 13));
		LoopTi.setForeground(new Color(0x57, 0x57, 0x57));
		userJPanel.add(LoopTi);

		okJButton = new JButton("运行");
		okJButton.setBounds(bounds.x + (bounds.width / 48) * 7, bounds.y
				+ (bounds.height / 6) * 3, (bounds.width / 30) * 4,
				(bounds.height / 30) * 2);
		okJButton.setContentAreaFilled(true);
		; // 此颜色值随便设置，只起占位作用，但是必须加上此句，否则不会出现透明背景效果。
		okJButton.setFont(new Font("楷体", Font.BOLD, bounds.height / 30));
		okJButton.setForeground(Color.BLUE);
		okJButton.setFocusPainted(false);
		contentPane.add(okJButton);
		okJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				okJButtonActionPerformed(event);
			}
			
		});

		
		cancelJButton = new JButton("返回");
		cancelJButton.setBounds(bounds.x + (bounds.width / 48) * 13+(bounds.width / 30) * 4, bounds.y
				+ (bounds.height / 6) * 3, (bounds.width / 30) * 4,
				(bounds.height / 30) * 2);
		cancelJButton.setContentAreaFilled(true);
		; // 此颜色值随便设置，只起占位作用，但是必须加上此句，否则不会出现透明背景效果。
		cancelJButton.setFont(new Font("楷体", Font.BOLD, bounds.height / 30));
		cancelJButton.setForeground(Color.BLUE);
		cancelJButton.setFocusPainted(false);
		contentPane.add(cancelJButton);
		cancelJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				cancelJButtonActionPerformed(event);
			}

			
			
		});
		// 背景图片
		Image imgbackground = Toolkit.getDefaultToolkit().getImage(
				GUI_RandomKey_RegularTime_SuccessSet.class.getClassLoader().getResource(
						"BackGroundConfig.jpg"));
		Image imgbackgroundbig = imgbackground.getScaledInstance((bounds.width / 3) * 2, (bounds.height / 3) * 2,Image.SCALE_SMOOTH);
		pictureJLabel = new JLabel();
		pictureJLabel
				.setBounds(bounds.x , bounds.y ,
						(bounds.width / 3) * 2, (bounds.height / 3) * 2);
		pictureJLabel.setIcon(new ImageIcon(imgbackgroundbig));
		contentPane.add(pictureJLabel);

		setTitle("设置信息确认");
		// setSize(380, 350);
		setBounds(bounds.x + bounds.width / 6, bounds.y + bounds.height / 6,
				(bounds.width / 3) * 2, (bounds.height / 3) * 2);
		// this.getContentPane().setBackground(Color.cyan);
		setResizable(false); // 将最大化按钮设置为不可用
		Image img = Toolkit.getDefaultToolkit().getImage(
				GUI_RandomKey_RegularTime_SuccessSet.class.getClassLoader().getResource(
						"Tray.png"));
		this.setIconImage(img);// 设置窗口左上角图标
		//Tray("o.png");// 设置系统托盘图标

		return "";
	}


	private void okJButtonActionPerformed(ActionEvent event) {

		setEnabled(false);
        GUI_close_run gui_close_run = new GUI_close_run();
        Thread gui_close_Th = new Thread(gui_close_run);
		ThreadPool.ThreadPoolexecutor.execute(gui_close_Th);
		setVisible(false);
		obj.setVisible(false);
		obj.setEnabled(false);
		Middle_exec_monitor exec = new Middle_exec_monitor();
		Thread exeh = new Thread(exec);
		ThreadPool.ThreadPoolexecutor.execute(exeh);


		
	}
	
	private void cancelJButtonActionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		setVisible(false);
		obj.setEnabled(true);
		obj.setVisible(true);
		
	}
	
	public GUI_RandomKey_RegularTime obj=null;
	public GUI_RandomKey_RegularTime_SuccessSet objsuccess=null;
	public void GetObject(GUI_RandomKey_RegularTime ob,GUI_RandomKey_RegularTime_SuccessSet obsuccess) {
		// TODO Auto-generated method stub
		obj=ob;
		objsuccess = obsuccess;
	}
	public static void main(String[] args) {
		// JFrame.setDefaultLookAndFeelDecorated(true);用window默认标题框
		GUI_RandomKey_RegularTime_SuccessSet successset = new GUI_RandomKey_RegularTime_SuccessSet();
		successset.setVisible(true);

	}

	

}