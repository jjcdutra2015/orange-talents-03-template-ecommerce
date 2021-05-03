package br.com.zupacademy.juliodutra.mercadolivre.produto;

import br.com.zupacademy.juliodutra.mercadolivre.caracteristica.CaracteristicaProduto;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class ProdutoResponse {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private Long id;
    private String nome;
    private BigDecimal valor;
    private int quantidade;
    private String descricao;
    private Long categoriaId;
    private String emailDono;
    private Set<CaracteristicaProduto> caracteristicas;
    private String instanteCadastro;

    public ProdutoResponse(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.valor = produto.getValor();
        this.quantidade = produto.getQuantidade();
        this.descricao = produto.getDescricao();
        this.categoriaId = produto.getCategoria().getId();
        this.emailDono = produto.getDono().getEmail();
        this.caracteristicas = produto.getCaracteristicas();
        String dataFormatada = produto.getInstanteCadastro().format(formatter);
        this.instanteCadastro = dataFormatada;
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

    public String getEmailDono() {
        return emailDono;
    }

    public Set<CaracteristicaProduto> getCaracteristicas() {
        return caracteristicas;
    }

    public String getInstanteCadastro() {
        return instanteCadastro;
    }
}
