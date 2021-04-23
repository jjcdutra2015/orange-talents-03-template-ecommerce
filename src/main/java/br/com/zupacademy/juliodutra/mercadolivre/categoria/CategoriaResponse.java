package br.com.zupacademy.juliodutra.mercadolivre.categoria;

public class CategoriaResponse {

    private Categoria categoria;

    public CategoriaResponse(Categoria categoria) {
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
