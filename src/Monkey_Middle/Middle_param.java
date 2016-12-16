package Monkey_Middle;

import java.util.HashMap;

public class Middle_param {
	public final static String Python_name = "Monkey_Jp.py";
	public final static String Log_name = "PLOG";
	public static String ToolsPath;
	public static String Ip_Port;
	public static int loopcount;
	public static int looptype;
	public static int key;
	public static int Time;
	public static HashMap map ;
	public static double TimeStart;
	public static double TimeEND;
	public static double RegularTimeCode;
	public static String getToolsPath() {
		return ToolsPath;
	}

	public static void setToolsPath(String toolsPath) {
		ToolsPath = toolsPath;
	}

	public static String getIp_Port() {
		return Ip_Port;
	}

	public static void setIp_Port(String ip_Port) {
		Ip_Port = ip_Port;
	}

	public static int getLoopcount() {
		return loopcount;
	}

	public static void setLoopcount(int loopcount) {
		Middle_param.loopcount = loopcount;
	}

	public static int getLooptype() {
		return looptype;
	}

	public static void setLooptype(int looptype) {
		Middle_param.looptype = looptype;
	}

	public static int getKey() {
		return key;
	}

	public static void setKey(int key) {
		Middle_param.key = key;
	}

	public static int getTime() {
		return Time;
	}

	public static void setTime(int time) {
		Time = time;
	}

	public static HashMap getMap() {
		return map;
	}

	public static void setMap(HashMap map) {
		Middle_param.map = map;
	}

	public static double getTimeStart() {
		return TimeStart;
	}

	public static void setTimeStart(double timeStart) {
		TimeStart = timeStart;
	}

	public static double getTimeEND() {
		return TimeEND;
	}

	public static void setTimeEND(double timeEND) {
		TimeEND = timeEND;
	}

	public static double getRegularTimeCode() {
		return RegularTimeCode;
	}

	public static void setRegularTimeCode(double regularTimeCode) {
		RegularTimeCode = regularTimeCode;
	}

	


	

}
