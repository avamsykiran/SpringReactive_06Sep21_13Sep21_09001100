package com.cts.rjd.service;

import java.util.Arrays;

import io.reactivex.Observable;

public class GreetProviderService {

	public Observable<String> getGreetings(){
		return Observable.just("Hello", "Hai","Welcome","Namaskar");
	}
	
	public Observable<String> getGreetingFromAnArray(){
		return Observable.fromArray(new String[] {"Hello", "Hai","Welcome","Namaskar"});
	}
	
	public Observable<String> getGreetingFromAList(){
		return Observable.fromIterable(Arrays.asList(new String[] {"Hello", "Hai","Welcome","Namaskar"}));
	}
}
