package com.seneca.global.todoservice.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;

@EnableWebSecurity
@SecurityScheme(name="todoapi", scheme="basic", type=SecuritySchemeType.HTTP, in=SecuritySchemeIn.HEADER)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    
    @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("abc@abc.com")
		.password("{bcrypt}$2a$10$BagghBQvnxcVuhHyXc9g9.fM6s109FakmyF4tPAoOMRkjqKsg1xl.") //123
		.authorities("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		
		.antMatchers("/swagger-ui/**","/v3/api-docs/**").permitAll()
		.anyRequest().authenticated()
		.and().httpBasic();
		http.csrf().disable();
	}
}

