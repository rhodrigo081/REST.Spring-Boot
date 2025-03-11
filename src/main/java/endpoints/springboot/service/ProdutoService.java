package endpoints.springboot.service;

import endpoints.springboot.entity.Produto;
import endpoints.springboot.exception.ProdutoNullException;
import endpoints.springboot.exception.ProdutoPriceException;
import endpoints.springboot.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto save(Produto produto) throws Exception {

        if ((produto.getNome() == null) || (produto.getPreco() == null)){
            throw new ProdutoNullException();
        }
        if (produto.getPreco() <= 0) {
            throw new ProdutoPriceException();
        }

        return produtoRepository.save(produto);
    }

    public Produto findById(long id){
        return produtoRepository.findById(id).orElse(null);
    }
    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }
}
