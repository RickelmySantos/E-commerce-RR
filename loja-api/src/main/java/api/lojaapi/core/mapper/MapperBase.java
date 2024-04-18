package api.lojaapi.core.mapper;

import api.lojaapi.core.entidadeBase.ProdutoBase;
import api.lojaapi.core.entidadeBase.ProdutoBaseDto;
import org.mapstruct.Mapping;

public interface MapperBase<E extends ProdutoBase, D extends ProdutoBaseDto<? extends E>> {

    @Mapping(target = "imagem", ignore = true)
    E paraEntidade(D dto);

    @Mapping(target = "imagem", ignore = true)
    D paraDTO(E entidade);
}
