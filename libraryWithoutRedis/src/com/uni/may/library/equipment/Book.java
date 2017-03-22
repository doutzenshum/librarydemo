package com.uni.may.library.equipment;


import com.uni.may.library.command.IEquCommand;

public class Book extends BaseEquipment implements IEquCommand{

	private String pagenum="1000";
	
	@Override
	public String ls() {
		return "书[" + this.name + "],共有" + this.pagenum + "页\n";
	}

	@Override
	public String cd(String id) {
		return "进入失败！！！已经是最后一级了！！！";
	}

	

//	@Override
//	public String toString() {
//		return "Book [pagenum=" + pagenum + "]";
//	}

	
	

}
