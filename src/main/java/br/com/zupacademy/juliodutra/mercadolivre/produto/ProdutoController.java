package br.com.zupacademy.juliodutra.mercadolivre.produto;

import br.com.zupacademy.juliodutra.mercadolivre.categoria.CategoriaRepository;
import br.com.zupacademy.juliodutra.mercadolivre.usuario.Usuario;
import br.com.zupacademy.juliodutra.mercadolivre.usuario.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private final CategoriaRepository categoriaRepository;
    private final ProdutoRepository produtoRepository;
    private final UsuarioRepository usuarioRepository;
    //1
    private Uploader uploaderFake;

    public ProdutoController(CategoriaRepository categoriaRepository, ProdutoRepository produtoRepository,
                             UsuarioRepository usuarioRepository, UploaderFake uploaderFake) {
        this.categoriaRepository = categoriaRepository;
        this.produtoRepository = produtoRepository;
        this.usuarioRepository = usuarioRepository;
        this.uploaderFake = uploaderFake;
    }

    @InitBinder(value = "novoProdutoRequest")
    //1
    public void init(WebDataBinder binder) {
        binder.addValidators(new ProibeCaracteristicaComNomeIgualValidator());
    }

    @PostMapping
    @Transactional
    //1
    public ResponseEntity<ProdutoResponse> cadastrar(@Valid @RequestBody NovoProdutoRequest request, @AuthenticationPrincipal Usuario logado) {
        Usuario usuarioLogado = usuarioRepository.findByEmail(logado.getEmail()).get();
        //1
        Produto produto = request.toModel(categoriaRepository, usuarioLogado);
        produtoRepository.save(produto);
        //1
        return ResponseEntity.ok(new ProdutoResponse(produto));
    }

    @PostMapping("/{id}/imagens")
    @Transactional
    //1
    public ResponseEntity<ImagemProdutoResponse> adicionaImagens(@PathVariable("id") Long id, @Valid NovaImagemProdutoRequest request) {
        /*
         * 1) Enviar imagens para o local de armazenamento
         * 2) Pegar os links das imagens
         * 3) Carregar os produtos
         * 4) Associar os links com os produtos
         * 5) Atualizar os produtos associados
         */

        Set<String> links = uploaderFake.envia(request.getImagens());
        var produto = produtoRepository.findById(id).get();
        produto.associaImagens(links);

        produtoRepository.save(produto);

        return ResponseEntity.ok(new ImagemProdutoResponse(produto));
    }
}
