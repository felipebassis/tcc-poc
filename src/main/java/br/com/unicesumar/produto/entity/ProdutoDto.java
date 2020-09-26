package br.com.unicesumar.produto.entity;

import br.com.unicesumar.common.entidade.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProdutoDto extends BaseDto {

    private String name;

    private String description;

    private BigDecimal cashValue;

    private BigDecimal termValue;

    private BigDecimal quantityInStock;
}
