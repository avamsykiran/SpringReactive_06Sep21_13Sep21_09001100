package com.cts.rjd.service;

public class NumberSeriesGeneratorService implements Runnable{

	private int lowerBound;
	private int upperBound;
	
	public NumberSeriesGeneratorService(int lowerBound, int upperBound) {
		super();
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}

	@Override
	public void run() {
		for(int n=lowerBound;n<=upperBound;n++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(n);
		}
	}
}
