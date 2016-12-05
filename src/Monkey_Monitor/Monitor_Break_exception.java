package Monkey_Monitor;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Monkey_GUI_Exception.GUI_Break_exception;
import Monkey_Middle.Middle_Close_Java;
import Monkey_Middle.Middle_Close_adb;
import Monkey_Middle.Middle_exec_python;
import Monkey_Middle.Middle_param;

public class Monitor_Break_exception implements Runnable {

	public static boolean break_ex = true;

	public static boolean isBreak_ex() {
		return break_ex;
	}

	public static void setBreak_ex(boolean break_ex) {
		Monitor_Break_exception.break_ex = break_ex;
	}

	private Process proc;

	@Override
	public void run() {
		// TODO Auto-generated method stub

		GUI_Break_exception break_exception = new GUI_Break_exception();
		break_exception.setVisible(true);
		break_exception.setDefaultCloseOperation(3);
		break_exception.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				// 加入动作
				//
				System.out.println("要退出了");
				if (ThreadPool.ThreadPoolexecutor.isShutdown()==false) {
					ThreadPool.ThreadPoolexecutor.shutdownNow();
				}
				new Middle_Close_adb();
				new Middle_Close_Java();
			}

		});
		Runtime runtime = Runtime.getRuntime();
		do {
			try {
				proc = runtime.exec("cmd /k adb connect " + Middle_param.getIp_Port());
			
			BufferedReader input = new BufferedReader(new InputStreamReader(
					proc.getInputStream(), "GBK"));
			String line = null;
			input = new BufferedReader(new InputStreamReader(
					proc.getInputStream(), "GBK"));
			line=input.readLine();
			if (line.contains("already connected")) {
				Middle_exec_python.setConnectEx(true);
			}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		} while (isBreak_ex()==false);
		break_exception.setVisible(false);
		setBreak_ex(true);
		/*Middle_exec_python exec_python =new Middle_exec_python();
		Thread thread = new Thread(exec_python);
		ThreadPool.ThreadPoolexecutor.execute(thread);*/
	}

}
