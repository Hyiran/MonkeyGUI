package Monkey_Middle;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Middle_CMDlog_Write {
	String FilePath;

	public Middle_CMDlog_Write() {
		// TODO Auto-generated constructor stub
		FilePath = Middle_param.getToolsPath() + Middle_param.Log_name;
		if (!new File(FilePath).exists()) {
			try {
				new File(FilePath).createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}

	// CMD–≈œ¢–¥»ÎTXT
	public synchronized boolean CMDWrite(String line) {
		line = line + "\n";
		try {
			File file = new File(FilePath);
			FileOutputStream fileoutputstream = new FileOutputStream(file, true);
			OutputStreamWriter filewrite = new OutputStreamWriter(
					fileoutputstream);
			BufferedWriter bufferwrite = new BufferedWriter(filewrite);
			bufferwrite.write(line, 0, line.length());
			bufferwrite.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}

}
