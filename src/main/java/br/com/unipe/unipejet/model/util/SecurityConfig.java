package br.com.unipe.unipejet.model.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	public void configuraGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		http.exceptionHandling().and().authorizeRequests().and()
				.exceptionHandling().accessDeniedPage("/index.jsp").and()
				.authorizeRequests().antMatchers("/javax.faces.resource/**")
				.permitAll().and().authorizeRequests().antMatchers("")
				.hasRole("ADMIN").anyRequest().authenticated().and().logout()
				.logoutSuccessUrl("").permitAll().and().formLogin()//.loginPage("/login.jsp")
				.failureUrl("/login.jsp?erro")
				.permitAll();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}
	
}
