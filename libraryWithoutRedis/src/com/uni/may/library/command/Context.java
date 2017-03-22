package com.uni.may.library.command;

import java.util.List;

import com.uni.may.library.equipment.BaseEquipment;

public class Context {
	
	//private BaseEquipment equ;
	private List<BaseEquipment> equList;


	public List<BaseEquipment> getEquList() {
		return equList;
	}

	public void setEquList(List<BaseEquipment> equList) {
		this.equList = equList;
	}

/*	public BaseEquipment getEqu() {
		return equ;
	}

	public void setEqu(BaseEquipment equ) {
		this.equ = equ;
	}*/

}
