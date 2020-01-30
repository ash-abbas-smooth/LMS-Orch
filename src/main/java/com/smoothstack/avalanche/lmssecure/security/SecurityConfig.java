package com.smoothstack.avalanche.lmssecure.security;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private JwtConfig jwtConfig;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.csrf().disable()
			//create stateless sessions
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			//handle authorized attempts
			.exceptionHandling().authenticationEntryPoint((req, res, e) -> res.sendError(HttpServletResponse.SC_UNAUTHORIZED))
			.and()
			//filter
			.addFilterAfter(new JwtAuthenticationFilter(jwtConfig), UsernamePasswordAuthenticationFilter.class)
			.authorizeRequests()
				.antMatchers("/login").permitAll()
				.antMatchers("/lms/admin/**").hasRole("ADMIN")
				.antMatchers("/lms/borrower/**").hasAnyRole("ADMIN", "BORROWER")
				.antMatchers("/lms/librarian/**").hasAnyRole("ADMIN", "LIBRARIAN")
				.anyRequest().authenticated();
	}
	
	@Bean
	public JwtConfig jwtConfig(){
		return new JwtConfig();
	}
	
}
