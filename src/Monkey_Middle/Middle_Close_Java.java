package Monkey_Middle;

import java.io.IOException;

public class Middle_Close_Java {

	
	public Middle_Close_Java(){
		
		Runtime rt = Runtime.getRuntime();
        try {
            rt
                    .exec("cmd.exe /C taskkill /f /t /im java.exe && taskkill /f /t /im cmd.exe");//关闭正在运行的cmd窗口
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
}
