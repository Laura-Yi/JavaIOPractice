package com.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exercise12 {
	/*
	 * 输入两个文件夹名称，将A文件夹内容全部拷贝到B文件夹，要求使用多线程来操作
	 */
	public static void copy(File fromFile,File toFile) {
		FileInputStream input = null;
		FileOutputStream output = null;
		try {
			input = new FileInputStream(fromFile);
			output = new FileOutputStream(toFile);
			byte[] bytes = new byte[1024];
			int len = 0;
			while((len = input.read(bytes))!= -1){
				output.write(bytes, 0, len);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
					input.close();
					output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

	public static void main(String[] args) {
//	Scanner scanner = new Scanner(System.in);
//	System.out.println("请输入要复制的文件");
//	String frompath = scanner.next();
//	System.out.println("请输入复制目的地");
//	String topath = scanner.next();
	
	String frompath = "d:\\da";
	String topath = "d:\\data";
		
	File fromFile = new File(frompath);
	File toFile = new File(topath);
	if(fromFile.isFile()){
		copy(fromFile, toFile);
	}else{
		if(topath.replace("\\", "/").toLowerCase().startsWith(frompath.replace("\\", "/").toLowerCase())&&topath.substring(frompath.length(), frompath.length()).equals("/")){
		System.out.println("错误：不能将文件复制到自己的子文件下");	
		return;
		}
		List<File> files = Exercise02.getAllfiles(frompath);
		ExecutorService threadPool = Executors.newFixedThreadPool(20);
		
		for (File file : files) {
			if(file.isFile()){
				threadPool.execute(new Runnable() {
					@Override
					public void run() {
						String name= file.getAbsolutePath();
						String toName = name.replace(fromFile.getParent(),toFile+"/");
						//System.out.println(toName);
						File copyfile = new File(toName);
						copyfile.getParentFile().mkdirs();
						copy(file, copyfile);
					}
				});
			}
		}
		System.out.println("复制完成");
	}
				
	
	
	
	
	
	
	
	
	
	}
}
