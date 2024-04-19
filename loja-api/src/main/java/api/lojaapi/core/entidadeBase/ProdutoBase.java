package api.lojaapi.core.entidadeBase;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@FieldNameConstants
@MappedSuperclass
public abstract class ProdutoBase implements Comparable<ProdutoBase> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, unique = true)
    @Positive
    @ToString.Include
    @EqualsAndHashCode.Include
    private Long id;
    @Column
    protected String nome;
    @Column
    protected String marca;
    @Column
    protected Double preco;
    @Column
    protected String descricao;
    @Column
    @Enumerated(EnumType.STRING)
    protected ProdutoStatus produtoStatus;
    @Enumerated(EnumType.STRING)
    protected CategoriaBase categoriaBase;
    @Lob
    protected byte[] imagem;

    @Override
    public int compareTo(ProdutoBase entidade) {
        if (this.id == entidade.id) {
            return 0;
        }

        if (this.id == null && entidade.id != null) {
            return -1;
        }

        if (this.id != null && entidade.id == null) {
            return 1;
        }

        return this.id.compareTo(entidade.id);
    }
}
