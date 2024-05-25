import { NgFor } from '@angular/common';
import {
    CUSTOM_ELEMENTS_SCHEMA,
    ChangeDetectionStrategy,
    Component,
} from '@angular/core';

@Component({
    selector: 'app-sidebar',
    template: `
    <aside class="sidebar">
       <div class="sidebar__logo ">
           <a routerLink="#">
              <span class="sidebar__highlight">RR</span>Confecções
           </a>
       </div>
      <nav class="sidebar__nav">
          <ul class="sidebar__list">
             <li class="sidebar__item" style="color: #484848;" *ngFor="let item of menuItems">
             <a routerLink="#" class="sidebar__link">{{ item }}</a>
            </li>
          </ul>
      </nav>
    </aside>
      <div class="sidebar__img">
        <img src="/assets/images/logos/header-group.png" alt="">
        <img class="mt-8 " src="/assets/images/logos/logos-group.svg" alt="">
      </div>

     `,
    standalone: true,
    changeDetection: ChangeDetectionStrategy.OnPush,
    schemas: [CUSTOM_ELEMENTS_SCHEMA],
    imports: [NgFor],
})
export class SidebarComponent {
    menuItems: string[] = ['Inicio', 'Coleções', 'Novidades', 'Sobre', 'Sig in'];
}
