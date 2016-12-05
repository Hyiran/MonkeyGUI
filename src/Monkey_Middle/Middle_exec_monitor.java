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
		// ɾ��֮ǰlog�ļ�
				if (new File(Middle_param.getToolsPath() + Middle_param.Log_name)
						.exists()) {
					File f = new File(Middle_param.getToolsPath()
							+ Middle_param.Log_name);
					System.out.println("ɾ��PLOG�����" + f.delete());
				}

				// ����Python�ű�
				Generate_Python_write g = new Generate_Python_write();
				g.Generate();

				// ִ��Python�ű����������
				int count = 1;
				Monkey_Monitor.Monitor_Log_Compare monitor_log = new Monitor_Log_Compare();
				Thread Monitor_Log = new Thread(monitor_log);// ����monkey-python cmd\��־�ļ�����̣߳���ش�С�Ƿ����
				Middle_exec_python exec = new Middle_exec_python();
				Thread exec_python = new Thread(exec);// ����python�ű�ִ���̣߳�ִ�����ɵĽű�
				ThreadPool.ThreadPoolexecutor.execute(exec_python);

				
				// ����Ƿ��������У����쳣������ʱ������Ҫ���CMD�����
				while (Timeout) {

					try {
						Monitor_Log_Compare.setLogTh("RUN");
						//Future<?> future = execu.submit(Monitor_Log);
						Future<?> future = ThreadPool.ThreadPoolexecutor.submit(Monitor_Log);
						System.out.println("Monitor_Log_Compare Start");
						System.out.println("�̳߳����߳���Ŀ��" + ThreadPool.ThreadPoolexecutor.getPoolSize() + "�������еȴ�ִ�е�������Ŀ��" + ThreadPool.ThreadPoolexecutor.getQueue().size() + "����ִ������������Ŀ��" + ThreadPool.ThreadPoolexecutor.getCompletedTaskCount());
						Object obj = future.get(1000 * 180, TimeUnit.MILLISECONDS); // ������ʱʱ����Ϊ280��,������ĵȴ�Monitor_Log_Compare�߳�ֹͣ��ʱ��
						Monitor_Log_Compare.setLogTh("STOP");
						ThreadPool.ThreadPoolexecutor.remove(monitor_log);
						Thread.sleep(100000);
						System.out.println("����ɹ�����:" + obj);
					} catch (TimeoutException ex) {
						System.out.println("����ʱ��....���ǵ�" + count + "����");
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
						System.out.println("����ʧ��.");
						
						e.printStackTrace();
						break;
					}

				}
				System.out.println("��ʱ����˳�");

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
