package com.example.demo.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.model.OrdineDiAcquistoDettaglio;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Dettagli non presenti")
public class DettaglioNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 851137198326731653L;

	
	private String ordineacquisto;
	
	public DettaglioNotFoundException(String ordine) {
		this.ordineacquisto = ordine;
	}

	public String getOrdineacquisto() {
		return ordineacquisto;
	}

	public void setOrdineacquisto(String ordineacquisto) {
		this.ordineacquisto = ordineacquisto;
	}

	
	
	
}
