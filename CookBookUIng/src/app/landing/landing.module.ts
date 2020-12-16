import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { LandingRoutingModule } from './landing-routing.module';
import { LandingComponent } from './landing.component';
import { TitleComponent } from './title/title.component';
import { ViewAccountCreationComponent } from './view-account-creation/view-account-creation.component';


@NgModule({
  declarations: [
    LandingComponent,
    TitleComponent,
    ViewAccountCreationComponent
  ],
  imports: [
    CommonModule,
    LandingRoutingModule,
    FormsModule
  ]
})
export class LandingModule { }
