package com.desafio.apirest.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.desafio.apirest.model.Usuario;
import com.desafio.apirest.model.UsuarioDTO;
import com.desafio.apirest.repository.UsuarioRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<SimpleGrantedAuthority> roles = null;

        Usuario user = repository.findByNombre(username);
        if (user != null) {
            roles = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
            return new User(user.getNombre(), user.getContrasenia(), roles);
        }
        throw new UsernameNotFoundException("No se encuntra el usuario con el nombre: " + username);
    }

    public Usuario save(UsuarioDTO user) {
        Usuario newUser = new Usuario();
        newUser.setNombre(user.getNombre());
        newUser.setContrasenia(bcryptEncoder.encode(user.getContrasenia()));
        newUser.setRole(user.getRole());
        return repository.save(newUser);
    }

}
