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
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ViewCreateRecipeComponent } from './view-create-recipe/view-create-recipe.component';
import { ViewRecipeListComponent } from './view-recipe-list/view-recipe-list.component';
import { SearchBarComponent } from './search-bar/search-bar.component';


@NgModule({
  declarations: [
    SiteComponent,
    NavbarComponent,
    SidebarComponent,
    ViewModeratorHomeComponent,
    ViewUserHomeComponent,
    RecipeItemComponent,
    ViewARecipeComponent,
    ViewCreateRecipeComponent,
    ViewRecipeListComponent,
    SearchBarComponent
  ],
  imports: [
    CommonModule,
    SiteRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [HttpClient]
})
export class SiteModule { }
