package br.com.zupacademy.juliodutra.mercadolivre.opiniaoProduto;

import br.com.zupacademy.juliodutra.mercadolivre.produto.Produto;
import br.com.zupacademy.juliodutra.mercadolivre.produto.ProdutoRepository;
import br.com.zupacademy.juliodutra.mercadolivre.usuario.Usuario;
import br.com.zupacademy.juliodutra.mercadolivre.usuario.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("produtos")
public class OpiniaoProdutoController {

    private OpiniaoProdutoRepository repository;
    private ProdutoRepository produtoRepository;
    private UsuarioRepository usuarioRepository;

    public OpiniaoProdutoController(OpiniaoProdutoRepository repository, ProdutoRepository produtoRepository, UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.produtoRepository = produtoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/{id}/opiniao")
    @Transactional
    public ResponseEntity<?> adicionaOpiniao(@PathVariable("id") Long id, @Valid @RequestBody NovaOpiniaoProdutoRequest request, @AuthenticationPrincipal Usuario logado) {
        Optional<Usuario> usuarioLogado = usuarioRepository.findByEmail(logado.getEmail());
        Optional<Produto> produto = produtoRepository.findById(id);
        OpiniaoProduto opiniaoProduto = request.toModel(produto.get(), usuarioLogado.get());
        repository.save(opiniaoProduto);

        return ResponseEntity.ok(new OpiniaoProdutoResponse(opiniaoProduto));
    }
}
