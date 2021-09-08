package com.cts.prd.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class NumberSeriesService {

	public Flux<Integer> generateSeries(int lb, int ub) {
		return Flux.create(emitter -> {

			if (lb > ub) {
				emitter.error(new Exception("Invlid limits, operation aborted"));
				return;
			}

			(new Thread(() -> {

				try {
					for (int i = lb; i <= ub; i++) {
						emitter.next(i);
						Thread.sleep(1000);
					}
				} catch (InterruptedException exp) {
					emitter.error(exp);
				}
				emitter.complete();
			})).start();

		});
	}

	public Flux<Integer> generateEvenSeries(int lb, int ub) {
		return generateSeries(lb, ub).filter(v -> v % 2 == 0);
	}

	public Flux<Integer> generateSquaredSeries(int lb, int ub) {
		return generateSeries(lb, ub).map(v -> v * v);
	}

	public Mono<Integer> sumOfGenerateSeries(int lb, int ub) {
		return generateSeries(lb, ub).reduce((v1, v2) -> v1 + v2);
	}

}
