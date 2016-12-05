package Monkey_Monitor;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Monkey_Middle.Middle_Open_BoxLog;
import Monkey_Middle.Middle_param;

//控制log是否输出到本地
public class Monitor_BOXLog_Control implements Runnable {

	String Toolspath;

	public static boolean OpenBoxLog = false;

	public static boolean isOpenBoxLog() {
		return OpenBoxLog;
	}

	public static void setOpenBoxLog(boolean openBoxLog) {
		OpenBoxLog = openBoxLog;
	}

	int n = 0;

	@Override
	public void run() {
		try {
				System.err.println(isOpenBoxLog());
					System.err.println("已进入BOXlog if条件内");
					/*
					 * Middle_Open_BoxLog.setOpenBoxlogWrite(false);
					 * Thread.sleep(2000);
					 */
					SimpleDateFormat df = new SimpleDateFormat(
							"yyyy-MM-dd-HH-mm-ss");// 设置日期格式
					String ToolspathDirectory = Middle_param.getToolsPath()
							+ "BOX_LOG";
					String IP = Middle_param.getIp_Port().substring(0,
							Middle_param.getIp_Port().lastIndexOf(":"));
					Toolspath = Middle_param.getToolsPath() + "BOX_LOG\\BoxLog"
							+ IP + "--" + df.format(new Date()) + ".txt";
					// System.out.println(Toolspath);// new Date()为获取当前系统时间
					File file = new File(ToolspathDirectory);
					// 如果文件夹不存在则创建
					if (!file.exists() && !file.isDirectory()) {
						System.out.println("//BOXLOG文件夹不存在，将为您创建");
						file.mkdir();
					}
					if (!new File(Toolspath).exists()) {
						try {
							new File(Toolspath).createNewFile();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					Middle_Open_BoxLog middle_Open_BoxLog=new Middle_Open_BoxLog(Toolspath);
					Thread open_boxlog = new Thread(middle_Open_BoxLog);
					ThreadPool.ThreadPoolexecutor.execute(open_boxlog);					
					System.err.println("已经开启机顶盒log，log存在于：" + Toolspath);
				Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("BOXLOG完成");
	}
}
