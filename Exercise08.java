package com.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Exercise08 {
	public static void main(String[] args){
		/*
		 * 统计一个文件calcCharNum.txt（见附件）中各个字母出现次数：
		 * (8),B(16),C(10)...,a(12),b(10),c(3)....，括号内代表字符出现次数
		 */
		Map<String, Integer> map = new HashMap<>();
		File file = new File("d:\\da\\aa.txt");
		try {
			FileInputStream input = new FileInputStream(file);
			int len = 0;
			char in = 0;
			while((len=input.read())!=-1){
				in = (char)len;
				if(map.containsKey(in+"")){
					map.put(in+"", map.get(in+"")+1);
				}else{
					map.put(in+"", 1);
				}
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (Map.Entry<String, Integer> entry : map.entrySet()){
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}
}
