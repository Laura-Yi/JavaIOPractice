package com.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Exercise09 {
	/*
	 * 统计一个文件calcCharNum2.txt（见附件）中各个字母出现次数：
	 * A(8),B(16),C(10)...,a(12),b(10),c(3)....中(5),国(6)，括号内代表字符出现次数;
	 */
	public static void main(String[] args){
		File file = new File("d:\\da\\aa.txt");
		Map<String, Integer> map = new HashMap<>();
		try {
			//处理中文乱码
			 BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(file),"GBK"));
			int len = 0;
			String in = null;
			while((len = reader.read()) != -1){
				in = (char)len+"";
					if(map.containsKey(in)){
						map.put(in, map.get(in)+1);
					}else{
							map.put(in, 1);
					}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//map迭代方法
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}
}
