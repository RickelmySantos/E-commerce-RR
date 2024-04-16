package api.lojaapi.servicos;

import api.lojaapi.core.servicos.CrudService;
import api.lojaapi.modelos.Sapato;
import api.lojaapi.repositorio.SapatoRepositorio;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
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
        List<Sapato> sapatos = repositorio.findAll();

        if (sapatos.isEmpty()) {
            throw new RuntimeException("Nenhum sapato encontrado");
        }
        return sapatos;
    }


    // public Page<Sapato> buscarComPaginacao(String nome, int page, int size) {
    // Pageable paginacao = PageRequest.of(page, size);
    // return repositorio.findByPagination(nome, paginacao);
    // }

    public Page<Sapato> listarComPaginacao(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return repositorio.findAll(pageable);
    }

    public Optional<Sapato> buscarPorId(Long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido: " + id);
        }

        try {
            Optional<Sapato> sapatoOptional = repositorio.findById(id);
            if (sapatoOptional.isEmpty()) {
                throw new NoSuchElementException("Sapato não encontrado para o ID: " + id);
            }
            return sapatoOptional;
        } catch (DataAccessException e) {
            throw new RuntimeException("Erro ao acessar o banco de dados.", e);
        }
    }

    public Sapato cadastrar(Sapato sapato) {
        validarSapato(sapato);
        return repositorio.save(sapato);
    }

    // public Sapato cadastrar(SapatoDto sapatoDto, byte[] imagem) {
    // Sapato sapato = new Sapato();
    // BeanUtils.copyProperties(sapatoDto, sapato);

    // sapato.setImagem(imagem);
    // return repositorio.save(sapato);
    // }

    public void excluir(Long id) {
        repositorio.deleteById(id);
    }

    private void validarSapato(Sapato sapato) {
        if (sapato.getPreco() <= 0) {
            throw new IllegalArgumentException("O preço do sapato deve ser maior que zero.");
        }
    }

}
