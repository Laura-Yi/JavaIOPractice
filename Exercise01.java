package com.io;

import java.io.File;
import java.io.IOException;
/*
 * 在电脑D盘下创建一个文件为HelloWorld.txt文件，判断他是文件还是目录，在创建一个目
录IOTest,之后将HelloWorld.txt移动到IOTest目录下去；之后遍历IOTest这个目录下的文
件
 */
public class Exercise01 {
	public static void main (String[] args){
		File file = new File("d:\\HelloWorld.txt");
			try {
				if(file.exists()){
					System.out.println("the file exists");
				}else{
					file.createNewFile();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		System.out.println("Is it directory:"+file.isDirectory());
		File path = new File("d:\\IOTest");
		if(path.exists()){
			System.out.println("the directory exists");
		}else{
			path.mkdir();
		}
		//renameTo用于移动或者重命名文件
		if(file.renameTo(new File("d:\\IOTest\\HelloWorld.txt"))){
			System.out.println("removing success");
		}else{
			System.out.println("removing fails");
		}
		String[] filesname = path.list();
		for (String filename : filesname) {
			System.out.println(filename);
		}
	}
}
