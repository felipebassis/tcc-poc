package br.com.unicesumar.common.crud.controller;

import br.com.unicesumar.common.crud.service.CrudService;
import br.com.unicesumar.common.entidade.BaseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public abstract class CrudController<VO extends BaseDto, SERVICE extends CrudService<VO, ?, ?>> {

    private final SERVICE crudService;

    protected CrudController(SERVICE crudService) {
        this.crudService = crudService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<VO> findAll() {
        return this.crudService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{id}")
    public VO findById(@PathVariable("id") UUID id) {
        return this.crudService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public VO addNewEntity(@RequestBody VO valueObject) {
        return this.crudService.save(valueObject);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("{id}")
    public VO updateEntity(@PathVariable("id") UUID id,
                           @RequestBody VO valueObject) {
        return this.crudService.update(id, valueObject);
    }

}
