package br.com.zupacademy.juliodutra.mercadolivre.usuario;

import br.com.zupacademy.juliodutra.mercadolivre.config.compartilhado.UniqueEmail;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class NovoUsuarioRequest {

    @NotBlank
    @Email
    @UniqueEmail(domainClass = Usuario.class, fieldName = "email")
    private String email;
    @NotBlank
    @Length(min = 6)
    private String senha;

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Usuario toModel() {
        return new Usuario(email, new SenhaLimpa(senha));
    }
}
