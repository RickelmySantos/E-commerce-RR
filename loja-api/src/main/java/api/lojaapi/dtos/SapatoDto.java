package api.lojaapi.dtos;

import api.lojaapi.core.entidadeBase.ProdutoBaseDto;
import api.lojaapi.modelos.Sapato;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class SapatoDto extends ProdutoBaseDto<Sapato> {

    private static final long serialVersionUID = 1L;

    @ToString.Include
    @Size(max = 255)
    private String tamanho;
}
