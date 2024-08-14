package api.lojaapi.sevicos;

import api.lojaapi.core.builder.sapatoFakeBuilder.SapatoFakeBuilder;
import api.lojaapi.modelos.Sapato;
import api.lojaapi.repositorio.SapatoRepositorio;
import api.lojaapi.servicos.SapatoService;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@ExtendWith(MockitoExtension.class)
@EntityScan("api.lojaapi")
class SapatoServiceTest {

  @InjectMocks
  private SapatoService service;

  @Mock
  private SapatoRepositorio repositorio;


  @Test
  void quando_Chamar_O_Metodo_ListarTodos_EntaoRetornarEntidades_ComSucesso() {
    // Given
    List<Sapato> sapatos = SapatoFakeBuilder.aSapato(4).buildList();

    Mockito.when(this.repositorio.findAll()).thenReturn(sapatos);

    // When
    List<Sapato> resultado = this.service.listarTodos();

    // Then
    Assertions.assertThat(resultado).hasSize(sapatos.size());
    Assertions.assertThat(resultado).usingRecursiveComparison().isEqualTo(sapatos);
  }

}
