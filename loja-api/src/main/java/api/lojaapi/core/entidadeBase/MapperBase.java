package api.lojaapi.core.entidadeBase;

import org.mapstruct.Mapper;

public interface MapperBase<E extends ProdutoBase, D extends ProdutoBaseDto<? extends E>> {


    E paraEntidade(D dto);

    D paraDTO(E entidade);
}
