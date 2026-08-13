package com.cm.med_app.config;

import com.cm.med_app.controller.AdminController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final AdminController adminController;

    SecurityConfig(AdminController adminController) {
        this.adminController = adminController;
    }

   @Bean
   public BCryptPasswordEncoder passwordEncoder()
   {
	   return new BCryptPasswordEncoder();
   }
   
   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
   {
	   http.csrf(csrf->csrf.disable()).authorizeHttpRequests(auth->auth
			   .requestMatchers("/","/shop","/product/**","/apppointment","/thankyou","/login","/css/**","/js/**","/images/**").permitAll()
			   .requestMatchers("/recommend").hasAnyRole("PATIENT","PHARMACIST","ADMIN")
			   .requestMatchers("/add").hasAnyRole("PHARMACIST","ADMIN")
			   .requestMatchers("/checkout").hasAnyRole("PHARMACIST","ADMIN","PATIENT")
			   .requestMatchers("/cart/**").hasAnyRole("PHARMACIST","ADMIN","PATIENT")
			   .requestMatchers("/admin/**").hasRole("ADMIN")
			   .requestMatchers("/pharmacy/**").hasRole("PHARMACIST")
			   .anyRequest()
			   .authenticated()
			   )
	           //.httpBasic(Customizer.withDefaults())
	           .formLogin(form->form
	        		   .loginPage("/login")
	        		   .loginProcessingUrl("/login")
	        		   .defaultSuccessUrl("/",true)
	        		   .failureUrl("/login?error=true")
	        		   .permitAll()
	        		   )
	           .logout(logout-> logout
	        		  .logoutUrl("/logout")
	        		  .logoutSuccessUrl("/login?logout=true")
	        		  .invalidateHttpSession(true)
	        		  .deleteCookies("JSESSIONID")
	        		  .permitAll()
	        		  );
	           
	   return http.build();
   }
}
