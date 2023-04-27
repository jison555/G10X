package com.example.junit.controller;

import java.util.HashMap;

public class HashMapClass {
	
		public static void main(String... args){
		HashMap<Test, String> a = new HashMap();
		a.put(new Test("a"), "a");
		a.put(new Test("b"), "b");
		System.out.println(a.get(new Test("a")) + " " + a.get(new Test("b")));
		}

}
