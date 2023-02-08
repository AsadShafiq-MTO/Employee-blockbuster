package com.employeeblockbuster.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService getUserDetailsService()
	{
		 return new UserDetailsServiceImpl(); 
		
		/* OR */
		
		/* return (UserDetailsService) new UserDetailsServiceImpl(); */
	}

	@Bean
	public BCryptPasswordEncoder getPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider getDaoAuthProvider() 
	{
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		
		/*
		 * daoAuthenticationProvider.setUserDetailsService(getUserDetailsService());
		 * 
		 */
		               /* OR */
		
		daoAuthenticationProvider.setUserDetailsService(this.getUserDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(getPasswordEncoder());

		return daoAuthenticationProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		auth.authenticationProvider(getDaoAuthProvider());
	}
	
	
	
//	@Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//            .antMatchers("/").hasAnyAuthority("USER", "CREATOR", "EDITOR", "ADMIN")
//            .antMatchers("/new").hasAnyAuthority("ADMIN", "CREATOR")
//            .antMatchers("/edit/**").hasAnyAuthority("ADMIN", "EDITOR")
//            .antMatchers("/delete/**").hasAuthority("ADMIN")
//            .anyRequest().authenticated()
//            .and()
//            .formLogin().permitAll()
//            .and()
//            .logout().permitAll()
//            .and()
//            .exceptionHandling().accessDeniedPage("/403")
//            ;
//    }	
	
	
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN").antMatchers("/user/**").hasRole("USER")
				.antMatchers("/**").permitAll().and().formLogin()
				.loginPage("/signin")
				.loginProcessingUrl("/myLogin")
				.defaultSuccessUrl("/user/")
				.and().csrf().disable();
		
		/*
		 * .loginPage("/signin").loginProcessingUrl("/login")
		 * .defaultSuccessUrl("/user/").and().csrf().disable();
		 */
	}
}