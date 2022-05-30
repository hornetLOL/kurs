package ru.maks.kurs.web.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.maks.kurs.entity.enums.UserRole;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	public static final String LOGIN_ENDPOINT = "/login";
	public static final String STUDENT_ALL_ENDPOINT = "/student/all";
	public static final String STUDENT_EDIT_ENDPOINT = "student/edit*";

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("dummy")
				.password(passwordEncoder().encode("password")).roles("ADMIN", "TEACHER")
				.and()
				.withUser("dummy2")
				.password(passwordEncoder().encode("password")).roles("TEACHER");
	}

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/", "/home").permitAll()
				.antMatchers("/report", "/curse/all", "/student/all", "/stuff/all", "/subject/all").hasRole("TEACHER")
				.antMatchers("/curse/change**", "/student/change**", "/stuff/change**", "/subject/change**").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/", true)
				.permitAll()
				.and()
				.logout()
				.logoutSuccessUrl("/")
				.permitAll()
				.and().csrf().disable();
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
