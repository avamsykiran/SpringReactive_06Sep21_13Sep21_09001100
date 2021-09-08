package com.cts.rjd.ui;

import com.cts.rjd.service.IntervalAndSchedularExample2;

import io.reactivex.schedulers.Schedulers;

public class App06 {

	public static void main(String[] args) {

		IntervalAndSchedularExample2 ise = new IntervalAndSchedularExample2();
		
		System.out.println("App started execution!");
		
		(new Thread(()-> {
			ise.getIntervals()
			.subscribe(System.out::println);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		})).start();
	}

}
