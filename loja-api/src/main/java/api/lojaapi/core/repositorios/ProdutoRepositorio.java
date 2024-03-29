package api.lojaapi.core.repositorios;

import api.lojaapi.core.entidadeBase.ProdutoBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS)
public interface ProdutoRepositorio<E extends ProdutoBase>
        extends JpaRepository<E, Long>, JpaSpecificationExecutor<E> {


}
