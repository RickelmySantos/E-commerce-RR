import { NgFor } from '@angular/common';
import { ChangeDetectionStrategy, Component, Input } from '@angular/core';
import { Sapato } from '../../models/sapato.model';

@Component({
    selector: 'app-galeria',
    template: `
        <section class="card-carrousel">
        <div *ngFor="let sapatos of sapato  ">
            <img [src]="sapatos.imagemUrl">
            <p>{{sapatos.nome}}</p>
             <p>{{sapatos.preco}}</p>   
        </div>
        </section>
    
    `,
    standalone: true,
    changeDetection: ChangeDetectionStrategy.OnPush,
    imports: [NgFor]
})

export class GaleriaComponent {
    @Input() sapato: Sapato[] = [];
}