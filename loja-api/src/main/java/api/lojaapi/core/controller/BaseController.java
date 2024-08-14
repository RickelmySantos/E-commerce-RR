package api.lojaapi.core.controller;

import api.lojaapi.core.entidadeBase.MapperBase;
import api.lojaapi.core.entidadeBase.ProdutoBase;
import api.lojaapi.core.entidadeBase.ProdutoBaseDto;
import api.lojaapi.core.repositorios.ProdutoRepositorio;
import api.lojaapi.core.servicos.CrudServiceImpl;
import jakarta.validation.Valid;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;


@Transactional(propagation = Propagation.REQUIRED)
public abstract class BaseController<E extends ProdutoBase, D extends ProdutoBaseDto<? extends E>, M extends MapperBase<E, D>, R extends ProdutoRepositorio<E>, S extends CrudServiceImpl<E, R>> {

  @Autowired
  private S service;
  @Autowired
  private M mapper;


  @GetMapping("/listar")
  public ResponseEntity<List<E>> listar() {
    List<E> lista = this.service.listarTodos();
    return ResponseEntity.ok(lista);
  }

  @GetMapping("/listar/{id}")
  public ResponseEntity<Object> buscarPorId(@PathVariable Long id) {
    Optional<E> entidade = this.service.buscarPorId(id);
    if (entidade.isPresent()) {
      return ResponseEntity.ok(entidade.get());
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("/{id}/imagem")
  public ResponseEntity<byte[]> getImagemProduto(@PathVariable Long id) {
    Optional<E> entidade = this.service.buscarPorId(id);
    if (entidade.isPresent() && entidade.get().getImagem() != null) {
      byte[] imagem = entidade.get().getImagem();
      return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imagem);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("/page")
  public List<E> listarProdutos(@RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "6") int size) {
    Pageable pageable = PageRequest.of(page, size);
    Page<E> pageResult = this.service.findPage(pageable);
    return pageResult.getContent();
  }

  @PostMapping("/cadastrar")
  public ResponseEntity<D> cadastrar(@RequestBody @Valid D produtoDto) {
    E entidade = this.mapper.paraEntidade(produtoDto);
    Optional<E> produtoSalvo = this.service.cadastrar(entidade);

    D produtoSalvoDto = this.mapper.paraDTO(produtoSalvo);
    return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvoDto);

  }

  @PostMapping(value = "/cadastrar/imagem", consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> cadastrarComImagem(@RequestParam("imagem") MultipartFile imagem,
      @RequestParam("produtoId") Long produtoId) {
    try {
      this.service.salvarImagem(produtoId, imagem.getBytes());
      return ResponseEntity.status(HttpStatus.CREATED).body("Imagem salva com sucesso!");
    } catch (Exception ex) {
      ex.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Falha ao salvar a imagem");
    }
  }

  @PostMapping(value = "/cadastrar/upload",
      consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE},
      produces = {"application/json"})
  public ResponseEntity<D> cadastrar(
      @RequestParam(value = "imagem", required = true) MultipartFile imagem,
      @RequestParam("produtoDto") @Valid D produtoDto) throws IOException {

    E entidade = this.mapper.paraEntidade(produtoDto);

    entidade.setImagem(imagem.getBytes());

    Optional<E> produtoSalvo = this.service.cadastrar(entidade);


    D produtoSalvoDto = this.mapper.paraDTO(produtoSalvo);

    return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvoDto);
  }

  @PutMapping("/{id}")
  public ResponseEntity<E> atualizar(@PathVariable Long id,
      @RequestPart(value = "imagem", required = false) MultipartFile imagem,
      @RequestPart("produtoDto") D produtoDto) {
    try {
      Optional<E> entidadOptional = this.service.buscarPorId(id);
      if (entidadOptional.isPresent()) {
        return ResponseEntity.notFound().build();
      }
      E entidade = this.mapper.paraEntidade(produtoDto);
      if (imagem != null) {
        entidade.setImagem(imagem.getBytes());
      }
      E produtoAtualizado = this.service.atualizar(entidade);
      return ResponseEntity.ok(produtoAtualizado);
    } catch (IOException ex) {
      ex.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletar(@PathVariable Long id) {
    this.service.deletar(id);
    return ResponseEntity.noContent().build();
  }

  @SuppressWarnings("unchecked")
  public Class<E> getEntityClass() {
    return (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass())
        .getActualTypeArguments()[0];
  }

  @SuppressWarnings("unchecked")
  public Class<D> getDtoClass() {
    return (Class<D>) ((ParameterizedType) this.getClass().getGenericSuperclass())
        .getActualTypeArguments()[1];
  }

}


