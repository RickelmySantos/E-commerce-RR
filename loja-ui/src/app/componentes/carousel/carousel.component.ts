import { CommonModule, NgFor } from '@angular/common';
import {
    CUSTOM_ELEMENTS_SCHEMA,
    ChangeDetectionStrategy,
    Component,
    OnInit,
} from '@angular/core';
import { CarouselModule } from 'primeng/carousel';
import { Sapato } from '../../models/sapato.model';
import { SapatoService } from '../../services/sapato.service';

@Component({
    selector: 'app-carousel',
    template: `
    <div class="flex">
      <a routerLink="#" class="a-generic"> Ver Lançamentos </a>
      <a routerLink="" class="a-generic"> Saiba Mais </a>
    </div>
    <p-carousel [value]="sapato" [numVisible]="3" [numScroll]="3" [circular]="true" [responsiveOptions]="responsiveOptions">
    <ng-template let-sapato pTemplate="item">
        <div class="border-1 surface-border border-round m-2 text-center py-5 px-3">
             <div class="mb-3">
                <img src="./assets/images/tenis-1.svg" alt="Imagem" class="w-6 ">
            </div>
           <div>
            <h4 class="mb-1">{{sapato.nome}}</h4>
            <h6>{{'$' + sapato.preco}}</h6>
           </div>
        </div>
    </ng-template>
    </p-carousel>
  `,
    standalone: true,
    changeDetection: ChangeDetectionStrategy.OnPush,
    schemas: [CUSTOM_ELEMENTS_SCHEMA],
    imports: [CommonModule, CarouselModule, NgFor],
})
export class CarouselComponent implements OnInit {
    sapato: Sapato[] = [];
    responsiveOptions: any[] | undefined;
    constructor(private sapatoService: SapatoService) { }

    ngOnInit(): void {
        this.sapatoService.getSapatos().subscribe((data: Sapato[]) => {
            this.sapato = data;
            console.log(this.sapato)
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
