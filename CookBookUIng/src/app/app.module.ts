import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LandingModule } from './landing/landing.module';
import { SiteModule } from './site/site.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { RecipeItemComponent } from './src/app/site/recipe-item/recipe-item.component';

@NgModule({
  declarations: [
    AppComponent,
    RecipeItemComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    LandingModule,
    SiteModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
