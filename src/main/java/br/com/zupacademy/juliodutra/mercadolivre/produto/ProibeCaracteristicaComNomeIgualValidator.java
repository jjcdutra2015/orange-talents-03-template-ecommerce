package br.com.zupacademy.juliodutra.mercadolivre.produto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Set;

public class ProibeCaracteristicaComNomeIgualValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return NovoProdutoRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        NovoProdutoRequest request = (NovoProdutoRequest) target;
        Set<String> nomesIguais = request.buscarCaracteristicasIguais();
        if (!nomesIguais.isEmpty()) {
            errors.rejectValue("caracteristicas", null, "Possui caracteristicas iguais " + nomesIguais);
        }
    }
}
