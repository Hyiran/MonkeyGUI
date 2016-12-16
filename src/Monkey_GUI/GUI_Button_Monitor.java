package Monkey_GUI;

import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;

import javax.swing.JDialog;
import javax.swing.JFileChooser;

import Monkey_GUI_Exception.GUI_DirectoryWrong_exception;
import Monkey_GUI_Exception.GUI_KeyNULL_exception;
import Monkey_GUI_Exception.GUI_KeyWrong_exception;
import Monkey_GUI_Exception.GUI_TextNULL_exception;
import Monkey_Generate_Python.Monkey_KEY;
import Monkey_Methods.Methods;
import Monkey_Middle.Middle_Close_Java;
import Monkey_Middle.Middle_Close_adb;
import Monkey_Middle.Middle_param;
import Monkey_Middle.Middle_param_Set;
import Monkey_Monitor.ThreadPool;

public class GUI_Button_Monitor {

	public static int MapTrue;

	public static int getMapTrue() {
		return MapTrue;
	}

	public static void setMapTrue(int mapTrue) {
		MapTrue = mapTrue;
	}

	protected void RegularKey_RegularTime_OkJButtonActionPerformed(
			ActionEvent event, String ToolsPath, String IP_Port,
			String loopcount, int key, int Time, HashMap map, double TimeStart,
			double TimeEND, String RegularTimeCode, GUI_RegularKey_RegularTime obj) {

		Methods method = new Methods();
		if (!IP_Port.contains(":")) {
			IP_Port = IP_Port + ":5555";
		}
		boolean TextNull = method.TextNull(ToolsPath,
				IP_Port.substring(0, IP_Port.lastIndexOf(":")), loopcount,
				RegularTimeCode);
		boolean DirectoryFind = method.DirectoryFind(ToolsPath);
		setMapTrue(method.MapTrue(map));
/*		GUI_Start_Show close = new GUI_Start_Show();
		close.setVisible(true);
		close.setDefaultCloseOperation(1);*/

		if (TextNull == false) {
			//close.setVisible(false);
			GUI_TextNULL_exception gui_TextNULL_exception = new GUI_TextNULL_exception();
			gui_TextNULL_exception.setVisible(true);
			gui_TextNULL_exception.setDefaultCloseOperation(1);
			System.out.println("选择文件、IP地址、循环次数、循环时间。是必填项！请检查是否有未填项");
		} else if (DirectoryFind == false) {
			//close.setVisible(false);
			GUI_DirectoryWrong_exception directoryWrong_exception = new GUI_DirectoryWrong_exception();
			directoryWrong_exception.setVisible(true);
			directoryWrong_exception.setDefaultCloseOperation(1);
			System.out.println("选择文件夹有误");
		} else if (getMapTrue() != 0) {
			//close.setVisible(false);
			GUI_KeyWrong_exception keyWrong_exception = new GUI_KeyWrong_exception();
			keyWrong_exception.setVisible(true);
			keyWrong_exception.setDefaultCloseOperation(1);
			System.out.println("请填写第" + MapTrue + "个键值");
		} else if (map.isEmpty()) {
			//close.setVisible(false);
			GUI_KeyNULL_exception gKeyNULL_exception = new GUI_KeyNULL_exception();
			gKeyNULL_exception.setVisible(true);
			gKeyNULL_exception.setDefaultCloseOperation(1);
			System.out.println("请至少填一个键值");
		}
/*
		else if (!method.FirstConnectCheck(IP_Port).equals("success")) {
			//close.setVisible(false);
			GUI_Connect_exception gConnect_exception = new GUI_Connect_exception();
			gConnect_exception.setVisible(true);
			gConnect_exception.setDefaultCloseOperation(1);
			System.out.println("填写的IP与端口无法正常进行adb连接，请确认是否正确");
		}*/

		else if (TextNull && DirectoryFind && MapTrue == 0) {
			obj.setEnabled(false);
			//close.setVisible(false);
			int looptype = method.Looptype(loopcount);
			int Loopcount = Integer.parseInt(loopcount);
			double regulartimecode = Double.parseDouble(RegularTimeCode);
			Middle_param_Set middle_param_Set = new Middle_param_Set();
			ToolsPath = ToolsPath + "\\";
			middle_param_Set.param_set(ToolsPath, IP_Port, Loopcount, looptype,
					key, Time, map, TimeStart, TimeEND, regulartimecode);

			System.out.println("您输入的参数为：");
			System.out.println("Toolspath：" + Middle_param.getToolsPath());
			System.out.println("IP_Port：" + Middle_param.getIp_Port());
			System.out.println("loopcount：" + Middle_param.getLoopcount());
			System.out.println("looptype：" + Middle_param.getLooptype());
			System.out.println("key：" + Middle_param.getKey());
			System.out.println("Time：" + Middle_param.getTime());
			System.out.println("map：" + Middle_param.getMap().values());
			System.out.println("TimeStart：" + Middle_param.getTimeStart());
			System.out.println("TimeEND：" + Middle_param.getTimeEND());
			System.out.println("RegularTimeCode："
					+ Middle_param.getRegularTimeCode());

			GUI_RegularKey_RegularTime_SuccessSet Succ = new GUI_RegularKey_RegularTime_SuccessSet();
			Succ.GetObject(obj, Succ);
			Succ.setVisible(true);
		}
		/*
		 * ThreadPool.ThreadPoolexecutor .execute(new
		 * GUI_RegularKey_RegularTime());
		 */

		// Succ.setAlwaysOnTop(true);
		/*
		 * Succ.addWindowListener(new WindowAdapter() {
		 * 
		 * public void windowClosing(WindowEvent e) { super.windowClosing(e); //
		 * 加入动作 // System.out.println("要退出了"); System.exit(0); }
		 * 
		 * });
		 */
	}

