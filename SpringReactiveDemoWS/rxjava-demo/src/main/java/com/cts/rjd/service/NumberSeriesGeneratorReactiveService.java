package com.cts.rjd.service;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class NumberSeriesGeneratorReactiveService implements Runnable,ObservableOnSubscribe<Integer>{

	private int lowerBound;
	private int upperBound;
	private ObservableEmitter<Integer> emitter;
	
	public NumberSeriesGeneratorReactiveService(int lowerBound, int upperBound) {
		super();
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}

	@Override
	public void run() {
		
		if(lowerBound>upperBound) {
			emitter.onError(new Exception("lowerBoudn foudn greater than the upperBound"));
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
	}

	public Observable<Integer> getObservable(){
		return Observable.create(this);
	}
	
	@Override
	public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
		this.emitter=emitter;
		new Thread(this).start();
	}
}
