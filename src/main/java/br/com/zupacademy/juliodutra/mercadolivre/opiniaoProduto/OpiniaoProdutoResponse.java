package br.com.zupacademy.juliodutra.mercadolivre.opiniaoProduto;

public class OpiniaoProdutoResponse {

    private Long id;
    private int nota;
    private String titulo;
    private String descricao;
    private Long idProduto;
    private String nomeProduto;
    private String emailUsuarioLogado;

    public OpiniaoProdutoResponse(OpiniaoProduto opiniaoProduto) {
        this.id = opiniaoProduto.getId();
        this.nota = opiniaoProduto.getNota();
        this.titulo = opiniaoProduto.getTitulo();
        this.descricao = opiniaoProduto.getDescricao();
        this.idProduto = opiniaoProduto.getProduto().getId();
        this.nomeProduto = opiniaoProduto.getProduto().getNome();
        this.emailUsuarioLogado = opiniaoProduto.getUsuario().getEmail();
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

    public Long getIdProduto() {
        return idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public String getEmailUsuarioLogado() {
        return emailUsuarioLogado;
    }
}
