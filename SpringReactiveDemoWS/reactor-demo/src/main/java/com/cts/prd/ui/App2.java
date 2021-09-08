package com.cts.prd.ui;

import com.cts.prd.service.NumberSeriesPrimeSubscriber;
import com.cts.prd.service.NumberSeriesService;

public class App2 {

	public static void main(String[] args) {
		NumberSeriesService nss = new NumberSeriesService();
		/*nss.generateSeries(1, 10).subscribe(n -> {
			int count = 2;
			try {
				for (int i = 2; i <= n / 2; i++) {
					count++;
					Thread.sleep(2000);
				}
			} catch (InterruptedException exp) {
				System.err.println(exp.getMessage());
			}

			if (count == 2)
				System.out.println(n + " is prime");
			else
				System.out.println(n + " is composite with " + count + " factors");
		});*/
		
		nss.generateSeries(1, 10).subscribe(new NumberSeriesPrimeSubscriber());
	}

}
