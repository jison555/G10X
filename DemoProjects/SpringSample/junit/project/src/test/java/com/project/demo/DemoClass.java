package com.project.demo;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

public class DemoClass {
	
	@Test
	public void test() {
		TodoService todoService =  mock(TodoService.class);
		System.out.println(todoService);
	}

}
