package com.cts.prd.ui;

import java.time.Duration;

import com.cts.prd.service.NumberSeriesPrimeSubscriber;
import com.cts.prd.service.NumberSeriesService;

public class App3 {

	public static void main(String[] args) {
		NumberSeriesService nss = new NumberSeriesService();
		
		/*
		nss.generateSeries(1, 10).
			take(5).
			subscribe(System.out::println);
		*/

		/*
		nss.generateSeries(1, 10).
			take(Duration.ofMillis(3000)).
			subscribe(System.out::println);
		 */
		
		/*
		nss.generateSeries(1, 10).
			takeUntil(v -> v%7==0).
			subscribe(System.out::println);
		*/
		
		nss.generateSeries(1, 10).
			takeWhile(v -> v%7!=0).
			subscribe(System.out::println);

		
	}

}
