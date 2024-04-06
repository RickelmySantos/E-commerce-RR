import { CUSTOM_ELEMENTS_SCHEMA, ChangeDetectionStrategy, Component } from '@angular/core';

@Component({
    selector: 'app-hero',
    template: `
      <section class="grid-container">
            <div class="hero-container">
                <div class="hero">
                    <div class="hero__h1">
                        <h1>Encontre o seu <br> único companheiro <br> conosco</h1>
                    </div>
                </div>
                <p class="flex mt-3">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod.</p>
                <div>
                    <button>Compre Agora</button>
                </div>
            </div>
            <div class="image-container ">
                <img src="/assets/images/hero-section.jpeg" alt="Logo da seção">
            </div>
        </section>
        <section>
            <div class="logos ">
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