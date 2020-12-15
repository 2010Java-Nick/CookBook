import { Component, NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LandingComponent } from './landing.component';
import { ViewAccountCreationComponent } from './view-account-creation/view-account-creation.component';

const routes: Routes = [
  {
    path: '',
    component: LandingComponent,
    children: [
      { path: '', component: ViewAccountCreationComponent }
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class LandingRoutingModule {}
