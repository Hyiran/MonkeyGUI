package Monkey_Generate_Python;

import java.util.HashMap;
import java.util.Map;

import Monkey_Middle.Middle_param;

public class Generate_Python_data {

	// 定义键值：按下HOME键 device.press('KEYCODE_HOME', MonkeyDevice.DOWN_AND_UP)
	String IP_Port;
	String Python_script;
	String Python_Head;
	int loopCount;
	String Python_KEY_TIME;// 具体操作
	// 定义循环两种次循环方式
	int Looptype;// 0表示while，1表示for
	String LoopCount;
	String LoopWhile;
	String LoopFor;
	// 定义随机、固定的键值与时间参数：0表示随机，1表示固定
	int Key;
	int Time;
	// 固定键值、时间参数
	double RegularTimeCode;
	// 固定键值随机时间,时间参数
	double TimeStart;
	double TimeEnd;

	public Generate_Python_data() {

		// 定义随机、固定的键值与时间参数：0表示随机，1表示固定
		Key = Middle_param.getKey();
		Time = Middle_param.getTime();
		// 固定键值随机时间,时间参数
		TimeStart = Middle_param.getTimeStart();
		TimeEnd = Middle_param.getTimeEND();
		// 固定键值、时间参数
		RegularTimeCode = Middle_param.getRegularTimeCode();
		IP_Port = Middle_param.getIp_Port();
		Python_Head = "# -*- coding: utf-8 -*-  "
				+ "\n"
				+ "#coding=utf-8 "
				+ "\n"
				+ "from com.android.monkeyrunner import MonkeyRunner,MonkeyImage,MonkeyDevice"
				+ "\n"
				+ "import random"
				+ "\n"
				+ "print \"The program is in progress, please wait for a while ^_^\""
				+ "\n" + "device = MonkeyRunner.waitForConnection(10,\""
				+ IP_Port + "\")" + "\n" + "print \"device connect is OK\""
				+ "\n" + "\n" + "n=0" + "\n";
		Python_KEY_TIME = "";// 具体操作
		// 定义循环两种次循环方式
		loopCount = Middle_param.getLoopcount();// 用户输入的循环次数
		Looptype = Middle_param.getLooptype();// 0表示while，1表示for
		LoopCount = String.valueOf(loopCount + 1);// 传入Python的循环次数需要+1
		LoopFor = "for i in range(1," + LoopCount + "):" + "\n"
				+ " print \"IN for\"" + "\n" + " n=n+1" + "\n";
		LoopWhile = "while True:" + "\n" + " print \"IN while\"" + "\n"
				+ " n=n+1" + "\n";
	}


	public String Python_Data() {

		System.out.println("脚本准备写入的参数为：");
		System.out.println("Key:" + Key);
		System.out.println("Time:" + Time);
		System.out.println("TimeStart:" + TimeStart);
		System.out.println("TimeEnd:" + TimeEnd);
		System.out.println("RegularTimeCode:" + RegularTimeCode);
		System.out.println("loopCount:" + loopCount);
		System.out.println("Looptype:" + Looptype);

		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map = Middle_param.getMap();

		if (Key == 1 && Time == 1 && map.size() > 0) {// 当固定时间固定键值时生成脚本全部内容
			System.out.println("固定时间固定键值");
			Python_Data_RegularKey_RegularTime(map, RegularTimeCode);
			//System.out.println(Python_KEY_TIME);
			if (Looptype == 0) {
				Python_script = Python_Head + LoopWhile + Python_KEY_TIME;
				return Python_script;
			}
			Python_script = Python_Head + LoopFor + Python_KEY_TIME;
		}
		if (Key == 1 && Time == 0 && map.size() > 0) {// 当随机时间固定键值时生成脚本全部内容
			System.out.println("随机时间固定键值");
			Python_Data_RegularKey_RandomTime(map, TimeStart, TimeEnd);
			//System.out.println(Python_KEY_TIME);
			if (Looptype == 0) {
				Python_script = Python_Head + LoopWhile + Python_KEY_TIME;
				return Python_script;
			}
			Python_script = Python_Head + LoopFor + Python_KEY_TIME;
		}
		if (Key == 0 && Time == 1 && map.size() > 0) {// 当固定时间随机键值时生成脚本全部内容
			System.out.println("固定时间随机键值");
			Python_Data_RandomKey_RegularTime(map, RegularTimeCode);
			//System.out.println(Python_KEY_TIME);
			if (Looptype == 0) {
				Python_script = Python_Head + LoopWhile + Python_KEY_TIME;
				return Python_script;
			}
			Python_script = Python_Head + LoopFor + Python_KEY_TIME;
		}
		if (Key == 0 && Time == 0 && map.size() > 0) {// 当随机时间随机键值时生成脚本全部内容
			System.out.println("随机时间随机键值");
			Python_Data_RandomKey_RandomTime(map, TimeStart, TimeEnd);
			//System.out.println(Python_KEY_TIME);
			if (Looptype == 0) {
				Python_script = Python_Head + LoopWhile + Python_KEY_TIME;
				return Python_script;
			}
			Python_script = Python_Head + LoopFor + Python_KEY_TIME;
		}
		return Python_script;
	}

