package Monkey_Middle;

import java.io.IOException;

public class Middle_Disconnect_adb {

	
	public Middle_Disconnect_adb(){
		
		Runtime rt = Runtime.getRuntime();
        try {
            rt
                    .exec("cmd.exe /C adb disconnect " + Middle_param.getIp_Port());//
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
}
