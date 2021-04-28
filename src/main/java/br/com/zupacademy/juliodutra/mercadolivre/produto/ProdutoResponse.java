package br.com.zupacademy.juliodutra.mercadolivre.produto;

import br.com.zupacademy.juliodutra.mercadolivre.caracteristica.CaracteristicaProduto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public class ProdutoResponse {

    private Long id;
    private String nome;
    private BigDecimal valor;
    private int quantidade;
    private String descricao;
    private Long categoriaId;
    private Set<CaracteristicaProduto> caracteristicas;
    private LocalDateTime instanteCadastro;

    public ProdutoResponse(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.valor = produto.getValor();
        this.quantidade = produto.getQuantidade();
        this.descricao = produto.getDescricao();
        this.categoriaId = produto.getCategoria().getId();
        this.caracteristicas = produto.getCaracteristicas();
        this.instanteCadastro = produto.getInstanteCadastro();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public Set<CaracteristicaProduto> getCaracteristicas() {
        return caracteristicas;
    }

    public LocalDateTime getInstanteCadastro() {
        return instanteCadastro;
    }
}
