package br.com.zupacademy.juliodutra.mercadolivre.categoria;

import br.com.zupacademy.juliodutra.mercadolivre.config.compartilhado.ExistsId;
import br.com.zupacademy.juliodutra.mercadolivre.config.compartilhado.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NovaCategoriaRequest {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome")
    private String nome;

    @ExistsId(domainClass = Categoria.class, fieldName = "id")
    private Long categoriaId;

    public Categoria toModel(CategoriaRepository categoriaRepository) {
        Categoria categoria = new Categoria(this.nome);

        if (this.categoriaId != null) {
            var possivelCategoria = categoriaRepository.findById(this.categoriaId);
            if (possivelCategoria.isPresent()) {
                categoria.setMae(possivelCategoria.get());
            }
        }

        return categoria;
    }

    public String getNome() {
        return nome;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }
}
