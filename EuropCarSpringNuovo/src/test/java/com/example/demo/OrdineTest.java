package com.example.demo;

import static org.junit.Assert.assertThrows;
//import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Fornitore;
import com.example.demo.model.OrdineAcquisto;



@DisplayName("OrdineTest")
public class OrdineTest {
		
	
	@BeforeAll
	public static void init() {
		System.out.println("before all started");
	}
	
	@BeforeEach
	public void init1() {
		System.out.println("before each started");
		
	}
	
	@AfterEach
	public void init2() {
		System.out.println("after each started");
	}
	
	
	@AfterAll
  public static void init3() {
		System.out.println("after all");
	}
	
	
	
	//Flusso di controllo è:
	/*
	 * before all
	 * 
	 * before each 
	 * metodo 2
	 * after each
	 * 
	 * before each 
	 * metodo 2
	 * after each
	 * 
	 * after all
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
	@Test
	@DisplayName("nuovoOrdineTest")
	public void nuovaOrdine() {
		OrdineAcquisto ordine = new OrdineAcquisto();
		Fornitore ofornitore = new Fornitore();
		
		System.out.println("nuovaAliquota");
		ordine.setImporto(2);
		ordine.setOfornitore(ofornitore);
		ordine.getOfornitore().setCitta("teramo");
		List<OrdineAcquisto> ordini = new ArrayList<>();
		ordini.add(ordine);
		assertNotNull(ordini);
		assertEquals(2, ordini.get(0).getImporto());
		assertEquals("teramo", ordini.get(0).getOfornitore().getCitta());
//		assertEquals("teram", ordini.get(0).getOfornitore().getCitta());
		//assertTrue controlla se un booleano è true assertFalse il contrario

	}
	
	
	@Test
	@Disabled
	public void exceptionControl() {
		System.out.println("exceptionControl");
		OrdineAcquisto ordine = new OrdineAcquisto();
//		ordine.setData("ciao");
		assertThrows(NullPointerException.class, () -> ordine.getOfornitore().setCap("prova"));
	}
	
	
	
	

}
