import { CUSTOM_ELEMENTS_SCHEMA, Component } from '@angular/core';
import { InfinitScrollComponent } from '../../shared/utils/infinit-scroll.component';
import { OfferGalleryComponent } from '../../shared/utils/offer-gallery.component';
import { SidebarComponent } from '../sidebar/sidebar.component';

@Component({
  selector: 'app-header',
  template: `
    <section class="header">
      <div class="header__content">
        <h1>Aumente sua velocidade</h1>
        <p>Coleções exclusivas e tendênciosas</p>
        <a href="" class="btn"> Compre Agora</a>
      </div>
      <div class="header__imagens">
        <img
          src="/assets/images/tenis-nike/nike-air-jordan-2.png"
          alt=""
          class="header__img"
        />
      </div>
    </section>
    <app-infinit-scroll></app-infinit-scroll>
  `,
  standalone: true,
  // changeDetection: ChangeDetectionStrategy.OnPush,
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  imports: [SidebarComponent, OfferGalleryComponent, InfinitScrollComponent],
})
export class HeaderComponent {}
