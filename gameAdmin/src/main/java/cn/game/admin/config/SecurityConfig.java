package cn.game.admin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 */

@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private PasswordEncoder passwordEncoder;
	//
	@Autowired
	private UserDetailsService securityUserDetailsService;

	/**
	 * 
	 * 验证登录用户
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(securityUserDetailsService).passwordEncoder(passwordEncoder);
		// 给内存加载一个用户
		auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");

	}

	@Configuration
	@Order(1)
	public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		 @Override
		    public void configure(WebSecurity web) throws Exception {
		      web.ignoring().antMatchers(
		          "/resources/**",
		          "/webjars/**",
		          "/js/**",
		          "/images/**",
		          "/css/**",
		          "/h2-console/*",
		          "/assets/*"
		      );
		    }

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			// 关闭X-Frame-Options
			http.headers().frameOptions().disable();
			http.authorizeRequests().antMatchers("/", "/home").permitAll().anyRequest().authenticated().and()
					.formLogin().loginPage("/login").defaultSuccessUrl("/").failureUrl("/login?error").permitAll().and()
					.logout().permitAll();
		}

	}
}