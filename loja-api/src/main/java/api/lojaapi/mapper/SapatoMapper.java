package api.lojaapi.mapper;

import api.lojaapi.core.entidadeBase.MapperBase;
import api.lojaapi.dtos.SapatoDto;
import api.lojaapi.modelos.Sapato;
import org.mapstruct.Mapper;

// @Component
@Mapper(componentModel = "spring")
public interface SapatoMapper extends MapperBase<Sapato, SapatoDto> {

}
