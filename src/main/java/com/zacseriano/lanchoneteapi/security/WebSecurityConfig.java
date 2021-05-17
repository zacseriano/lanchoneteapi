package com.zacseriano.lanchoneteapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.zacseriano.lanchoneteapi.filters.JwtRequestFilter;
/*
 * Classe que implementa as configurações da Spring Security da Lanchonete Java API
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private ImplementsUserDetailsService userDetailsService;
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	/*
	 * Campo que indica para que o filtro de autenticação não impeça o Swagger de funcionar
	 */
	private static final String[] AUTH_WHITELIST = {

            // -- swagger ui
            "/swagger-resources/**",
            "/swagger-ui.html",
            "/v2/api-docs",
            "/webjars/**"
    };
	
	/* 
	 * Método que configura o tipo de autenticação, usando o BCrypt como encoder 
	 * de senha
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	/*
	 * Criando o Bean do AuthenticationManager 
	 */
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	/*
	 * Configurando a autorização de todas as URLs da API
	 */
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception{
		httpSecurity.csrf().disable().authorizeRequests()
		.antMatchers("/api/cliente/**").hasRole("CLIENTE")
		.antMatchers("/api/gestor/**").hasRole("GESTOR")
		.antMatchers(AUTH_WHITELIST).permitAll()
        .antMatchers("/**/*").denyAll()		
		.antMatchers(HttpMethod.POST, "/api/cadastrarCliente").permitAll()
		.antMatchers(HttpMethod.POST, "/api/cadastrarGestor").permitAll()
		.antMatchers(HttpMethod.POST, "/api/authenticate").permitAll()
		.anyRequest().authenticated().and()
		.exceptionHandling().and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}	
}