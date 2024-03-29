package api.lojaapi.core.servicos;

import api.lojaapi.core.entidadeBase.ProdutoBase;
import api.lojaapi.core.repositorios.ProdutoRepositorio;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Transactional(propagation = Propagation.REQUIRED)
public interface CrudService<E extends ProdutoBase, R extends ProdutoRepositorio<E>> {


    // Métodos de validação e callbacks genéricos
    default void validarCadastro(E entidade) {}

    default void validarAtualizacao(E entidade) {}

    default void OnCadastrar(E entidade) {}


    default void OnAtualizar(E entidade) {}


    default void OnExcluir(E entidadeBase) {}
}
