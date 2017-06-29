package com.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Exercise07 {
	/*
	 * 统计一个文件calcCharNum.txt（见附件）中字母'A'和'a'出现的总次数
	 */
	public static void main(String[] args){
		File file = new File("d://da//test.txt");
		try {
			InputStream input = new FileInputStream(file);
			int len = 0;
			int counta = 0;
			int countA = 0;
			while((len = input.read()) != -1){
				if(((char)len) == 'a'){
					counta++;
				}
				if(((char)len) == 'A'){
					countA++;
				}
			}
			input.close();
			System.out.println("countA:"+countA);
			System.out.println("counta:"+counta);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
