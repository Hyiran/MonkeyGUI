package Monkey_Middle;

import java.io.IOException;

public class Middle_adbServe_connect {

	
	public Middle_adbServe_connect(){
		
		Runtime rt = Runtime.getRuntime();
        try {
            rt
                    .exec("cmd.exe /C taskkill /f /t /im adb.exe  && taskkill /f /t /im cmd.exe");//�ر��������е�cmd����
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
}
