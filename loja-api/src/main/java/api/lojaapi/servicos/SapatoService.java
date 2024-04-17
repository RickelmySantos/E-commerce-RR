package api.lojaapi.servicos;

import api.lojaapi.core.servicos.CrudService;
import api.lojaapi.modelos.Sapato;
import api.lojaapi.repositorio.SapatoRepositorio;
import java.util.List;
import java.util.Optional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Getter
@RequiredArgsConstructor
@Service
public class SapatoService implements CrudService<Sapato, SapatoRepositorio> {

    private final SapatoRepositorio repositorio;

    public List<Sapato> listarTodos() {
        return repositorio.findAll();
    }

    public Page<Sapato> listarComPaginacao(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return repositorio.findAll(pageable);
    }

    public Optional<Sapato> buscarPorId(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido: " + id);
        }

        return repositorio.findById(id);
    }

    public Sapato cadastrar(Sapato sapato) {
        validarSapato(sapato);
        return repositorio.save(sapato);
    }

    public void excluir(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID inválido: " + id);
        }

        repositorio.deleteById(id);
    }

    private void validarSapato(Sapato sapato) {
        if (sapato == null) {
            throw new IllegalArgumentException("Sapato não pode ser nulo");
        }
        if (sapato.getPreco() <= 0) {
            throw new IllegalArgumentException("O preço do sapato deve ser maior que zero.");
        }
    }
}
