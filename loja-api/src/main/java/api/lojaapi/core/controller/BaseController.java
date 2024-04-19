package api.lojaapi.core.controller;

import api.lojaapi.core.entidadeBase.MapperBase;
import api.lojaapi.core.entidadeBase.ProdutoBase;
import api.lojaapi.core.entidadeBase.ProdutoBaseDto;
import api.lojaapi.core.servicos.CrudService;
import jakarta.validation.Valid;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;


@Transactional(propagation = Propagation.REQUIRED)
public abstract class BaseController<E extends ProdutoBase, D extends ProdutoBaseDto<? extends E>, M extends MapperBase<E, D>> {

    private final CrudService<E> service;
    private final M mapper;

    public BaseController(CrudService<E> service, M mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<E>> listar() {
        List<E> lista = service.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable Long id) {
        Optional<E> entidade = service.buscarPorId(id);
        if (entidade.isPresent()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(entidade.get());
        }
    }

    @PostMapping(value = "/cadastrar",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {"application/json"})
    public ResponseEntity<E> cadastrar(
            @RequestPart(value = "imagem", required = true) MultipartFile imagem,
            @RequestPart("produtoDto") @Valid D produtoDto) {

        try {
            E entidade = mapper.paraEntidade(produtoDto);
            entidade.setImagem(imagem.getBytes());
            E produtoSalvo = service.cadastrar(entidade);

            return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
        } catch (IOException ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<E> atualizar(@PathVariable Long id,
            @RequestPart(value = "imagem", required = false) MultipartFile imagem,
            @RequestPart("produtoDto") D produtoDto) {
        try {
            Optional<E> entidadOptional = service.buscarPorId(id);
            if (entidadOptional.isPresent()) {
                return ResponseEntity.notFound().build();
            }
            E entidade = mapper.paraEntidade(produtoDto);
            if (imagem != null) {
                entidade.setImagem(imagem.getBytes());
            }
            E produtoAtualizado = service.atualizar(entidade);
            return ResponseEntity.ok(produtoAtualizado);
        } catch (IOException ex) {
            ex.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }



    // private E convertJson(ProdutoBaseDto produtoDto) {
    // ObjectMapper objectMapper = new ObjectMapper();
    // Class<E> entityClass = getEntityClass();
    // return objectMapper.convertValue(produtoDto, entityClass);
    // }

    @SuppressWarnings("unchecked")
    public Class<E> getEntityClass() {
        return (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    @SuppressWarnings("unchecked")
    public Class<D> getDtoClass() {
        return (Class<D>) ((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[1];
    }
}
