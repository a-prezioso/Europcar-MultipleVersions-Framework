package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.AliquotaIva;

@org.springframework.context.annotation.Configuration
public class Configuration {

	
	@Bean
	@Qualifier("1")
	public AliquotaIva configuraAli1() {
		AliquotaIva oaliquota = new AliquotaIva();
		oaliquota.setAliquota(0);
		oaliquota.setDescrizione("");
		return oaliquota;
	}
	
	@Bean
	@Qualifier("2")
	public AliquotaIva configuraAli2() {
		AliquotaIva oaliquota = new AliquotaIva();
		oaliquota.setAliquota(20);
		oaliquota.setDescrizione("standard");
		return oaliquota;
	}
	
	
}
