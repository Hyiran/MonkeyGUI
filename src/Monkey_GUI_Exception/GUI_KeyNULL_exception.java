package Monkey_GUI_Exception;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Monkey_Methods.Methods;

public class GUI_KeyNULL_exception extends JFrame {
	// private JComboBox nameJComboBox;
	private JLabel pictureJLabel1;
	private JButton closeJButton;
	private JLabel Prompt,Prompt1,Prompt2;

	Methods method = new Methods();

	public GUI_KeyNULL_exception() {
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


		// 提示
		Prompt1 = new JLabel(
				"键值至少填一个。且是必填项！");
		Prompt1.setBounds(bounds.x + bounds.width / 35, bounds.y + bounds.height
				/ 13, bounds.width, bounds.height / 13);
		Prompt1.setFont(new Font("楷体", Font.BOLD, bounds.height / 30));
		Prompt1.setForeground(Color.RED);
		add(Prompt1);
		// 提示
				Prompt2 = new JLabel(
						"请检查键值是否未填");
				Prompt2.setBounds(bounds.x + bounds.width / 35, bounds.y + bounds.height
						/ 8, bounds.width, bounds.height / 13);
				Prompt2.setFont(new Font("楷体", Font.BOLD, bounds.height / 30));
				Prompt2.setForeground(Color.RED);
				add(Prompt2);

		closeJButton = new JButton("关闭");
		closeJButton.setBounds(bounds.x + bounds.width / 6, bounds.y
				+ bounds.height / 3, (bounds.width / 30) * 4,
				bounds.height / 13);
		closeJButton.setContentAreaFilled(true);
		// 此颜色值随便设置，只起占位作用，但是必须加上此句，否则不会出现透明背景效果。
		closeJButton.setFont(new Font("楷体", Font.BOLD, bounds.height / 35));
		closeJButton.setForeground(Color.BLUE);
		closeJButton.setBackground(Color.WHITE);
		closeJButton.setFocusPainted(false);
		contentPane.add(closeJButton);
		closeJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				closeJButtonActionPerformed(event);
			}
		});
		setTitle("键值未填，请填写！");
		setBounds(bounds.x + bounds.width / 4, bounds.y + bounds.height / 4,
				bounds.width / 2, bounds.height / 2);
		contentPane.setBackground(Color.WHITE);
		setResizable(false); // 将最大化按钮设置为不可用
		Image img = Toolkit.getDefaultToolkit().getImage(
				GUI_KeyNULL_exception.class.getClassLoader().getResource(
						"Tray.png"));
		this.setIconImage(img);// 设置窗口左上角图标

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setVisible(false);
		return "";
	}

	
	private void closeJButtonActionPerformed(ActionEvent event) {
		setVisible(false);
	}




	public static void main(String[] args) {
		// JFrame.setDefaultLookAndFeelDecorated(true);用window默认标题框
		GUI_KeyNULL_exception close = new GUI_KeyNULL_exception();
		close.setVisible(true);
		close.setDefaultCloseOperation(1);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close.setVisible(false);

	}

}
