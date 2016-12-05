package Monkey_Generate_Python;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Monkey_Middle.Middle_param;

public class Generate_Python_write {
	String ToolsPythonName;
	String write;
	
	public Generate_Python_write() {
		ToolsPythonName = Middle_param.getToolsPath()+Middle_param.Python_name;
	}
	public void Generate() {

		File file;
		System.out.println("ToolsPythonName:"+ToolsPythonName);
		if (!new File(ToolsPythonName).exists()) {
			try {
				new File(ToolsPythonName).createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Generate_Python_data write_python = new Generate_Python_data();
		write = write_python.Python_Data();
		try {
			file = new File(ToolsPythonName);
			FileWriter filewrite = new FileWriter(file, false);// 加true表示不覆盖文件，追加
			BufferedWriter bufferwrite = new BufferedWriter(filewrite);
			System.out.println("start python write");
			bufferwrite.write(write + "\n");
			bufferwrite.close();
			System.out.println("end python write");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		Generate_Python_write g =new Generate_Python_write();
		g.Generate();
	}
}
