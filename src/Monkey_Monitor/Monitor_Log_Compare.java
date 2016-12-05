package Monkey_Monitor;

import java.io.File;
import java.io.IOException;
import Monkey_Middle.Middle_param;


//监控weite1.txt，监控Exec_python类run（）对其有无更新，无更新则任务不结束，Exec_python类main函数捕获到未更新操作重启run()
public class Monitor_Log_Compare implements Runnable {

	public static long file_lengh;
	public static boolean file_EX = true;
	public static String LogTh = "RUN";

	public static long getFile_lengh() {
		return file_lengh;
	}

	public static void setFile_lengh(long file_lengh) {
		Monitor_Log_Compare.file_lengh = file_lengh;
	}

	public static boolean isFile_EX() {
		return file_EX;
	}

	public static void setFile_EX(boolean file_EX) {
		Monitor_Log_Compare.file_EX = file_EX;
	}

	public static String getLogTh() {
		return LogTh;
	}

	public static void setLogTh(String logTh) {
		LogTh = logTh;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String Toolspath = Middle_param.getToolsPath()+Middle_param.Log_name;
		if (!new File(Toolspath).exists()) {
			try {
				new File(Toolspath).createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		File f = new File(Toolspath);
		if (f.exists() && f.isFile()) {
			setFile_lengh(f.length());
			System.out.println("The Frist f.length():" + getFile_lengh());
		}
		//间隔一定的时间获取文件大小进行比对
		while (getLogTh().equals("RUN")) {
			try {
				Thread.sleep(50000);
				System.out.println("wait 50s");
				if (getFile_lengh() == f.length()) {
					System.out.println("The f.length()==The getFile_lengh(),值为:"+ f.length());
					Thread.sleep(10000);
					System.out.println("wait 10s");
					setFile_EX(false);
				} else {
					System.out.println("The getFile_lengh():" + getFile_lengh());
					System.out.println("The f.length()" + f.length());
					setFile_EX(true);
					break;
				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}// 50s

		}
		System.out.println("log监控退出");

	}
}
