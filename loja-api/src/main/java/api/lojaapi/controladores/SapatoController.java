package api.lojaapi.controladores;

import api.lojaapi.dtos.SapatoDto;
import api.lojaapi.modelos.Sapato;
import api.lojaapi.repositorio.SapatoRepositorio;
import api.lojaapi.servicos.SapatoService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sapato")
@CrossOrigin
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

        Sapato sapato = service.cadastrar(sapatoModelo);

        return ResponseEntity.status(HttpStatus.CREATED).body(repositorio.save(sapato));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Sapato>> listar() {
        List<Sapato> lista = service.listarTodos();

        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<Object> listarPorId(@PathVariable(value = "id") Long id) {
        Optional<Sapato> sapato = service.buscarPorId(id);

        if (sapato.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Produto não existe na base de dados");
        }
        return ResponseEntity.status((HttpStatus.OK)).body(sapato.get());
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Object> atualizar(@PathVariable(value = "id") Long id,
            @RequestBody @Valid SapatoDto sapatoDto) {
        Optional<Sapato> sapato = repositorio.findById(id);
        if (sapato.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sapato não encontrado");
        }
        var sapatoModel = sapato.get();
        BeanUtils.copyProperties(sapatoDto, sapatoModel, "id");
        return ResponseEntity.status(HttpStatus.OK).body(repositorio.save(sapatoModel));
    }
}
