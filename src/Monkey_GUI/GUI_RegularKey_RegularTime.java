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

public class GUI_RegularKey_RegularTime extends JFrame implements Runnable{

	private JPanel userJPanel, userJPanel1;
	private JButton RegularKey_RegularTime_OkJButton, btnSelect, RegularKey_RegularTime_BackJButton;
	private JLabel IP1, Port1, SeleFolder1, Key_one1, Key_two1, Key_three1,
			Key_four1, Key_five1, Key_six1, Key_seven1, Key_eight1, Key_nine1,
			Key_ten1, Key_eleven1, Key_Twelve1, Key_Thirteen1, Key_Fourteen1,
			LoopCount1, LoopTime1;// �ı���ǰ˵��
	private JLabel IP2, LoopCount2, LoopTime2, pictureJlabelBackground,
			pictureJLabel, LogoJLabel;// �ı����˵��
	private JTextField IP, Port, SeleFolder, LoopTime, LoopCount;
	private JComboBox Key_one, Key_two, Key_three, Key_four, Key_five, Key_six,
			Key_seven, Key_eight, Key_nine, Key_ten, Key_eleven, Key_Twelve,
			Key_Thirteen, Key_Fourteen, Key_Fifteen, Key_Sixteen,
			Key_Seventeen, Key_Eighteen, Key_Nineteen, Twenty;
	ImageIcon image, pictureBackground;
	JFileChooser fc = new JFileChooser();
	HashMap<Integer, String> map =new  HashMap<Integer, String>();

