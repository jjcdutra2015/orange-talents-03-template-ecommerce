package br.com.zupacademy.juliodutra.mercadolivre.opiniaoProduto;

import br.com.zupacademy.juliodutra.mercadolivre.produto.Produto;
import br.com.zupacademy.juliodutra.mercadolivre.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
public class OpiniaoProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Positive
    @Range(min = 1, max = 5)
    private int nota;
    @NotBlank
    private String titulo;
    @NotBlank
    @Length(max = 500)
    private String descricao;
    @JsonIgnore
    @NotNull
    @ManyToOne
    private Produto produto;
    @NotNull
    @ManyToOne
    private Usuario usuario;

    @Deprecated
    public OpiniaoProduto() {
    }

    public OpiniaoProduto(int nota, String titulo, String descricao, Produto produto, Usuario usuario) {
        this.nota = nota;
        this.titulo = titulo;
        this.descricao = descricao;
        this.produto = produto;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public int getNota() {
        return nota;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Produto getProduto() {
        return produto;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