	protected void RegularKey_RegularTime_BackJButtonActionPerformed(
			ActionEvent event, GUI_RegularKey_RegularTime obj) {

		GUI_Move_Label.setRollset(true);
		GUI_main mian = new GUI_main();
		mian.setVisible(true);
		mian.setDefaultCloseOperation(3);
		obj.setVisible(false);
		if (ThreadPool.ThreadPoolexecutor.isShutdown() == false) {
			ThreadPool.ThreadPoolexecutor.shutdownNow();
		}
		new Middle_Close_adb();
		new Middle_Close_Java();
	}

	public void RegularKey_RandomTime_BackJButtonActionPerformed(
			ActionEvent event, GUI_RegularKey_RandomTime obj) {
		// TODO Auto-generated method stub
		

		GUI_Move_Label.setRollset(true);
		GUI_main mian = new GUI_main();
		mian.setVisible(true);
		mian.setDefaultCloseOperation(3);
		obj.setVisible(false);
		if (ThreadPool.ThreadPoolexecutor.isShutdown() == false) {
			ThreadPool.ThreadPoolexecutor.shutdownNow();
		}
		new Middle_Close_adb();
		new Middle_Close_Java();
	
	}

	public void RegularKey_RandomTime_OkJButtonActionPerformed(
			ActionEvent event, String ToolsPath, String IP_Port,
			String loopcount, int key, int Time, HashMap map, String TimeStart,
			String TimeEND, String RegularTimeCode, GUI_RegularKey_RandomTime obj) {
		// TODO Auto-generated method stub

		Methods method = new Methods();
		if (!IP_Port.contains(":")) {
			IP_Port = IP_Port + ":5555";
		}
		boolean TextNull = method.TextNull(ToolsPath,
				IP_Port.substring(0, IP_Port.lastIndexOf(":")), loopcount,
				TimeStart,TimeEND);
		boolean DirectoryFind = method.DirectoryFind(ToolsPath);
		setMapTrue(method.MapTrue(map));
/*		GUI_Start_Show close = new GUI_Start_Show();
		close.setVisible(true);
		close.setDefaultCloseOperation(1);*/

		if (TextNull == false) {
			//close.setVisible(false);
			GUI_TextNULL_exception gui_TextNULL_exception = new GUI_TextNULL_exception();
			gui_TextNULL_exception.setVisible(true);
			gui_TextNULL_exception.setDefaultCloseOperation(1);
			System.out.println("选择文件、IP地址、循环次数、循环时间。是必填项！请检查是否有未填项");
		} else if (DirectoryFind == false) {
			//close.setVisible(false);
			GUI_DirectoryWrong_exception directoryWrong_exception = new GUI_DirectoryWrong_exception();
			directoryWrong_exception.setVisible(true);
			directoryWrong_exception.setDefaultCloseOperation(1);
			System.out.println("选择文件夹有误");
		} else if (getMapTrue() != 0) {
			//close.setVisible(false);
			GUI_KeyWrong_exception keyWrong_exception = new GUI_KeyWrong_exception();
			keyWrong_exception.setVisible(true);
			keyWrong_exception.setDefaultCloseOperation(1);
			System.out.println("请填写第" + MapTrue + "个键值");
		} else if (map.isEmpty()) {
			//close.setVisible(false);
			GUI_KeyNULL_exception gKeyNULL_exception = new GUI_KeyNULL_exception();
			gKeyNULL_exception.setVisible(true);
			gKeyNULL_exception.setDefaultCloseOperation(1);
			System.out.println("请至少填一个键值");
		}

		else if (Double.parseDouble(TimeStart)>=Double.parseDouble(TimeEND) ){
			//close.setVisible(false);

			System.out.println("请填写的时间范围前者小于后者");
		}

		else if (TextNull && DirectoryFind && MapTrue == 0) {
			obj.setEnabled(false);
			//close.setVisible(false);
			int looptype = method.Looptype(loopcount);
			int Loopcount = Integer.parseInt(loopcount);
			double regulartimecode = Double.parseDouble(RegularTimeCode);
			double StartTime = Double.parseDouble(TimeStart);
			double EndTime = Double.parseDouble(TimeEND);
			Middle_param_Set middle_param_Set = new Middle_param_Set();
			ToolsPath = ToolsPath + "\\";
			middle_param_Set.param_set(ToolsPath, IP_Port, Loopcount, looptype,
					key, Time, map, StartTime, EndTime, regulartimecode);

			System.out.println("您输入的参数为：");
			System.out.println("Toolspath：" + Middle_param.getToolsPath());
			System.out.println("IP_Port：" + Middle_param.getIp_Port());
			System.out.println("loopcount：" + Middle_param.getLoopcount());
			System.out.println("looptype：" + Middle_param.getLooptype());
			System.out.println("key：" + Middle_param.getKey());
			System.out.println("Time：" + Middle_param.getTime());
			System.out.println("map：" + Middle_param.getMap().values());
			System.out.println("TimeStart：" + Middle_param.getTimeStart());
			System.out.println("TimeEND：" + Middle_param.getTimeEND());
			System.out.println("RegularTimeCode："
					+ Middle_param.getRegularTimeCode());

			GUI_RegularKey_RandomTime_SuccessSet Succ = new GUI_RegularKey_RandomTime_SuccessSet();
			Succ.GetObject(obj, Succ);
			Succ.setVisible(true);
		}
		
		
	}

