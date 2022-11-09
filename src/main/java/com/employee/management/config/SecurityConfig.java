package com.employee.management.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.employee.management.entity.EmployeeUserDetails;
import com.employee.management.serviceImp.EmployeeUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new EmployeeUserDetailService();
	}
	
	
	
//	@Override
//	public UserDetailsService userDetailsServiceBean() throws Exception {
//		// TODO Auto-generated method stub
//		return super.userDetailsServiceBean();
//	}



	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("User1").password(passwordEncoder().encode("1234")).roles("USER")                               
//                                 //.authorities("USER")
//                             .and().withUser("User2").password(passwordEncoder().encode("1234")).roles("USER")
//                                 //.authorities("USER")
//                             .and().withUser("admin").password(passwordEncoder().encode("1234")).roles("ADMIN");
//                                 //.authorities("ADMIN");	                              
//		auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
		auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
		
		
	}

//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		
//	}
//
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		    .cors().disable()
    	    .authorizeRequests()
    	    .antMatchers("/ReadServices/**").hasAnyRole("USER","ADMIN")
	        .and()
	        .authorizeRequests()
            .antMatchers("/CreateServices/**","/UpdateServices/**","/DeleteServices/**").hasRole("ADMIN")
            .anyRequest().authenticated()
            .and()
	        .formLogin().defaultSuccessUrl("/ReadServices", true) 
	        .and()
	        .httpBasic();

	}

//    @Bean
//    public InMemoryUserDetailsManager userDetailService() {
//    	
//    	UserDetails user1 = User
//    	UserDetails user2 = User.withUsername("User2")
//                                .password(passwordEncoder().encode("1234"))
//                                .roles("USER").authorities("ROLE_USER")
//                                .build();
//    	UserDetails admin = User.withUsername("admin")
//                                .password(passwordEncoder().encode("1234"))
//                                .roles("ADMIN").authorities("ROLE_ADMIN")
//                                .build();
//    	return new InMemoryUserDetailsManager(user1,user2, admin);
//
//    	
//    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
}
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//    	http.csrf().disable()
//    	    .authorizeRequests()
//    	    .antMatchers("/CreateServices").access("hasRole('ROLE_ADMIN')")
//    	    .antMatchers("/UpdateServices").access("hasRole('ROLE_ADMIN')")
//    	    .antMatchers("/DeleteServices").access("hasRole('ROLE_ADMIN')")
//    	    .antMatchers("/ReadServices").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
//    	    .and()
//    	    .formLogin();
//    	     return http.build();
//    	                
//    }
//   


	
	
}
