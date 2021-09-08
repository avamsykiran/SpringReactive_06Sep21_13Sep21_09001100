package com.cts.prd.ui;

import java.util.Arrays;
import java.util.stream.Stream;

import reactor.core.publisher.Flux;

public class App4 {

	public static void main(String[] args) {
	
		Flux.just("Hello","Hai","Namsthey","Namaskar","Welcome").subscribe(System.out::println);
		
		System.out.println("-----------------------------------------------------------");
		
		Flux.fromArray(new String[] {"Hello","Hai","Namsthey","Namaskar","Welcome"} ).subscribe(System.out::println);
		
		System.out.println("-----------------------------------------------------------");
		
		Flux.fromIterable(Arrays.asList(new String[] {"Hello","Hai","Namsthey","Namaskar","Welcome"}) ).subscribe(System.out::println);
		
		System.out.println("-----------------------------------------------------------");
		
		Flux.fromStream(Stream.of("Hello","Hai","Namsthey","Namaskar","Welcome")).subscribe(System.out::println);
		
		System.out.println("-----------------------------------------------------------");
		
		Flux.combineLatest(
				Flux.just("Hello","Hai","Namsthey","Namaskar","Welcome"), 
				Flux.just("Vamsy","Suseela","Ram","L:askhman"),
				(v1,v2) -> v1 +" "+ v2
				).subscribe(System.out::println);
	
		System.out.println("-----------------------------------------------------------");
		
		Flux.zip(
				Flux.just("Hello","Hai","Namsthey","Namaskar","Welcome"), 
				Flux.just("Vamsy","Suseela","Ram","L:askhman"),
				(v1,v2) -> v1 +" "+ v2
				).subscribe(System.out::println);
	}
}
