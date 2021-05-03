package br.com.zupacademy.juliodutra.mercadolivre.pergunta;

import br.com.zupacademy.juliodutra.mercadolivre.produto.Produto;
import br.com.zupacademy.juliodutra.mercadolivre.usuario.Usuario;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Pergunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String titulo;
    @NotNull
    @ManyToOne
    private Produto produto;
    @NotNull
    @ManyToOne
    private Usuario usuarioLogado;
    private LocalDateTime instanteCriacao = LocalDateTime.now();

    public Pergunta(@NotBlank String titulo, @NotNull @Valid Produto produto, @NotNull @Valid Usuario usuarioLogado) {
        this.titulo = titulo;
        this.produto = produto;
        this.usuarioLogado = usuarioLogado;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Produto getProduto() {
        return produto;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public LocalDateTime getInstanteCriacao() {
        return instanteCriacao;
    }
}
