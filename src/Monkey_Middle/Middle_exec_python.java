package Monkey_Middle;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.SequenceInputStream;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.swing.plaf.SliderUI;

import Monkey_GUI_Exception.GUI_Break_exception;
import Monkey_Generate_Python.Generate_Python_write;
import Monkey_Generate_Python.Monkey_KEY;
import Monkey_Monitor.Monitor_BOXLog_Control;
import Monkey_Monitor.Monitor_Break_exception;
import Monkey_Monitor.Monitor_Log_Compare;
import Monkey_Monitor.ThreadPool;

public class Middle_exec_python implements Runnable {

	public Process proc = null;
	public static boolean ConnectEx = true;


	// Ö´ÐÐ½Å±¾
	public static boolean LogWrite = true;
	public static boolean isLogWrite() {
		return LogWrite;
	}

	public static void setLogWrite(boolean logWrite) {
		LogWrite = logWrite;
	}

	public static boolean isConnectEx() {
		return ConnectEx;
	}

	public static void setConnectEx(boolean connectEx) {
		ConnectEx = connectEx;
	}

	public void run() {
		String IP_Port = Middle_param.getIp_Port();
		String ToolsPath = Middle_param.getToolsPath()
				+ Middle_param.Python_name;
		System.out.println("IP_Port:" + IP_Port);
		System.out.println("ToolsPath:" + ToolsPath);
		Runtime runtime = Runtime.getRuntime();
		try {
			if (proc != null) {
				proc.destroy();
			}
/*			proc = runtime.exec("cmd /k echo on && adb disconnect " + IP_Port
					+ "&& adb connect " + IP_Port + " && monkeyrunner "
					+ ToolsPath +" && echo CMDOUT");*/
			proc = runtime.exec("cmd /k echo on && adb disconnect && adb connect " + IP_Port + " && monkeyrunner "
					+ ToolsPath +" && echo CMDOUT");
			InputStream inputStream = proc.getInputStream();
			InputStream errorStream = proc.getErrorStream();
			setLogWrite(true);
			Monkey_Middle.Middle_CMDlog_Write monitor_cmd = new Middle_CMDlog_Write();
			Middle_InpurLOG_catch inpurLOG_catch = new Middle_InpurLOG_catch(proc, monitor_cmd,inputStream);
			Thread inpurLOG_catch_Thread = new Thread(inpurLOG_catch);
			Middle_ErrorLOG_catch errorLOG_catch = new Middle_ErrorLOG_catch(proc, monitor_cmd,errorStream);
			Thread errorLOG_catch_Thread = new Thread(errorLOG_catch);
			ThreadPool.ThreadPoolexecutor.execute(inpurLOG_catch_Thread);
			ThreadPool.ThreadPoolexecutor.execute(errorLOG_catch_Thread);
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
	}
}
