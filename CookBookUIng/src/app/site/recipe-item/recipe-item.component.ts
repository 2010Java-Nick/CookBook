import { Component, OnInit,OnDestroy } from '@angular/core';
import {Recipe} from '../../models/recipe.model';
import { ViewARecipeService} from '../../services/view-a-recipe.service'
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-recipe-item',
  templateUrl: './recipe-item.component.html',
  styleUrls: ['./recipe-item.component.css']
})
export class RecipeItemComponent implements OnInit {

  recipe!: Recipe ;
  private sub: any;
  id!: number;

  

  constructor(
    private viewARecipeService : ViewARecipeService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.sub = this.route.params.subscribe(params => {
      this.id = +params['id'];  });

    this.viewARecipeService.getRecipe(this.id).subscribe(
      (result) => { this.recipe = result  
    });
  }
  

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  

}
