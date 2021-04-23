package br.com.zupacademy.juliodutra.mercadolivre.config.compartilhado;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Documented
@Constraint(validatedBy = {UniqueValueValidator.class})
@Target({FIELD})
@Retention(RUNTIME)
public @interface UniqueValue {

    String message() default "Campo informado deve ser único";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default  { };

    String fieldName();

    Class<?> domainClass();
}
