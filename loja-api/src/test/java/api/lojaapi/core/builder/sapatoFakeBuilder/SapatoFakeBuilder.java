package api.lojaapi.core.builder.sapatoFakeBuilder;

import api.lojaapi.core.builder.BaseFakeBuilder;
import api.lojaapi.modelos.Sapato;
import java.util.ArrayList;
import java.util.List;

public class SapatoFakeBuilder extends BaseFakeBuilder<Sapato> {

  private Sapato sapato;
  private int quantidade;

  private SapatoFakeBuilder() {
    super(Sapato.class);
    this.sapato = this.create();
  }

  public SapatoFakeBuilder(int quantidade) {
    super(Sapato.class);
    this.quantidade = quantidade;
  }

  public static SapatoFakeBuilder aSapato() {
    return new SapatoFakeBuilder();
  }

  public static SapatoFakeBuilder aSapato(int quantidade) {
    return new SapatoFakeBuilder(quantidade);
  }

  public SapatoFakeBuilder withId(long id) {
    this.sapato.setId(id);
    return this;
  }

  public SapatoFakeBuilder withNome(String nome) {
    this.sapato.setNome(nome);
    return this;
  }

  public SapatoFakeBuilder withCor(String descricao) {
    this.sapato.setDescricao(descricao);
    return this;
  }

  public Sapato build() {
    return this.sapato;
  }

  public List<Sapato> buildList() {
    List<Sapato> sapatos = new ArrayList<>();
    for (int i = 0; i < this.quantidade; i++) {
      sapatos.add(this.create());
    }
    return sapatos;
  }

}
