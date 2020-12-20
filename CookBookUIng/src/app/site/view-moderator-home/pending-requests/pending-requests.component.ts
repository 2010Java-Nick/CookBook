import { Component, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { Recipe } from 'src/app/models/recipe.model';
import { FeaturedService } from 'src/app/services/featured.service';

@Component({
  selector: 'app-pending-requests',
  templateUrl: './pending-requests.component.html',
  styleUrls: ['./pending-requests.component.css']
})
export class PendingRequestsComponent implements OnInit {

  public recipeList: Recipe [] = new Array();

  constructor(private featuredService: FeaturedService, private router: Router) { }

  ngOnInit(): void {
    this.featuredService.getFeaturedRecipes().subscribe(
      (result) => {
        if (result.body){
          this.recipeList = result.body;
        }
      }
    );
  }

  approvalForFeatured(recipe: Recipe): void{

    this.featuredService.completePending(recipe);
    this.ngOnInit();
  }

}
