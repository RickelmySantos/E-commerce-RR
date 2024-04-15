package api.lojaapi.core.entidadeBase;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.web.multipart.MultipartFile;



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
    @NotBlank
    @Size(min = 10, max = 50, message = "Tamanho mínimo de caracteres é 10 e o máximo 50")
    protected String nome;
    @NotBlank
    protected String marca;
    @NotNull
    protected double preco;
    @NotBlank
    protected String descricao;

    protected ProdutoStatus produtoStatus;

    protected CategoriaBase categoriaBase;

    protected MultipartFile imagem;

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
