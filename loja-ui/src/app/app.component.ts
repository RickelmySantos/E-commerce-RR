import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from './componentes/header/header.component';
import { SidebarComponent } from './componentes/sidebar/sidebar.component';
import { CarouselComponent } from './shared/utils/carousel.component';
import { HeroComponent } from './componentes/main/hero.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    RouterOutlet,
    HeaderComponent,
    HeroComponent,
    CarouselComponent,
    SidebarComponent,
  ],
  templateUrl: './app.component.html',
})
export class AppComponent {
  title = 'Sapataria';
}
