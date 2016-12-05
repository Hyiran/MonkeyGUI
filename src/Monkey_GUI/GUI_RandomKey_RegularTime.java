package Monkey_GUI;

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;

import org.apache.log4j.spi.Configurator;

import Monkey_Generate_Python.Monkey_KEY;
import Monkey_Methods.Methods;
import Monkey_Middle.Middle_param_Set;
import Monkey_Monitor.ThreadPool;

public class GUI_RandomKey_RegularTime extends JFrame implements Runnable {

	private JPanel userJPanel, userJPanel1, userJPanel2;
	private JButton RandomKey_RegularTime_OkJButton, btnSelect,
			RandomKey_RegularTime_BackJButton;
	private JLabel IP1, Port1, SeleFolder1, SeleKey,Key_one1, Key_two1, Key_three1,
			Key_four1, Key_five1, Key_six1, Key_seven1, Key_eight1, Key_nine1,
			Key_ten1, Key_eleven1, Key_Twelve1, Key_Thirteen1, Key_Fourteen1,
			LoopCount1, LoopTime1;// 文本框前说明
	private JLabel IP2, LoopCount2, LoopTime2,
			pictureJlabelBackground, pictureJLabel, LogoJLabel;// 文本框后说明
	private JTextField IP, Port, SeleFolder, LoopTime, LoopCount;
	private JComboBox Key_one, Key_two, Key_three, Key_four, Key_five, Key_six,
			Key_seven, Key_eight, Key_nine, Key_ten, Key_eleven, Key_Twelve,
			Key_Thirteen, Key_Fourteen, Key_Fifteen, Key_Sixteen,
			Key_Seventeen, Key_Eighteen, Key_Nineteen, Twenty;
	private Checkbox[] cb;
	ImageIcon image, pictureBackground;
	JFileChooser fc = new JFileChooser();
	HashMap<Integer, String> map = new HashMap<Integer, String>();

	public GUI_RandomKey_RegularTime() {
		createUserInterface(); // 调用创建用户界面方法

	}

	@Override
	public void run() {
		// createUserInterface(); // 调用创建用户界面方法

	}