	public GUI_RegularKey_RegularTime() {
		createUserInterface(); // ���ô����û����淽��

	}
	@Override
	public void run() {
		//createUserInterface(); // ���ô����û����淽��
		
	}
	private void createUserInterface() {
		// ��ȡ��󴰿�
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle bounds = new Rectangle(screenSize);
		Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(
				getGraphicsConfiguration());
		bounds.x += insets.left;
		bounds.y += insets.top;
		bounds.width -= insets.left + insets.right;
		bounds.height -= insets.top + insets.bottom;
		System.out.println("�����ܴ�С��" + bounds.x + "   " + bounds.y + "   "
				+ bounds.width + "   " + bounds.height);

		// ����һ������
		Container contentPane = getContentPane();
		contentPane.setLayout(null);



		// ������һ��JPanel
		Rectangle boundsuserJPanel = new Rectangle(screenSize);
		boundsuserJPanel.x = bounds.x + bounds.width / 30;
		boundsuserJPanel.y = bounds.y + bounds.height / 6;
		boundsuserJPanel.width = (bounds.width / 30) * 13;
		boundsuserJPanel.height = (bounds.height / 5) * 3;
		userJPanel = new JPanel();
		userJPanel.setBounds(boundsuserJPanel.x, boundsuserJPanel.y,
				boundsuserJPanel.width, boundsuserJPanel.height);
		userJPanel.setBorder(BorderFactory.createEtchedBorder()); // ��ʾһȦ�߶�
		// userJPanel.setBackground(Color.yellow);
		userJPanel.setOpaque(false);// ���ñ���͸��
		userJPanel.setLayout(null);
		contentPane.add(userJPanel);
		System.out.println("���Jpanelλ�ã�" + boundsuserJPanel.x + "   "
				+ boundsuserJPanel.y + "   " + boundsuserJPanel.width + "   "
				+ boundsuserJPanel.height);

		// �����ڶ���JPanel
		Rectangle boundsuserJPanel1 = new Rectangle(screenSize);
		boundsuserJPanel1.x = bounds.x + (bounds.width / 30) * 15;
		boundsuserJPanel1.y = bounds.y + bounds.height / 6;
		boundsuserJPanel1.width = (bounds.width / 30) * 13;
		boundsuserJPanel1.height = (bounds.height / 5) * 3;
		userJPanel1 = new JPanel();
		userJPanel1.setBounds(boundsuserJPanel1.x, boundsuserJPanel1.y,
				boundsuserJPanel1.width, boundsuserJPanel1.height);
		userJPanel1.setBorder(BorderFactory.createEtchedBorder()); // ��ʾһȦ�߶�
		// userJPanel.setBackground(Color.yellow);
		userJPanel1.setOpaque(false);// ���ñ���͸��
		userJPanel1.setLayout(null);
		contentPane.add(userJPanel1);
		System.out.println("�Ҳ�Jpanelλ�ã�" + boundsuserJPanel1.x + "   "
				+ boundsuserJPanel1.y + "   " + boundsuserJPanel1.width + "   "
				+ boundsuserJPanel1.height);

		// ����ѡ���ļ���
		SeleFolder = new JTextField("sdk��tools�ļ���·��");
		SeleFolder.setBounds(boundsuserJPanel.width / 3,
				boundsuserJPanel.height / 20, boundsuserJPanel.width / 3,
				boundsuserJPanel.height / 12);
		SeleFolder.setFont(new Font("����", Font.BOLD,
				boundsuserJPanel.height / 25));
		SeleFolder.setForeground(new Color(0x43,0x6E,0xEE));
		userJPanel.add(SeleFolder);

		SeleFolder1 = new JLabel("��ѡ���ļ��У�");
		SeleFolder1.setBounds(boundsuserJPanel.width / 50,
				boundsuserJPanel.height / 20, boundsuserJPanel.width / 3,
				boundsuserJPanel.height / 12);
		SeleFolder1.setFont(new Font("����", Font.BOLD,
				boundsuserJPanel.height / 20));
		SeleFolder1.setForeground(new Color(0x57,0x57,0x57));

		btnSelect = new JButton("ѡ��");
		btnSelect.setBounds((boundsuserJPanel.width / 28) * 21,
				boundsuserJPanel.height / 20, boundsuserJPanel.width / 6,
				boundsuserJPanel.height / 12);
		btnSelect.setFont(new Font("����", Font.BOLD,
				boundsuserJPanel.height / 20));
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				btnSelectactionPerformed(event);
			}
		});
		userJPanel.add(SeleFolder1);
		userJPanel.add(btnSelect);

		// ����IP��˿�
		IP = new JTextField();
		Port = new JTextField();
		Rectangle IP_Portbounds = new Rectangle(screenSize);
		IP_Portbounds.y = (boundsuserJPanel.height / 20)
				+ (boundsuserJPanel.height / 10);
		IP.setBounds(boundsuserJPanel.width / 3, IP_Portbounds.y,
				boundsuserJPanel.width / 3, boundsuserJPanel.height / 12);
		Port.setBounds((boundsuserJPanel.width / 16) * 13, IP_Portbounds.y,
				boundsuserJPanel.width / 6, boundsuserJPanel.height / 12);
		// manufacturer_id.setFont(new Font("����", Font.BOLD, 60));
		IP.setFont(new Font("����", Font.BOLD, boundsuserJPanel.height / 25));
		IP.setForeground(new Color(0x43,0x6E,0xEE));
		Port.setFont(new Font("����", Font.BOLD, boundsuserJPanel.height / 25));
		Port.setForeground(new Color(0x43,0x6E,0xEE));
		userJPanel.add(IP);
		userJPanel.add(Port);
		IP1 = new JLabel("���������IP :");
		IP1.setBounds(boundsuserJPanel.width / 50, IP_Portbounds.y,
				boundsuserJPanel.width / 3, boundsuserJPanel.height / 12);
		IP2 = new JLabel(" �˿�: ");
		IP2.setBounds((boundsuserJPanel.width / 3) * 2, IP_Portbounds.y,
				boundsuserJPanel.width / 6, boundsuserJPanel.height / 12);
		IP1.setFont(new Font("����", Font.BOLD, boundsuserJPanel.height / 20));
		IP1.setForeground(new Color(0x57,0x57,0x57));
		IP2.setFont(new Font("����", Font.BOLD, boundsuserJPanel.height / 20));
		IP2.setForeground(new Color(0x57,0x57,0x57));
		userJPanel.add(IP1);
		userJPanel.add(IP2);

		// ���õ�һ������
		Key_one = new JComboBox();
		Rectangle Key_onebounds = new Rectangle(screenSize);
		Key_onebounds.y = IP_Portbounds.y + (boundsuserJPanel.height / 10);
		Key_one.setBounds(boundsuserJPanel.width / 3, Key_onebounds.y,
				boundsuserJPanel.width / 3, boundsuserJPanel.height / 12);
		Key_one.setFont(new Font("����", Font.BOLD, boundsuserJPanel.height / 25));
		Key_one.setForeground(new Color(0x43,0x6E,0xEE));
		Key_one.addItem("��ѡ�񰴼�");
		Key_one.addItem("HOME");
		Key_one.addItem("BACK");
		Key_one.addItem("OK");
		Key_one.addItem("DOWN");
		Key_one.addItem("UP");
		Key_one.addItem("LEFT");
		Key_one.addItem("RIGHT");
		Key_one.addItem("0");
		Key_one.addItem("1");
		Key_one.addItem("2");
		Key_one.addItem("3");
		Key_one.addItem("4");
		Key_one.addItem("5");
		Key_one.addItem("6");
		Key_one.addItem("7");
		Key_one.addItem("8");
		Key_one.addItem("9");
		userJPanel.add(Key_one);

		Key_one1 = new JLabel("��1������:");
		Key_one1.setBounds(boundsuserJPanel.width / 50, Key_onebounds.y,
				boundsuserJPanel.width / 3, boundsuserJPanel.height / 12);
		Key_one1.setFont(new Font("����", Font.BOLD, boundsuserJPanel.height / 20));
		Key_one1.setForeground(new Color(0x57,0x57,0x57));
		/*
		 * Key_one2 = new JLabel(" ( �磺E://1.ts )"); Key_one2.setBounds(330, 90,
		 * 250, 25);
		 */
		userJPanel.add(Key_one1);
		// userJPanel.add(Key_one2);
		Key_one.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				int index = Key_one.getSelectedIndex();
				if (index != 0) { // ==0��ʾѡ�е��µ�һ��
					String content = Key_one.getSelectedItem().toString();
					map.put(1, Monkey_KEY.SetMapKey().get(content).toString());
					//System.out.println("map��ӳ��Ϊ��"+map.values().toString());
					System.out.println("ѡ�еļ�ֵΪ=" + index + ", content="
							+ content);
				}
				else {
					map.remove(1);
					System.out.println("ɾ��key 1��"+map.values().toString());
				}
			}
		});
		// ���õڶ�������
		Key_two = new JComboBox();
		Rectangle Key_twobounds = new Rectangle(screenSize);
		Key_twobounds.y = Key_onebounds.y + (boundsuserJPanel.height / 10);
		Key_two.setBounds(boundsuserJPanel.width / 3, Key_twobounds.y,
				boundsuserJPanel.width / 3, boundsuserJPanel.height / 12);
		Key_two.setFont(new Font("����", Font.BOLD, boundsuserJPanel.height / 25));
		Key_two.setForeground(new Color(0x43,0x6E,0xEE));
		Key_two.addItem("��ѡ�񰴼�");
		Key_two.addItem("HOME");
		Key_two.addItem("BACK");
		Key_two.addItem("OK");
		Key_two.addItem("DOWN");
		Key_two.addItem("UP");
		Key_two.addItem("LEFT");
		Key_two.addItem("RIGHT");
		Key_two.addItem("0");
		Key_two.addItem("1");
		Key_two.addItem("2");
		Key_two.addItem("3");
		Key_two.addItem("4");
		Key_two.addItem("5");
		Key_two.addItem("6");
		Key_two.addItem("7");
		Key_two.addItem("8");
		Key_two.addItem("9");
		userJPanel.add(Key_two);

		Key_two1 = new JLabel("��2������:");
		Key_two1.setBounds(boundsuserJPanel.width / 50, Key_twobounds.y,
				boundsuserJPanel.width / 3, boundsuserJPanel.height / 12);
		Key_two1.setFont(new Font("����", Font.BOLD, boundsuserJPanel.height / 20));
		Key_two1.setForeground(new Color(0x57,0x57,0x57));
		userJPanel.add(Key_two1);
		Key_two.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				int index = Key_two.getSelectedIndex();
				if (index != 0) { // ==0��ʾѡ�е��µ�һ��
					String content = Key_two.getSelectedItem().toString();
					map.put(2, Monkey_KEY.SetMapKey().get(content).toString());
					//System.out.println("map��ӳ��Ϊ��"+map.values().toString());
					System.out.println("ѡ�еļ�ֵΪ=" + index + ", content="
							+ content);
				}
				else {
					map.remove(2);
					System.out.println("ɾ��key 2��"+map.values().toString());
				}
			}
		});
		// ���õ���������
		Key_three = new JComboBox();
		Rectangle Key_threebounds = new Rectangle(screenSize);
		Key_threebounds.y = Key_twobounds.y + (boundsuserJPanel.height / 10);
		Key_three.setBounds(boundsuserJPanel.width / 3, Key_threebounds.y,
				boundsuserJPanel.width / 3, boundsuserJPanel.height / 12);
		Key_three.setFont(new Font("����", Font.BOLD,
				boundsuserJPanel.height / 25));
		Key_three.setForeground(new Color(0x43,0x6E,0xEE));
		Key_three.addItem("��ѡ�񰴼�");
		Key_three.addItem("HOME");
		Key_three.addItem("BACK");
		Key_three.addItem("OK");
		Key_three.addItem("DOWN");
		Key_three.addItem("UP");
		Key_three.addItem("LEFT");
		Key_three.addItem("RIGHT");
		Key_three.addItem("0");
		Key_three.addItem("1");
		Key_three.addItem("2");
		Key_three.addItem("3");
		Key_three.addItem("4");
		Key_three.addItem("5");
		Key_three.addItem("6");
		Key_three.addItem("7");
		Key_three.addItem("8");
		Key_three.addItem("9");
		userJPanel.add(Key_three);

		Key_three1 = new JLabel("��3������:");
		Key_three1.setBounds(boundsuserJPanel.width / 50, Key_threebounds.y,
				boundsuserJPanel.width / 3, boundsuserJPanel.height / 12);
		Key_three1.setFont(new Font("����", Font.BOLD,
				boundsuserJPanel.height / 20));
		Key_three1.setForeground(new Color(0x57,0x57,0x57));
		userJPanel.add(Key_three1);
		Key_three.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				int index = Key_three.getSelectedIndex();
				if (index != 0) { // ==0��ʾѡ�е��µ�һ��
					String content = Key_three.getSelectedItem().toString();
					map.put(3, Monkey_KEY.SetMapKey().get(content).toString());
					//System.out.println("map��ӳ��Ϊ��"+map.values().toString());
					System.out.println("ѡ�еļ�ֵΪ=" + index + ", content="
							+ content);
				}
				else {
					map.remove(3);
					System.out.println("ɾ��key 3��"+map.values().toString());
				}
			}
		});

		// ���õ��ĸ�����
		Key_four = new JComboBox();
		Rectangle Key_fourbounds = new Rectangle(screenSize);
		Key_fourbounds.y = Key_threebounds.y + (boundsuserJPanel.height / 10);
		Key_four.setBounds(boundsuserJPanel.width / 3, Key_fourbounds.y,
				boundsuserJPanel.width / 3, boundsuserJPanel.height / 12);
		Key_four.setFont(new Font("����", Font.BOLD, boundsuserJPanel.height / 25));
		Key_four.setForeground(new Color(0x43,0x6E,0xEE));
		Key_four.addItem("��ѡ�񰴼�");
		Key_four.addItem("HOME");
		Key_four.addItem("BACK");
		Key_four.addItem("OK");
		Key_four.addItem("DOWN");
		Key_four.addItem("UP");
		Key_four.addItem("LEFT");
		Key_four.addItem("RIGHT");
		Key_four.addItem("0");
		Key_four.addItem("1");
		Key_four.addItem("2");
		Key_four.addItem("3");
		Key_four.addItem("4");
		Key_four.addItem("5");
		Key_four.addItem("6");
		Key_four.addItem("7");
		Key_four.addItem("8");
		Key_four.addItem("9");
		userJPanel.add(Key_four);

		Key_four1 = new JLabel("��4������:");
		Key_four1.setBounds(boundsuserJPanel.width / 50, Key_fourbounds.y,
				boundsuserJPanel.width / 3, boundsuserJPanel.height / 12);
		Key_four1.setFont(new Font("����", Font.BOLD,
				boundsuserJPanel.height / 20));
		Key_four1.setForeground(new Color(0x57,0x57,0x57));
		userJPanel.add(Key_four1);
		Key_four.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				int index = Key_four.getSelectedIndex();
				if (index != 0) { // ==0��ʾѡ�е��µ�һ��
					String content = Key_four.getSelectedItem().toString();
					map.put(4, Monkey_KEY.SetMapKey().get(content).toString());
					//System.out.println("map��ӳ��Ϊ��"+map.values().toString());
					System.out.println("ѡ�еļ�ֵΪ=" + index + ", content="
							+ content);
				}
				else {
					map.remove(4);
					System.out.println("ɾ��key 4��"+map.values().toString());
				}
			}
		});

		// ���õ��������
		Key_five = new JComboBox();
		Rectangle Key_fivebounds = new Rectangle(screenSize);
		Key_fivebounds.y = Key_fourbounds.y + (boundsuserJPanel.height / 10);
		Key_five.setBounds(boundsuserJPanel.width / 3, Key_fivebounds.y,
				boundsuserJPanel.width / 3, boundsuserJPanel.height / 12);
		Key_five.setFont(new Font("����", Font.BOLD, boundsuserJPanel.height / 25));
		Key_five.setForeground(new Color(0x43,0x6E,0xEE));
		Key_five.addItem("��ѡ�񰴼�");
		Key_five.addItem("HOME");
		Key_five.addItem("BACK");
		Key_five.addItem("OK");
		Key_five.addItem("DOWN");
		Key_five.addItem("UP");
		Key_five.addItem("LEFT");
		Key_five.addItem("RIGHT");
		Key_five.addItem("0");
		Key_five.addItem("1");
		Key_five.addItem("2");
		Key_five.addItem("3");
		Key_five.addItem("4");
		Key_five.addItem("5");
		Key_five.addItem("6");
		Key_five.addItem("7");
		Key_five.addItem("8");
		Key_five.addItem("9");
		userJPanel.add(Key_five);

		Key_five1 = new JLabel("��5������:");
		Key_five1.setBounds(boundsuserJPanel.width / 50, Key_fivebounds.y,
				boundsuserJPanel.width / 3, boundsuserJPanel.height / 12);
		Key_five1.setFont(new Font("����", Font.BOLD,
				boundsuserJPanel.height / 20));
		Key_five1.setForeground(new Color(0x57,0x57,0x57));
		userJPanel.add(Key_five1);
		Key_five.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				int index = Key_five.getSelectedIndex();
				if (index != 0) { // ==0��ʾѡ�е��µ�һ��
					String content = Key_five.getSelectedItem().toString();
					map.put(5, Monkey_KEY.SetMapKey().get(content).toString());
					//System.out.println("map��ӳ��Ϊ��"+map.values().toString());
					System.out.println("ѡ�еļ�ֵΪ=" + index + ", content="
							+ content);
				}
				else {
					map.remove(5);
					System.out.println("ɾ��key 5��"+map.values().toString());
				}
			}
		});

		// ���õ�6������
		Key_six = new JComboBox();
		Rectangle Key_sixbounds = new Rectangle(screenSize);
		Key_sixbounds.y = Key_fivebounds.y + (boundsuserJPanel.height / 10);
		Key_six.setBounds(boundsuserJPanel.width / 3, Key_sixbounds.y,
				boundsuserJPanel.width / 3, boundsuserJPanel.height / 12);
		Key_six.setFont(new Font("����", Font.BOLD, boundsuserJPanel.height / 25));
		Key_six.setForeground(new Color(0x43,0x6E,0xEE));
		Key_six.addItem("��ѡ�񰴼�");
		Key_six.addItem("HOME");
		Key_six.addItem("BACK");
		Key_six.addItem("OK");
		Key_six.addItem("DOWN");
		Key_six.addItem("UP");
		Key_six.addItem("LEFT");
		Key_six.addItem("RIGHT");
		Key_six.addItem("0");
		Key_six.addItem("1");
		Key_six.addItem("2");
		Key_six.addItem("3");
		Key_six.addItem("4");
		Key_six.addItem("5");
		Key_six.addItem("6");
		Key_six.addItem("7");
		Key_six.addItem("8");
		Key_six.addItem("9");
		userJPanel.add(Key_six);

		Key_six1 = new JLabel("��6������:");
		Key_six1.setBounds(boundsuserJPanel.width / 50, Key_sixbounds.y,
				boundsuserJPanel.width / 3, boundsuserJPanel.height / 12);
		Key_six1.setFont(new Font("����", Font.BOLD, boundsuserJPanel.height / 20));
		Key_six1.setForeground(new Color(0x57,0x57,0x57));
		userJPanel.add(Key_six1);
		Key_six.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				int index = Key_six.getSelectedIndex();
				if (index != 0) { // ==0��ʾѡ�е��µ�һ��
					String content = Key_six.getSelectedItem().toString();
					map.put(6, Monkey_KEY.SetMapKey().get(content).toString());
					//System.out.println("map��ӳ��Ϊ��"+map.values().toString());
					System.out.println("ѡ�еļ�ֵΪ=" + index + ", content="
							+ content);
				}
				else {
					map.remove(6);
					System.out.println("ɾ��key 61��"+map.values().toString());
				}
			}
		});

		// ���õ�7����ֵ
		Key_seven = new JComboBox();
		Rectangle Key_sevenbounds = new Rectangle(screenSize);
		Key_sevenbounds.y = Key_sixbounds.y + (boundsuserJPanel.height / 10);
		Key_seven.setBounds(boundsuserJPanel.width / 3, Key_sevenbounds.y,
				boundsuserJPanel.width / 3, boundsuserJPanel.height / 12);
		Key_seven.setFont(new Font("����", Font.BOLD,
				boundsuserJPanel.height / 25));
		Key_seven.setForeground(new Color(0x43,0x6E,0xEE));
		Key_seven.addItem("��ѡ�񰴼�");
		Key_seven.addItem("HOME");
		Key_seven.addItem("BACK");
		Key_seven.addItem("OK");
		Key_seven.addItem("DOWN");
		Key_seven.addItem("UP");
		Key_seven.addItem("LEFT");
		Key_seven.addItem("RIGHT");
		Key_seven.addItem("0");
		Key_seven.addItem("1");
		Key_seven.addItem("2");
		Key_seven.addItem("3");
		Key_seven.addItem("4");
		Key_seven.addItem("5");
		Key_seven.addItem("6");
		Key_seven.addItem("7");
		Key_seven.addItem("8");
		Key_seven.addItem("9");
		userJPanel.add(Key_seven);

		Key_seven1 = new JLabel("��7������:");
		Key_seven1.setBounds(boundsuserJPanel.width / 50, Key_sevenbounds.y,
				boundsuserJPanel.width / 3, boundsuserJPanel.height / 12);
		Key_seven1.setFont(new Font("����", Font.BOLD,
				boundsuserJPanel.height / 20));
		Key_seven1.setForeground(new Color(0x57,0x57,0x57));
		userJPanel.add(Key_seven1);
		Key_seven.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				int index = Key_seven.getSelectedIndex();
				if (index != 0) { // ==0��ʾѡ�е��µ�һ��
					String content = Key_seven.getSelectedItem().toString();
					map.put(7, Monkey_KEY.SetMapKey().get(content).toString());
					//System.out.println("map��ӳ��Ϊ��"+map.values().toString());
					System.out.println("ѡ�еļ�ֵΪ=" + index + ", content="
							+ content);
				}
				else {
					map.remove(7);
					System.out.println("ɾ��key 7��"+map.values().toString());
				}
				
			}
		});

		// ����ѭ������

		LoopCount = new JTextField();
		LoopCount.setBounds(boundsuserJPanel1.width / 3,
				boundsuserJPanel1.height / 20, boundsuserJPanel1.width / 10,
				boundsuserJPanel1.height / 12);
		LoopCount.setFont(new Font("����", Font.BOLD,
				boundsuserJPanel1.height / 25));
		LoopCount.setForeground(new Color(0x43,0x6E,0xEE));
		userJPanel1.add(LoopCount);
		LoopCount1 = new JLabel("ѭ��������");
		LoopCount1.setBounds(boundsuserJPanel1.width / 50,
				boundsuserJPanel1.height / 20, boundsuserJPanel1.width / 3,
				boundsuserJPanel1.height / 12);
		LoopCount1.setFont(new Font("����", Font.BOLD,
				boundsuserJPanel1.height / 20));
		LoopCount1.setForeground(new Color(0x57,0x57,0x57));
		LoopCount2 = new JLabel("��������������0Ϊ����ѭ��");
		LoopCount2.setBounds((boundsuserJPanel1.width / 3)
				+ (boundsuserJPanel1.width / 10),
				boundsuserJPanel1.height / 20,
				(boundsuserJPanel1.width / 3) * 2,
				boundsuserJPanel1.height / 12);
		LoopCount2.setFont(new Font("����", Font.BOLD | Font.ITALIC,
				boundsuserJPanel1.height / 20));
		LoopCount2.setForeground(new Color(0x57,0x57,0x57));
		userJPanel1.add(LoopCount1);
		userJPanel1.add(LoopCount2);

		// ����ѭ��ʱ��
		LoopTime = new JTextField();
		Rectangle LoopTimebounds = new Rectangle(screenSize);
		LoopTimebounds.y = (boundsuserJPanel1.height / 20)
				+ (boundsuserJPanel1.height / 10);
		LoopTime.setBounds(boundsuserJPanel1.width / 3, LoopTimebounds.y,
				boundsuserJPanel1.width / 10, boundsuserJPanel1.height / 12);
		LoopTime.setFont(new Font("����", Font.BOLD,
				boundsuserJPanel1.height / 25));
		LoopTime.setForeground(new Color(0x43,0x6E,0xEE));
		userJPanel1.add(LoopTime);
		LoopTime1 = new JLabel("��ֵ���ʱ��:");
		LoopTime1.setBounds(boundsuserJPanel1.width / 50, LoopTimebounds.y,
				(boundsuserJPanel1.width / 12) * 5,
				boundsuserJPanel1.height / 12);
		LoopTime1.setFont(new Font("����", Font.BOLD,
				boundsuserJPanel1.height / 20));
		LoopTime1.setForeground(new Color(0x57,0x57,0x57));
		LoopTime2 = new JLabel("��λ��,��ֵ��>0");
		LoopTime2.setBounds((boundsuserJPanel1.width / 3)
				+ (boundsuserJPanel1.width / 10),
				LoopTimebounds.y, boundsuserJPanel1.width / 3,
				boundsuserJPanel1.height / 12);
		LoopTime2.setFont(new Font("����", Font.BOLD| Font.ITALIC,
				boundsuserJPanel1.height / 20));
		LoopTime2.setForeground(new Color(0x57,0x57,0x57));
		userJPanel1.add(LoopTime1);
		userJPanel1.add(LoopTime2);

		// ���õڰ˸�����
		Key_eight = new JComboBox();
		Rectangle Key_eightbounds = new Rectangle(screenSize);
		Key_eightbounds.y = LoopTimebounds.y + (boundsuserJPanel1.height / 10);
		Key_eight.setBounds(boundsuserJPanel1.width / 3, Key_eightbounds.y,
				boundsuserJPanel1.width / 3, boundsuserJPanel1.height / 12);
		Key_eight.setFont(new Font("����", Font.BOLD,
				boundsuserJPanel1.height / 25));
		Key_eight.setForeground(new Color(0x43,0x6E,0xEE));
		Key_eight.addItem("��ѡ�񰴼�");
		Key_eight.addItem("HOME");
		Key_eight.addItem("BACK");
		Key_eight.addItem("OK");
		Key_eight.addItem("DOWN");
		Key_eight.addItem("UP");
		Key_eight.addItem("LEFT");
		Key_eight.addItem("RIGHT");
		Key_eight.addItem("0");
		Key_eight.addItem("1");
		Key_eight.addItem("2");
		Key_eight.addItem("3");
		Key_eight.addItem("4");
		Key_eight.addItem("5");
		Key_eight.addItem("6");
		Key_eight.addItem("7");
		Key_eight.addItem("8");
		Key_eight.addItem("9");
		userJPanel1.add(Key_eight);

		Key_eight1 = new JLabel("��8������:");
		Key_eight1.setBounds(boundsuserJPanel1.width / 50, Key_eightbounds.y,
				boundsuserJPanel1.width / 3, boundsuserJPanel1.height / 12);
		Key_eight1.setFont(new Font("����", Font.BOLD,
				boundsuserJPanel1.height / 20));
		Key_eight1.setForeground(new Color(0x57,0x57,0x57));
		userJPanel1.add(Key_eight1);
		Key_eight.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				int index = Key_eight.getSelectedIndex();
				if (index != 0) { // ==0��ʾѡ�е��µ�һ��
					String content = Key_eight.getSelectedItem().toString();
					map.put(8, Monkey_KEY.SetMapKey().get(content).toString());
					//System.out.println("map��ӳ��Ϊ��"+map.values().toString());
					System.out.println("ѡ�еļ�ֵΪ=" + index + ", content="
							+ content);
				}
				else {
					map.remove(8);
					System.out.println("ɾ��key 8��"+map.values().toString());
				}
			}
		});

		// ���õھŸ�����
		Key_nine = new JComboBox();
		Rectangle Key_ninebounds = new Rectangle(screenSize);
		Key_ninebounds.y = Key_onebounds.y + (boundsuserJPanel1.height / 10);
		Key_nine.setBounds(boundsuserJPanel1.width / 3, Key_ninebounds.y,
				boundsuserJPanel1.width / 3, boundsuserJPanel1.height / 12);
		Key_nine.setFont(new Font("����", Font.BOLD,
				boundsuserJPanel1.height / 25));
		Key_nine.setForeground(new Color(0x43,0x6E,0xEE));
		Key_nine.addItem("��ѡ�񰴼�");
		Key_nine.addItem("HOME");
		Key_nine.addItem("BACK");
		Key_nine.addItem("OK");
		Key_nine.addItem("DOWN");
		Key_nine.addItem("UP");
		Key_nine.addItem("LEFT");
		Key_nine.addItem("RIGHT");
		Key_nine.addItem("0");
		Key_nine.addItem("1");
		Key_nine.addItem("2");
		Key_nine.addItem("3");
		Key_nine.addItem("4");
		Key_nine.addItem("5");
		Key_nine.addItem("6");
		Key_nine.addItem("7");
		Key_nine.addItem("8");
		Key_nine.addItem("9");
		userJPanel1.add(Key_nine);

		Key_nine1 = new JLabel("��9������:");
		Key_nine1.setBounds(boundsuserJPanel1.width / 50, Key_ninebounds.y,
				boundsuserJPanel1.width / 3, boundsuserJPanel1.height / 12);
		Key_nine1.setFont(new Font("����", Font.BOLD,
				boundsuserJPanel1.height / 20));
		Key_nine1.setForeground(new Color(0x57,0x57,0x57));
		userJPanel1.add(Key_nine1);
		Key_nine.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				int index = Key_nine.getSelectedIndex();
				if (index != 0) { // ==0��ʾѡ�е��µ�һ��
					String content = Key_nine.getSelectedItem().toString();
					map.put(9, Monkey_KEY.SetMapKey().get(content).toString());
					//System.out.println("map��ӳ��Ϊ��"+map.values().toString());
					System.out.println("ѡ�еļ�ֵΪ=" + index + ", content="
							+ content);
				}
				else {
					map.remove(9);
					System.out.println("ɾ��key 9��"+map.values().toString());
				}
			}
		});
		// ���õ�ʮ������
		Key_ten = new JComboBox();
		Rectangle Key_tenbounds = new Rectangle(screenSize);
		Key_tenbounds.y = Key_ninebounds.y + (boundsuserJPanel1.height / 10);
		Key_ten.setBounds(boundsuserJPanel1.width / 3, Key_tenbounds.y,
				boundsuserJPanel1.width / 3, boundsuserJPanel1.height / 12);
		Key_ten.setFont(new Font("����", Font.BOLD, boundsuserJPanel1.height / 25));
		Key_ten.setForeground(new Color(0x43,0x6E,0xEE));
		Key_ten.addItem("��ѡ�񰴼�");
		Key_ten.addItem("HOME");
		Key_ten.addItem("BACK");
		Key_ten.addItem("OK");
		Key_ten.addItem("DOWN");
		Key_ten.addItem("UP");
		Key_ten.addItem("LEFT");
		Key_ten.addItem("RIGHT");
		Key_ten.addItem("0");
		Key_ten.addItem("1");
		Key_ten.addItem("2");
		Key_ten.addItem("3");
		Key_ten.addItem("4");
		Key_ten.addItem("5");
		Key_ten.addItem("6");
		Key_ten.addItem("7");
		Key_ten.addItem("8");
		Key_ten.addItem("9");
		userJPanel1.add(Key_ten);

		Key_ten1 = new JLabel("��10������:");
		Key_ten1.setBounds(boundsuserJPanel1.width / 50, Key_tenbounds.y,
				boundsuserJPanel1.width / 3, boundsuserJPanel1.height / 12);
		Key_ten1.setFont(new Font("����", Font.BOLD,
				boundsuserJPanel1.height / 20));
		Key_ten1.setForeground(new Color(0x57,0x57,0x57));
		userJPanel1.add(Key_ten1);
		Key_ten.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				int index = Key_ten.getSelectedIndex();
				if (index != 0) { // ==0��ʾѡ�е��µ�һ��
					String content = Key_ten.getSelectedItem().toString();
					map.put(10, Monkey_KEY.SetMapKey().get(content).toString());
					//System.out.println("map��ӳ��Ϊ��"+map.values().toString());
					System.out.println("ѡ�еļ�ֵΪ=" + index + ", content="
							+ content);
				}
				else {
					map.remove(10);
					System.out.println("ɾ��key 10��"+map.values().toString());
				}
			}
		});

		// ���õ�ʮһ������
		Key_eleven = new JComboBox();
		Rectangle Key_elevenbounds = new Rectangle(screenSize);
		Key_elevenbounds.y = Key_tenbounds.y + (boundsuserJPanel1.height / 10);
		Key_eleven.setBounds(boundsuserJPanel1.width / 3, Key_elevenbounds.y,
				boundsuserJPanel1.width / 3, boundsuserJPanel1.height / 12);
		Key_eleven.setFont(new Font("����", Font.BOLD,
				boundsuserJPanel1.height / 25));
		Key_eleven.setForeground(new Color(0x43,0x6E,0xEE));
		Key_eleven.addItem("��ѡ�񰴼�");
		Key_eleven.addItem("HOME");
		Key_eleven.addItem("BACK");
		Key_eleven.addItem("OK");
		Key_eleven.addItem("DOWN");
		Key_eleven.addItem("UP");
		Key_eleven.addItem("LEFT");
		Key_eleven.addItem("RIGHT");
		Key_eleven.addItem("0");
		Key_eleven.addItem("1");
		Key_eleven.addItem("2");
		Key_eleven.addItem("3");
		Key_eleven.addItem("4");
		Key_eleven.addItem("5");
		Key_eleven.addItem("6");
		Key_eleven.addItem("7");
		Key_eleven.addItem("8");
		Key_eleven.addItem("9");
		userJPanel1.add(Key_eleven);

		Key_eleven1 = new JLabel("��11������:");
		Key_eleven1.setBounds(boundsuserJPanel1.width / 50, Key_elevenbounds.y,
				boundsuserJPanel1.width / 3, boundsuserJPanel1.height / 12);
		Key_eleven1.setFont(new Font("����", Font.BOLD,
				boundsuserJPanel1.height / 20));
		Key_eleven1.setForeground(new Color(0x57,0x57,0x57));
		userJPanel1.add(Key_eleven1);
		Key_eleven.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				int index = Key_eleven.getSelectedIndex();
				if (index != 0) { // ==0��ʾѡ�е��µ�һ��
					String content = Key_eleven.getSelectedItem().toString();
					map.put(11, Monkey_KEY.SetMapKey().get(content).toString());
					//System.out.println("map��ӳ��Ϊ��"+map.values().toString());
					System.out.println("ѡ�еļ�ֵΪ=" + index + ", content="
							+ content);
				}
				else {
					map.remove(11);
					System.out.println("ɾ��key 11��"+map.values().toString());
				}
			}
		});

		// ���õ�ʮ��������
		Key_Twelve = new JComboBox();
		Rectangle Key_Twelvebounds = new Rectangle(screenSize);
		Key_Twelvebounds.y = Key_elevenbounds.y
				+ (boundsuserJPanel1.height / 10);
		Key_Twelve.setBounds(boundsuserJPanel1.width / 3, Key_Twelvebounds.y,
				boundsuserJPanel1.width / 3, boundsuserJPanel1.height / 12);
		Key_Twelve.setFont(new Font("����", Font.BOLD,
				boundsuserJPanel1.height / 25));
		Key_Twelve.setForeground(new Color(0x43,0x6E,0xEE));
		Key_Twelve.addItem("��ѡ�񰴼�");
		Key_Twelve.addItem("HOME");
		Key_Twelve.addItem("BACK");
		Key_Twelve.addItem("OK");
		Key_Twelve.addItem("DOWN");
		Key_Twelve.addItem("UP");
		Key_Twelve.addItem("LEFT");
		Key_Twelve.addItem("RIGHT");
		Key_Twelve.addItem("0");
		Key_Twelve.addItem("1");
		Key_Twelve.addItem("2");
		Key_Twelve.addItem("3");
		Key_Twelve.addItem("4");
		Key_Twelve.addItem("5");
		Key_Twelve.addItem("6");
		Key_Twelve.addItem("7");
		Key_Twelve.addItem("8");
		Key_Twelve.addItem("9");
		userJPanel1.add(Key_Twelve);

		Key_Twelve1 = new JLabel("��12������:");
		Key_Twelve1.setBounds(boundsuserJPanel1.width / 50, Key_Twelvebounds.y,
				boundsuserJPanel1.width / 3, boundsuserJPanel1.height / 12);
		Key_Twelve1.setFont(new Font("����", Font.BOLD,
				boundsuserJPanel1.height / 20));
		Key_Twelve1.setForeground(new Color(0x57,0x57,0x57));
		userJPanel1.add(Key_Twelve1);
		Key_Twelve.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				int index = Key_Twelve.getSelectedIndex();
				if (index != 0) { // ==0��ʾѡ�е��µ�һ��
					String content = Key_Twelve.getSelectedItem().toString();
					map.put(12, Monkey_KEY.SetMapKey().get(content).toString());
					//System.out.println("map��ӳ��Ϊ��"+map.values().toString());
					System.out.println("ѡ�еļ�ֵΪ=" + index + ", content="
							+ content);
				}
				else {
					map.remove(12);
					System.out.println("ɾ��key 12��"+map.values().toString());
				}
			}
		});

		// ���õ�13������
		Key_Thirteen = new JComboBox();
		Rectangle Key_Thirteenbounds = new Rectangle(screenSize);
		Key_Thirteenbounds.y = Key_Twelvebounds.y
				+ (boundsuserJPanel1.height / 10);
		Key_Thirteen.setBounds(boundsuserJPanel1.width / 3,
				Key_Thirteenbounds.y, boundsuserJPanel1.width / 3,
				boundsuserJPanel1.height / 12);
		Key_Thirteen.setFont(new Font("����", Font.BOLD,
				boundsuserJPanel1.height / 25));
		Key_Thirteen.setForeground(new Color(0x43,0x6E,0xEE));
		Key_Thirteen.addItem("��ѡ�񰴼�");
		Key_Thirteen.addItem("HOME");
		Key_Thirteen.addItem("BACK");
		Key_Thirteen.addItem("OK");
		Key_Thirteen.addItem("DOWN");
		Key_Thirteen.addItem("UP");
		Key_Thirteen.addItem("LEFT");
		Key_Thirteen.addItem("RIGHT");
		Key_Thirteen.addItem("0");
		Key_Thirteen.addItem("1");
		Key_Thirteen.addItem("2");
		Key_Thirteen.addItem("3");
		Key_Thirteen.addItem("4");
		Key_Thirteen.addItem("5");
		Key_Thirteen.addItem("6");
		Key_Thirteen.addItem("7");
		Key_Thirteen.addItem("8");
		Key_Thirteen.addItem("9");
		userJPanel1.add(Key_Thirteen);

		Key_Thirteen1 = new JLabel("��13������:");
		Key_Thirteen1.setBounds(boundsuserJPanel1.width / 50,
				Key_Thirteenbounds.y, boundsuserJPanel1.width / 3,
				boundsuserJPanel1.height / 12);
		Key_Thirteen1.setFont(new Font("����", Font.BOLD,
				boundsuserJPanel1.height / 20));
		Key_Thirteen1.setForeground(new Color(0x57,0x57,0x57));
		userJPanel1.add(Key_Thirteen1);
		Key_Thirteen.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				int index = Key_Thirteen.getSelectedIndex();
				if (index != 0) { // ==0��ʾѡ�е��µ�һ��
					String content = Key_Thirteen.getSelectedItem().toString();
					map.put(13, Monkey_KEY.SetMapKey().get(content).toString());
					//System.out.println("map��ӳ��Ϊ��"+map.values().toString());
					System.out.println("ѡ�еļ�ֵΪ=" + index + ", content="
							+ content);
				}
				else {
					map.remove(13);
					System.out.println("ɾ��key 13��"+map.values().toString());
				}
			}
		});

		// ���õ�14����ֵ
		Key_Fourteen = new JComboBox();
		Rectangle Key_Fourteenbounds = new Rectangle(screenSize);
		Key_Fourteenbounds.y = Key_Thirteenbounds.y
				+ (boundsuserJPanel1.height / 10);
		Key_Fourteen.setBounds(boundsuserJPanel1.width / 3,
				Key_Fourteenbounds.y, boundsuserJPanel1.width / 3,
				boundsuserJPanel1.height / 12);
		Key_Fourteen.setFont(new Font("����", Font.BOLD,
				boundsuserJPanel1.height / 25));
		Key_Fourteen.setForeground(new Color(0x43,0x6E,0xEE));
		Key_Fourteen.addItem("��ѡ�񰴼�");
		Key_Fourteen.addItem("HOME");
		Key_Fourteen.addItem("BACK");
		Key_Fourteen.addItem("OK");
		Key_Fourteen.addItem("DOWN");
		Key_Fourteen.addItem("UP");
		Key_Fourteen.addItem("LEFT");
		Key_Fourteen.addItem("RIGHT");
		Key_Fourteen.addItem("0");
		Key_Fourteen.addItem("1");
		Key_Fourteen.addItem("2");
		Key_Fourteen.addItem("3");
		Key_Fourteen.addItem("4");
		Key_Fourteen.addItem("5");
		Key_Fourteen.addItem("6");
		Key_Fourteen.addItem("7");
		Key_Fourteen.addItem("8");
		Key_Fourteen.addItem("9");
		userJPanel1.add(Key_Fourteen);

		Key_Fourteen1 = new JLabel("��14������:");
		Key_Fourteen1.setBounds(boundsuserJPanel1.width / 50,
				Key_Fourteenbounds.y, boundsuserJPanel1.width / 3,
				boundsuserJPanel1.height / 12);
		Key_Fourteen1.setFont(new Font("����", Font.BOLD,
				boundsuserJPanel1.height / 20));
		Key_Fourteen1.setForeground(new Color(0x57,0x57,0x57));
		userJPanel1.add(Key_Fourteen1);
		Key_Fourteen.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				int index = Key_Fourteen.getSelectedIndex();
				if (index != 0) { // ==0��ʾѡ�е��µ�һ��
					String content = Key_Fourteen.getSelectedItem().toString();
					map.put(14, Monkey_KEY.SetMapKey().get(content).toString());
					//System.out.println("map��ӳ��Ϊ��"+map.values().toString());
					System.out.println("ѡ�еļ�ֵΪ=" + index + ", content="
							+ content);
				}
				else {
					map.remove(14);
					System.out.println("ɾ��key 14��"+map.values().toString());
				}
			}
		});

		RegularKey_RegularTime_OkJButton = new JButton("ȷ��");
		RegularKey_RegularTime_OkJButton
				.setBounds(bounds.x + bounds.width / 5, bounds.y
						+ (bounds.height / 6) * 5, bounds.width / 9,
						bounds.height / 20);
		RegularKey_RegularTime_OkJButton.setContentAreaFilled(false);
		 // ����ɫֵ������ã�ֻ��ռλ���ã����Ǳ�����ϴ˾䣬���򲻻����͸������Ч����
		RegularKey_RegularTime_OkJButton.setFont(new Font("����", Font.BOLD,
				boundsuserJPanel1.height / 20));
		RegularKey_RegularTime_OkJButton.setForeground(new Color(0x0A,0x0A,0x0A));
		RegularKey_RegularTime_OkJButton.setFocusPainted(false);
		contentPane.add(RegularKey_RegularTime_OkJButton);
		RegularKey_RegularTime_OkJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String IP_Port = IP.getText()+":"+Port.getText();
				if (IP.getText().equals("") | IP.getText()==null) {
					IP_Port = "000.000.000.000";
				}
				if (Port.getText().equals("") | Port.getText()==null) {
					IP_Port = IP.getText();
				}
				System.out.println("map.values():"+map.values());
				GUI_Button_Monitor okJButtonAction = new GUI_Button_Monitor();
				okJButtonAction.RegularKey_RegularTime_OkJButtonActionPerformed(event, SeleFolder.getText(), IP_Port, LoopCount.getText(),  1, 1, map, 1, 3, LoopTime.getText(),obj);
			}
		});

		 RegularKey_RegularTime_BackJButton = new JButton("����");
		 RegularKey_RegularTime_BackJButton
				.setBounds(bounds.x + (bounds.width / 5) * 3, bounds.y
						+ (bounds.height / 6) * 5, bounds.width / 9,
						bounds.height / 20);
		 RegularKey_RegularTime_BackJButton.setContentAreaFilled(false);
		; // ����ɫֵ������ã�ֻ��ռλ���ã����Ǳ�����ϴ˾䣬���򲻻����͸������Ч����
			// okJButton.setIcon(new
			// ImageIcon("bin/filechooser/image/rec.gif"));
		 RegularKey_RegularTime_BackJButton.setFont(new Font("����", Font.BOLD,
				boundsuserJPanel1.height / 20));
		 RegularKey_RegularTime_BackJButton.setForeground(new Color(0x0A,0x0A,0x0A));
		 RegularKey_RegularTime_BackJButton.setFocusPainted(false);
		contentPane.add( RegularKey_RegularTime_BackJButton);
		 RegularKey_RegularTime_BackJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				GUI_Button_Monitor backJButtonAction =new GUI_Button_Monitor();
				backJButtonAction. RegularKey_RegularTime_BackJButtonActionPerformed(event,obj);
			}
		});
		
		
		//�Ϸ�����

		LogoJLabel = new JLabel();
		LogoJLabel.setBounds((bounds.x + bounds.width / 256) * 101, bounds.y
				+ bounds.height / 24, bounds.width / 2, bounds.height / 8);
		LogoJLabel.setText("�̶���ֵ���̶�ʱ����");
		LogoJLabel.setFont(new Font("Serif", Font.BOLD , 44));
		LogoJLabel.setForeground(new Color(0x57,0x57,0x57));
		contentPane.add(LogoJLabel);

		// ������Ӧ��Ļ��С�ı���ͼƬ
		Image imgbackground = Toolkit.getDefaultToolkit().getImage(
				GUI_RegularKey_RegularTime.class.getClassLoader().getResource(
						"BackGroundConfig.jpg"));
		Image imgbackgroundbig = imgbackground.getScaledInstance(bounds.width, bounds.height,Image.SCALE_SMOOTH);
		pictureJLabel = new JLabel();
		pictureJLabel
				.setBounds(bounds.x, bounds.y, bounds.width, bounds.height);
		pictureJLabel.setIcon(new ImageIcon(imgbackgroundbig));
		contentPane.add(pictureJLabel);

		ImageIcon icon = new ImageIcon("pic.gif");
		setIconImage(icon.getImage());
		setTitle("����д�̶���ֵ���̶�ʱ�������Ϣ");
		setBounds(bounds);//���ô������
		setResizable(false); // ����󻯰�ť����Ϊ������
		Image img = Toolkit.getDefaultToolkit().getImage(
				GUI_RegularKey_RegularTime.class.getClassLoader().getResource(
						"Tray.png"));
		this.setIconImage(img);// ���ô������Ͻ�ͼ��
		//Tray("o.png");// ����ϵͳ����ͼ��

	}

	public void btnSelectactionPerformed(ActionEvent e) {
		if (e.getSource() == btnSelect) {

			/*
			 * ������Ϊ��Ҫ�ġ���ΪJFileChooserĬ�ϵ���ѡ���ļ�������ҪѡĿ¼�� ��Ҫ��DIRECTORIES_ONLYװ��ģ��
			 * ���⣬��ѡ���ļ���������˾�
			 */
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int intRetVal = fc.showOpenDialog(this);
			if (intRetVal == JFileChooser.APPROVE_OPTION) {
				SeleFolder.setText(fc.getSelectedFile().getPath());
				//System.out.println(SeleFolder.getText());
			}
		}
	}
	public GUI_RegularKey_RegularTime obj=null;
	
	public void GetObject(GUI_RegularKey_RegularTime ob) {
		
		obj = ob;
		
	}
	public static void main(String[] args) {
		// JFrame.setDefaultLookAndFeelDecorated(true);��windowĬ�ϱ����
		GUI_RegularKey_RegularTime mylogin = new GUI_RegularKey_RegularTime();
		mylogin.GetObject(mylogin);
		mylogin.setVisible(true);
		mylogin.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mylogin.addWindowListener(new WindowAdapter() {  
			  
			  
			public void windowClosing(WindowEvent e) {  
			super.windowClosing(e);  
			//���붯��  
			//  
			System.out.println("Ҫ�˳���");
			System.exit(0);
			 }  
			  
			}); 
		
	}

	
}
