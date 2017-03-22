package com.uni.may.library.equipment;

import java.util.Arrays;
import java.util.List;

import com.uni.may.library.command.BaseCommand;
import com.uni.may.library.command.Context;
import com.uni.may.library.command.IEquCommand;
import com.uni.may.library.util.Utility;

public class Room extends BaseEquipment implements IEquCommand {

	private BookSelf[] bookSelfs;
	private static final ThreadLocal<Context> THREAD_CONTEXT = BaseCommand.THREAD_CONTEXT;
	private List<BaseEquipment> equList;
	@Override
	public String ls() {
		if(this.bookSelfs == null){
			return "图书室[" + this.id + "],为空图书室";
		}
		String rs = "图书室[" + this.id + "]里面共有" + this.bookSelfs.length + "个书架:\n";
//		for(int i=0;i < this.bookSelfs.length ; i++){
//			rs = rs + "["+this.bookSelfs[i].getId()+"]" +this.bookSelfs[i].getName() + "\t";
//			if(i % 5 == 4){
//				rs = rs + "\n";
//			}
//		}
//		rs = rs + "\n";
		rs = Utility.combineLsResult(rs, bookSelfs);
		return rs;
	}

	@Override
	public String cd(String id) {
		equList = THREAD_CONTEXT.get().getEquList();
		BaseEquipment equ = equList.get(equList.size()-1);
		BookSelf _bookSelf = null;
		if(id !=null && equ instanceof Room){
			BookSelf[] bookSelfs = ((Room)equ).getBookSelfs();
			for(BookSelf bookSelf:bookSelfs){
				if(id.equals(bookSelf.getId())){
					_bookSelf = bookSelf;
				}
			}
		}
		if(_bookSelf != null){
			equList.add(_bookSelf);
			return "进入" + _bookSelf.getName() + "成功！！！";
		}
		return "进入失败！！！";
	}
	


	public BookSelf[] getBookSelfs() {
		return bookSelfs;
	}

	public void setBookSelfs(BookSelf[] bookSelfs) {
		this.bookSelfs = bookSelfs;
	}

//	@Override
//	public String toString() {
//		return "Room [bookSelfs=" + Arrays.toString(bookSelfs) + "]";
//	}

	

}
