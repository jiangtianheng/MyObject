package com.cappuccino.offer.jobs;


public class CapService {

	public static  Integer work(Double payout) {
		int cap = 100;
		if (payout <= 1) {
			cap = 1000;
		}
		if (payout > 1 && payout <= 2) {
			cap = 500;
		}
		if (payout > 2 && payout <= 4) {
			cap = 200;
		}
		if (payout > 4) {
			cap = 100;
		}
		return cap;
	}
	
	
	
	
}
