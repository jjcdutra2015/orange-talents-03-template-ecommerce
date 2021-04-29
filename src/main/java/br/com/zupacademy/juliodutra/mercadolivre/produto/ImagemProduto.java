package br.com.zupacademy.juliodutra.mercadolivre.produto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
public class ImagemProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @JsonIgnore
    @ManyToOne
    @Valid
    private Produto produto;
    @NotBlank
    private String link;

    @Deprecated
    public ImagemProduto() {
    }

    public ImagemProduto(@NotNull @Valid Produto produto, @NotBlank String link) {
        this.produto = produto;
        this.link = link;
    }

    public Long getId() {
        return id;
    }

    public String getLink() {
        return link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImagemProduto that = (ImagemProduto) o;
        return link.equals(that.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(link);
    }
}
