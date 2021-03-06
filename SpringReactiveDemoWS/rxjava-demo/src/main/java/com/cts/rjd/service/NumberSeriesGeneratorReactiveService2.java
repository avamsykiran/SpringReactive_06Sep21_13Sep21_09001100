package com.cts.rjd.service;

import java.util.Arrays;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class NumberSeriesGeneratorReactiveService2 {

	public Observable<Integer> generateSeries(int lowerBound,int upperBound){
		return Observable.create(emitter -> {
			new Thread(() -> {

				if(lowerBound>upperBound) {
					emitter.onError(new Exception("lowerBoudn found greater than the upperBound"));
					return;
				}
				
				for(int n=lowerBound;n<=upperBound;n++) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//System.out.println(n);
					emitter.onNext(n);
				}
				
				emitter.onComplete();		
			}).start();
		});
	}

	public Observable<Integer> generateEvenSeries(int lowerBound,int upperBound){
		return generateSeries(lowerBound, upperBound).filter(v -> v%2==0);
	}
	
	public Observable<Integer> generateSquaredSeries(int lowerBound,int upperBound){
		return generateSeries(lowerBound, upperBound).map(v -> v*v);
	}
	
	public Observable<Integer> generateEvenSquaredSeries(int lowerBound,int upperBound){
		return generateSeries(lowerBound, upperBound).filter(v -> v%2==0).map(v -> v*v);
	}
	
}
