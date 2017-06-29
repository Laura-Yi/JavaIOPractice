package com.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Exercise10 {
	/*
	 * 使用随机文件流类RandomAccessFile将一个文本文件倒置读出
	 */
	public static void main(String[] args){
		StringBuffer bf = new StringBuffer();
		try {
			RandomAccessFile random = new RandomAccessFile("d:\\da\\test.txt", "rw");
			long length =  random.length();
			int len = 0;
			while(length > 0){
				length--;
				random.seek(length);
				/*read和readbyte返回的值不同
				 * 
				 * len = (char)random.readByte();	
				if(len>=0&&len<=255){
					bf.append((char)len);
					*/
				len = (char)random.read();	
				if(len>=0&&len<=128){
					bf.append((char)len);
				}else{
					length--;
					random.seek(length);
					byte[] bytes = new byte[2];
					//知道汉字占两个字节，readFully更好
					 random.readFully(bytes);
					bf.append(new String(bytes,"GBK"));
				}
			}
			random.close();
			System.out.println(bf);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
