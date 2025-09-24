package org.example.yardflow.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SegurancaConfig {

    @Bean
    public SecurityFilterChain chain(HttpSecurity http) throws Exception {
        http
                // regras de autorização
                .authorizeHttpRequests(request -> request
                        // libera estáticos
                        .requestMatchers("/img/**", "/css/**").permitAll()
                        // somente ADMIN pode acessar
                        .requestMatchers("/usuario/novo").hasAuthority("ADMIN")
                        // todo o resto precisa estar autenticado
                        .anyRequest().authenticated()
                )
                // login
                .formLogin(login -> login
                        .loginPage("/index")
                        .defaultSuccessUrl("/home", true)
                        .failureUrl("/login?falha=true")
                        .permitAll()
                )
                // logout
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout=true")
                        .permitAll()
                )
                // tratamento de exceções
                .exceptionHandling(exception -> exception
                        .accessDeniedHandler((request, response, accessDeniedException) -> {
                            response.sendRedirect("/acesso_negado");
                        })
                );


        return http.build();

    }

    @Bean
    public PasswordEncoder encoder() {

        return new BCryptPasswordEncoder();
    }


}