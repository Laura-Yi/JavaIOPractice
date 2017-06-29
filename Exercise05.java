package com.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Exercise05 {
	/*
	 * 在程序中写一个"HelloJavaWorld你好世界"输出到操作系统文件Hello.txt文件中
	 */
	public static void main(String[] args) {
		String line = "Helloworld你好世界";
		File file = new File("d:\\da\\Hello.txt");
		try {
			OutputStream outputStream = new FileOutputStream(file);
			outputStream.write(line.getBytes());
			outputStream.flush();
			outputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
