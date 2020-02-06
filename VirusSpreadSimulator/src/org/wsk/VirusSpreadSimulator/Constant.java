package org.wsk.VirusSpreadSimulator;

public class Constant {
	//感染概率
	public static final double INFECTIONPROBABILITY= 0.8;
	//医院床位
	public static final int BEDS = 10;
	//初始感染数量
	public static final int INITIALINFRCTION = 1;
	//检测（确诊）时间
	public static final int CONFIRMTIME = 1;
	//总人数
	public static final long PEOPLENUM = 50;
	//出门概率
	public static final double GOOUTPROBABILITY = 0.2;
	//疑似概率
	public static final double SUSPECTEDPROBABLILTY = 0.2;
	//死亡概率
	public static final double DEATHPROBABLILTY = 0.002;
	//每日样本检测上限
	public static final int SAMPLEPREDAY = 2;
	//治愈时间
	public static final int CURETIME = 14;
	//潜伏时间
	public static final int LATENTTIME = 10;
	//状态
	public static enum state{
		//健康
		HEALTH,
		//疑似
		SUSPECTED,
		//感染
		INFECTION,
		//疑似并感染
		SUSPECTEDANDINFECTION,
		//死亡
		DEAD,
		//潜伏
		LATENT
	}
	//地点
	public static enum environment{
		//正常
		NORMAL,
		//隔离
		ISOLATION,
		//医院
		HOSTIPAL,
		//死亡
		DEAD
	}
	public static enum daycheck {
		CHECKHEALTH,
		HEALTH,
		CHECKINFECTION,
		SUSPECTED,
		DEAD,
		GOHEALTH,
		
	}

}
