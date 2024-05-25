import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { CarouselModule } from 'primeng/carousel';
import { Observable } from 'rxjs';
import { Sapato } from '../../models/sapato.model';
import { SapatoService } from '../../services/sapato.service';

@Component({
  selector: 'offer-gallery',
  template: `

        <div class="p-4">
          <h1>
            Ofertas do mês
          </h1>
          <p>
            Lorem ipsum dolor sit amet, consectetur adipiscing <br />
            elit. Scelerisque duis ultrices sollicitudin aliquam sem. <br />
            Scelerisque duis ultrices sollicitudin
          </p>
          <a href="" class="offer__btn">Compre Agora</a>
        </div>
        <div class="offer__gallery" *ngIf="(sapato$ | async) as sapato">
      <p-carousel 
           [value]="sapato"
           [numVisible]="3"
           [numScroll]="3"
           [circular]="true"
          [responsiveOptions]="responsiveOptions"
           [autoplayInterval]="3000"
          >
              <ng-template let-sapato pTemplate="item">
            <div
              class="surface-border border-round m-2 text-center py-5 px-3"
            >
              <div class="mb-3">
                 <img
                  [src]="sapato.imagem"
                  alt="Imagem"
                  class="w-4 h-4 img__produto"
                />
              </div>
              <div>
                <h4 class="mb-1">{{ sapato.nome }}</h4>
                <h6>{{ "$" + sapato.preco }}</h6>
              </div>
            </div>
          </ng-template>
        </p-carousel>
        </div>
    `,
  standalone: true,
  imports: [CommonModule, CarouselModule]
})

export class OfferGalleryComponent implements OnInit {

  sapato$: Observable<Sapato[]>;
  responsiveOptions: any[] | undefined;

  constructor(private sapatoService: SapatoService) {
    this.sapato$ = this.sapatoService.listarAllSapatos();
  }

  ngOnInit(): void {
    this.responsiveOptions = [
      {
        breakpoint: "1200px",
        numVisible: 1,
        numScroll: 1,
      },
      {
        breakpoint: "991px",
        numVisible: 2,
        numScroll: 1,
      },
      {
        breakpoint: "600px",
        numVisible: 1,
        numScroll: 1,
      },
    ];

  }
}