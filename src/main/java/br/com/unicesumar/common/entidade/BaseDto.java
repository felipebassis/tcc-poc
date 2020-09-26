package br.com.unicesumar.common.entidade;

import lombok.Data;

import java.util.UUID;

@Data
public abstract class BaseDto {

    private UUID id;
}
