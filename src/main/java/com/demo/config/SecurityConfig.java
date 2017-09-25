package com.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@PropertySource({"classpath:security.properties"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${security.usersByUsernameQuery}")
    private String usersByUsernameQuery;

    @Value("${security.authoritiesByUsernameQuery}")
    private String authoritiesByUsernameQuery;

    @Value("${security.realmName}")
    private String realmName;

    @Value("${security.remember_me.key}")
    private String key;

    @Value("${security.form_login.loginPage}")
    private String loginPage;

    @Value("${security.password.secret}")
    private String secret;

    @Autowired
    private DataSource dataSource;

    @Bean
    public PersistentTokenRepository memoryTokenRepository() {
        return new InMemoryTokenRepositoryImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new StandardPasswordEncoder(secret);
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .formLogin()
                .loginPage(loginPage)
            .and()
            .logout()
                .logoutSuccessUrl("/")
            .and()
            .rememberMe()
                .tokenRepository(memoryTokenRepository())
                .tokenValiditySeconds(2419200) // 4 weeks
                .key(key)
            .and()
            .httpBasic()
                .realmName(realmName)
            .and()
            .authorizeRequests()
                .regexMatchers("\\/user\\/create\\/?").permitAll()
                .regexMatchers("\\/user\\/delete\\/.*").hasRole("ADMIN")
                .regexMatchers("\\/user(\\/.*)?(\\?.*)?").authenticated()
                .anyRequest().permitAll();
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(usersByUsernameQuery)
                .authoritiesByUsernameQuery(authoritiesByUsernameQuery)
                .passwordEncoder(passwordEncoder());
    }

    
}
