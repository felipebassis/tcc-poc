package br.com.unicesumar.produto.entity;

import br.com.unicesumar.common.entidade.BaseEntity;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.math.BigDecimal;

@Setter
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "product")
public class Produto extends BaseEntity {
    private static final long serialVersionUID = -4659875908531356771L;

    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "cash_value")
    private BigDecimal cashValue;

    @Column(name = "term_value")
    private BigDecimal termValue;

    @Column(name = "quantity_in_stock")
    private BigDecimal quantityInStock;
}
