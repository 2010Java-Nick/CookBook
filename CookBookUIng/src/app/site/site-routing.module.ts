import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SiteComponent } from './site.component';
import { ViewACookbookComponent } from './view-a-cookbook/view-a-cookbook.component';
import { ViewARecipeComponent } from './view-a-recipe/view-a-recipe.component';
import { ViewCookbookListComponent } from './view-cookbook-list/view-cookbook-list.component';
import { ViewCreateRecipeComponent } from './view-create-recipe/view-create-recipe.component';
import { ViewModeratorHomeComponent } from './view-moderator-home/view-moderator-home.component';
import { ViewRecipeListComponent } from './view-recipe-list/view-recipe-list.component';
import { ViewSearchPageComponent } from './view-search-page/view-search-page.component';
import { ViewUserHomeComponent } from './view-user-home/view-user-home.component';


const routes: Routes = [
  {
    path: '',
    component: SiteComponent,
    children: [
      { path: '', component: ViewUserHomeComponent },
      { path: 'mod', component: ViewModeratorHomeComponent },
      { path : 'recipe/:id', component : ViewARecipeComponent},
      { path : 'createRecipe', component : ViewCreateRecipeComponent},
      { path : 'search', component : ViewRecipeListComponent},
      { path : 'cookbooks', component : ViewCookbookListComponent},
      { path : 'cookbook/:id', component : ViewACookbookComponent}
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class SiteRoutingModule {}
