package br.com.zupacademy.juliodutra.mercadolivre.produto;

import br.com.zupacademy.juliodutra.mercadolivre.categoria.CategoriaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private CategoriaRepository categoriaRepository;
    private ProdutoRepository produtoRepository;

    public ProdutoController(CategoriaRepository categoriaRepository, ProdutoRepository produtoRepository) {
        this.categoriaRepository = categoriaRepository;
        this.produtoRepository = produtoRepository;
    }

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(new ProibeCaracteristicaComNomeIgualValidator());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ProdutoResponse> cadastrar(@Valid @RequestBody NovoProdutoRequest request) {
        Produto produto = request.toModel(categoriaRepository);
        produtoRepository.save(produto);

        return ResponseEntity.ok(new ProdutoResponse(produto));
    }
}
