package com.example.demo.generation;

public class FatturaElettronica {
	
	private FatturaElettronicaHeader header;
	
	private FatturaElettronicaBody body;

	
	// Get e Set
	public FatturaElettronicaHeader getHeader() {
		return header;
	}

	public void setHeader(FatturaElettronicaHeader header) {
		this.header = header;
	}

	public FatturaElettronicaBody getBody() {
		return body;
	}

	public void setBody(FatturaElettronicaBody body) {
		this.body = body;
	}

}
