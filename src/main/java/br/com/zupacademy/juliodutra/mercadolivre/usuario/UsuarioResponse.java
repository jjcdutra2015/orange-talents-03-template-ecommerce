package br.com.zupacademy.juliodutra.mercadolivre.usuario;

import java.time.format.DateTimeFormatter;

public class UsuarioResponse {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private Long id;
    private String instanteCadastro;
    private String email;

    public UsuarioResponse(Usuario usuario) {
        this.id = usuario.getId();
        String dataFormatada = usuario.getInstanteCadastro().format(formatter);
        this.instanteCadastro = dataFormatada;
        this.email = usuario.getEmail();
    }

    public Long getId() {
        return id;
    }

    public String getInstanteCadastro() {
        return instanteCadastro;
    }

    public String getEmail() {
        return email;
    }
}
