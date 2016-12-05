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

public class Middle_ErrorLOG_catch implements Runnable{

	public Process proc;
	public Monkey_Middle.Middle_CMDlog_Write monitor_cmd;
	public static boolean ConnectEx = true;
	public InputStream erStream;

	// 执行脚本
	public static boolean isConnectEx() {
		return ConnectEx;
	}

	public static void setConnectEx(boolean connectEx) {
		ConnectEx = connectEx;
	}
	public Middle_ErrorLOG_catch(Process pro, Monkey_Middle.Middle_CMDlog_Write monitor,InputStream errorStream){
		
		proc=pro;
		monitor_cmd=monitor;
		erStream = errorStream;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		BufferedReader input;
		try {
			input = new BufferedReader(new InputStreamReader(
					erStream, "GBK"));
			System.out.println("Middle_ErrorLOG_catch Start");
			String line = null;
			input = new BufferedReader(new InputStreamReader(
					erStream, "GBK"));
			while (Middle_exec_python.isLogWrite()) {
			if ((line = input.readLine()) != null) {

				if (line.contains("Error sending press event")|line.contains("ADB server didn't ACK")) {
					System.out.println(line);
					input.close();
					proc.destroy();
					Middle_exec_python.setLogWrite(false);
					new Middle_Close_adb();
					Thread.sleep(10000);
					System.out.println("脚本Error sending press event错误，将重启执行");
					//重启
					System.gc();
					Middle_exec_python exec_python = new Middle_exec_python();
					Thread exec_monitor_Thread = new Thread(exec_python);
					ThreadPool.ThreadPoolexecutor.execute(exec_monitor_Thread);
					//Monitor_BOXLog_Control.setOpenBoxLog(true);
					break;
				}
				boolean CMDWrite=monitor_cmd.CMDWrite(line);
				System.out.println("ERROR锁是否被释放"+CMDWrite);
				System.out.println("ERROR"+line);
			}}
			

		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	

