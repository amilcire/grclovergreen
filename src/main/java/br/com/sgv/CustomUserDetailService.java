/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sgv;

import br.com.sgv.model.Usuario;
import br.com.sgv.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pablo Rangel
 */
 
@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Buscar o usuário pelo login
        final Usuario usuario = usuarioRepository.findByLogin(username);
        
        // Se não encontrar o usuário, lançar exceção
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        // Verificar a senha com BCrypt
        return User.withUsername(usuario.getLogin())
                   .password(usuario.getSenha()) // Senha criptografada no banco de dados
                   .roles(usuario.getPapel())    // Papel do usuário (role)
                   .build();
    }
}

