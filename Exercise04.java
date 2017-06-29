package com.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Exercise04 {
	/*
	 * 从磁盘读取一个文件到内存中，再打印到控制台
	 */
	public static void main(String[] args)  {
		File file = new File("d://da//a.txt");
		try {
			FileInputStream input = new FileInputStream(file);
			byte[] buf = new byte[1024];
			StringBuffer sb = new StringBuffer();
			int len = 0;
			while((len=input.read(buf))!=-1){
				System.out.println(len);
				sb.append(new String(buf, 0, len));
			}
			System.out.println(sb);
			input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
