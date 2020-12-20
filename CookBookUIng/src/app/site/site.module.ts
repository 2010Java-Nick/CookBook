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
import { ViewSearchPageComponent } from './view-search-page/view-search-page.component';
import { RecipeFilterPipe } from '../pipes/search-filter.pipe';
import { RecipeListItemComponent } from './recipe-list-item/recipe-list-item.component';
import { PendingRequestsComponent } from './view-moderator-home/pending-requests/pending-requests.component';
import { ViewCookbookListComponent } from './view-cookbook-list/view-cookbook-list.component';
import { ViewACookbookComponent } from './view-a-cookbook/view-a-cookbook.component';


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
    SearchBarComponent,
    ViewSearchPageComponent,
    RecipeFilterPipe,
    RecipeListItemComponent,
    PendingRequestsComponent,
    ViewCookbookListComponent,
    ViewACookbookComponent
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
