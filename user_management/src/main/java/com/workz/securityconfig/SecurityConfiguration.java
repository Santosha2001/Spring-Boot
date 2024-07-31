package com.workz.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	public SecurityConfiguration() {
		super();
		System.out.println("SecurityConfiguration");
	}

	// custom user details service
	@Autowired
	private SecurityCustomUserDetailsService customUserDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// dao authentication provider
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

		daoAuthenticationProvider.setUserDetailsService(customUserDetailsService);
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

		// managing routes(handlers) or url's
		httpSecurity.authorizeHttpRequests(authorize -> {
			// authorize.requestMatchers("/","/register").permitAll();
			authorize.requestMatchers("/user/**").authenticated();
			authorize.anyRequest().permitAll();
		});

		// form login
		httpSecurity.formLogin(formLogin -> {
			formLogin.loginPage("/login");
			formLogin.loginProcessingUrl("/signin");
			formLogin.defaultSuccessUrl("/user/profile");
			// formLogin.failureForwardUrl("/login?error=true");
			formLogin.usernameParameter("email");
			formLogin.passwordParameter("password");

		});

		// form logout
		httpSecurity.csrf(AbstractHttpConfigurer::disable);
		httpSecurity.logout(logoutForm -> {
			logoutForm.logoutUrl("/logout");
			logoutForm.logoutSuccessUrl("/login?logout=true");
		});

		return httpSecurity.build();
	}
}
