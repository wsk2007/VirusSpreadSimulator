package org.wsk.VirusSpreadSimulator;

import java.util.ArrayList;
import java.util.HashMap;

public class City {
	//��Ա��
	public HashMap<String , People> peoplepool = new HashMap<>();
	//����
	public int length;
	public int weight;
	public City(int l ,int w) {
		this.length = l;
		this.weight = w;
		this.init(l,w);
	}
	//��ʼ��
	private void init(int l , int w) {
		People p;
		//���ѭ��
		for(int i = 1; i <= l; i++) {
			//�ڲ�ѭ��
			for(int j = 1; j <= w ; j++) {
				System.out.println("��λ��" +  j + "," + i + "�����");
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
