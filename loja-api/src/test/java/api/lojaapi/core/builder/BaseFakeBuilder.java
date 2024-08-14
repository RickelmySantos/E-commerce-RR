package api.lojaapi.core.builder;

import org.instancio.Instancio;

public class BaseFakeBuilder<E> {

  public final Class<E> clazz;

  public BaseFakeBuilder(Class<E> clazz) {
    this.clazz = clazz;
  }

  public E create() {
    return Instancio.create(this.clazz);
  }

  public E createWithCustom(Customizer<E> customizer) {
    E instance = Instancio.create(this.clazz);
    customizer.customizer(instance);
    return instance;
  }

  public interface Customizer<E> {
    void customizer(E instance);
  }
}
