package com.example.myAPP_1;

import com.sohaib.dao.Services.PersonneService;
import com.sohaib.main.mainClass.DemoApplication;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = DemoApplication.class)
class DemoApplicationTests {

	@Autowired
	PersonneService personneService;
/*
	@Autowired
	DataController dataController;*/

	@BeforeEach
	public void messageAvant(){
		System.out.println("Début des Tests .");
	}

	@AfterEach
	public void messageApres(){
		System.out.println("Fin des Tests .");
	}
	
/*
	@Test
	public void contextLoads() {
		assertEquals(HttpStatus.OK,dataController.recupererToutesLesPersonnes().getStatusCode()); // tester si la reponse est 200

		System.out.println("TEST 01 ");
	}
*/

}
