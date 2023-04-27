package com.example.demo.controllerTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.example.demo.controller.InventoryController;
import com.example.demo.model.InventoryModel;
import com.example.demo.service.InventoryService;
import com.example.demo.service.InventoryServiceImpl;

@TestInstance(Lifecycle.PER_CLASS)
public class InventoryControllerTest {

	@BeforeAll
	public void invInstance() {
		System.out.println("hii");
		InventoryService ser = mock(InventoryServiceImpl.class);

		System.out.println("ser = " + ser);
		System.out.println();
	}

	@Test
	@DisplayName("save inventory")
	void shouldSaveInventory() {

		// when(ser.saveInventory(invModel1)).thenReturn(invModel2);
		// verify(inv.saveInventory(invModel3));

	}

}
