package com.nugurang.config;

import com.nugurang.oauth2.OAuth2RestAccessDeniedHandler;
import com.nugurang.oauth2.OAuth2RestAuthenticationEntryPoint;
import com.nugurang.oauth2.OAuth2RestAuthenticationFailureHandler;
import com.nugurang.oauth2.OAuth2RestAuthenticationFilter;
import com.nugurang.oauth2.OAuth2RestAuthenticationProvider;
import com.nugurang.oauth2.OAuth2RestAuthenticationSuccessHandler;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
/*
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
 */
//import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.context.NullSecurityContextRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${nugurang.addr.front.url}")
    private String frontUrl;

    private final OAuth2RestAuthenticationEntryPoint oauth2RestAuthenticationEntryPoint;
    private final OAuth2RestAuthenticationSuccessHandler oauth2RestAuthenticationSuccessHandler;
    private final OAuth2RestAuthenticationFailureHandler oauth2RestAuthenticationFailureHandler;
    private final OAuth2RestAccessDeniedHandler oauth2RestAccessDeniedHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .cors()
            .and()
            .csrf()
            .disable()
            .authorizeRequests()
            .antMatchers("/signin", "/test"/*, "/login"*/)
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .exceptionHandling()
            .authenticationEntryPoint(oauth2RestAuthenticationEntryPoint)
            .accessDeniedHandler(oauth2RestAccessDeniedHandler)
            //.and()
            //.oauth2Login()
            //.loginPage("/signin")
            //.defaultSuccessUrl("/after-signin", true)
            .and()
            .logout()
            //.logoutSuccessUrl("/after-signout")
            .permitAll()
            .clearAuthentication(true)
            .deleteCookies("JSESSIONID")
            .invalidateHttpSession(true)
            .and()
            .headers()
            .frameOptions()
            .sameOrigin()
            .and()
            .addFilterBefore(getFilter(), LogoutFilter.class)
            .securityContext()
            .securityContextRepository(new NullSecurityContextRepository())
            /* TODO
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)*/
        ;
    }

    @Bean
    OAuth2RestAuthenticationFilter getFilter() {
        final var filter = new OAuth2RestAuthenticationFilter();
        filter.setAuthenticationManager(new ProviderManager(Collections.singletonList(new OAuth2RestAuthenticationProvider())));
        filter.setAuthenticationSuccessHandler(oauth2RestAuthenticationSuccessHandler);
        filter.setAuthenticationFailureHandler(oauth2RestAuthenticationFailureHandler);
        return filter;
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin(frontUrl);
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        configuration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
/*
    @Bean
    public OAuth2UserService<OAuth2UserRequest, OAuth2User> oauth2UserService() {
        return new DefaultOAuth2UserService();
    }
 */
}
