package com.cs.designpatterns;

import java.io.Serializable;

public class SingletonPattern implements Serializable, Cloneable {

	private static SingletonPattern soleInstance = null;

	private SingletonPattern() {
		System.out.println("Creating Singleton");
	}

	public static SingletonPattern getInstance() {
		if (soleInstance == null) {
			soleInstance = new SingletonPattern();
		}
		return soleInstance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
