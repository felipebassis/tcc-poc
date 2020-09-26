package br.com.unicesumar.produto.service;

import br.com.unicesumar.common.crud.service.CrudService;
import br.com.unicesumar.produto.database.ProdutoRepository;
import br.com.unicesumar.produto.entity.Produto;
import br.com.unicesumar.produto.entity.ProdutoDto;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService extends CrudService<ProdutoDto, Produto, ProdutoRepository> {

    protected ProdutoService(ProdutoRepository repository) {
        super(repository);
    }

    @Override
    protected ProdutoDto mapToVo(Produto produto) {
        ProdutoDto produtoDto = new ProdutoDto();
        produtoDto.setId(produto.getId());
        produtoDto.setName(produto.getName());
        produtoDto.setDescription(produto.getDescription());
        produtoDto.setCashValue(produto.getCashValue());
        produtoDto.setTermValue(produto.getTermValue());
        produtoDto.setQuantityInStock(produto.getQuantityInStock());
        return produtoDto;
    }

    @Override
    protected Produto mapToEntity(ProdutoDto produtoDto) {
        return Produto.builder()
                .name(produtoDto.getName())
                .description(produtoDto.getDescription())
                .cashValue(produtoDto.getCashValue())
                .termValue(produtoDto.getTermValue())
                .quantityInStock(produtoDto.getQuantityInStock())
                .build();
    }

    @Override
    protected void updateEntity(Produto produto, ProdutoDto produtoDto) {
        produto.setName(produtoDto.getName());
        produto.setDescription(produtoDto.getDescription());
        produto.setCashValue(produtoDto.getCashValue());
        produto.setTermValue(produtoDto.getTermValue());
        produto.setQuantityInStock(produtoDto.getQuantityInStock());
    }
}
