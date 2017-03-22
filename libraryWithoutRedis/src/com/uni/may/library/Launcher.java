package com.uni.may.library;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import com.uni.may.library.command.BaseCommand;


public class Launcher {

	public static void main(String[] args) throws Exception {
		//读取控制台中输入的command
		String command = null;
		String[] params = null;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in,"UTF-8"));
		String line = null;
		while(!"exit".equals(line = reader.readLine())){
			if(line==null){
				continue;
			}
			//分离基本指令和参数
			String[] elems = line.split(" ");//将空格两边的字段分离为字符串数组
			command = elems[0];//基本指令
			if(elems.length > 1){
				params = Arrays.copyOfRange(elems, 1 , elems.length);//获取参数
			}
			
			BaseCommand.execute(command, params);
		}
		
	}

}
