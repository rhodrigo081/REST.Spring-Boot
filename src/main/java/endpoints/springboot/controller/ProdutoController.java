package endpoints.springboot.controller;

import endpoints.springboot.entity.Produto;
import endpoints.springboot.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @PostMapping("/save")
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) throws Exception {
            produto = produtoService.save(produto);

            return ResponseEntity.ok().body(produto);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProduto(@PathVariable Long id){

        Produto produto = produtoService.findById(id);

        return ResponseEntity.ok().body(produto);
    }

    @GetMapping("/Lista-Produtos")
    public ResponseEntity<List<Produto>> listarTodosProdutos(){
        List<Produto> produtos = produtoService.findAll();

        return ResponseEntity.ok().body(produtos);
    }
}
