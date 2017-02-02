package com.cs.designpatterns;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class TestClass {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			FileNotFoundException, IOException, CloneNotSupportedException {
		
		SingletonPattern s1 = SingletonPattern.getInstance();
		SingletonPattern s2 = SingletonPattern.getInstance();

		print("s1", s1);
		print("s2", s2);

		violationUsingReflections();

		violationUsingSerialization(s1);

		violationUsingClonableInterface(s2);

	}
	
	static void useSingleton(){
		SingletonPattern singletonPattern = SingletonPattern.getInstance();
		print("singletonpattern", singletonPattern);
	}

	private static void violationUsingClonableInterface(SingletonPattern s2) throws CloneNotSupportedException {
		// violation of singleton using Cloneable interface
		// override default clone method which returns super.clone() to the
		// caller
		SingletonPattern s5 = (SingletonPattern) s2.clone();
		print("s5", s5);
	}

	private static void violationUsingSerialization(SingletonPattern s1)
			throws IOException, FileNotFoundException, ClassNotFoundException {
		// serialization example
		// Implement Serializable interface to SingletonPattern.java
		ObjectOutputStream ostream = new ObjectOutputStream(new FileOutputStream("F:/Jan2017-Work/data/s1.ser"));
		ostream.writeObject(s1);

		ObjectInputStream istream = new ObjectInputStream(new FileInputStream("F:/Jan2017-Work/data/s1.ser"));
		SingletonPattern s4 = (SingletonPattern) istream.readObject();
		print("s4", s4);
	}

	private static void violationUsingReflections() throws ClassNotFoundException, NoSuchMethodException,
			InstantiationException, IllegalAccessException, InvocationTargetException {
		// Using reflecton to create new instance
		Class class1 = Class.forName("com.cs.designpatterns.SingletonPattern");
		Constructor<SingletonPattern> ctor = class1.getDeclaredConstructor();
		ctor.setAccessible(true);
		SingletonPattern s3 = ctor.newInstance();

		print("s3", s3);
	}

	private static void print(String name, SingletonPattern object) {
		// TODO Auto-generated method stub
		System.out.println(String.format("Name = %s, HashCode = %d", name, object.hashCode()));
	}

}
