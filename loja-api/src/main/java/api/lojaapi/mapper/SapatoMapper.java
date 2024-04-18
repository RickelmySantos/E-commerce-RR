package api.lojaapi.mapper;

import api.lojaapi.core.mapper.MapperBase;
import api.lojaapi.dtos.SapatoDto;
import api.lojaapi.modelos.Sapato;
import org.mapstruct.Mapper;

@Mapper
public interface SapatoMapper extends MapperBase<Sapato, SapatoDto> {

}
