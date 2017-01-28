package com.cs.designpatterns;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestClassUsingMultithreading {

	public static void main(String[] args) {
		// multiple threads causing trouble while lazily creating new instance
		// in getInstance() method
		// creating useSingleton() method to get the instance of singleton
		// object and invoking the method using ExecutorService
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.submit(TestClass::useSingleton); // using java 8 lambda
													// expression to call
													// useSingleton
		service.submit(TestClass::useSingleton);

		service.shutdown();
		
		//two different instances are created

	}

	static void useSingleton() {
		SingletonPattern singletonPattern = SingletonPattern.getInstance();
		print("singletonpattern", singletonPattern);
	}

	private static void print(String name, SingletonPattern object) {
		// TODO Auto-generated method stub
		System.out.println(String.format("Name = %s, HashCode = %d", name, object.hashCode()));
	}

}
