package br.com.zupacademy.juliodutra.mercadolivre.pergunta;

import br.com.zupacademy.juliodutra.mercadolivre.produto.Produto;
import br.com.zupacademy.juliodutra.mercadolivre.usuario.Usuario;

import javax.validation.constraints.NotBlank;

public class NovaPerguntaRequest {

    @NotBlank
    private String titulo;

    @Deprecated
    public NovaPerguntaRequest() {
    }

    public NovaPerguntaRequest(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public Pergunta toModel(Produto produto, Usuario usuarioLogado) {
        return new Pergunta(this.titulo, produto, usuarioLogado);
    }
}
