package br.com.zupacademy.juliodutra.mercadolivre.opiniaoProduto;

import br.com.zupacademy.juliodutra.mercadolivre.produto.Produto;
import br.com.zupacademy.juliodutra.mercadolivre.usuario.Usuario;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class NovaOpiniaoProdutoRequest {

    @Positive
    @Range(min = 1, max = 5)
    private int nota;
    @NotBlank
    private String titulo;
    @NotBlank
    @Length(max = 500)
    private String descricao;

    public NovaOpiniaoProdutoRequest(int nota, String titulo, String descricao) {
        this.nota = nota;
        this.titulo = titulo;
        this.descricao = descricao;
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

    public OpiniaoProduto toModel(@NotNull @Valid Produto produto, @NotNull @Valid Usuario usuario) {
        return new OpiniaoProduto(this.nota, this.titulo, this.descricao, produto, usuario);
    }
}
