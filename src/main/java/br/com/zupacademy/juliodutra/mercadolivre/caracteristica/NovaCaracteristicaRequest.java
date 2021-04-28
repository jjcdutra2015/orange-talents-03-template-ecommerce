package br.com.zupacademy.juliodutra.mercadolivre.caracteristica;

import br.com.zupacademy.juliodutra.mercadolivre.produto.Produto;

import javax.validation.constraints.NotBlank;

public class NovaCaracteristicaRequest {

    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;

    public NovaCaracteristicaRequest(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "NovaCaracteristicaRequest{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    public CaracteristicaProduto toModel(Produto produto) {
        return new CaracteristicaProduto(this.nome, this.descricao, produto);
    }
}
