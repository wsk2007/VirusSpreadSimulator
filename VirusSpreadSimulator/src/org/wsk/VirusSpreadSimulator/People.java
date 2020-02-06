package org.wsk.VirusSpreadSimulator;

import java.security.SecureRandom;
import java.util.ArrayList;

import org.wsk.VirusSpreadSimulator.Constant.state;

public class People {
	City c;
	private boolean isdeadcheck = false;
	SecureRandom sr = new SecureRandom();
	int x;
	int y;
	int check = -1;
	int gohealth = -1;
	//潜伏期
	int lt = -1;
	//状态
	Constant.state state = Constant.state.HEALTH;
	//环境
	Constant.environment en = Constant.environment.NORMAL;
	//构造函数
	public People(int x , int y , City c) {
		this.x = x;
		this.y = y;
		this.c = c;
	}
	
	public Constant.daycheck newDay() {
		if((state == state.INFECTION  || state == state.SUSPECTEDANDINFECTION) && isdeadcheck == false) {
			this.death();
			isdeadcheck = true;
			if(state == state.DEAD) {
				return Constant.daycheck.DEAD;
			}
		}
		if(state == state.LATENT) {
			this.Latent();
			return Constant.daycheck.HEALTH;
		}
		if(state == state.SUSPECTED || state == state.SUSPECTEDANDINFECTION) {
			this.goHospital();
			if(state == state.HEALTH) {
				return Constant.daycheck.CHECKHEALTH;
			}
			if(state == state.INFECTION) {
				return Constant.daycheck.CHECKINFECTION;
			}
		}
		if(state == state.INFECTION && (en == en.ISOLATION || en == en.HOSTIPAL)) {
			this.goh();
			if(state == state.HEALTH) {
				return Constant.daycheck.GOHEALTH;
			}
		}
		this.goout();
		this.Suspfalse();
		if(state == state.SUSPECTED) {
			return Constant.daycheck.SUSPECTED;
		}
		return Constant.daycheck.HEALTH;
		
		
		
	}
	
	private Constant.state Latent() {
		if(lt == -1) {
			lt = Constant.LATENTTIME;
			this.state = state.LATENT;
			return this.state;
		}else {
			if(lt == 1) {
				check = -1;
				return this.Infec();
			}
			lt--;
			
		}
		return state;
		
	}
	
	private Constant.state Suspfalse(){
		int i =sr.nextInt(100);
		if(i <= Constant.SUSPECTEDPROBABLILTY) {
			this.state = state.SUSPECTED;
			en = en.ISOLATION;
		    this.goHospital();
		}
		
		return state;
	}
	


	
	private Constant.state Infec() {
		this.state = state.SUSPECTEDANDINFECTION;
		en = en.ISOLATION;
		this.goHospital();
		return this.state;
	}
	
	private void goHospital() {
		if(check == -1) {
			check = Constant.CONFIRMTIME;
		}else {
			if (check == 1 && Day.ischecked < 2) {
				if(state == state.SUSPECTED) {
					state = state.HEALTH;
					check = -1;
					return;
				}else {
					state = state.INFECTION;
					if(Hospital.goin(this)) {
						check = -1;
						return;
					}else {
						check = -1;
						en = en.ISOLATION;
						return;
					}
				}
			}
			check--;
			
		}
		
		
		
	}
	public Constant.state death(){
		if((state == state.SUSPECTEDANDINFECTION || state == state.INFECTION) && (en != en.DEAD && state != state.DEAD)) {
			int i = sr.nextInt(1000);
			if( i <= Constant.DEATHPROBABLILTY * 1000) {
				state = state.DEAD;
				en = en.DEAD;
				return state;
			}
		}
		return state;
	}
	
	public Constant.state contant(){
		int i = sr.nextInt(100);
		if(i <= 80) {
			this.state = state.LATENT;
			this.Latent();
		}else {
			this.state = state.SUSPECTED;
		}
		
		this.goHospital();
		return state;
	}
	
	private void goout() {
		if((state != state.SUSPECTEDANDINFECTION  || state != state.INFECTION) && en == en.NORMAL) {
			int r = sr.nextInt(100);
			if(r <= Constant.GOOUTPROBABILITY  * 100) {
				int mx = sr.nextInt(c.weight);
				int my = sr.nextInt(c.length);
				ArrayList<People> pl = c.getAround(mx, my);
				for(People p : pl) {
					p.contant();
				}
				
			}else {
				
			}
		}else {
			
		}
	}
	private Constant.state goh(){
		if(gohealth == -1) {
			gohealth = Constant.CURETIME;
			return state;
		}else {
			if(gohealth == 1) {
				state = state.HEALTH;
				return state;
			}
			gohealth--;
		}
		return state;
	}

}