	public void RandomKey_RegularTime_OkJButtonActionPerformed(
			ActionEvent event, String ToolsPath, String IP_Port,
			String loopcount, int key, int Time, HashMap map, String TimeStart,
			String TimeEND, String RegularTimeCode, GUI_RandomKey_RegularTime obj) {
		// TODO Auto-generated method stub
		Methods method = new Methods();
		if (!IP_Port.contains(":")) {
			IP_Port = IP_Port + ":5555";
		}
		boolean TextNull = method.TextNull(ToolsPath,
				IP_Port.substring(0, IP_Port.lastIndexOf(":")), loopcount,
				TimeStart,TimeEND);
		boolean DirectoryFind = method.DirectoryFind(ToolsPath);
		setMapTrue(method.MapTrue(map));


		if (TextNull == false) {
			//close.setVisible(false);
			GUI_TextNULL_exception gui_TextNULL_exception = new GUI_TextNULL_exception();
			gui_TextNULL_exception.setVisible(true);
			gui_TextNULL_exception.setDefaultCloseOperation(1);
			System.out.println("选择文件、IP地址、循环次数、循环时间。是必填项！请检查是否有未填项");
		} else if (DirectoryFind == false) {
			//close.setVisible(false);
			GUI_DirectoryWrong_exception directoryWrong_exception = new GUI_DirectoryWrong_exception();
			directoryWrong_exception.setVisible(true);
			directoryWrong_exception.setDefaultCloseOperation(1);
			System.out.println("选择文件夹有误");
		} else if (getMapTrue() != 0) {
			//close.setVisible(false);
			GUI_KeyWrong_exception keyWrong_exception = new GUI_KeyWrong_exception();
			keyWrong_exception.setVisible(true);
			keyWrong_exception.setDefaultCloseOperation(1);
			System.out.println("请填写第" + MapTrue + "个键值");
		} else if (map.isEmpty()) {
			//close.setVisible(false);
			GUI_KeyNULL_exception gKeyNULL_exception = new GUI_KeyNULL_exception();
			gKeyNULL_exception.setVisible(true);
			gKeyNULL_exception.setDefaultCloseOperation(1);
			System.out.println("请至少填一个键值");
		}
		else if (TextNull && DirectoryFind && MapTrue == 0) {
			obj.setEnabled(false);
			//close.setVisible(false);
			int looptype = method.Looptype(loopcount);
			int Loopcount = Integer.parseInt(loopcount);
			double regulartimecode = Double.parseDouble(RegularTimeCode);
			double StartTime = Double.parseDouble(TimeStart);
			double EndTime = Double.parseDouble(TimeEND);
			Middle_param_Set middle_param_Set = new Middle_param_Set();
			ToolsPath = ToolsPath + "\\";
			middle_param_Set.param_set(ToolsPath, IP_Port, Loopcount, looptype,
					key, Time, map, StartTime, EndTime, regulartimecode);

			System.out.println("您输入的参数为：");
			System.out.println("Toolspath：" + Middle_param.getToolsPath());
			System.out.println("IP_Port：" + Middle_param.getIp_Port());
			System.out.println("loopcount：" + Middle_param.getLoopcount());
			System.out.println("looptype：" + Middle_param.getLooptype());
			System.out.println("key：" + Middle_param.getKey());
			System.out.println("Time：" + Middle_param.getTime());
			System.out.println("map：" + Middle_param.getMap().values());
			System.out.println("TimeStart：" + Middle_param.getTimeStart());
			System.out.println("TimeEND：" + Middle_param.getTimeEND());
			System.out.println("RegularTimeCode："
					+ Middle_param.getRegularTimeCode());

			GUI_RandomKey_RegularTime_SuccessSet Succ = new GUI_RandomKey_RegularTime_SuccessSet();
			Succ.GetObject(obj, Succ);
			Succ.setVisible(true);
		}
	}

