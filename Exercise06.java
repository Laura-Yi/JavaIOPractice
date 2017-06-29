package com.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Exercise06 {
	public static void main(String[] args) {
		/*
		 * 拷贝一张图片，从一个目录到另外一个目录下(PS:是拷贝是不是移动)
		 */
		File picture = new File("d://da//a.jpg");
		File pictureTo = new File("d://data//b.jpg");
		try {
			InputStream input = new FileInputStream(picture);
			OutputStream output = new FileOutputStream(pictureTo);
			int len = 0;
			byte[] bytes = new byte[1024];
			while((len=input.read(bytes)) != -1){
				//最后一次写出的长度不为1024 用write(bytes)还是不是很好
				output.write(bytes,0,len);
			}
			output.flush();
			output.close();
			input.close();
			System.out.println("文件复制成功");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	
	
	}
}
