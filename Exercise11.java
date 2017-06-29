package com.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Exercise11 {
	/*
	 * 编写一个Java应用程序，可以实现Dos中的type命令，并加上行号。
	 * 即将文本文件在控制台上显示出来，并在每一行的前面加上行号。
	 */
	public static void main(String[] args){
		File file = new File("d:\\da\\test.txt");
		BufferedReader reader = null;
		int row = 0;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"GBK"));
			String line = null;
			while((line = reader.readLine())!=null){
				row++;
				System.out.println("line"+row+":"+line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
