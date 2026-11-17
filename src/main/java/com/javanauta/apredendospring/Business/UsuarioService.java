package com.javanauta.apredendospring.Business;

import com.javanauta.apredendospring.Infrastructure.Entity.Usuario;
import com.javanauta.apredendospring.Infrastructure.Repository.UsuarioRepository;
import com.javanauta.apredendospring.Infrastructure.exceptions.ConflictException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.cert.CertificateException;

@Service
@RequiredArgsConstructor

public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public Usuario salvaUsuario(Usuario usuario) {
        try {
            emailExiste(usuario.getEmail());
            usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
            return usuarioRepository.save(usuario);
        } catch (ConflictException e) {
            throw new ConflictException("Email já cadastrado" + e.getCause());
        }
    }

    public void emailExiste(String email){
        try{
            boolean existe= verificaEmailExistente(email);
            if (existe){
                throw new CertificateException("Email já cadastrado" + email);
            }
        }catch (CertificateException e){
            throw new ConflictException("Email já cadastrado" + e.getCause());
        }
    }

    public boolean verificaEmailExistente(String email){
        return usuarioRepository.existsByEmail(email);
    }
}
