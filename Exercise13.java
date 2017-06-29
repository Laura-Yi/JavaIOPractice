package com.io;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Exercise13 {
	/*
	 * 查看D盘中所有的文件和文件夹名称，并且使用名称升序降序，文件夹在前和文件夹在
     * 后，文件大小排序等。
	 */
	public static void main(String[] args){
		List<File> files = Exercise02.getAllfiles("d:\\da");
		//按照名称来排序
		Collections.sort(files,new Comparator<File>() {
			
			@Override
			public int compare(File o1, File o2) {
				return (o1.getName().compareTo(o2.getName()));
			}
			
		});
		
		//按照文件大小来排序
		Collections.sort(files,new Comparator<File>(){

			@Override
			public int compare(File o1, File o2) {
				//file.length表示文件大小
				return (int)(o1.length()-o2.length());
			}
		});
		for (File file : files) {
			System.out.println(file.getName());
		}
	}
}
