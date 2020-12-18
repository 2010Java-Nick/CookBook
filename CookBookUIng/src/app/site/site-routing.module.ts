import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SiteComponent } from './site.component';
import { ViewARecipeComponent } from './view-a-recipe/view-a-recipe.component';
import { ViewCreateRecipeComponent } from './view-create-recipe/view-create-recipe.component';
import { ViewModeratorHomeComponent } from './view-moderator-home/view-moderator-home.component';
import { ViewUserHomeComponent } from './view-user-home/view-user-home.component';

const routes: Routes = [
  {
    path: '',
    component: SiteComponent,
    children: [
      { path: '', component: ViewUserHomeComponent },
      { path: 'mod', component: ViewModeratorHomeComponent },
      { path : 'recipe/:id', component : ViewARecipeComponent},
      { path : 'createRecipe', component : ViewCreateRecipeComponent}
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class SiteRoutingModule {}
