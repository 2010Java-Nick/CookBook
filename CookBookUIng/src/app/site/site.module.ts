import { CommonModule } from '@angular/common';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RecipeFilterPipe } from '../pipes/search-filter.pipe';
import { NavbarComponent } from './navbar/navbar.component';
import { RecipeItemComponent } from './recipe-item/recipe-item.component';
import { RecipeListItemComponent } from './recipe-list-item/recipe-list-item.component';
import { SearchBarComponent } from './search-bar/search-bar.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { SiteRoutingModule } from './site-routing.module';
import { SiteComponent } from './site.component';
import { ViewACookbookComponent } from './view-a-cookbook/view-a-cookbook.component';
import { ViewARecipeComponent } from './view-a-recipe/view-a-recipe.component';
import { ViewCookbookListComponent } from './view-cookbook-list/view-cookbook-list.component';
import { ViewCreateRecipeComponent } from './view-create-recipe/view-create-recipe.component';
import { PendingFeaturedCardComponent } from './view-moderator-home/pending-requests/pending-featured-card/pending-featured-card.component';
import { PendingFeaturedListComponent } from './view-moderator-home/pending-requests/pending-featured-list/pending-featured-list.component';
import { PendingRequestsComponent } from './view-moderator-home/pending-requests/pending-requests.component';
import { ViewModeratorHomeComponent } from './view-moderator-home/view-moderator-home.component';
import { ViewRecipeListComponent } from './view-recipe-list/view-recipe-list.component';
import { ViewSearchPageComponent } from './view-search-page/view-search-page.component';
import { ViewUserHomeComponent } from './view-user-home/view-user-home.component';

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
    PendingFeaturedListComponent,
    PendingFeaturedCardComponent,
    ViewCookbookListComponent,
    ViewACookbookComponent,
  ],
  imports: [
    CommonModule,
    SiteRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [HttpClient],
})
export class SiteModule {}
