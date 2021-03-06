package com.cts.rjd.ui;

import com.cts.rjd.service.IntervalAndSchedularExample;

public class App05 {

	public static void main(String[] args) throws InterruptedException {

		IntervalAndSchedularExample ise = new IntervalAndSchedularExample();
		
		System.out.println("App started execution!");
		//ise.getIntervals().subscribe(System.out::println);
		
		//ise.getDelayedGreetings().subscribe(System.out::println);
		
		ise.getIntervaledGreetings().subscribe(System.out::println);
		
		Thread.sleep(1500);
		System.out.println("App Terminated!");
	}

}
