package br.com.zupacademy.juliodutra.mercadolivre.usuario;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotBlank;

public class SenhaLimpa {

    private String senha;

    public SenhaLimpa(@NotBlank @Length(min = 6) String senha) {
        Assert.isTrue(StringUtils.hasLength(senha), "Senha não pode ser vazio");
        Assert.isTrue(senha.length() >= 6, "Senha deve ter no mínimo 6 caracteres");
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public String hash() {
        return new BCryptPasswordEncoder().encode(senha);
    }
}
