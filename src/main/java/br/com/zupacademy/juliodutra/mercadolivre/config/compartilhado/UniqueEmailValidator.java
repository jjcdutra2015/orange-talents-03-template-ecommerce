package br.com.zupacademy.juliodutra.mercadolivre.config.compartilhado;

import br.com.zupacademy.juliodutra.mercadolivre.usuario.Usuario;
import br.com.zupacademy.juliodutra.mercadolivre.usuario.UsuarioRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, Object> {

    private UsuarioRepository usuarioRepository;

    public UniqueEmailValidator(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Optional<Usuario> possivelUsuario = usuarioRepository.findByEmail(value.toString());

        return !possivelUsuario.isPresent();
    }
}
