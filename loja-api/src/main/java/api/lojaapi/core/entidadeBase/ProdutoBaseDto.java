package api.lojaapi.core.entidadeBase;

import jakarta.validation.constraints.Positive;
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
@EqualsAndHashCode
@ToString
public abstract class ProdutoBaseDto<E extends ProdutoBase>
        implements Comparable<ProdutoBaseDto<E>> {

    private final static long serialVersionUID = 1L;


    @Positive
    @ToString.Include
    @EqualsAndHashCode.Include
    protected Long id;

    protected String nome;

    protected String marca;

    protected double preco;

    protected String descricao;

    @Override
    public int compareTo(ProdutoBaseDto<E> dto) {
        if (this.id == dto.id) {
            return 0;
        }

        if (this.id == null && dto.id != null) {
            return -1;
        }

        if (this.id != null && dto.id == null) {
            return 1;
        }

        return this.id.compareTo(dto.id);
    }
}