	// 固定键值，固定时间间隔操作生成Python操作
	public String Python_Data_RegularKey_RegularTime(HashMap map,
			double RegularTimeCode) {
		String RegularTime = String.valueOf(RegularTimeCode);
		for (int i = 1; i <= map.size(); i++) {
			Python_KEY_TIME = Python_KEY_TIME + " device.press(" + map.get(i)
					+ ", MonkeyDevice.DOWN_AND_UP)" + "\n"
					+ " MonkeyRunner.sleep(" + RegularTime + ")" + "\n"
					+ " print \"The "+map.get(i)+" KEY\"" + "\n";
		}
		Python_KEY_TIME = Python_KEY_TIME + " print \"The \"+str(n)+\" loop\""
				+ "\n";
		System.out.println("map.size=" + map.size());
		return Python_KEY_TIME;
	}

	// 固定键值随机时间生成Python操作
	public String Python_Data_RegularKey_RandomTime(HashMap map, double TimeStart,
			double TimeEnd) {
		String TimeS = String.valueOf(TimeStart);
		String TimeE = String.valueOf(TimeEnd);
		for (int i = 1; i <= map.size(); i++) {
			Python_KEY_TIME = Python_KEY_TIME + " device.press(" + map.get(i)
					+ ", MonkeyDevice.DOWN_AND_UP)" + "\n"
					+ " MonkeyRunner.sleep(Ran)" + "\n"
					+ " print \"The "+map.get(i)+" KEY\"" + "\n";
			

		}
		Python_KEY_TIME = " Ran=round(random.uniform(" + TimeS + "," + TimeE + "),9)"
				+ "\n" + " print \"The \"+str(n)+\" loop\"" + "\n"
				+ " print \"The last random time:\"+str(Ran)" + "\n"
				+ Python_KEY_TIME + "\n";
		return Python_KEY_TIME;
	}

	// 随机键值固定时间生成Python操作
	public String Python_Data_RandomKey_RegularTime(HashMap map,
			double RegularTimeCode) {
		String RegularTime = String.valueOf(RegularTimeCode);
		String KeyList = "";
		for (int i = 1; i <= map.size(); i++) {
			/*Python_KEY_TIME = Python_KEY_TIME
					+ " device.press(list[Ran], MonkeyDevice.DOWN_AND_UP)"
					+ "\n" + " MonkeyRunner.sleep(" + RegularTime + ")" + "\n";*/
			KeyList = KeyList + i + ":" + map.get(i) + ",";
		}
		Python_KEY_TIME = " device.press(list[Ran], MonkeyDevice.DOWN_AND_UP)"
				+ "\n" + " MonkeyRunner.sleep(" + RegularTime + ")" + "\n";
		KeyList = " list = {" + KeyList + "}" + "\n";
		Python_KEY_TIME = " Ran=random.randint(1," + map.size() + ")" + "\n"
				+ KeyList + " print \"The \"+str(n)+\" loop\"" + "\n"
				+ " print \"The \"+list[Ran]+\" loop\"" + "\n"
				+ Python_KEY_TIME + "\n";
		System.out.println("map.size=" + map.size() + "KeyList=" + KeyList);
		return Python_KEY_TIME;
	}

	// 随机键值随机时间生成Python操作
	public String Python_Data_RandomKey_RandomTime(HashMap map, double TimeStart,
			double TimeEnd) {
		String TimeS = String.valueOf(TimeStart);
		String TimeE = String.valueOf(TimeEnd);
		String KeyList = "";
		for (int i = 1; i <= map.size(); i++) {
			/*Python_KEY_TIME = Python_KEY_TIME
					+ " device.press(list[Ran], MonkeyDevice.DOWN_AND_UP)"
					+ "\n" + " MonkeyRunner.sleep(RanTime)" + "\n";*/
			KeyList = KeyList + i + ":" + map.get(i) + ",";
		}
		Python_KEY_TIME = " device.press(list[Ran], MonkeyDevice.DOWN_AND_UP)"
				+ "\n" + " MonkeyRunner.sleep(RanTime)" + "\n";
		KeyList = " list = {" + KeyList + "}" + "\n";
		Python_KEY_TIME = " Ran=random.randint(1," + map.size() + ")" + "\n"
				+ " RanTime=round(random.uniform(" + TimeS + "," + TimeE + "),9)" + "\n"
				+ KeyList + " print \"The \"+str(n)+\" loop\"" + "\n"
				+ " print \"The \"+list[Ran]+\" Key\"" + "\n"
				+ " print \"The Random time is\"+str(RanTime)" + "\n"
				+ Python_KEY_TIME + "\n";
		System.out.println("map.size=" + map.size() + "KeyList=" + KeyList);
		return Python_KEY_TIME;
	}

}
