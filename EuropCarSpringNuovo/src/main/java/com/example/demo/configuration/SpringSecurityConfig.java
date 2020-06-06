//package com.example.demo.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
//	
//	@Autowired
//	private SimpleAuthenticationSuccessHandler successHandler;
//	
//
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/Login/Admin").hasRole("ADMIN").antMatchers("/Login/User").hasRole("USER").and()
//				.formLogin().successHandler(successHandler).and().oauth2Login().and().logout().logoutSuccessUrl("/login?logout=true")
//					.invalidateHttpSession(true).permitAll();
//	}
//
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//		auth.inMemoryAuthentication().withUser("springadmin").password(encoder.encode("admin123")).roles("ADMIN").and().
//			withUser("springuser").password(encoder.encode("user123")).roles("USER");
//	}
//
//	
//	
//	
//	
//}
