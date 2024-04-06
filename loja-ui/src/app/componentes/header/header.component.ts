import { CUSTOM_ELEMENTS_SCHEMA, ChangeDetectionStrategy, Component } from '@angular/core';
import { SidebarComponent } from '../sidebar/sidebar.component';

@Component({
    selector: 'app-header',
    template: `
     
     <header class="header-page ">
        <app-sidebar></app-sidebar>
     </header>
    
    `,
    standalone: true,
    changeDetection: ChangeDetectionStrategy.OnPush,
    schemas: [CUSTOM_ELEMENTS_SCHEMA],
    imports: [SidebarComponent]
})
export class HeaderComponent {
}