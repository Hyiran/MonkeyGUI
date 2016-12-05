package Monkey_GUI_Exception;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Monkey_GUI.GUI_RegularKey_RegularTime;
import Monkey_Methods.Methods;
import Monkey_Middle.Middle_Close_Java;
import Monkey_Middle.Middle_Close_adb;
import Monkey_Monitor.ThreadPool;

public class GUI_Break_exception extends JFrame {
	// private JComboBox nameJComboBox;
	private JLabel pictureJLabel1;
	private JButton closeJButton;
	private JLabel Prompt,Prompt1,Prompt2;

	Methods method = new Methods();

	public GUI_Break_exception() {
		createUserInterface();
		// TODO Auto-generated constructor stub
	}

	private String createUserInterface() {

		Container contentPane = getContentPane();
		contentPane.setLayout(null);

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

		// ��ʾ
		Prompt = new JLabel(
				"������ʾ��Ŀǰadb�Ѿ�ʧȥ���ӣ����ڳ���������");
		Prompt.setBounds(bounds.x + bounds.width / 29, bounds.y + bounds.height
				/ 30, bounds.width, bounds.height / 13);
		Prompt.setFont(new Font("����", Font.BOLD, bounds.height / 30));
		Prompt.setForeground(Color.RED);
		add(Prompt);

		// ��ʾ
		Prompt1 = new JLabel(
				"����رճ��򣬲鿴����״̬����������");
		Prompt1.setBounds(bounds.x + bounds.width / 29, bounds.y + bounds.height
				/ 13, bounds.width, bounds.height / 13);
		Prompt1.setFont(new Font("����", Font.BOLD, bounds.height / 30));
		Prompt1.setForeground(Color.RED);
		add(Prompt1);

		// ��ʾ
		Prompt2 = new JLabel(
				"���ȴ�����������ر�,�����ɹ�����ʾ���Զ���ʧ��");
		Prompt2.setBounds(bounds.x + bounds.width / 29, bounds.y + bounds.height
				/ 8, bounds.width, bounds.height / 13);
		Prompt2.setFont(new Font("����", Font.BOLD, bounds.height / 30));
		Prompt2.setForeground(Color.RED);
		add(Prompt2);

		// �Ϸ���̬ͼ
		pictureJLabel1 = new JLabel();
		pictureJLabel1.setBounds(bounds.x + bounds.width / 5, bounds.y
				+ bounds.height / 6, bounds.width / 4, bounds.height / 6);
		pictureJLabel1.setIcon(new ImageIcon("Connect.gif"));
		contentPane.add(pictureJLabel1);

		closeJButton = new JButton("�ر�");
		closeJButton.setBounds(bounds.x + bounds.width / 6, bounds.y
				+ bounds.height / 3, (bounds.width / 30) * 4,
				bounds.height / 13);
		closeJButton.setContentAreaFilled(true);
		// ����ɫֵ������ã�ֻ��ռλ���ã����Ǳ�����ϴ˾䣬���򲻻����͸������Ч����
		closeJButton.setFont(new Font("����", Font.BOLD, bounds.height / 35));
		closeJButton.setForeground(Color.BLUE);
		closeJButton.setBackground(Color.WHITE);
		closeJButton.setFocusPainted(false);
		contentPane.add(closeJButton);
		closeJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				closeJButtonActionPerformed(event);
			}
		});
		setTitle("����ʧ��---��������");
		setBounds(bounds.x + bounds.width / 4, bounds.y + bounds.height / 4,
				bounds.width / 2, bounds.height / 2);
		contentPane.setBackground(Color.WHITE);
		setResizable(false); // ����󻯰�ť����Ϊ������
		Image img = Toolkit.getDefaultToolkit().getImage(
				GUI_Break_exception.class.getClassLoader().getResource(
						"Tray.png"));
		this.setIconImage(img);// ���ô������Ͻ�ͼ��
		// Tray("o.png");// ����ϵͳ����ͼ��

		return "";
	}

	
	private void closeJButtonActionPerformed(ActionEvent event) {
		if (ThreadPool.ThreadPoolexecutor.isShutdown()==false) {
			ThreadPool.ThreadPoolexecutor.shutdownNow();	
		}
		new Middle_Close_adb();
		new Middle_Close_Java();
		System.exit(0);

	}


	public GUI_RegularKey_RegularTime obj = null;

	public void GetObject(GUI_RegularKey_RegularTime ob) {
		// TODO Auto-generated method stub
		obj = ob;
	}

	public static void main(String[] args) {
		// JFrame.setDefaultLookAndFeelDecorated(true);��windowĬ�ϱ����
		GUI_Break_exception close = new GUI_Break_exception();
		close.setVisible(true);
		close.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}
