package com.q10viking.wrap;

public class Test {
	public static void main(String[] args) {
		Taxi taxi=new Taxi();
		
		taxi.run();
		taxi.stop();
		
		TaxiWrap taxiWrap = new TaxiWrap(taxi);
		taxiWrap.run();
		taxiWrap.stop();
	}
}
