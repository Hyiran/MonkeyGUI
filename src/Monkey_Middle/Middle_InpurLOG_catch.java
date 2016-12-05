package Monkey_Middle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import Monkey_Monitor.Monitor_BOXLog_Control;
import Monkey_Monitor.Monitor_Break_exception;
import Monkey_Monitor.Monitor_Log_Compare;
import Monkey_Monitor.ThreadPool;

public class Middle_InpurLOG_catch implements Runnable{

	public Process proc;
	public Monkey_Middle.Middle_CMDlog_Write monitor_cmd;
	public InputStream inStream;
	public static boolean ConnectEx = true;

	// 执行脚本
	public static boolean isConnectEx() {
		return ConnectEx;
	}

	public static void setConnectEx(boolean connectEx) {
		ConnectEx = connectEx;
	}
	public Middle_InpurLOG_catch(Process pro, Monkey_Middle.Middle_CMDlog_Write monitor ,InputStream inputStream){
		
		proc=pro;
		monitor_cmd=monitor;
		inStream = inputStream;
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		BufferedReader input;
		try {
			input = new BufferedReader(new InputStreamReader(
					inStream, "GBK"));
			System.out.println("Middle_InpurLOG_catch Start");
			String line = null;
			input = new BufferedReader(new InputStreamReader(
					inStream, "GBK"));
			while (Middle_exec_python.isLogWrite()) {
			if ((line = input.readLine()) != null) {

				if (line.contains("device connect is OK")) {
					if (Middle_exec_monitor.isBoxlogCounts()) {//首次运行生成isBoxlogCounts为true
						System.out.println("INPUT:生成BOXLog");
						Monitor_BOXLog_Control boxLog_Control = new Monitor_BOXLog_Control();
						Thread boxlog = new Thread(boxLog_Control);//建立机顶盒log输出线程
						ThreadPool.ThreadPoolexecutor.execute(boxlog);
						//Middle_exec_monitor.setBoxlogCounts(false);//至isBoxlogCounts为false，不重新生成
					}
					
				}
				// 判断adb连接是否异常
				if (line.contains("unable to connect to")) {
					Monitor_Break_exception.setBreak_ex(false);
					setConnectEx(false);
					Monitor_Break_exception break_exception = new Monitor_Break_exception();
					Thread break_exception_th = new Thread(break_exception);
					ThreadPool.ThreadPoolexecutor
							.execute(break_exception_th);
					while (isConnectEx() == false) {
						Thread.sleep(5000);
					}
					System.out.println("adb连接异常，即将重连");
					//重启
					input.close();
					proc.destroy();
					Middle_exec_python.setLogWrite(false);
					new Middle_Close_adb();
					Thread.sleep(5000);
					System.gc();
					Middle_exec_python exec_python = new Middle_exec_python();
					Thread exec_monitor_Thread = new Thread(exec_python);
					ThreadPool.ThreadPoolexecutor.execute(exec_monitor_Thread);
					break;
				}

				//正常执行完毕退出
				if (line.contains("CMDOUT")) {
					System.out.println("INPUT:"+line);
					proc.destroy();
					input.close();
					Monitor_Log_Compare.setLogTh("STOP");
					Middle_exec_monitor.setTimeout(false);
					System.out.println("脚本执行完毕");
					new Middle_Close_adb();
					new Middle_Close_Java();
					if (ThreadPool.ThreadPoolexecutor.isShutdown() == false) {
						ThreadPool.ThreadPoolexecutor.shutdownNow();
						System.exit(0);
					}
				}
				boolean CMDWrite=monitor_cmd.CMDWrite(line);
				//System.out.println("INPUT锁是否被释放"+CMDWrite);
				System.out.println("INPUT:"+line);
			}}
			
			
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	

