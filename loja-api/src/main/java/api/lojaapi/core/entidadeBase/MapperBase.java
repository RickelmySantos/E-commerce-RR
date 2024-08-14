package api.lojaapi.core.entidadeBase;

import java.util.Optional;

public interface MapperBase<E extends ProdutoBase, D extends ProdutoBaseDto<? extends E>> {


  E paraEntidade(D dto);

  D paraDTO(Optional<E> produtoSalvo);
}
