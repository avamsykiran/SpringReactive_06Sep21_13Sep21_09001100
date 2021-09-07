package com.cts.rjd.ui;

import com.cts.rjd.service.GreetProviderService;

public class App04 {

	public static void main(String[] args) {

		GreetProviderService gps = new GreetProviderService();
		
		gps.getGreetings().subscribe(v -> System.out.println("From CommaSeperatedSource: "+v));
		gps.getGreetingFromAnArray().subscribe(v -> System.out.println("From Array: "+v));
		gps.getGreetingFromAList().subscribe(v -> System.out.println("From List: "+v));
		
		
	}

}
