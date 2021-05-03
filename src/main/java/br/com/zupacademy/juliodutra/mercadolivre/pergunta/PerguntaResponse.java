package br.com.zupacademy.juliodutra.mercadolivre.pergunta;

import java.time.format.DateTimeFormatter;

public class PerguntaResponse {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private Long id;
    private String titulo;
    private Long idProduto;
    private String nomeProduto;
    private String emailLogado;
    private String instanteCriacao;

    public PerguntaResponse(Pergunta pergunta) {
        this.id = pergunta.getId();
        this.titulo = pergunta.getTitulo();
        this.idProduto = pergunta.getProduto().getId();
        this.nomeProduto = pergunta.getProduto().getNome();
        this.emailLogado = pergunta.getUsuarioLogado().getEmail();
        String dataFormatada = pergunta.getInstanteCriacao().format(formatter);
        this.instanteCriacao = dataFormatada;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public String getEmailLogado() {
        return emailLogado;
    }

    public String getInstanteCriacao() {
        return instanteCriacao;
    }
}
