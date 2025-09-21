package org.example.yardflow.service;

import org.example.yardflow.model.Usuario;
import org.example.yardflow.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UsuarioDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio uR;

    @Override
    public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {

        Usuario usuario = uR.findByUsername(nome)
                .orElseThrow(()-> new UsernameNotFoundException("Usuário não encontrado"));

        return new User(usuario.getNome(), usuario.getSenha(), usuario.getFuncoes().stream()
                        .map(funcao -> new SimpleGrantedAuthority(funcao.getNome().toString()))
                        .collect(Collectors.toList())
        );
    }
}
