package api.lojaapi.core.repositorios;

import api.lojaapi.core.entidadeBase.ProdutoBase;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS)
@Primary
public interface ProdutoRepositorio<E extends ProdutoBase>
        extends JpaRepository<E, Long>, JpaSpecificationExecutor<E> {


    Page<E> findAll(Pageable pageable);
}
