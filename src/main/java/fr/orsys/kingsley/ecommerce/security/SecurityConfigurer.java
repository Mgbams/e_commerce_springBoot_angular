package fr.orsys.kingsley.ecommerce.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import fr.orsys.kingsley.ecommerce.serviceImpl.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	 
	 @Override
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {  
		auth.userDetailsService(myUserDetailsService);
	  }
	  
	  @Bean
	  public BCryptPasswordEncoder bCryptPasswordEncoder() {
	    return new  BCryptPasswordEncoder();
	  }
	  
	  @Override
	  @Bean
	  public AuthenticationManager authenticationManagerBean() throws Exception {
	      return super.authenticationManagerBean();
	  }
	  
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
	      http.csrf().disable()
	              .authorizeRequests()
	              .antMatchers("/authenticate").permitAll()
	              .antMatchers("/").permitAll()
	              .anyRequest().authenticated();
	  }
}
