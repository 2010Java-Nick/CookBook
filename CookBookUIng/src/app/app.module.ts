import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LandingComponent } from './components/landing/landing.component';
import { SiteComponent } from './components/site/site.component';
import { NavbarComponent } from './components/site/navbar/navbar.component';
import { SidebarComponent } from './components/site/sidebar/sidebar.component';
import { TitleComponent } from './components/landing/title/title.component';
import { ViewAccountCreationComponent } from './components/landing/view-account-creation/view-account-creation.component';
import { ViewUserHomeComponent } from './components/site/view-user-home/view-user-home.component';
import { ViewModeratorHomeComponent } from './components/site/view-moderator-home/view-moderator-home.component';

@NgModule({
  declarations: [
    AppComponent,
    LandingComponent,
    SiteComponent,
    NavbarComponent,
    SidebarComponent,
    TitleComponent,
    ViewAccountCreationComponent,
    ViewUserHomeComponent,
    ViewModeratorHomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
