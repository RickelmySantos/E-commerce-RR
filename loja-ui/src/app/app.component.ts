import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CarouselComponent } from './componentes/carousel/carousel.component';
import { HeaderComponent } from './componentes/header/header.component';
import { HeroComponent } from './componentes/hero/hero.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, HeaderComponent, HeroComponent, CarouselComponent],
  templateUrl: './app.component.html',
})
export class AppComponent {
  title = 'Sapataria';
}
