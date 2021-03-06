package com.cts.rjd.ui;

import com.cts.rjd.service.NumberSeriesGeneratorReactiveService2;

public class App03 {

	public static void main(String[] args) {

		NumberSeriesGeneratorReactiveService2 nss = new NumberSeriesGeneratorReactiveService2();
		
		nss.generateSquaredSeries(10, 25).subscribe(
				ele -> System.out.println("Job1: "+ele), 
				Throwable::getMessage, 
				() -> System.out.println("Job1 Accomplished")
				);
		
		nss.generateEvenSeries(10, 25).subscribe(
				ele -> System.out.println("Job2: "+ele), 
				Throwable::getMessage, 
				() -> System.out.println("Job2 Accomplished")
				);
		
	}

}
