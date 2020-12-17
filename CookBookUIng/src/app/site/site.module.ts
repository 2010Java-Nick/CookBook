import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { SiteRoutingModule } from './site-routing.module';
import { NavbarComponent } from './navbar/navbar.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { ViewModeratorHomeComponent } from './view-moderator-home/view-moderator-home.component';
import { ViewUserHomeComponent } from './view-user-home/view-user-home.component';
import { SiteComponent } from './site.component';
import { RecipeItemComponent } from './recipe-item/recipe-item.component';
import { ViewARecipeComponent} from './view-a-recipe/view-a-recipe.component'
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    SiteComponent,
    NavbarComponent,
    SidebarComponent,
    ViewModeratorHomeComponent,
    ViewUserHomeComponent,
    RecipeItemComponent,
    ViewARecipeComponent
  ],
  imports: [
    CommonModule,
    SiteRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [HttpClient]
})
export class SiteModule { }
