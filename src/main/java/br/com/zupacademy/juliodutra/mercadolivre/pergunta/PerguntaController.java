package br.com.zupacademy.juliodutra.mercadolivre.pergunta;

import br.com.zupacademy.juliodutra.mercadolivre.produto.Produto;
import br.com.zupacademy.juliodutra.mercadolivre.produto.ProdutoRepository;
import br.com.zupacademy.juliodutra.mercadolivre.usuario.Usuario;
import br.com.zupacademy.juliodutra.mercadolivre.usuario.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Optional;

@RestController
@RequestMapping("produtos")
public class PerguntaController {

    private final PerguntaRepository perguntaRepository;
    private final ProdutoRepository produtoRepository;
    private final UsuarioRepository usuarioRepository;
    private final Emails emails;

    public PerguntaController(PerguntaRepository perguntaRepository, ProdutoRepository produtoRepository, UsuarioRepository usuarioRepository, Emails emails) {
        this.perguntaRepository = perguntaRepository;
        this.produtoRepository = produtoRepository;
        this.usuarioRepository = usuarioRepository;
        this.emails = emails;
    }

    @PostMapping("/{id}/perguntas")
    @Transactional
    private ResponseEntity<?> fazerPergunta(@PathVariable("id") Long id, @RequestBody NovaPerguntaRequest request, @AuthenticationPrincipal Usuario logado) {
        Optional<Usuario> usuarioLogado = usuarioRepository.findByEmail(logado.getEmail());
        Optional<Produto> produto = produtoRepository.findById(id);
        Pergunta pergunta = request.toModel(produto.get(), usuarioLogado.get());
        perguntaRepository.save(pergunta);

        emails.novaPergunta(pergunta);

        return ResponseEntity.ok(new PerguntaResponse(pergunta));
    }
}
