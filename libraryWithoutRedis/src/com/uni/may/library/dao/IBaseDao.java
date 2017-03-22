package com.uni.may.library.dao;

import com.uni.may.library.equipment.BaseEquipment;

public interface IBaseDao {
	
	public BaseEquipment getById(String id);
	
	public BaseEquipment[] listAll();
	
	public void add(BaseEquipment beseEqu);
	
	public void del(String id);
	
}
