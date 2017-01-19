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
import Monkey_Middle.Middle_Close_Java;
import Monkey_Middle.Middle_Close_adb;
import Monkey_Middle.Middle_exec_python;
import Monkey_Middle.Middle_param;
import Monkey_Monitor.Monitor_BOXLog_Control;
import Monkey_Monitor.Monitor_Log_Compare;
import Monkey_Monitor.ThreadPool;

public class GUI_Close extends JFrame implements Runnable {
	// private JComboBox nameJComboBox;
	private JPanel userJPanel;
	private JLabel pictureJLabel, pictureJLabel1;
	private JButton closeJButton, cancelJButton;
	private JLabel Prompt, Prompt1,Prompt2 ;

	Methods method = new Methods();

	public GUI_Close() {
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

		//设置类型
		String SetType = "";
		int key = Middle_param.getKey();
		int time = Middle_param.getTime();
		System.out.println("key= "+key+" time="+time);
		if (key ==0 && time == 0) {
			SetType = "随机键值随机时间";
		}else if (key ==0 && time == 1) {
			SetType = "随机键值固定时间";
		}else if (key ==1 && time == 0) {
			SetType = "固定键值随机时间";
		}else if (key ==1 && time == 1) {
			SetType = "固定键值固定时间";
		}
		
		// 提示
		String prom = "无限循环,"+ SetType;
		if (Middle_param.getLoopcount()>0) {
			prom ="循环"+Middle_param.getLoopcount()+"次,"+ SetType;
		}
		Prompt = new JLabel("友情提示：程序正在运行,"+prom);
		Prompt.setBounds(bounds.x + bounds.width / 29, bounds.y , bounds.width, bounds.height / 13);
		Prompt.setFont(new Font("楷体", Font.BOLD, bounds.height / 35));
		Prompt.setForeground(new Color(0x57, 0x57, 0x57));
		add(Prompt);
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
		// 提示
		Prompt1 = new JLabel("执行的键值为：" + KeySetStr1);
		Prompt1.setBounds(bounds.x + bounds.width / 29, bounds.y
				+ bounds.height / 20, bounds.width, bounds.height / 13);
		Prompt1.setFont(new Font("楷体", Font.BOLD, bounds.height / 40));
		Prompt1.setForeground(new Color(0x57, 0x57, 0x57));
		add(Prompt1);
		// 提示
		Prompt2 = new JLabel(KeySetStr2);
		Prompt2.setBounds(bounds.x + bounds.width / 29, bounds.y
				+ bounds.height / 13, bounds.width, bounds.height / 13);
		Prompt2.setFont(new Font("楷体", Font.BOLD, bounds.height / 40));
		Prompt2.setForeground(new Color(0x57, 0x57, 0x57));
		add(Prompt2);
		// 提示
		Prompt2 = new JLabel("请耐心等待2分钟，若盒端无反应，请关闭后再重启程序");
		Prompt2.setBounds(bounds.x + bounds.width / 29, bounds.y
						+ bounds.height / 10, bounds.width, bounds.height / 13);
		Prompt2.setFont(new Font("楷体", Font.BOLD, bounds.height / 40));
		Prompt2.setForeground(new Color(0x57, 0x57, 0x57));
				add(Prompt2);
		// 上方动态图
		pictureJLabel1 = new JLabel();
		pictureJLabel1.setBounds(bounds.x + bounds.width / 5, bounds.y
				+ bounds.height / 6, bounds.width / 4, bounds.height / 6);
		pictureJLabel1.setIcon(new ImageIcon(GUI_Close.class.getClassLoader()
				.getResource("android.gif")));
		contentPane.add(pictureJLabel1);

		closeJButton = new JButton("关闭");
		closeJButton.setBounds((bounds.x + bounds.width / 90)*16, bounds.y
				+ bounds.height / 3, (bounds.width / 30) * 4,
				bounds.height / 13);
		closeJButton.setContentAreaFilled(true);
		// 此颜色值随便设置，只起占位作用，但是必须加上此句，否则不会出现透明背景效果。
		closeJButton.setFont(new Font("楷体", Font.BOLD, bounds.height / 35));
		closeJButton.setForeground(Color.BLUE);
		closeJButton.setBackground(Color.BLACK);
		closeJButton.setFocusPainted(false);
		contentPane.add(closeJButton);
		closeJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				closeJButtonActionPerformed(event);
			}
		});
		/*cancelJButton = new JButton("重新设置");
		cancelJButton.setBounds(bounds.x + (bounds.width / 100) * 27, bounds.y
				+ bounds.height / 3, (bounds.width / 30) * 3,
				bounds.height / 13);
		cancelJButton.setContentAreaFilled(true);
		; // 此颜色值随便设置，只起占位作用，但是必须加上此句，否则不会出现透明背景效果。
		cancelJButton.setFont(new Font("楷体", Font.BOLD, bounds.height / 30));
		cancelJButton.setForeground(Color.BLUE);
		cancelJButton.setBackground(Color.BLACK);
		cancelJButton.setFocusPainted(false);
		contentPane.add(cancelJButton);
		cancelJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				cancelJButtonActionPerformed(event);
			}

		});*/
		/*
		 * // 背景图片 Image imgbackground = Toolkit.getDefaultToolkit().getImage(
		 * "Blck-background.jpg"); Image imgbackgroundbig =
		 * imgbackground.getScaledInstance(bounds.width / 2, bounds.height /
		 * 2,Image.SCALE_SMOOTH); pictureJLabel = new JLabel(); pictureJLabel
		 * .setBounds(bounds.x , bounds.y , bounds.width / 2, bounds.height /
		 * 2); pictureJLabel.setIcon(new ImageIcon(imgbackgroundbig));
		 * contentPane.add(pictureJLabel);
		 */

		setTitle("正在运行");
		// setSize(380, 350);
		setBounds(bounds.x + bounds.width / 4, bounds.y + bounds.height / 4,
				bounds.width / 2, bounds.height / 2);
		contentPane.setBackground(Color.BLACK);
		// this.getContentPane().setBackground(Color.cyan);
		setResizable(false); // 将最大化按钮设置为不可用
		Image img = Toolkit.getDefaultToolkit().getImage(
				GUI_Close.class.getClassLoader().getResource("Tray.png"));
		this.setIconImage(img);// 设置窗口左上角图标
		// Tray("o.png");// 设置系统托盘图标

		return "";
	}

	private void closeJButtonActionPerformed(ActionEvent event) {

		if (ThreadPool.ThreadPoolexecutor.isShutdown() == false) {
			ThreadPool.ThreadPoolexecutor.shutdownNow();
		}
		new Middle_Close_adb();
		new Middle_Close_Java();
		System.exit(0);

	}
/*
	private void cancelJButtonActionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		setVisible(false);
		if (ThreadPool.ThreadPoolexecutor.isShutdown() == false) {
			ThreadPool.ThreadPoolexecutor.shutdownNow();
			new Middle_Close_adb();
		}
		new ThreadPool();
		GUI_RegularKey_RegularTime regularKey_RegularTime = new GUI_RegularKey_RegularTime();
		regularKey_RegularTime.setVisible(true);
		regularKey_RegularTime.setDefaultCloseOperation(3);
	}*/

	public GUI_RegularKey_RegularTime obj = null;

	public void GetObject(GUI_RegularKey_RegularTime ob) {
		// TODO Auto-generated method stub
		obj = ob;
	}

	public static void main(String[] args) {
		// JFrame.setDefaultLookAndFeelDecorated(true);用window默认标题框
		GUI_Close close = new GUI_Close();
		close.setVisible(true);
		close.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}
