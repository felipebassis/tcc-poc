package br.com.unicesumar.produto.controller;

import br.com.unicesumar.common.crud.controller.CrudController;
import br.com.unicesumar.produto.entity.ProdutoDto;
import br.com.unicesumar.produto.service.ProdutoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProdutoController extends CrudController<ProdutoDto, ProdutoService> {

    protected ProdutoController(ProdutoService crudService) {
        super(crudService);
    }
}
