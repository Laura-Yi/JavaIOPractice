package com.io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
/*
 * 递归实现输入任意目录，列出文件以及文件夹
 */
public class Exercise02 {
	//递归获得一个文件夹下多有的文件
	public static List<File> getAllfiles(String filepath){
		List<File> listFile = new ArrayList<>(); 
		File file = new File(filepath);
		if(file.exists()&&file.isDirectory()){
			findFile(file,listFile);
		}
		return listFile;
	}

	private static void findFile(File file, List<File> listFile) {
		File[] files = file.listFiles();
		
		if(files == null){
			return;
		}else{
			for (File file2 : files) {
				listFile.add(file2);
				//递归
				findFile(file2,listFile);
			}
		}
	}
	
	public static void main(String[] args){
		String filepath= "d://data";
		List<File> filelist = Exercise02.getAllfiles(filepath);
		for (File file : filelist) {
			System.out.println(file);
		}
	}
}
