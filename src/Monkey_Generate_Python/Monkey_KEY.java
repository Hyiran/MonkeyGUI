package Monkey_Generate_Python;

import java.util.HashMap;

public class Monkey_KEY {
	public static String HOME="'KEYCODE_HOME'";
	public static String BACK="'KEYCODE_BACK'";
	public static String DOWN="'KEYCODE_DPAD_DOWN'";
	public static String UP="'KEYCODE_DPAD_UP'";
	public static String CENTER="'KEYCODE_DPAD_CENTER'";
	public static String LEFT="'KEYCODE_DPAD_LEFT'";
	public static String RIGHT="'KEYCODE_DPAD_RIGHT'";
	public static String ZERO="'KEYCODE_0'";
	public static String ONE="'KEYCODE_1'";
	public static String TWO="'KEYCODE_2'";
	public static String THREE="'KEYCODE_3'";
	public static String FOUR="'KEYCODE_4'";
	public static String FIVE="'KEYCODE_5'";
	public static String SIX="'KEYCODE_6'";
	public static String SEVEN="'KEYCODE_7'";
	public static String EIGHT="'KEYCODE_8'";
	public static String NINE="'KEYCODE_9'";
	
	public static HashMap<String, String> SetMapKey() {
		
		HashMap<String , String> map = new HashMap<String , String>();
		map.put("HOME", "'KEYCODE_HOME'");
		map.put("BACK", "'KEYCODE_BACK'");
		map.put("OK", "'KEYCODE_DPAD_CENTER'");
		map.put("DOWN", "'KEYCODE_DPAD_DOWN'");
		map.put("UP", "'KEYCODE_DPAD_UP'");
		map.put("LEFT", "'KEYCODE_DPAD_LEFT'");
		map.put("RIGHT", "'KEYCODE_DPAD_RIGHT'");
		map.put("0", "'KEYCODE_0'");
		map.put("1", "'KEYCODE_1'");
		map.put("2", "'KEYCODE_2'");
		map.put("3", "'KEYCODE_3'");
		map.put("4", "'KEYCODE_4'");
		map.put("5", "'KEYCODE_5'");
		map.put("6", "'KEYCODE_6'");
		map.put("7", "'KEYCODE_7'");
		map.put("8", "'KEYCODE_8'");
		map.put("9", "'KEYCODE_9'");
		
		
		return map;
	}
	
	public static String getBACK() {
		return BACK;
	}
	public static void setBACK(String bACK) {
		BACK = bACK;
	}
	public static String getHOME() {
		return HOME;
	}
	public static String getDOWN() {
		return DOWN;
	}
	public static String getUP() {
		return UP;
	}
	public static String getCENTER() {
		return CENTER;
	}
	public static String getLEFT() {
		return LEFT;
	}
	public static String getRIGHT() {
		return RIGHT;
	}
	public static String getZERO() {
		return ZERO;
	}
	public static String getONE() {
		return ONE;
	}
	public static String getTWO() {
		return TWO;
	}
	public static String getTHREE() {
		return THREE;
	}
	public static String getFOUR() {
		return FOUR;
	}
	public static String getFIVE() {
		return FIVE;
	}
	public static String getSIX() {
		return SIX;
	}
	public static String getSEVEN() {
		return SEVEN;
	}
	public static String getEIGHT() {
		return EIGHT;
	}
	public static String getNINE() {
		return NINE;
	}
	
	
	
}
