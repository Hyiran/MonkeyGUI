package Monkey_Monitor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

	public  static ThreadPoolExecutor ThreadPoolexecutor = null;

	public ThreadPool(){
		ThreadPoolexecutor = new ThreadPoolExecutor(20, 30, 300, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(5));
	}

	
}
