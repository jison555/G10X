package com.example.junit.cotrollerTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.example.junit.controller.JunitController;
@TestInstance(Lifecycle.PER_CLASS)
public class JunitControllerTest {
	

	
	 JunitController cont;
	
	@BeforeAll
	public void instanceMeth() {
		 cont = new JunitController();
		 System.out.println("normal instance = "+cont);
		try {
			JunitController conttl = mock(JunitController.class);
			System.out.println("mock instance  = "+conttl);
		}catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	@DisplayName("Demo junit Test")
	void addTest() {
		System.out.println("Demo junit Test");
		Assertions.assertEquals(5, cont.add(3, 2));
	}
	
	
	@Nested
	class InnerClass{
		
		@Test
		@DisplayName("inner class method test")
		public void inneMeth() {
			System.out.println("inner class method test = " + cont);
		}
	}

}
