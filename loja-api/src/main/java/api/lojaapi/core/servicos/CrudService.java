package api.lojaapi.core.servicos;

import api.lojaapi.core.entidadeBase.ProdutoBase;
import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Transactional(propagation = Propagation.REQUIRED)
public interface CrudService<E extends ProdutoBase> {

    default void validarCadastro(E entidade) {}

    default void validarAtualizacao(E entidade) {}

    default void OnCadastrar(E entidade) {}

    default void OnAtualizar(E entidade) {}

    default void OnExcluir(E entidadeBase) {}

    List<E> listarTodos();

    Optional<E> buscarPorId(Long id);

    E cadastrar(E entidade);

    E atualizar(E entidade);

    void deletar(Long id);

    E salvarImagem(Long id, byte[] imagem);
}
