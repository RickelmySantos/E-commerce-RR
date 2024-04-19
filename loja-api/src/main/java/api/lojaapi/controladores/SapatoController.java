package api.lojaapi.controladores;


import api.lojaapi.core.controller.BaseController;
import api.lojaapi.core.servicos.CrudService;
import api.lojaapi.dtos.SapatoDto;
import api.lojaapi.mapper.SapatoMapper;
import api.lojaapi.modelos.Sapato;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sapato")
@CrossOrigin
public class SapatoController extends BaseController<Sapato, SapatoDto, SapatoMapper> {

    public SapatoController(CrudService<Sapato> service, SapatoMapper mapper) {
        super(service, mapper);
    }


}
