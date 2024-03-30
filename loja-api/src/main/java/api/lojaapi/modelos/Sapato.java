package api.lojaapi.modelos;

import api.lojaapi.core.entidadeBase.ProdutoBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_SAPATO")
public class Sapato extends ProdutoBase {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Column(name = "TAMANHO", length = 255)
    private Integer tamanho;
}
