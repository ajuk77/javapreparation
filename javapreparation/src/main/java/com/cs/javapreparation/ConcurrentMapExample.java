package com.cs.javapreparation;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentMapExample {
	static Map<String, Long> orders = new ConcurrentHashMap<String, Long>();
	//use AtomicLong to prevent inconsistency while multiple threads modifies the map
	public static void processOrders() {
		for(String city : orders.keySet()){
			for (int i = 0; i < 50; i++) {
				Long order = orders.get(city);
				orders.put(city, order+1); 
			}
		}
	}
	
	public static void main(String[] args) {
		orders.put("Bombay", 1l);
		orders.put("Beijing", 1l);
		orders.put("London", 1l);
		orders.put("New York", 1l);
		
		try {
			ExecutorService service = Executors.newFixedThreadPool(2);
			service.submit(ConcurrentMapExample::processOrders);
			service.submit(ConcurrentMapExample::processOrders);

			service.awaitTermination(1, TimeUnit.SECONDS);
			service.shutdown();
			System.out.println("Map :" + orders);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
