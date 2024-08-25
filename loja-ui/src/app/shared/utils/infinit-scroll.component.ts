import { NgClass, NgFor } from '@angular/common';
import { Component, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

@Component({
  selector: 'app-infinit-scroll',
  template: `
    <div class="wrapper-infinit-scroll">
      <div class="item item1">
        <img src="/assets/images/logos/louis-vuitton-logo.png" alt="" />
      </div>
      <div class="item item2">
        <img src="/assets/images/logos/chanel-logo.png" alt="" />
      </div>
      <div class="item item3">
        <img src="/assets/images/logos/calvin-klein-logo.png" alt="" />
      </div>
      <div class="item item4">
        <img src="/assets/images/logos/denim-logo.png" alt="" />
      </div>
      <div class="item item5">
        <img src="/assets/images/logos/prada-logo.png" alt="" />
      </div>
      <div class="item item6">
        <img src="/assets/images/logos/prada-logo.png" alt="" />
      </div>
    </div>
  `,

  standalone: true,
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  imports: [NgFor, NgClass],
})
export class InfinitScrollComponent {}
