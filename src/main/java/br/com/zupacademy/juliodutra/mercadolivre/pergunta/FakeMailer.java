package br.com.zupacademy.juliodutra.mercadolivre.pergunta;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FakeMailer implements Mailer {

    @Override
    public void send(String body, String subject, String emailFrom, String from, String to) {
        System.out.println(body);
        System.out.println(subject);
        System.out.println(emailFrom);
        System.out.println(from);
        System.out.println(to);
    }
}
