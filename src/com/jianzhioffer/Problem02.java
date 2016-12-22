package com.jianzhioffer;

/**
 * 实现单例模式
 * 
 * @author zhouxueyun
 */
public class Problem02 {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+"::"+Singleton1.getInstance());
		System.out.println(Thread.currentThread().getName()+"::"+Singleton2.getInstance());
	}
	
}

/**
 * 线程不安全
 */
class Singleton1{
	private static Singleton1 sInstance = null;
	private Singleton1(){
	}
	public static Singleton1 getInstance(){
		if (sInstance==null)
			sInstance = new Singleton1();
		return sInstance;
	}
}

/**
 * 线程安全
 */
class Singleton2{
	private static Singleton2 sInstance = null;
	private Singleton2(){
	}
	public static Singleton2 getInstance(){
		if (sInstance==null) {
			synchronized (Singleton2.class) {
				if (sInstance==null) 
					sInstance = new Singleton2();
			}
		}
		return sInstance;
	}
}