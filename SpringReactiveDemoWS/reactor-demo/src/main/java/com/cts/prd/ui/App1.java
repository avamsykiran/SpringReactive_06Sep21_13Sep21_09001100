package com.cts.prd.ui;

import com.cts.prd.service.NumberSeriesService;

public class App1 {

	public static void main(String[] args) {
		NumberSeriesService nss = new NumberSeriesService();
		nss.generateSeries(1, 40).subscribe(System.out::println);
		nss.sumOfGenerateSeries(1, 40).subscribe(System.out::println);
	}

}
