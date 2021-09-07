package com.cts.rjd.ui;

import com.cts.rjd.service.NumberSeriesGeneratorReactiveService;

public class App02 {

	public static void main(String[] args) {

		NumberSeriesGeneratorReactiveService nss = new NumberSeriesGeneratorReactiveService(10, 25);
		
		nss.getObservable().subscribe(
				ele -> System.out.println(ele), 
				exp -> System.out.println("Error "+ exp.getMessage()), 
				() -> System.out.println("Job1 Accomplished")
				);
		

		NumberSeriesGeneratorReactiveService nss2 = new NumberSeriesGeneratorReactiveService(125,150);
		
		nss2.getObservable().subscribe(
				ele -> System.out.println(ele), 
				exp -> System.out.println("Error "+ exp.getMessage()), 
				() -> System.out.println("Job2 Accomplished")
				);
		
		System.out.println("Hello All of you!!");
	}

}
