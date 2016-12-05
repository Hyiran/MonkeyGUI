package Monkey_GUI;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

public class GUI_Move_Label extends JLabel implements Runnable {

	private static final long serialVersionUID = 1891684760189602720L;

	private String text = null;

	public static boolean Rollset = true;
	

	private int x = 0;

	private int w = 0, h = 0;

	public static boolean isRollset() {
		return Rollset;
	}

	public static void setRollset(boolean rollset) {
		Rollset = rollset;
	}

	public GUI_Move_Label(String text) {
		super(text);
		this.text = text;
		
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		super.setText(text);
		this.text = text;
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(0x2F, 0x4F, 0x4F));
		g.fillRect(0, 0, w = this.getWidth(), h = this.getHeight());
		g.setColor(this.getForeground());
		g.setFont(this.getFont());
		g.drawString(text, x, h - 2);
	}

	public void run() {
		while (isRollset()) {
			x -= 2;
			if (x < -w) {
				x = w;
			}
			this.repaint();
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("ÍË³ö¹ö¶¯");
	}
}
