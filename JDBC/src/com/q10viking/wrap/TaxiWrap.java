package com.q10viking.wrap;

public class TaxiWrap implements Car {

	private Car car;

	TaxiWrap(Car car){
		this.car=car;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("After the taxi is repaired，run faster");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		car.stop();
	}
}
