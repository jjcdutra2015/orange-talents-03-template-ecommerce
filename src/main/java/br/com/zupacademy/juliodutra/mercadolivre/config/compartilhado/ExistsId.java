package br.com.zupacademy.juliodutra.mercadolivre.config.compartilhado;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = {ExistsIdValidator.class})
@Target({FIELD})
@Retention(RUNTIME)
public @interface ExistsId {

    String message() default "Campo informado não existe em nossa base da dados";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default  { };

    String fieldName();

    Class<?> domainClass();
}
