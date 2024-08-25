package api.lojaapi.repositorio;

import api.lojaapi.core.builder.sapatoFakeBuilder.SapatoFakeBuilder;
import api.lojaapi.modelos.Sapato;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SapatoRepositorioTest {

  @Autowired
  private SapatoRepositorio sapatoRepositorio;

  @Test
  @Transactional
  @Rollback
  void dado_IdValido_QuandoFindById_EntaoRetornaEntidadePersistida() {
    // given
    Sapato entity = SapatoFakeBuilder.aSapato().create();
    Sapato savedSapato = this.sapatoRepositorio.saveAndFlush(entity);

    // when
    Optional<Sapato> foundSapato = this.sapatoRepositorio.findById(savedSapato.getId());

    // then
    Assertions.assertThat(foundSapato).isPresent();
    Assertions.assertThat(foundSapato.get().getId()).isEqualTo(savedSapato.getId());
    Assertions.assertThat(foundSapato.get().getNome()).isEqualTo(savedSapato.getNome());
  }

  @Test
  @Transactional
  @Rollback
  void testSaveSapato() {
    // given
    Sapato entity = Instancio.create(Sapato.class);

    // when
    Sapato savedSapato = this.sapatoRepositorio.saveAndFlush(entity);

    // then
    Assertions.assertThat(savedSapato.getId()).isNotNull();
    Assertions.assertThat(savedSapato.getNome()).isEqualTo(entity.getNome());
  }
}
