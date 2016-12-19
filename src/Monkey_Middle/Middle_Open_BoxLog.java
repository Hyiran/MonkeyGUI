package Monkey_Middle;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import Monkey_GUI.GUI_main;




public class Middle_Open_BoxLog implements Runnable{

	public static boolean OpenBoxlogWrite = true;
	
	String BoxLogpath;
	public static boolean isOpenBoxlogWrite() {
		return OpenBoxlogWrite;
	}


	public static void setOpenBoxlogWrite(boolean openBoxlogWrite) {
		OpenBoxlogWrite = openBoxlogWrite;
	}


	public Middle_Open_BoxLog(String Toolspath){

		BoxLogpath = Toolspath;
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		try {
			setOpenBoxlogWrite(true);
			BoxLogpath = BoxLogpath.replace("\\", "/");
		    Runtime rt = Runtime.getRuntime();
		    String logCmd = "adb logcat –v threadtime";
        	//System.out.println("cmd /k adb logcat -v time *:V > "+Toolspath);
		    //InputStream inStream = rt.exec("cmd /k adb root && adb remount && adb logcat -v time *:V && echo logcat Over").getInputStream();//打开boxlog
		    //InputStream inStream = rt.exec("cmd /k start adb logcat –v threadtime").getInputStream();//打开boxlog
		    InputStream inStream = rt.exec("cmd /k adb root && adb remount && adb logcat -v threadtime && echo logcat Over").getInputStream();
		    System.out.println("log输出命令为: adb logcat –v threadtime ");
        	BufferedReader input;
    		try {
    			File file = new File(BoxLogpath);
    			FileOutputStream fileoutputstream = new FileOutputStream(file, true);
    			OutputStreamWriter filewrite = new OutputStreamWriter(
    					fileoutputstream);
    			BufferedWriter bufferwrite = new BufferedWriter(filewrite);
    			System.out.println("Middle_Open_BoxLog Start AND isOpenBoxlogWrite()="+isOpenBoxlogWrite());
    			String line = null;
    			input = new BufferedReader(new InputStreamReader(
    					inStream, "GBK"));
    			while (isOpenBoxlogWrite()) {
    			if ((line = input.readLine()) != null) {
    				line = line + "\n";
    				//System.out.println(line);
        			bufferwrite.write(line, 0, line.length());
    				//System.out.println("INPUT_Logcat:"+line);
    			}
    			}

    			bufferwrite.close();
    			
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            //System.out.println("Toolspath2=="+Toolspath);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	public static void main(String[] args) {
		// JFrame.setDefaultLookAndFeelDecorated(true);用window默认标题框
		
		 Runtime rt = Runtime.getRuntime();
		    String logCmd = "adb logcat –v threadtime";
     	//System.out.println("cmd /k adb logcat -v time *:V > "+Toolspath);
		    //InputStream inStream = rt.exec("cmd /k adb root && adb remount && adb logcat -v time *:V && echo logcat Over").getInputStream();//打开boxlog
		    try {
				//rt.exec("cmd /k echo on");
		    	InputStream inStream = rt.exec("cmd /k adb root && adb remount && adb logcat -v threadtime *:V && echo logcat Over").getInputStream();
		    BufferedReader input;
		    String line = null;
    			input = new BufferedReader(new InputStreamReader(
    					inStream, "GBK"));
    			while (isOpenBoxlogWrite()) {
    			if ((line = input.readLine()) != null) {
    				line = line + "\n";
    				System.out.println(line);
    				//System.out.println("INPUT_Logcat:"+line);
    			}
    			}
    			
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            //System.out.println("Toolspath2=="+Toolspath);
        }

	}

