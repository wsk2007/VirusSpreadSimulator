package org.wsk.VirusSpreadSimulator;

public class Hospital {
	public static int beds = Constant.BEDS;
	public static int peoples = 0;
	public static boolean goin(People p ) {
		if (peoples < beds) {
			p.en = Constant.environment.HOSTIPAL;
			return true;
		}else {
			return false;
		}
	}

}
