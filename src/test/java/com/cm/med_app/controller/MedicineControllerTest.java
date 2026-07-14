//package com.cm.med_app.controller;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import java.util.List;
//
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import com.cm.med_app.model.Medicine;
//import com.cm.med_app.repository.MedicineRepo;
//
//@SpringBootTest
//public class MedicineControllerTest {
//
//	@Autowired
//	private MedicineRepo medRepo;
//	@Autowired
//	private MedicineController medContro;
//	
//	
//	@BeforeAll
//	static void beforeAll()
//	{
//		System.out.println("===Start===");
//	}
//	@AfterAll
//	static void afterAll()
//	{
//		System.out.println("===End===");
//	}
//	@BeforeEach
//    void setUp()
//	{
//		medRepo.deleteAll();
//	}
//	@AfterEach
//	void tearDown()
//	{
//		System.out.println("test done");
//	}
//	
//	@Test
//	void testAddMedicine()
//	{
//		Medicine medicine=new Medicine(null,"paracetamol",50.6,null,null,null);
//		Medicine result=medContro.add(medicine);
//		assertNotNull(result);
//		assertEquals("paracetamol",result.getName());
//		assertTrue(result.getPrice()>0.0);
//	}
//	
//	@Test
//	void testGetAllMedicine()
//	{
//		medContro.add(new Medicine(null,"Dolo",55.0,null,null,null));
//		List<Medicine> medicines=medContro.getAll();
//		assertNotNull(medicines);
//		assertEquals(1,medicines.size());
//	}
//	
//	
//	
//}
