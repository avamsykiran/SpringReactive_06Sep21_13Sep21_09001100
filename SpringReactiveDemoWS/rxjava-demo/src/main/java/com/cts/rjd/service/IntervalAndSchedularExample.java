package com.cts.rjd.service;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class IntervalAndSchedularExample {

	public Observable<Long> getIntervals(){
		//return Observable.interval(1000, 500, TimeUnit.MILLISECONDS, Schedulers.single());
		return Observable.interval(0, 500, TimeUnit.MILLISECONDS, Schedulers.single());
	}

	public Observable<String> getDelayedGreetings(){ //emit first and wait
		return Observable.just("Hello", "Hai","Welcome","Namaskar").delay(500, TimeUnit.MILLISECONDS);
	}
	
	public Observable<String> getIntervaledGreetings(){//wait first and then emit
		
		String[] greetings = new String[] {"Hello", "Hai","Welcome","Namaskar"};
		
		return Observable.
				intervalRange(0, greetings.length, 0, 500, TimeUnit.MILLISECONDS, Schedulers.single()).
				map(v -> (int)(long)v).
				map(index -> greetings[index]);
				
	}
}
