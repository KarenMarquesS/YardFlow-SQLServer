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
                                                // usuario passa pela autenticacao
        http.authorizeHttpRequests( (request) -> request.requestMatchers("/usuario/novo").hasAuthority("ADMIN")
                    .anyRequest().authenticated() )
                                    // pagina de login = quando bem sussedido vai para o home
            .formLogin( (login) -> login.loginPage("/index").defaultSuccessUrl("/home", true)
                    // se falhar = o usuario permanece na mesma página - isso permite enviar uma mensagem de erro
                    .failureUrl("/login?falha=true").permitAll())
                //não tem necessidade de estar autenticado
            .logout((logout) -> logout.logoutUrl("/logout")
                    .logoutSuccessUrl("/login?logout=true").permitAll()  )
            .exceptionHandling((exception) ->
                    exception.accessDeniedHandler((request, response, AccessDeniedException)
                            -> {response.sendRedirect("/acesso_negado");}) );

        return http.build();

    }

    @Bean
    public PasswordEncoder encoder() {

        return new BCryptPasswordEncoder();
    }


}
