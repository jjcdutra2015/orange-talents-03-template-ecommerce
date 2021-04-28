package br.com.zupacademy.juliodutra.mercadolivre.produto;

import br.com.zupacademy.juliodutra.mercadolivre.caracteristica.NovaCaracteristicaRequest;
import br.com.zupacademy.juliodutra.mercadolivre.categoria.Categoria;
import br.com.zupacademy.juliodutra.mercadolivre.categoria.CategoriaRepository;
import br.com.zupacademy.juliodutra.mercadolivre.config.compartilhado.ExistsId;
import br.com.zupacademy.juliodutra.mercadolivre.config.compartilhado.UniqueValue;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NovoProdutoRequest {

    @NotBlank
    @UniqueValue(domainClass = Produto.class, fieldName = "nome")
    private String nome;
    @NotNull
    @Positive
    private BigDecimal valor;
    @NotNull
    @Positive
    private int quantidade;
    @NotBlank
    @Length(max = 1000)
    private String descricao;
    @NotNull
    @ExistsId(domainClass = Categoria.class, fieldName = "id")
    private Long categoriaId;
    @Valid
    @Size(min = 3)
    private List<NovaCaracteristicaRequest> caracteristicas = new ArrayList<>();

    public NovoProdutoRequest(String nome, BigDecimal valor, int quantidade, String descricao, Long categoriaId, List<NovaCaracteristicaRequest> caracteristicas) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.categoriaId = categoriaId;
        this.caracteristicas.addAll(caracteristicas);
    }

    public Produto toModel(CategoriaRepository categoriaRepository) {
        Categoria categoria = categoriaRepository.findById(categoriaId).get();
        return new Produto(this.nome, this.valor, this.quantidade, this.descricao, categoria, caracteristicas);
    }

    public List<NovaCaracteristicaRequest> getCaracteristicas() {
        return caracteristicas;
    }

    @Override
    public String toString() {
        return "NovoProdutoRequest{" +
                "nome='" + nome + '\'' +
                ", valor=" + valor +
                ", quantidade=" + quantidade +
                ", descricao='" + descricao + '\'' +
                ", categoriaId=" + categoriaId +
                ", caracteristicas=" + caracteristicas +
                '}';
    }

    public Set<String> buscarCaracteristicasIguais() {
        HashSet<String> nomesIguais = new HashSet<>();
        HashSet<String> resultados = new HashSet<>();
        for (NovaCaracteristicaRequest caracteristica : caracteristicas) {
            String nome = caracteristica.getNome();
            if (!nomesIguais.add(nome)) {
                resultados.add(nome);
            }
        }
        return resultados;
    }
}
