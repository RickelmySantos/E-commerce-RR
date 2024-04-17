package api.lojaapi.servicos;

import api.lojaapi.core.servicos.CrudServiceImpl;
import api.lojaapi.modelos.Sapato;
import api.lojaapi.repositorio.SapatoRepositorio;
import org.springframework.stereotype.Service;

@Service
public class SapatoService extends CrudServiceImpl<Sapato, SapatoRepositorio> {

    public SapatoService(SapatoRepositorio repository) {
        super(repository);
    }


}
