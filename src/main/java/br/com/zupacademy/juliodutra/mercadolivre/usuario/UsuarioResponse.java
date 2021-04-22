package br.com.zupacademy.juliodutra.mercadolivre.usuario;

import java.time.LocalDateTime;

public class UsuarioResponse {

    private Long id;
    private LocalDateTime instanteCadastro;
    private String email;

    public UsuarioResponse(Usuario usuario) {
        this.id = usuario.getId();
        this.instanteCadastro = usuario.getInstanteCadastro();
        this.email = usuario.getEmail();
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getInstanteCadastro() {
        return instanteCadastro;
    }

    public String getEmail() {
        return email;
    }
}
