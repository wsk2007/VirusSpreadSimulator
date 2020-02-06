package org.wsk.VirusSpreadSimulator;

import java.util.ArrayList;
import java.util.HashMap;

public class City {
	//人员表
	public HashMap<String , People> peoplepool = new HashMap<>();
	//长宽
	public int length;
	public int weight;
	public City(int l ,int w) {
		this.length = l;
		this.weight = w;
		this.init(l,w);
	}
	//初始化
	private void init(int l , int w) {
		People p;
		//外层循环
		for(int i = 1; i <= l; i++) {
			//内层循环
			for(int j = 1; j <= w ; j++) {
				System.out.println("在位置" +  j + "," + i + "添加人");
				p = new People(j , i, this);
				peoplepool.put(j + "," + i, p);
			}
		}
	}
	
	public City getCity() {
		return this;
	}
	
	public ArrayList<People> getAround(int x , int y){
		ArrayList<People> pl = new ArrayList<>();
		pl.add(peoplepool.get(x + "," + y));
		pl.add(peoplepool.get((x + 1) + "," + y));
		pl.add(peoplepool.get((x - 1) + "," + y));
		pl.add(peoplepool.get(x + "," + (y + 1)));
		pl.add(peoplepool.get(x + "," + (y - 1)));
		pl.add(peoplepool.get((x + 1) + "," + (y - 1)));
		pl.add(peoplepool.get((x - 1) + "," + (y + 1)));
		pl.add(peoplepool.get((x + 1) + "," + (y + 1)));
		pl.add(peoplepool.get((x - 1) + "," + (y - 1)));
		return pl;
	}
 
}
