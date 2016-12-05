package Monkey_GUI;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Monkey_Middle.Middle_Close_Java;
import Monkey_Middle.Middle_Close_adb;
import Monkey_Monitor.ThreadPool;

public class GUI_close_run implements Runnable {



	public void run() {
		// TODO Auto-generated method stub
		GUI_Close Close = new GUI_Close();
		Close.setVisible(true);
		Close.setDefaultCloseOperation(3);
		Close.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				// 加入动作
				//
				System.out.println("要退出了");
				if (ThreadPool.ThreadPoolexecutor.isShutdown() == false) {
					ThreadPool.ThreadPoolexecutor.shutdownNow();
				}
				new Middle_Close_adb();
				new Middle_Close_Java();
			}

		});
	}


}
