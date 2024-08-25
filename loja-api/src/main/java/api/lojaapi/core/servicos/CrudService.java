package api.lojaapi.core.servicos;

import api.lojaapi.core.entidadeBase.ProdutoBase;
import api.lojaapi.core.exceptions.customExceptions.ImageNotFoundException;
import api.lojaapi.core.exceptions.customExceptions.ProductNotFoundException;
import api.lojaapi.core.repositorios.ProdutoRepositorio;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public abstract class CrudService<E extends ProdutoBase, R extends ProdutoRepositorio<E>> {


  protected final R repository;

  protected CrudService(R repository) {
    this.repository = repository;
  }

  public List<E> listarTodos() {
    return this.repository.findAll();
  }

  public Page<E> findPage(Pageable pageable) {
    return this.repository.findAll(pageable);
  }

  public Optional<E> buscarPorId(Long id) {
    Assert.notNull(id, "Id não pode ser nulo");
    Assert.isTrue(id > 0, "Id deve ser maior que 0");
    return this.repository.findById(id);
  }

  public Optional<E> cadastrar(E entidade) {
    Assert.notNull(entidade, "Entidade não pode ser nula");
    Assert.isNull(entidade.getId(), "Id não deve estar preenchido");
    return Optional.ofNullable(this.repository.save(entidade));
  }

  public E atualizar(E entidade) {
    Assert.notNull(entidade, "Entidade não pode ser nula");
    Assert.notNull(entidade.getId(), "Id nao pode ser nulo");
    Assert.isTrue(entidade.getId() > 0, "Id deve ser maior que 0");

    Optional<E> result = this.buscarPorId(entidade.getId());

    if (result.isEmpty()) {
      throw new ProductNotFoundException(
          "Não foi possível encontrar a entidade com o Id informado");
    }
    return this.repository.save(entidade);
  }

  public void deletar(Long id) {
    Optional<E> produto = this.repository.findById(id);
    if (produto.isPresent()) {
      this.repository.deleteById(id);

    } else {
      throw new EntityNotFoundException("Produto com id " + id + " não existe!");
    }
  }

  public E salvarImagem(Long id, byte[] imagem) {
    E entidade = this.repository.findById(id).orElseThrow(() -> new ProductNotFoundException(
        "Não foi possível encontrar a entidade com o Id informado"));

    entidade.setImagem(imagem);
    return this.repository.save(entidade);
  }

  public byte[] getImagemProduto(Long id) {
    E entidade = this.buscarPorId(id)
        .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));
    if (entidade.getImagem() == null) {
      throw new ImageNotFoundException("Imagem não encontrada para o produto");
    }
    return entidade.getImagem();
  }
}
