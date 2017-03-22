package com.uni.may.library.equipment;

import java.util.Arrays;
import java.util.List;

import com.uni.may.library.command.BaseCommand;
import com.uni.may.library.command.Context;
import com.uni.may.library.command.IEquCommand;
import com.uni.may.library.dao.JSONDaoImpl;
import com.uni.may.library.util.Utility;

public class Liber extends BaseEquipment implements IEquCommand {
	
	
	private Room[] rooms;
	private static Liber liber ;
	private static final ThreadLocal<Context> THREAD_CONTEXT = BaseCommand.THREAD_CONTEXT;
	private List<BaseEquipment> equList;
	
	private Liber(){}
	
	public static Liber getInstance(){
		synchronized (Liber.class) {
			if (liber == null) {
				liber = (Liber) new JSONDaoImpl().getById("");
			}
		}
		return liber;
	}
	
	@Override
	public String ls() {
		//为什么是没必要的代码
//		BaseEquipment[] equs = new JSONDaoImpl().listAll();
//		rooms = new Room[equs.length];
//		for(int i=0;i<equs.length;i++){
//			rooms[i] = (Room)equs[i];
//		}
		if(this.rooms == null){
			return "图书管[" + this.getId() + "],为空图书室";
		}
		String rs = "图书管[" + this.getId() + "]里面共有" + this.rooms.length + "个图书室:\n";
//		for(int i=0;i < this.rooms.length ; i++){
//			rs = rs + "["+this.rooms[i].getId()+"]" + this.rooms[i].getName() + "\t";
//			if(i % 5 == 4){
//				rs = rs + "\n";
//			}
//		}
//		rs = rs + "\n";
		rs = Utility.combineLsResult(rs, rooms);
		return rs;
	}

	@Override
	public String cd(String id) {
		equList = THREAD_CONTEXT.get().getEquList();
		BaseEquipment equ = equList.get(equList.size()-1);
		Room _room = null;
		if(id !=null && equ instanceof Liber){
			Room[] rooms = ((Liber)equ).getRooms();
			for(Room room:rooms){
				if(id.equals(room.getId())){
					_room = room;
				}
			}
		}
		if(_room != null){
			equList.add(_room);
			return "进入" + _room.getName() + "成功！！！";
		}
		return "进入失败！！！";
	}


	public Room[] getRooms() {
		return rooms;
	}

	public void setRooms(Room[] rooms) {
		this.rooms = rooms;
	}

//	@Override
//	public String toString() {
//		return "Liber [rooms=" + Arrays.toString(rooms) + "]";
//	}
	
	
}