	public void RandomKey_RegularTime_BackJButtonActionPerformed(
			ActionEvent event, GUI_RandomKey_RegularTime obj) {
		// TODO Auto-generated method stub

		GUI_Move_Label.setRollset(true);
		GUI_main mian = new GUI_main();
		mian.setVisible(true);
		mian.setDefaultCloseOperation(3);
		obj.setVisible(false);
		if (ThreadPool.ThreadPoolexecutor.isShutdown() == false) {
			ThreadPool.ThreadPoolexecutor.shutdownNow();
		}
		new Middle_Close_adb();
		new Middle_Close_Java();
	}

	public void RandomKey_RandomTime_BackJButtonActionPerformed(
			ActionEvent event, GUI_RandomKey_RandomTime obj) {
		// TODO Auto-generated method stub
		GUI_Move_Label.setRollset(true);
		GUI_main mian = new GUI_main();
		mian.setVisible(true);
		mian.setDefaultCloseOperation(3);
		obj.setVisible(false);
		if (ThreadPool.ThreadPoolexecutor.isShutdown() == false) {
			ThreadPool.ThreadPoolexecutor.shutdownNow();
		}
		new Middle_Close_adb();
		new Middle_Close_Java();
	}

	public void RandomKey_RandomTime_OkJButtonActionPerformed(
			ActionEvent event, String ToolsPath, String IP_Port,
			String loopcount, int key, int Time, HashMap map, String TimeStart,
			String TimeEND, String RegularTimeCode, GUI_RandomKey_RandomTime obj) {
		// TODO Auto-generated method stub
		Methods method = new Methods();
		if (!IP_Port.contains(":")) {
			IP_Port = IP_Port + ":5555";
		}
		boolean TextNull = method.TextNull(ToolsPath,
				IP_Port.substring(0, IP_Port.lastIndexOf(":")), loopcount,
				TimeStart,TimeEND);
		boolean DirectoryFind = method.DirectoryFind(ToolsPath);
		setMapTrue(method.MapTrue(map));


		if (TextNull == false) {
			//close.setVisible(false);
			GUI_TextNULL_exception gui_TextNULL_exception = new GUI_TextNULL_exception();
			gui_TextNULL_exception.setVisible(true);
			gui_TextNULL_exception.setDefaultCloseOperation(1);
			System.out.println("选择文件、IP地址、循环次数、循环时间。是必填项！请检查是否有未填项");
		} else if (DirectoryFind == false) {
			//close.setVisible(false);
			GUI_DirectoryWrong_exception directoryWrong_exception = new GUI_DirectoryWrong_exception();
			directoryWrong_exception.setVisible(true);
			directoryWrong_exception.setDefaultCloseOperation(1);
			System.out.println("选择文件夹有误");
		} else if (getMapTrue() != 0) {
			//close.setVisible(false);
			GUI_KeyWrong_exception keyWrong_exception = new GUI_KeyWrong_exception();
			keyWrong_exception.setVisible(true);
			keyWrong_exception.setDefaultCloseOperation(1);
			System.out.println("请填写第" + MapTrue + "个键值");
		} else if (map.isEmpty()) {
			//close.setVisible(false);
			GUI_KeyNULL_exception gKeyNULL_exception = new GUI_KeyNULL_exception();
			gKeyNULL_exception.setVisible(true);
			gKeyNULL_exception.setDefaultCloseOperation(1);
			System.out.println("请至少填一个键值");
		}
		else if (TextNull && DirectoryFind && MapTrue == 0) {
			obj.setEnabled(false);
			//close.setVisible(false);
			int looptype = method.Looptype(loopcount);
			int Loopcount = Integer.parseInt(loopcount);
			double regulartimecode = Double.parseDouble(RegularTimeCode);
			double StartTime = Double.parseDouble(TimeStart);
			double EndTime = Double.parseDouble(TimeEND);
			Middle_param_Set middle_param_Set = new Middle_param_Set();
			ToolsPath = ToolsPath + "\\";
			middle_param_Set.param_set(ToolsPath, IP_Port, Loopcount, looptype,
					key, Time, map, StartTime, EndTime, regulartimecode);

			System.out.println("您输入的参数为：");
			System.out.println("Toolspath：" + Middle_param.getToolsPath());
			System.out.println("IP_Port：" + Middle_param.getIp_Port());
			System.out.println("loopcount：" + Middle_param.getLoopcount());
			System.out.println("looptype：" + Middle_param.getLooptype());
			System.out.println("key：" + Middle_param.getKey());
			System.out.println("Time：" + Middle_param.getTime());
			System.out.println("map：" + Middle_param.getMap().values());
			System.out.println("TimeStart：" + Middle_param.getTimeStart());
			System.out.println("TimeEND：" + Middle_param.getTimeEND());
			System.out.println("RegularTimeCode："
					+ Middle_param.getRegularTimeCode());

			GUI_RandomKey_RandomTime_SuccessSet Succ = new GUI_RandomKey_RandomTime_SuccessSet();
			Succ.GetObject(obj, Succ);
			Succ.setVisible(true);
		}
	}

}
