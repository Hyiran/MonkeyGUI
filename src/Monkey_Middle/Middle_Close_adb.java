package Monkey_Middle;

import java.io.IOException;

public class Middle_Close_adb {

	
	public Middle_Close_adb(){
		
		Runtime rt = Runtime.getRuntime();
        try {
            rt
                    .exec("cmd.exe /C taskkill /f /t /im adb.exe  && taskkill /f /t /im cmd.exe");//�ر��������е�cmd����
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
}
