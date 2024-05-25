package api.lojaapi.core.servicos;

import api.lojaapi.core.entidadeBase.ProdutoBase;
import api.lojaapi.core.repositorios.ProdutoRepositorio;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public abstract class CrudServiceImpl<E extends ProdutoBase, R extends ProdutoRepositorio<E>> {

    private final R repository;

    protected CrudServiceImpl(R repository) {
        this.repository = repository;
    }

    public List<E> listarTodos() {
        return repository.findAll();
    }

    public Page<E> findPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<E> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public E cadastrar(E entidade) {
        return repository.save(entidade);
    }

    public E atualizar(E entidade) {
        return repository.save(entidade);
    }

    public void deletar(Long id) {
        Optional<E> produto = repository.findById(id);
        if (produto.isPresent()) {
            repository.deleteById(id);

        } else {
            throw new EntityNotFoundException("Produto com id " + id + " não existe!");
        }
    }

    public E salvarImagem(Long id, byte[] imagem) {

        Optional<E> entidadeOptional = repository.findById(id);
        if (entidadeOptional.isPresent()) {
            E entidade = entidadeOptional.get();
            entidade.setImagem(imagem);
            return repository.save(entidade);
        } else {
            throw new EntityNotFoundException("Produto com id " + id + " não encontrado!");
        }
    }
}
