package com.sol.b5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		// 정적 자원 요청 URL은 Security 거치지 않고 통과
		web.ignoring()
					.antMatchers("/css/**")
					.antMatchers("/js/**")
					.antMatchers("/images/**")
					.antMatchers("/vendor/**")
					.antMatchers("/favicon*/**")
					.antMatchers("/resources/**")
					.antMatchers("/front/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
			.cors()
			.and()
			.csrf().disable()
			.authorizeRequests()
								.antMatchers("/").permitAll()
								.antMatchers("/notice/selectList", "/notice/selectOne").permitAll()
								.antMatchers("/notice/**").hasRole("ADMIN")
								//.antMatchers("/notice/insert", "/notice/update", "/notice/delete").hasRole("ADMIN")
								// ROLE_ 를 제외한 나머지 roleName
								//.antMatchers("/member/memberLogin").permitAll()
								.antMatchers("/member/memberJoin").permitAll()
								.anyRequest().authenticated()
								// 위의 antMatchers 그 외 나머지는 인증(로그인)이 되어야 가능
								.and()
			// Security에서는 기본 로그인 폼을 제공
			// 개발자가 만든 로그인 폼으로 사용
			.formLogin()
						.loginPage("/member/memberLogin")
						.defaultSuccessUrl("/")
						// 파라미터 이름은 security에서는 username을 사용
						// 파라미터 이름이 다를 경우 작성
						.usernameParameter("id")
						.passwordParameter("pw")
						.permitAll()
						
						;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		// Spring 5 이후부터, 비밀번호를 평문 저장 금지
		return new BCryptPasswordEncoder();
	}
}
