package org.wsk.VirusSpreadSimulator;

public class Constant {
	//��Ⱦ����
	public static final double INFECTIONPROBABILITY= 0.8;
	//ҽԺ��λ
	public static final int BEDS = 10;
	//��ʼ��Ⱦ����
	public static final int INITIALINFRCTION = 1;
	//��⣨ȷ�ʱ��
	public static final int CONFIRMTIME = 1;
	//������
	public static final long PEOPLENUM = 50;
	//���Ÿ���
	public static final double GOOUTPROBABILITY = 0.2;
	//���Ƹ���
	public static final double SUSPECTEDPROBABLILTY = 0.2;
	//��������
	public static final double DEATHPROBABLILTY = 0.002;
	//ÿ�������������
	public static final int SAMPLEPREDAY = 2;
	//����ʱ��
	public static final int CURETIME = 14;
	//Ǳ��ʱ��
	public static final int LATENTTIME = 10;
	//״̬
	public static enum state{
		//����
		HEALTH,
		//����
		SUSPECTED,
		//��Ⱦ
		INFECTION,
		//���Ʋ���Ⱦ
		SUSPECTEDANDINFECTION,
		//����
		DEAD,
		//Ǳ��
		LATENT
	}
	//�ص�
	public static enum environment{
		//����
		NORMAL,
		//����
		ISOLATION,
		//ҽԺ
		HOSTIPAL,
		//����
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
