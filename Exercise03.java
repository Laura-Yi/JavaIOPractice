package com.io;

import java.io.File;
import java.util.List;

public class Exercise03 {
	/*
	 *  递归实现列出当前工程下所有.Java文件
	 */
	public static void  main(String[] args) {
		//获得当前工程所有文件
		List<File> files = Exercise02.getAllfiles(".");
		for(File file:files){
			if(file.toString().endsWith(".java")){
				System.out.println(file);
			}
		}
	}
	
}
