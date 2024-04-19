package api.lojaapi.core.entidadeBase;

import org.mapstruct.Mapping;


public interface MapperBase<E extends ProdutoBase, D extends ProdutoBaseDto<? extends E>> {

    @Mapping(target = "imagem", ignore = true)
    E paraEntidade(D dto);

    @Mapping(target = "imagem", ignore = true)
    D paraDTO(E entidade);
}
