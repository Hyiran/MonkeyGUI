package Monkey_Methods;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Monkey_GUI.GUI_RegularKey_RegularTime_SuccessSet;
import Monkey_Middle.Middle_CMDlog_Write;
import Monkey_Monitor.Monitor_Log_Compare;

public class Methods {

	public boolean DirectoryFind(String path) {
		File file = new File(path);
		if (!file.exists() && !file.isDirectory()) {
			System.out.println("未找到文件夹");
			return false;
		} else {
			return true;
		}
	}

	public boolean TextNull(String path, String IP, String Loopcount,
			String Time) {
		if (path.equals("") | IP.equals("") | Loopcount.equals("")
				| Time.equals("")) {

			System.out.println("有空值");
			return false;
		} else if (isNumeric(Loopcount) == false || isNumeric(Time) == false) {
			System.out.println("循环次数与时间非数字");
			return false;
		} else {
			return true;
		}
	}

	public boolean TextNull(String toolsPath, String IP,
			String loopcount, String timeStart, String timeEND) {
		// TODO Auto-generated method stub
		if (toolsPath.equals("") | IP.equals("") | loopcount.equals("")
				| timeStart.equals("")| timeEND.equals("")) {

			System.out.println("有空值");
			return false;
		} else if (isNumeric(loopcount) == false || isNumeric(timeStart) == false||isNumeric(timeEND) == false) {
			System.out.println("循环次数与时间非数字");
			return false;
		} else {
			return true;
		}
	}

	public int Looptype(String loopcount) {
		int Loopcount = Integer.parseInt(loopcount);
		if (Loopcount <= 0) {

			System.out.println("loopcount=0，因此While循环");
			return 0;
		} else {
			System.out.println("loopcount非0，因此For循环");
			return 1;
		}
	}

	public int MapTrue(HashMap map) {
		List<Integer> keyList = new ArrayList<Integer>(map.keySet());
		Collections.sort(keyList);
		for (int i = 0; i < keyList.size(); i++) {
			if (keyList.get(i) != (i + 1)) {
				return i + 1;
			}
		}

		return 0;

	}

	public boolean isNumeric(String str) {
		for (int i = 0; i < str.length(); i++) {
			// System.out.println(str.charAt(i));
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public String FirstConnectCheck(String IP_Port) {

		Process proc = null;
		Runtime runtime = Runtime.getRuntime();
		String line = null;
		try {
			if (proc != null) {
				proc.destroy();
			}
			proc = runtime.exec("cmd /k adb connect " + IP_Port);
			BufferedReader input = new BufferedReader(new InputStreamReader(
					proc.getInputStream(), "GBK"));
			System.out.println("开始检测adb链接状态");

			input = new BufferedReader(new InputStreamReader(
					proc.getInputStream(), "GBK"));
			line = input.readLine();
			if (line.contains("unable to connect to")
					| line.contains("bad port number")|line.contains("daemon not running")) {
				System.out.println(line);
				proc.destroy();
				input.close();
				return line;
			}
			System.out.println("连接失败！请确认IP与端口是否正常.确认后，请重启程序。");
			proc.destroy();
			input.close();

		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
		System.out.println(line);
		System.out.println("adb首次检测：已连接");
		return "success";
	}

	public Object HashKeyget(Map map, Object value) {

		for (Object key : map.keySet())
			if (map.get(key).equals(value))
				return key;

		return null;
	}

	public int SeleStr(String string, char c, int number) {
		int position = 0;
		char arr[] = string.toCharArray();
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] == c) {
				position++;
			}
			if (position == number) {
				return i + 1;
			}
		}
		return 0;

	}

	public static void main(String[] args) {
		Methods me = new Methods();
		me.SeleStr(
				"adfad+safdsf+safdASfdasf+adfadfadf+afasdfasdf+afadfadfasdf+阿德法地方+啊刀法+",
				'+', 5);
	}

}
