package api.lojaapi.servicos;

import api.lojaapi.core.servicos.CrudService;
import api.lojaapi.modelos.Sapato;
import api.lojaapi.repositorio.SapatoRepositorio;
import org.springframework.stereotype.Service;

@Service
public class SapatoService extends CrudService<Sapato, SapatoRepositorio> {

  public SapatoService(SapatoRepositorio repository) {
    super(repository);
  }


}
