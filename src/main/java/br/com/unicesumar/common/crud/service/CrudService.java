package br.com.unicesumar.common.crud.service;

import br.com.unicesumar.common.entidade.BaseDto;
import br.com.unicesumar.common.entidade.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

//@Transactional(readOnly = true)
public abstract class CrudService<VO extends BaseDto, ENTITY extends BaseEntity, REPOSITORY extends JpaRepository<ENTITY, UUID>> {

    private final REPOSITORY repository;

    protected CrudService(REPOSITORY repository) {
        this.repository = repository;
    }

    protected abstract VO mapToVo(ENTITY entity);

    protected abstract ENTITY mapToEntity(VO entityToBeCreated);

    protected abstract void updateEntity(ENTITY entity, VO entityToBeUpdated);

    public VO findById(UUID id) {
        return repository.findById(id)
                .map(this::mapToVo)
                .orElseThrow(() -> new IllegalArgumentException("Entity of id " + " not found."));
    }

    public List<VO> findAll() {
        return repository.findAll()
                .stream()
                .map(this::mapToVo)
                .collect(Collectors.toList());
    }

    @Transactional
    public VO save(VO entityToBeCreated) {
        ENTITY entity = this.mapToEntity(entityToBeCreated);
        this.beforeSave(entity);
        return this.mapToVo(this.repository.save(entity));
    }

    @Transactional
    public VO update(UUID id, VO entityToBeUpdated) {
        ENTITY entity = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Entity of id " + " not found."));
        this.updateEntity(entity, entityToBeUpdated);
        this.beforeUpdate(entity);
        return this.mapToVo(this.repository.save(entity));
    }

    @Transactional
    public void delete(UUID id) {
        this.repository.deleteById(id);
    }

    protected void beforeUpdate(ENTITY entity) {
        //To be implemented if necessary
    }

    protected void beforeSave(ENTITY entity) {
        //To be implemented if necessary
    }

}
