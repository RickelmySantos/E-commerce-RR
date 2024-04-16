package api.lojaapi.controladores;

import api.lojaapi.dtos.SapatoDto;
import api.lojaapi.modelos.Sapato;
import api.lojaapi.repositorio.SapatoRepositorio;
import api.lojaapi.servicos.SapatoService;
import jakarta.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

    // @PostMapping("/cadastrar")
    // public ResponseEntity<Sapato> cadastrar(@RequestBody @Valid SapatoDto dto) {
    // var sapatoModelo = new Sapato();
    // BeanUtils.copyProperties(dto, sapatoModelo);

    // Sapato sapato = service.cadastrar(sapatoModelo);

    // return ResponseEntity.status(HttpStatus.CREATED).body(repositorio.save(sapato));
    // }

    // CADASTRAR COM IMAGEM
    @PostMapping("/cadastrar")
    public ResponseEntity<Sapato> cadastrar(
            @RequestParam(value = "imagem", required = false) MultipartFile imagem,
            @ModelAttribute @Valid SapatoDto sapatoDto) {

        try {
            byte[] imagemBytes = IOUtils.toByteArray(imagem.getInputStream());

            Sapato sapatoModel = new Sapato();
            BeanUtils.copyProperties(sapatoDto, sapatoModel);

            sapatoModel.setImagem(imagemBytes);

            Sapato sapato = service.cadastrar(sapatoModel);

            return ResponseEntity.status(HttpStatus.CREATED).body(sapato);

        } catch (IOException e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



    @GetMapping("/listar")
    public ResponseEntity<List<Sapato>> listar() {
        List<Sapato> lista = service.listarTodos();

        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }


    // @GetMapping("/paginacao")
    // public ResponseEntity<Map<String, Object>> listarComPaginacao(
    // @RequestParam(required = false) String nome, @RequestParam(defaultValue = "0") int page,
    // @RequestParam(defaultValue = "5") int size) {

    // Pageable paginacao = PageRequest.of(page, size);
    // // List<Sapato> sapatos = new ArrayList<Sapato>();
    // Page<Sapato> paginas = service.buscarComPaginacao(nome, page, size);
    // List<Sapato> sapatos = paginas.getContent();

    // Map<String, Object> response = new HashMap<>();

    // response.put("sapatos", response);
    // response.put("currentPage", paginas.getNumber());
    // response.put("totalItems", paginas.getTotalElements());
    // response.put("totalPages", paginas.getTotalPages());

    // return new ResponseEntity<>(response, HttpStatus.OK);


    // }

    @GetMapping
    public ResponseEntity<Page<Sapato>> buscarComPaginacao(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "5") int PageSize) {

        Page<Sapato> sapatos = service.listarComPaginacao(pageNo, PageSize);
        return ResponseEntity.ok(sapatos);

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
