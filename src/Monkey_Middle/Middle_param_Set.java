package Monkey_Middle;

import java.util.HashMap;

public class Middle_param_Set {

	public void param_set(String ToolsPath, String Ip_Port, int loopcount,
			int looptype, int key, int Time, HashMap map, int TimeStart,
			int TimeEND,int RegularTimeCode) {
	
		Middle_param.setToolsPath(ToolsPath);
		Middle_param.setIp_Port(Ip_Port);
		Middle_param.setLoopcount(loopcount);
		Middle_param.setKey(key);
		Middle_param.setTime(Time);
		Middle_param.setMap(map);
		Middle_param.setTimeStart(TimeStart);
		Middle_param.setTimeEND(TimeEND);
		Middle_param.setRegularTimeCode(RegularTimeCode);
		Middle_param.setLooptype(looptype);

	}
}
