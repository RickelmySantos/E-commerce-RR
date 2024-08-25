package api.lojaapi.controladores;


import api.lojaapi.core.controller.BaseController;
import api.lojaapi.dtos.SapatoDto;
import api.lojaapi.mapper.SapatoMapper;
import api.lojaapi.modelos.Sapato;
import api.lojaapi.repositorio.SapatoRepositorio;
import api.lojaapi.servicos.SapatoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sapato")
@CrossOrigin
public class SapatoController
    extends BaseController<Sapato, SapatoDto, SapatoMapper, SapatoRepositorio, SapatoService> {

}
