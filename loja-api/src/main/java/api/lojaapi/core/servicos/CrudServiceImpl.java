package api.lojaapi.core.servicos;

import api.lojaapi.core.entidadeBase.ProdutoBase;
import api.lojaapi.core.repositorios.ProdutoRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CrudServiceImpl<E extends ProdutoBase, R extends ProdutoRepositorio<E>>
        implements CrudService<E> {

    private final R repository;

    public CrudServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public List<E> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<E> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public E cadastrar(E entidade) {
        return repository.save(entidade);
    }

    @Override
    public E atualizar(E entidade) {
        return repository.save(entidade);
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public E salvarImagem(Long id, byte[] imagem) {

        Optional<E> entidadeOptional = repository.findById(id);
        if (entidadeOptional.isPresent()) {
            E entidade = entidadeOptional.get();
            entidade.setImagem(imagem);
            return repository.save(entidade);
        } else {
            throw new RuntimeException("Entidade não encontrada com o ID" + id);
        }
    }
}
