package com.cts.prd.service;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class NumberSeriesPrimeSubscriber implements Subscriber<Integer> {

	private Subscription s;
	private long batchCount=1;
	
	@Override
	public void onSubscribe(Subscription s) {
		this.s=s;
		s.request(batchCount);
	}

	@Override
	public void onNext(Integer n) {
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
		
		s.request(batchCount);
	}

	@Override
	public void onError(Throwable t) {
		System.err.println(t.getMessage());
	}

	@Override
	public void onComplete() {
		System.out.println("Job Accomplished");
	}

}
