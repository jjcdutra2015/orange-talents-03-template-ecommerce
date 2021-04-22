package br.com.zupacademy.juliodutra.mercadolivre.usuario;

import java.time.LocalDateTime;

public class UsuarioResponse {

    private LocalDateTime instanteCadastro;
    private String login;

    public UsuarioResponse(Usuario usuario) {
        this.instanteCadastro = usuario.getInstanteCadastro();
        this.login = usuario.getLogin();
    }

    public LocalDateTime getInstanteCadastro() {
        return instanteCadastro;
    }

    public String getLogin() {
        return login;
    }
}
