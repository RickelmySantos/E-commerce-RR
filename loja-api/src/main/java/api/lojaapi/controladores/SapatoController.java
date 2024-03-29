package api.lojaapi.controladores;

import api.lojaapi.dtos.SapatoDto;
import api.lojaapi.modelos.Sapato;
import api.lojaapi.repositorio.SapatoRepositorio;
import api.lojaapi.servicos.SapatoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sapato")
public class SapatoController {


    private final SapatoService service;

    private final SapatoRepositorio repositorio;

    public SapatoController(SapatoService service, SapatoRepositorio repositorio) {
        this.service = service;
        this.repositorio = repositorio;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Sapato> cadastrar(@RequestBody @Valid SapatoDto dto) {
        var sapatoModelo = new Sapato();
        BeanUtils.copyProperties(dto, sapatoModelo);

        return ResponseEntity.status(HttpStatus.CREATED).body(repositorio.save(sapatoModelo));
    }
}