	private void createUserInterface() {
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

		// 建立一个容器
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		// 建立第一个JPanel
		Rectangle boundsuserJPanel = new Rectangle(screenSize);
		boundsuserJPanel.x = bounds.x + bounds.width / 30;
		boundsuserJPanel.y = bounds.y + bounds.height / 6;
		boundsuserJPanel.width = (bounds.width / 30) * 13;
		boundsuserJPanel.height = (bounds.height / 6) * 1;
		userJPanel = new JPanel();
		userJPanel.setBounds(boundsuserJPanel.x, boundsuserJPanel.y,
				boundsuserJPanel.width, boundsuserJPanel.height);
		userJPanel.setBorder(BorderFactory.createEtchedBorder()); // 显示一圈边儿
		// userJPanel.setBackground(Color.yellow);
		userJPanel.setOpaque(false);// 设置背景透明
		userJPanel.setLayout(null);
		contentPane.add(userJPanel);
		System.out.println("左侧Jpanel位置：" + boundsuserJPanel.x + "   "
				+ boundsuserJPanel.y + "   " + boundsuserJPanel.width + "   "
				+ boundsuserJPanel.height);

		// 建立第二个JPanel
		Rectangle boundsuserJPanel1 = new Rectangle(screenSize);
		boundsuserJPanel1.x = bounds.x + (bounds.width / 30) * 15;
		boundsuserJPanel1.y = bounds.y + bounds.height / 6;
		boundsuserJPanel1.width = (bounds.width / 30) * 13;
		boundsuserJPanel1.height = (bounds.height / 6) * 1;
		userJPanel1 = new JPanel();
		userJPanel1.setBounds(boundsuserJPanel1.x, boundsuserJPanel1.y,
				boundsuserJPanel1.width, boundsuserJPanel1.height);
		userJPanel1.setBorder(BorderFactory.createEtchedBorder()); // 显示一圈边儿
		// userJPanel.setBackground(Color.yellow);
		userJPanel1.setOpaque(false);// 设置背景透明
		userJPanel1.setLayout(null);
		contentPane.add(userJPanel1);
		System.out.println("右侧Jpanel位置：" + boundsuserJPanel1.x + "   "
				+ boundsuserJPanel1.y + "   " + boundsuserJPanel1.width + "   "
				+ boundsuserJPanel1.height);

		// 建立第三个JPanel
		Rectangle boundsuserJPanel2 = new Rectangle(screenSize);
		boundsuserJPanel2.x = bounds.x + bounds.width / 30;
		boundsuserJPanel2.y = bounds.y + (bounds.height / 100) * 35;
		boundsuserJPanel2.width = (bounds.width / 30) * 27;
		boundsuserJPanel2.height = (bounds.height / 100) * 48;
		userJPanel2 = new JPanel();
		userJPanel2.setBounds(boundsuserJPanel2.x, boundsuserJPanel2.y,
				boundsuserJPanel2.width, boundsuserJPanel2.height);
		userJPanel2.setBorder(BorderFactory.createEtchedBorder()); // 显示一圈边儿
		// userJPanel.setBackground(Color.yellow);
		userJPanel2.setOpaque(false);// 设置背景透明
		userJPanel2.setLayout(null);
		contentPane.add(userJPanel2);
		System.out.println("底部Jpanel位置：" + boundsuserJPanel2.x + "   "
				+ boundsuserJPanel2.y + "   " + boundsuserJPanel2.width + "   "
				+ boundsuserJPanel2.height);

		
		SeleKey = new JLabel("请选择需要随机的按键:");
		SeleKey.setBounds(boundsuserJPanel2.x/2,bounds.y+bounds.height/32, boundsuserJPanel2.width, boundsuserJPanel2.height/8);
		SeleKey.setFont(new Font("楷体", Font.BOLD,
				(boundsuserJPanel.height / 100) * 45));
		SeleKey.setForeground(new Color(0x57, 0x57, 0x57));
		userJPanel2.add(SeleKey);
		
		
		final int n = 18;
		cb = new Checkbox[n];
		// jb=new JButton("submit");
		// jb.setBounds(new Rectangle(20,20,75,25));
		/*
		 * for(int i=0;i<n;i++) { cb[i]=new Checkbox(""+(i+1));
		 * cb[i].setBounds(new Rectangle(20,50+20*i,60,25)); jp.add(cb[i]); }
		 */
	
		cb[1] = new Checkbox("HOME");
		cb[1].setBounds(boundsuserJPanel2.x+(boundsuserJPanel2.width/32)*1,bounds.y+bounds.height/8, boundsuserJPanel2.width/12, boundsuserJPanel2.height/10);
		cb[1].setFont(new Font("楷体", Font.BOLD,
				(boundsuserJPanel2.height / 100) * 10));
		userJPanel2.add(cb[1]);
		cb[2] = new Checkbox("BACK");
		cb[2].setBounds(boundsuserJPanel2.x+(boundsuserJPanel2.width/32)*5,bounds.y+bounds.height/8, boundsuserJPanel2.width/13, boundsuserJPanel2.height/10);
		cb[2].setFont(new Font("楷体", Font.BOLD,
				(boundsuserJPanel2.height / 100) * 10));
		userJPanel2.add(cb[2]);
		cb[3] = new Checkbox("OK");
		cb[3].setBounds(boundsuserJPanel2.x+(boundsuserJPanel2.width/32)*9,bounds.y+bounds.height/8, boundsuserJPanel2.width/13, boundsuserJPanel2.height/10);
		cb[3].setFont(new Font("楷体", Font.BOLD,
				(boundsuserJPanel2.height / 100) * 10));
		userJPanel2.add(cb[3]);
		cb[4] = new Checkbox("DOWN");
		cb[4].setBounds(boundsuserJPanel2.x+(boundsuserJPanel2.width/32)*13,bounds.y+bounds.height/8, boundsuserJPanel2.width/11, boundsuserJPanel2.height/10);
		cb[4].setFont(new Font("楷体", Font.BOLD,
				(boundsuserJPanel2.height / 100) * 10));
		userJPanel2.add(cb[4]);
		cb[5] = new Checkbox("UP");
		cb[5].setBounds(boundsuserJPanel2.x+(boundsuserJPanel2.width/32)*18,bounds.y+bounds.height/8, boundsuserJPanel2.width/13, boundsuserJPanel2.height/10);
		cb[5].setFont(new Font("楷体", Font.BOLD,
				(boundsuserJPanel2.height / 100) * 10));
		userJPanel2.add(cb[5]);
		cb[6] = new Checkbox("LEFT");
		cb[6].setBounds(boundsuserJPanel2.x+(boundsuserJPanel2.width/32)*22,bounds.y+bounds.height/8, boundsuserJPanel2.width/13, boundsuserJPanel2.height/10);
		cb[6].setFont(new Font("楷体", Font.BOLD,
				(boundsuserJPanel2.height / 100) * 10));
		userJPanel2.add(cb[6]);
		cb[7] = new Checkbox("RIGHT");
		cb[7].setBounds(boundsuserJPanel2.x+(boundsuserJPanel2.width/32)*26,bounds.y+bounds.height/8, boundsuserJPanel2.width/10, boundsuserJPanel2.height/10);
		cb[7].setFont(new Font("楷体", Font.BOLD,
				(boundsuserJPanel2.height / 100) * 10));
		userJPanel2.add(cb[7]);
		cb[8] = new Checkbox("0");
		cb[8].setBounds(boundsuserJPanel2.x+(boundsuserJPanel2.width/64)*2,bounds.y+bounds.height/4, boundsuserJPanel2.width/18, boundsuserJPanel2.height/10);
		cb[8].setFont(new Font("楷体", Font.BOLD,
				(boundsuserJPanel2.height / 100) * 10));
		userJPanel2.add(cb[8]);
		cb[9] = new Checkbox("1");
		cb[9].setBounds(boundsuserJPanel2.x+(boundsuserJPanel2.width/64)*8,bounds.y+bounds.height/4, boundsuserJPanel2.width/18, boundsuserJPanel2.height/10);
		cb[9].setFont(new Font("楷体", Font.BOLD,
				(boundsuserJPanel2.height / 100) * 10));
		userJPanel2.add(cb[9]);
		cb[10] = new Checkbox("2");
		cb[10].setBounds(boundsuserJPanel2.x+(boundsuserJPanel2.width/64)*14,bounds.y+bounds.height/4, boundsuserJPanel2.width/18, boundsuserJPanel2.height/10);
		cb[10].setFont(new Font("楷体", Font.BOLD,
				(boundsuserJPanel2.height / 100) * 10));
		userJPanel2.add(cb[10]);
		cb[11] = new Checkbox("3");
		cb[11].setBounds(boundsuserJPanel2.x+(boundsuserJPanel2.width/64)*20,bounds.y+bounds.height/4, boundsuserJPanel2.width/18, boundsuserJPanel2.height/10);
		cb[11].setFont(new Font("楷体", Font.BOLD,
				(boundsuserJPanel2.height / 100) * 10));
		userJPanel2.add(cb[11]);
		cb[12] = new Checkbox("4");
		cb[12].setBounds(boundsuserJPanel2.x+(boundsuserJPanel2.width/64)*26,bounds.y+bounds.height/4, boundsuserJPanel2.width/18, boundsuserJPanel2.height/10);
		cb[12].setFont(new Font("楷体", Font.BOLD,
				(boundsuserJPanel2.height / 100) * 10));
		userJPanel2.add(cb[12]);
		cb[13] = new Checkbox("5");
		cb[13].setBounds(boundsuserJPanel2.x+(boundsuserJPanel2.width/64)*32,bounds.y+bounds.height/4, boundsuserJPanel2.width/18, boundsuserJPanel2.height/10);
		cb[13].setFont(new Font("楷体", Font.BOLD,
				(boundsuserJPanel2.height / 100) * 10));
		userJPanel2.add(cb[13]);
		cb[14] = new Checkbox("6");
		cb[14].setBounds(boundsuserJPanel2.x+(boundsuserJPanel2.width/64)*38,bounds.y+bounds.height/4, boundsuserJPanel2.width/18, boundsuserJPanel2.height/10);
		cb[14].setFont(new Font("楷体", Font.BOLD,
				(boundsuserJPanel2.height / 100) * 10));
		userJPanel2.add(cb[14]);
		cb[15] = new Checkbox("7");
		cb[15].setBounds(boundsuserJPanel2.x+(boundsuserJPanel2.width/64)*44,bounds.y+bounds.height/4, boundsuserJPanel2.width/18, boundsuserJPanel2.height/10);
		cb[15].setFont(new Font("楷体", Font.BOLD,
				(boundsuserJPanel2.height / 100) * 10));
		userJPanel2.add(cb[15]);
		cb[16] = new Checkbox("8");
		cb[16].setBounds(boundsuserJPanel2.x+(boundsuserJPanel2.width/64)*50,bounds.y+bounds.height/4, boundsuserJPanel2.width/18, boundsuserJPanel2.height/10);
		cb[16].setFont(new Font("楷体", Font.BOLD,
				(boundsuserJPanel2.height / 100) * 10));
		userJPanel2.add(cb[16]);
		cb[17] = new Checkbox("9");
		cb[17].setBounds(boundsuserJPanel2.x+(boundsuserJPanel2.width/64)*56,bounds.y+bounds.height/4, boundsuserJPanel2.width/18, boundsuserJPanel2.height/10);
		cb[17].setFont(new Font("楷体", Font.BOLD,
				(boundsuserJPanel2.height / 100) * 10));
		userJPanel2.add(cb[17]);

		// 设置选择文件夹
		SeleFolder = new JTextField("sdk中tools文件夹路径");
		SeleFolder.setBounds(boundsuserJPanel.width / 3,
				boundsuserJPanel.height / 10, boundsuserJPanel.width / 3,
				(boundsuserJPanel.height / 100) * 45);
		SeleFolder.setFont(new Font("楷体", Font.BOLD,
				(boundsuserJPanel.height / 100) * 22));
		SeleFolder.setForeground(new Color(0x43, 0x6E, 0xEE));
		userJPanel.add(SeleFolder);

		SeleFolder1 = new JLabel("请选择文件夹：");
		SeleFolder1.setBounds(boundsuserJPanel.width / 50,
				boundsuserJPanel.height / 10, boundsuserJPanel.width / 3,
				(boundsuserJPanel.height / 100) * 45);
		SeleFolder1.setFont(new Font("楷体", Font.BOLD,
				(boundsuserJPanel.height / 100) * 30));
		SeleFolder1.setForeground(new Color(0x57, 0x57, 0x57));

		btnSelect = new JButton("选择");
		btnSelect.setBounds((boundsuserJPanel.width / 28) * 21,
				boundsuserJPanel.height / 10, boundsuserJPanel.width / 6,
				(boundsuserJPanel.height / 100) * 45);
		btnSelect.setFont(new Font("楷体", Font.BOLD,
				(boundsuserJPanel.height / 100) * 30));
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				btnSelectactionPerformed(event);
			}
		});
		userJPanel.add(SeleFolder1);
		userJPanel.add(btnSelect);

		// 设置IP与端口
		IP = new JTextField();
		Port = new JTextField();
		Rectangle IP_Portbounds = new Rectangle(screenSize);
		IP_Portbounds.y = (boundsuserJPanel.height / 20)
				+ (boundsuserJPanel.height / 2);
		IP.setBounds(boundsuserJPanel.width / 3, IP_Portbounds.y,
				boundsuserJPanel.width / 3,
				(boundsuserJPanel.height / 100) * 45);
		Port.setBounds((boundsuserJPanel.width / 16) * 13, IP_Portbounds.y,
				boundsuserJPanel.width / 6,
				(boundsuserJPanel.height / 100) * 45);
		// manufacturer_id.setFont(new Font("宋体", Font.BOLD, 60));
		IP.setFont(new Font("楷体", Font.BOLD,
				(boundsuserJPanel.height / 100) * 22));
		IP.setForeground(new Color(0x43, 0x6E, 0xEE));
		Port.setFont(new Font("楷体", Font.BOLD,
				(boundsuserJPanel.height / 100) * 22));
		Port.setForeground(new Color(0x43, 0x6E, 0xEE));
		userJPanel.add(IP);
		userJPanel.add(Port);
		IP1 = new JLabel("盒子IP :");
		IP1.setBounds(boundsuserJPanel.width / 50, IP_Portbounds.y,
				boundsuserJPanel.width / 3,
				(boundsuserJPanel.height / 100) * 45);
		IP2 = new JLabel("端口: ");
		IP2.setBounds((boundsuserJPanel.width / 3) * 2, IP_Portbounds.y,
				boundsuserJPanel.width / 6,
				(boundsuserJPanel.height / 100) * 45);
		IP1.setFont(new Font("楷体", Font.BOLD,
				(boundsuserJPanel.height / 100) * 30));
		IP1.setForeground(new Color(0x57, 0x57, 0x57));
		IP2.setFont(new Font("楷体", Font.BOLD,
				(boundsuserJPanel.height / 100) * 30));
		IP2.setForeground(new Color(0x57, 0x57, 0x57));
		userJPanel.add(IP1);
		userJPanel.add(IP2);

		// 设置循环次数

		LoopCount = new JTextField();
		LoopCount.setBounds(((boundsuserJPanel1.width / 24) * 7),
				boundsuserJPanel1.height / 10, boundsuserJPanel1.width / 10,
				(boundsuserJPanel1.height / 100) * 45);
		LoopCount.setFont(new Font("楷体", Font.BOLD,
				(boundsuserJPanel.height / 100) * 22));
		LoopCount.setForeground(new Color(0x43, 0x6E, 0xEE));
		userJPanel1.add(LoopCount);
		LoopCount1 = new JLabel("循环次数：");
		LoopCount1.setBounds(boundsuserJPanel1.width / 50,
				boundsuserJPanel1.height / 10, boundsuserJPanel1.width / 3,
				(boundsuserJPanel.height / 100) * 45);
		LoopCount1.setFont(new Font("楷体", Font.BOLD,
				(boundsuserJPanel.height / 100) * 30));
		LoopCount1.setForeground(new Color(0x57, 0x57, 0x57));
		LoopCount2 = new JLabel("请填正整数，0为无限循环");
		LoopCount2.setBounds(((boundsuserJPanel1.width / 48) * 15)
				+ (boundsuserJPanel1.width / 10),
				boundsuserJPanel1.height / 10,
				(boundsuserJPanel1.width / 3) * 2,
				(boundsuserJPanel.height / 100) * 45);
		LoopCount2.setFont(new Font("楷体", Font.BOLD | Font.ITALIC,
				(boundsuserJPanel1.height / 100) * 30));
		LoopCount2.setForeground(new Color(0x57, 0x57, 0x57));
		userJPanel1.add(LoopCount1);
		userJPanel1.add(LoopCount2);

		// 设置循环时间
		LoopTime = new JTextField();
		Rectangle LoopTimebounds = new Rectangle(screenSize);
		LoopTimebounds.y = (boundsuserJPanel1.height / 20)
				+ (boundsuserJPanel1.height / 2);
		LoopTime.setBounds(((boundsuserJPanel1.width / 24) * 7),
				LoopTimebounds.y, boundsuserJPanel1.width / 10,
				(boundsuserJPanel.height / 100) * 45);
		LoopTime.setFont(new Font("楷体", Font.BOLD,
				(boundsuserJPanel.height / 100) * 22));
		LoopTime.setForeground(new Color(0x43, 0x6E, 0xEE));
		userJPanel1.add(LoopTime);
		LoopTime1 = new JLabel("键值间隔:");
		LoopTime1.setBounds(boundsuserJPanel1.width / 50, LoopTimebounds.y,
				(boundsuserJPanel1.width / 12) * 5,
				(boundsuserJPanel.height / 100) * 45);
		LoopTime1.setFont(new Font("楷体", Font.BOLD,
				(boundsuserJPanel.height / 100) * 30));
		LoopTime1.setForeground(new Color(0x57, 0x57, 0x57));
		LoopTime2 = new JLabel("单位秒,数值请>0");
		LoopTime2.setBounds(((boundsuserJPanel1.width / 48) * 15)
				+ (boundsuserJPanel1.width / 10), LoopTimebounds.y,
				boundsuserJPanel1.width / 2,
				(boundsuserJPanel.height / 100) * 45);
		LoopTime2.setFont(new Font("楷体", Font.BOLD | Font.ITALIC,
				(boundsuserJPanel.height / 100) * 30));
		LoopTime2.setForeground(new Color(0x57, 0x57, 0x57));
		userJPanel1.add(LoopTime1);
		userJPanel1.add(LoopTime2);

		RandomKey_RegularTime_OkJButton = new JButton("确认");
		RandomKey_RegularTime_OkJButton.setBounds(bounds.x + bounds.width / 5,
				bounds.y + (bounds.height / 6) * 5, bounds.width / 9,
				bounds.height / 16);
		RandomKey_RegularTime_OkJButton.setContentAreaFilled(false);
		// 此颜色值随便设置，只起占位作用，但是必须加上此句，否则不会出现透明背景效果。
		RandomKey_RegularTime_OkJButton.setFont(new Font("楷体", Font.BOLD,
				((bounds.height / 6) / 100) * 40));
		RandomKey_RegularTime_OkJButton.setForeground(new Color(0x0A, 0x0A,
				0x0A));
		RandomKey_RegularTime_OkJButton.setFocusPainted(false);
		contentPane.add(RandomKey_RegularTime_OkJButton);
		RandomKey_RegularTime_OkJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				int mapcount = 1;
				for (int i = 1; i <= n; i++) {
					try {
						if (cb[i].getSelectedObjects().length == 1)// 判断是否选中,1为选中,报错为没选中.
						{
							//System.out.println(i + "选中的按键为" + cb[i].getLabel());// 输出选中的
							map.put(mapcount, Monkey_KEY.SetMapKey().get(cb[i].getLabel()).toString());
							//System.out.println(mapcount+"   "+map.get(mapcount));
							mapcount = mapcount+1;
						}
					} catch (Exception ex) { // 报错为没选中，不需要输出报错
					}
				}

				
				System.out.println("map.values():"+map.values());
				String IP_Port = IP.getText() + ":" + Port.getText();
				if (IP.getText().equals("") | IP.getText() == null) {
					IP_Port = "000.000.000.000";
				}
				if (Port.getText().equals("") | Port.getText() == null) {
					IP_Port = IP.getText();
				}
				GUI_Button_Monitor okJButtonAction = new GUI_Button_Monitor();
				okJButtonAction.RandomKey_RegularTime_OkJButtonActionPerformed(
						event, SeleFolder.getText(), IP_Port,
						LoopCount.getText(), 0, 1, map,"1",
						"3", LoopTime.getText(), obj);
			}
		});

		RandomKey_RegularTime_BackJButton = new JButton("返回");
		RandomKey_RegularTime_BackJButton.setBounds(bounds.x
				+ (bounds.width / 5) * 3, bounds.y + (bounds.height / 6) * 5,
				bounds.width / 9, bounds.height / 16);
		RandomKey_RegularTime_BackJButton.setContentAreaFilled(false);
		; // 此颜色值随便设置，只起占位作用，但是必须加上此句，否则不会出现透明背景效果。
			// okJButton.setIcon(new
			// ImageIcon("bin/filechooser/image/rec.gif"));
		RandomKey_RegularTime_BackJButton.setFont(new Font("楷体", Font.BOLD,
				((bounds.height / 6) / 100) * 40));
		RandomKey_RegularTime_BackJButton.setForeground(new Color(0x0A, 0x0A,
				0x0A));
		RandomKey_RegularTime_BackJButton.setFocusPainted(false);
		contentPane.add(RandomKey_RegularTime_BackJButton);
		RandomKey_RegularTime_BackJButton
				.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						GUI_Button_Monitor backJButtonAction = new GUI_Button_Monitor();
						backJButtonAction
								.RandomKey_RegularTime_BackJButtonActionPerformed(
										event, obj);
					}
				});

		// 上方文字

		LogoJLabel = new JLabel();
		LogoJLabel.setBounds((bounds.x + bounds.width / 256) * 101, bounds.y
				+ bounds.height / 24, bounds.width / 2, bounds.height / 8);
		LogoJLabel.setText("随机键值、固定时间间隔");
		LogoJLabel.setFont(new Font("Serif", Font.BOLD, 44));
		LogoJLabel.setForeground(new Color(0x57, 0x57, 0x57));
		contentPane.add(LogoJLabel);

		// 创建适应屏幕大小的背景图片
		Image imgbackground = Toolkit.getDefaultToolkit().getImage(
				GUI_RandomKey_RegularTime.class.getClassLoader().getResource(
						"BackGroundConfig.jpg"));
		Image imgbackgroundbig = imgbackground.getScaledInstance(bounds.width,
				bounds.height, Image.SCALE_SMOOTH);
		pictureJLabel = new JLabel();
		pictureJLabel
				.setBounds(bounds.x, bounds.y, bounds.width, bounds.height);
		pictureJLabel.setIcon(new ImageIcon(imgbackgroundbig));
		contentPane.add(pictureJLabel);

		ImageIcon icon = new ImageIcon("pic.gif");
		setIconImage(icon.getImage());
		setTitle("请填写随机键值、固定时间相关信息");
		setBounds(bounds);// 设置窗口最大化
		setResizable(false); // 将最大化按钮设置为不可用
		Image img = Toolkit.getDefaultToolkit().getImage(
				GUI_RandomKey_RegularTime.class.getClassLoader().getResource(
						"Tray.png"));
		this.setIconImage(img);// 设置窗口左上角图标
		// Tray("o.png");// 设置系统托盘图标

	}

	public void btnSelectactionPerformed(ActionEvent e) {
		if (e.getSource() == btnSelect) {

			/*
			 * 这是尤为重要的。因为JFileChooser默认的是选择文件，而需要选目录。 故要将DIRECTORIES_ONLY装入模型
			 * 另外，若选择文件，则无需此句
			 */
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int intRetVal = fc.showOpenDialog(this);
			if (intRetVal == JFileChooser.APPROVE_OPTION) {
				SeleFolder.setText(fc.getSelectedFile().getPath());
				//System.out.println(SeleFolder.getText());
			}
		}
	}

	public GUI_RandomKey_RegularTime obj = null;

	public void GetObject(GUI_RandomKey_RegularTime ob) {

		obj = ob;

	}

	public static void main(String[] args) {
		// JFrame.setDefaultLookAndFeelDecorated(true);用window默认标题框
		GUI_RandomKey_RegularTime mylogin = new GUI_RandomKey_RegularTime();
		mylogin.GetObject(mylogin);
		mylogin.setVisible(true);
		mylogin.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mylogin.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				// 加入动作
				//
				System.out.println("要退出了");
				System.exit(0);
			}

		});

	}

}
