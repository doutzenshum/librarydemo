package com.uni.may.library.equipment;

import java.util.Arrays;
import java.util.List;

import com.uni.may.library.command.BaseCommand;
import com.uni.may.library.command.Context;
import com.uni.may.library.command.IEquCommand;
import com.uni.may.library.util.Utility;

public class BookSelf extends BaseEquipment implements IEquCommand{
	
	private Book[] books;
	private static final ThreadLocal<Context> THREAD_CONTEXT = BaseCommand.THREAD_CONTEXT;
	private List<BaseEquipment> equList;

	@Override
	public String ls() {
		if(this.books == null){
			return "书架[" + this.id + "],为空书架";
		}
		String rs = "书架[" + this.id + "]里面共有" + this.books.length + "本书:\n";
//		for(int i=0;i < this.books.length ; i++){
//			rs = rs + "["+this.books[i].getId()+"]" + this.books[i].getName() + "\t";
//			if(i % 5 == 4){
//				rs = rs + "\n";
//			}
//		}
//		rs = rs + "\n";
		rs = Utility.combineLsResult(rs, books);
		return rs;
	}

	@Override
	public String cd(String id) {
		equList = THREAD_CONTEXT.get().getEquList();
		BaseEquipment equ = equList.get(equList.size()-1);
		Book _book = null;
		if(id !=null && equ instanceof BookSelf){
			Book[] books = ((BookSelf)equ).getBooks();
			for(Book book:books){
				if(id.equals(book.getId())){
					_book = book;
				}
			}
		}
		if(_book != null){
			equList.add(_book);
			return "进入" + _book.getName() + "成功！！！";
		}
		return "进入失败！！！";
	}


	public Book[] getBooks() {
		return books;
	}

	public void setBooks(Book[] books) {
		this.books = books;
	}

//	@Override
//	public String toString() {
//		return "BookSelf [books=" + Arrays.toString(books) + "]";
//	}
	
	

}
