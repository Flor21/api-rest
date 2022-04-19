package com.desafio.apirest.service;

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
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        List<SimpleGrantedAuthority> roles = null;

        Usuario usuario = repository.findByEmail(email);
        if (usuario != null) {
            roles = Arrays.asList(new SimpleGrantedAuthority(usuario.getRole()));
            return new User(usuario.getNombre(), usuario.getContrasenia(), roles);
        }
        throw new UsernameNotFoundException("No se encuentra el usuario con el email: " + email);
    }

    public Usuario save(UsuarioDTO usuario) {
        Usuario usuarioEncontrado = repository.findByEmail(usuario.getEmail());
        Boolean contraseniaVacia = verificarPalabraSinEspacio(usuario.getContrasenia());

        if (usuarioEncontrado == null && !contraseniaVacia) {
            Usuario newUser = new Usuario();
            newUser.setNombre(usuario.getNombre());
            newUser.setContrasenia(bcryptEncoder.encode(usuario.getContrasenia()));
            newUser.setRole(usuario.getRole());
            newUser.setEmail(usuario.getEmail());
            return repository.save(newUser);
        }
        if (contraseniaVacia) {
            throw new UsernameNotFoundException("La contraseña no puede ser vacia");

        }
        throw new UsernameNotFoundException("El email ya esta registrado");
    }

    public Boolean verificarPalabraSinEspacio(String contrasenia) {
        return contrasenia.trim().equals("");
    }

}
