package com.uni.may.library.command;

import java.util.ArrayList;
import java.util.List;

import com.uni.may.library.equipment.BaseEquipment;
import com.uni.may.library.equipment.Liber;


public class BaseCommand {
	//每个客户端为一个线程
	public static final ThreadLocal<Context> THREAD_CONTEXT = new ThreadLocal<Context>();

	public static void execute(String command, String[] params) {
		//从线程中获取上下文
		Context cntxt = THREAD_CONTEXT.get();
		List<BaseEquipment> equList;
		
		if (cntxt == null) {
			cntxt = new Context();
			THREAD_CONTEXT.set(cntxt);
		}
		//List<BaseEquipment> equList =new ArrayList<BaseEquipment>();存放基础设施的子类对象
		equList = cntxt.getEquList();

		if(equList == null){
			equList = new ArrayList<BaseEquipment>();
			cntxt.setEquList(equList);
		}
		if(equList.isEmpty()){
			equList.add(Liber.getInstance());
		}

		
		//BaseEquipment iequ = cntxt.getEqu();
		//List<BaseEquipment> preEqus = cntxt.getEquList();
		BaseEquipment equ;
		String rs = null;
		switch (command) {
		case "ls":
			equ = equList.get(equList.size()-1);
			rs = equ.ls();
			System.out.println(rs);
			break;
		case "cd":
			equ = equList.get(equList.size()-1);
			if(params!=null&& !"".equals(params)&&params[0]!=null && !"".equals(params[0])){
				//------------这个if------------------------------------
				if ("..".equals(params[0])) {
					if(equList.size()>1){
						equList.remove(equList.size()-1);
						System.out.println("进入"+equList.get(equList.size()-1).getName()+"成功！！！");
					}else{
						System.out.println("已经没有上级目录了！！！");
					}
				}
				else {
					rs = equ.cd(params[0]);
				}
				//else是退回上级目录的代码-------------------------------
			}else{
				rs = "请输入要进入的位置编号！！！";
			}
			if (!(rs==null) && !"".equals(rs)) {
				System.out.println(rs);
			}
			params[0]=null;
			break;
//若是将以上退回上级目录的代码替换为以下代码，则cd..返回上级。但是bug贼jb多
//		case "cd..":
//			if(equList.size()>1){
//				equList.remove(equList.size()-1);
//				System.out.println("进入"+equList.get(equList.size()-1).getName()+"成功！！！");
//			}else{
//				System.out.println("已经没有上级目录了！！！");
//			}
//			break;
		default:
			break;
		}
		
//没用的代码		
/*		switch (command) {
		case "ls":
			String rs = cntxt.getEqu().ls();
			System.out.println(rs);
			break;
		case "cd":
			preEqus.add(iequ);
			if(iequ instanceof Liber){
				cntxt.setEqu(((Liber)iequ).getRooms()[0]);
			}else if(iequ instanceof Room){
				cntxt.setEqu(((Room)iequ).getBookSelfs()[0]);
			}else if(iequ instanceof BookSelf){
				cntxt.setEqu(((BookSelf)iequ).getBooks()[0]);
			}
			break;
		case "cd..":
			cntxt.setEqu(preEqus.get(preEqus.size()-1));
			preEqus.remove(preEqus.get(preEqus.size()-1));
		default:
			break;
		}
*/	}
	
}
