package com.codegym.blogs.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    cấu hình xác thực bộ nhớ với thông tin đăng nhập và vai trò của người dùng.
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("toan").password("{noop}888").roles("ADMIN")
                .and()
                .withUser("user").password("{noop}666").roles("USER");
    }

//     cấu hình bảo mật dựa trên web cho tất cả các yêu cầu HTTP. Theo mặc định, nó sẽ được áp dụng cho tất cả các yêu cầu
//     '/' không được bảo mật và có thể được truy cập bởi bất kỳ ai.
//     '/user' đều được bảo mật và chỉ những người dùng nào có vai trò 'USER' mới có thể truy cập được.
//     '/admin' đều được bảo mật và chỉ những người dùng nào có vai trò 'ADMIN' mới có thể truy cập được.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/admin**").hasRole("ADMIN")
                .and()
                .authorizeRequests().antMatchers("/user**").hasRole("USER")
                .and()
                .formLogin().defaultSuccessUrl("/blogs")
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }
}
