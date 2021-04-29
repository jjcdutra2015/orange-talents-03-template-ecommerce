package br.com.zupacademy.juliodutra.mercadolivre.produto;

import java.util.Set;

public class ImagemProdutoResponse {
    private Long idProduto;
    private String nomeProduto;
    private Set<ImagemProduto> imagensDoProduto;

    public ImagemProdutoResponse(Produto produto) {
        this.idProduto = produto.getId();
        this.nomeProduto = produto.getNome();
        this.imagensDoProduto = produto.getImagens();
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public Set<ImagemProduto> getImagensDoProduto() {
        return imagensDoProduto;
    }
}
