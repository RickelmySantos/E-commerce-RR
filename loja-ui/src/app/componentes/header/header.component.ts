import {
  CUSTOM_ELEMENTS_SCHEMA,
  Component
} from "@angular/core";
import { OfferGalleryComponent } from "../../shared/utils/offer-gallery.component";
import { SidebarComponent } from "../sidebar/sidebar.component";

@Component({
  selector: "app-header",
  template: `
    <section class="flex flex-column">
      <app-sidebar></app-sidebar>
      <div>
        <offer-gallery class="offer"></offer-gallery>
      </div>
    </section>
  `,
  standalone: true,
  // changeDetection: ChangeDetectionStrategy.OnPush,
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  imports: [SidebarComponent, OfferGalleryComponent],
})
export class HeaderComponent { }
