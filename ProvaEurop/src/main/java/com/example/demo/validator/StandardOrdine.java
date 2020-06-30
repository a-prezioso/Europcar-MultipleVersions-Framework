package com.example.demo.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StandardOrdineImpl.class)
@Documented
public @interface StandardOrdine {
	
	public String message() default "Inserire il prefisso Ord- per l'ordine acquisto";
	
	public String errore() default "Ord-";
	
	public Class<?>[] groups() default {};
	
	public abstract Class<? extends Payload>[] payload() default {};

}
