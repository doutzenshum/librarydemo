package com.uni.may.library.dao;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import com.uni.may.library.equipment.BaseEquipment;
import com.uni.may.library.equipment.Liber;

public class JSONDaoImpl implements IBaseDao {

	ObjectMapper om = new ObjectMapper();
	
	public Liber liber = null;
	
	public JSONDaoImpl() {
		try {
			liber = (Liber) om.readValue(new File("E:\\myeclipse2014\\gzkj\\libraryWithoutRedis\\json\\liber.json"),Liber.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public BaseEquipment getById(String id) {
		return liber;
	}

	@Override
	public BaseEquipment[] listAll() {
		return liber.getRooms();
	}

	@Override
	public void add(BaseEquipment beseEqu) {

	}

	@Override
	public void del(String id) {

	}

	@Test
	public void selfTest(){
		JSONDaoImpl jdao = new JSONDaoImpl();
		System.out.println(jdao.liber.toString());
		//System.out.println(jdao.liber.getId());
		//Assert.assertNotNull(jdao.om);
	}
}
