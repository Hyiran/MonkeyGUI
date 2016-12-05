package Monkey_Middle;

import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import Monkey_Generate_Python.Generate_Python_write;
import Monkey_Monitor.Monitor_BOXLog_Control;
import Monkey_Monitor.Monitor_Log_Compare;
import Monkey_Monitor.ThreadPool;

public class Middle_exec_monitor implements Runnable{

	
	public static boolean Timeout = true;
	Process proc = null;
	public static boolean  boxlogCounts = true;
	
	public static boolean isBoxlogCounts() {
		return boxlogCounts;
	}

	public static void setBoxlogCounts(boolean boxlogCounts) {
		Middle_exec_monitor.boxlogCounts = boxlogCounts;
	}

	public static boolean isTimeout() {
		return Timeout;
	}

	public static void setTimeout(boolean timeout) {
		Timeout = timeout;
	}

	
	public void run() {
		// 删除之前log文件
				if (new File(Middle_param.getToolsPath() + Middle_param.Log_name)
						.exists()) {
					File f = new File(Middle_param.getToolsPath()
							+ Middle_param.Log_name);
					System.out.println("删除PLOG结果：" + f.delete());
				}

				// 生成Python脚本
				Generate_Python_write g = new Generate_Python_write();
				g.Generate();

				// 执行Python脚本并开启监控
				int count = 1;
				Monkey_Monitor.Monitor_Log_Compare monitor_log = new Monitor_Log_Compare();
				Thread Monitor_Log = new Thread(monitor_log);// 建立monkey-python cmd\日志文件监控线程，监控大小是否更新
				Middle_exec_python exec = new Middle_exec_python();
				Thread exec_python = new Thread(exec);// 建立python脚本执行线程，执行生成的脚本
				ThreadPool.ThreadPoolexecutor.execute(exec_python);

				
				// 检测是否正常运行，若异常，做超时处理，主要针对CMD无输出
				while (Timeout) {

					try {
						Monitor_Log_Compare.setLogTh("RUN");
						//Future<?> future = execu.submit(Monitor_Log);
						Future<?> future = ThreadPool.ThreadPoolexecutor.submit(Monitor_Log);
						System.out.println("Monitor_Log_Compare Start");
						System.out.println("线程池中线程数目：" + ThreadPool.ThreadPoolexecutor.getPoolSize() + "，队列中等待执行的任务数目：" + ThreadPool.ThreadPoolexecutor.getQueue().size() + "，已执行玩别的任务数目：" + ThreadPool.ThreadPoolexecutor.getCompletedTaskCount());
						Object obj = future.get(1000 * 180, TimeUnit.MILLISECONDS); // 任务处理超时时间设为280秒,加下面的等待Monitor_Log_Compare线程停止的时间
						Monitor_Log_Compare.setLogTh("STOP");
						ThreadPool.ThreadPoolexecutor.remove(monitor_log);
						Thread.sleep(100000);
						System.out.println("任务成功返回:" + obj);
					} catch (TimeoutException ex) {
						System.out.println("处理超时啦....这是第" + count + "次了");
						count++;
						Monitor_Log_Compare.setLogTh("STOP");
						System.out.println("Monitor_Log_Compare STOP");
						Middle_exec_python.setLogWrite(false);
						if (ThreadPool.ThreadPoolexecutor.isShutdown()==false) {
							ThreadPool.ThreadPoolexecutor.shutdownNow();
						}
						new Middle_Close_adb();
						Middle_exec_python.setLogWrite(true);
						System.gc();
						new ThreadPool();
						Middle_exec_monitor exec_monitor = new Middle_exec_monitor();
						Thread exec_monitor_Thread = new Thread(exec_monitor);
						ThreadPool.ThreadPoolexecutor.execute(exec_monitor_Thread);
						ex.printStackTrace();
					} catch (Exception e) {
						System.out.println("处理失败.");
						
						e.printStackTrace();
						break;
					}

				}
				System.out.println("超时监控退出");

				try {
					Monitor_Log.interrupt();
					Monitor_Log.join(3000);
					exec_python.interrupt();
					exec_python.join(3000);
					Middle_exec_python.setLogWrite(false);
					if (ThreadPool.ThreadPoolexecutor.isShutdown()==false) {
						ThreadPool.ThreadPoolexecutor.shutdownNow();
					}
					new Middle_Close_adb();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Middle_exec_python.setLogWrite(false);
					if (ThreadPool.ThreadPoolexecutor.isShutdown()==false) {
						ThreadPool.ThreadPoolexecutor.shutdownNow();
					}
					new Middle_Close_adb();
					
				}

	}
}
