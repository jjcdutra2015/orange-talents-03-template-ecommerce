package br.com.zupacademy.juliodutra.mercadolivre.pergunta;

import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
public class Emails {

    private final Mailer mailer;

    public Emails(Mailer mailer) {
        this.mailer = mailer;
    }

    public void novaPergunta(@NotNull @Valid Pergunta pergunta) {
        mailer.send("<html></html>", "Nova pergunta...", pergunta.getUsuarioLogado().getEmail(), "email@email.com", pergunta.getProduto().getDono().getEmail());
    }
}
