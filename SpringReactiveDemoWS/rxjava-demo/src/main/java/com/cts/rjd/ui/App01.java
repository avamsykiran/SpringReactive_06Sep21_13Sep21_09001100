package com.cts.rjd.ui;

import com.cts.rjd.service.NumberSeriesGeneratorService;

public class App01 {

	public static void main(String[] args) {

		NumberSeriesGeneratorService ns = new NumberSeriesGeneratorService(10, 25);
		
		Thread t = new Thread(ns);
		t.start();
		
	}

}
