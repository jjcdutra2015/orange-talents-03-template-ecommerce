package br.com.zupacademy.juliodutra.mercadolivre.usuario;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {

    private UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UsuarioResponse> cadastrar(@Valid @RequestBody NovoUsuarioRequest request) {
        Usuario usuario = request.toModel();
        repository.save(usuario);

        return ResponseEntity.ok(new UsuarioResponse(usuario));
    }
}
