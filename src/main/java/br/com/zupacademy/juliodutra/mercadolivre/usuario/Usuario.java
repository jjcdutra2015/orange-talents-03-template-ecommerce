package br.com.zupacademy.juliodutra.mercadolivre.usuario;

import org.hibernate.validator.constraints.Length;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @PastOrPresent
    private LocalDateTime instanteCadastro = LocalDateTime.now();
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Length(min = 6)
    private String senha;

    @Deprecated
    public Usuario() {
    }

    public Usuario(@Email @NotBlank String email, SenhaLimpa senhaLimpa) {
        Assert.isTrue(StringUtils.hasLength(email), "Email não pode estar vazio");
        Assert.notNull(senhaLimpa, "Objeto senha limpa não pode ser nulo");
        this.email = email;
        this.senha = senhaLimpa.hash();
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

    public String getSenha() {
        return senha;
    }
}
