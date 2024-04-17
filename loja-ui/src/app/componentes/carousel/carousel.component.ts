import { CommonModule } from '@angular/common';
import {
    CUSTOM_ELEMENTS_SCHEMA,
    Component,
    OnInit
} from '@angular/core';
import { CarouselModule } from 'primeng/carousel';
import { Sapato } from '../../models/sapato.model';
import { SapatoService } from '../../services/sapato.service';
import { CardGenericComponent } from '../../shared/components/cards.component';
import { GaleriaComponent } from '../../shared/components/galeria.component';

@Component({
    selector: 'app-carousel',
    template: `
    <div class="flex-generic mt-4">
      <a routerLink="#" class="a-generic"> Ver Lançamentos </a>
      <a routerLink="#" class="a-generic"> Saiba Mais </a>
    </div>
    <p-carousel [value]="sapato" [numVisible]="3" [numScroll]="3" [circular]="true" [responsiveOptions]="responsiveOptions">
    <ng-template let-sapato pTemplate="item">
        <div class="border-1 surface-border border-round m-2 text-center py-2 px-3">
             <div class="mb-3">
                <img src="./assets/images/tenis-1.svg" alt="Imagem" class="w-4 h-4 ">
             </div>
           <div>
            <p class="mb-1 font-bold text-2xl">{{sapato.nome}}</p>
            <span class="mb-2 text-2xl">{{'$' + sapato.preco}}</span>
           </div>
        </div>
    </ng-template>
    </p-carousel>

     <!-- <card-generic>
        <div>
            <img src="./assets/images/cards/tenis-card.jpg" alt="" class="w-4 h-4 ">
            <img src="./assets/images/cards/sapato-ideal.jpg" alt="" class="w-4 h-4 ">
            <img src="./assets/images/cards/modelos.jpg" alt="" class="w-4 h-4 ">
        </div>
     </card-generic> -->

    <section class="explore">
        <!-- <img src="./assets/images/explore.svg" class="header__img border-1"> -->
        <div class="flex flex-1 flex-column align-content-center align-items-center">
            <h2 >Encontre sua<br>sensação</h2>
            <span>tudo oque você precisa para seu dia</span>
        </div>
        <a href="#" class="w-12rem">explore</a>

    </section>
    <app-galeria ></app-galeria>
  `,
    standalone: true,
    // changeDetection: ChangeDetectionStrategy.OnPush,
    schemas: [CUSTOM_ELEMENTS_SCHEMA],
    imports: [CommonModule, CarouselModule, CardGenericComponent, GaleriaComponent],
})
export class CarouselComponent implements OnInit {
    sapato: Sapato[] = [];
    responsiveOptions: any[] | undefined;
    constructor(private sapatoService: SapatoService) { }

    ngOnInit(): void {
        this.sapatoService.getSapatos().subscribe((data: Sapato[]) => {
            this.sapato = data;
        });

        this.responsiveOptions = [
            {
                breakpoint: '1200px',
                numVisible: 1,
                numScroll: 1
            },
            {
                breakpoint: '991px',
                numVisible: 2,
                numScroll: 1
            },
            {
                breakpoint: '600px',
                numVisible: 1,
                numScroll: 1
            }
        ];
    }
}
