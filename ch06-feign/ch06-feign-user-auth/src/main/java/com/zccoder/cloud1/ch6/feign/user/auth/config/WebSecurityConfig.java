package com.zccoder.cloud1.ch6.feign.user.auth.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @title 配置类
 * @describe Spring Security配置类
 * @author zc
 * @version 1.0 2017-12-05
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 所有的请求，都需要经过Http Basic认证
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		// 明文编码器。这是一个不做任何操作的密码编码器，是Spring提供给我们用来做明文测试的
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Autowired
	private CustomUserDetailsServiceImpl userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.userDetailsService).passwordEncoder(this.passwordEncoder());
	}

	@Component
	class CustomUserDetailsServiceImpl implements UserDetailsService{
		
		/**
		 * 模拟两个账户
		 * ①账号时user，密码是password1，角色是user-role
		 * ②账号时admin，密码是password2，角色是admin-role
		 */
		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

			String roleUser = "user";
			String roleAdmin = "admin";

			if(roleUser.equals(username)){
				return new SecurityUser("user","password1","user-role");
			}else if(roleAdmin.equals(username)){
				return new SecurityUser("admin","password2","admin-role");
			}else{
				return null;
			}
		}
	}
	
	class SecurityUser implements UserDetails{
		
		private static final long serialVersionUID = -3678869230490873602L;

		public SecurityUser(String username, String password, String role) {
			super();
			this.username = username;
			this.password = password;
			this.role = role;
		}

		public SecurityUser() {
		}

		private Long id;
		private String username;
		private String password;
		private String role;
		
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority(this.role);
			authorities.add(authority);
			return authorities;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		@Override
		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		@Override
		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}
		
	}
}
