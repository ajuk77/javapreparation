package com.cs.javapreparation;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapExample {
	public static void main(String[] args) {
		Map<Order, Integer> orders = new WeakHashMap<>();
		orders.put(new Order(1, "Ajinkya"), 1);
		orders.put(new Order(2, "AJ"), 2);

		Order order3 = new Order(3, "J");
		orders.put(order3, 3);
		
		System.gc();
		System.out.println("Size of the map :" + orders.size());
	}

}

class Order {
	int orderId;
	String details;
	
	public Order(int id, String dt){
		orderId = id;
		details = dt;
	}
}
