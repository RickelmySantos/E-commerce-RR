import { CUSTOM_ELEMENTS_SCHEMA, ChangeDetectionStrategy, Component } from '@angular/core';

@Component({
    selector: 'app-hero',
    template: `
      <header class="header">
            <div class="header__left">
                 <h1>Encontre o seu <br> único companheiro <br> conosco</h1>
                  <p class="flex mt-3">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod.</p>
                  <a>
                    <i></i>
                    <span>Compre Agora</span>
                  </a>
            </div>
                <img class="header__img" src="/assets/images/hero-section.jpeg" alt="Logo da seção">
        </header>
        <section>
            <div class="logos">
                <div class="logos__wrapper ml-4">
                    <img class="logos__logo" src="/assets/images/nike-3-logo-svgrepo-com.svg" alt="Logos">
                </div>
                <div class="logos__wrapper">
                   <img class="logos__logo" src="/assets/images/adidas-9-logo-svgrepo-com.svg" alt="Logos">
                </div>
                <div class="logos__wrapper">
                    <img class="logos__logo" src="/assets/images/nike-3-logo-svgrepo-com.svg" alt="Logos">
                </div>
                <div class="logos__wrapper">
                     <img class="logos__logo" src="/assets/images/adidas-9-logo-svgrepo-com.svg" alt="Logos">
                </div>
                <div class="logos__wrapper">
                    <img class="logos__logo" src="/assets/images/nike-3-logo-svgrepo-com.svg" alt="Logos">
                </div>
                <div class="logos__wrapper mr-4">
                   <img class="logos__logo" src="/assets/images/adidas-9-logo-svgrepo-com.svg" alt="Logos">
                </div>
            </div>
        </section>

    `,
    standalone: true,
    changeDetection: ChangeDetectionStrategy.OnPush,
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})

export class HeroComponent {

}