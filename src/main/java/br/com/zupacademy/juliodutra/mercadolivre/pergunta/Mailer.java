package br.com.zupacademy.juliodutra.mercadolivre.pergunta;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public interface Mailer {

    /**
     * @param body      corpo do email
     * @param subject   assunto do email
     * @param emailFrom nome para aparecer no provedor de email
     * @param from      email de origem
     * @param to        email de destino
     */
    void send(@NotBlank String body, @NotBlank String subject, @NotBlank @Email String emailFrom,
              @NotBlank @Email String from, @NotBlank @Email String to);
}
