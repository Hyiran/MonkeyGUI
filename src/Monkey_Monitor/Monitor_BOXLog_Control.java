package Monkey_Monitor;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Monkey_Middle.Middle_Open_BoxLog;
import Monkey_Middle.Middle_param;

//����log�Ƿ����������
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
					System.err.println("�ѽ���BOXlog if������");
					/*
					 * Middle_Open_BoxLog.setOpenBoxlogWrite(false);
					 * Thread.sleep(2000);
					 */
					SimpleDateFormat df = new SimpleDateFormat(
							"yyyy-MM-dd-HH-mm-ss");// �������ڸ�ʽ
					String ToolspathDirectory = Middle_param.getToolsPath()
							+ "BOX_LOG";
					String IP = Middle_param.getIp_Port().substring(0,
							Middle_param.getIp_Port().lastIndexOf(":"));
					Toolspath = Middle_param.getToolsPath() + "BOX_LOG\\BoxLog"
							+ IP + "--" + df.format(new Date()) + ".txt";
					// System.out.println(Toolspath);// new Date()Ϊ��ȡ��ǰϵͳʱ��
					File file = new File(ToolspathDirectory);
					// ����ļ��в������򴴽�
					if (!file.exists() && !file.isDirectory()) {
						System.out.println("//BOXLOG�ļ��в����ڣ���Ϊ������");
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
					System.err.println("�Ѿ�����������log��log�����ڣ�" + Toolspath);
				Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("BOXLOG���");
	}
}
