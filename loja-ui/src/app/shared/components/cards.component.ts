import { ChangeDetectionStrategy, Component } from '@angular/core';

@Component({
    selector: 'card-generic',
    template: `
        <div class="card-carrousel">
            <ng-content></ng-content>
        </div>
    
    `,
    standalone: true,
    changeDetection: ChangeDetectionStrategy.OnPush,
    imports: []
})

export class CardGenericComponent {
}