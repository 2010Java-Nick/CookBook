import { Component, Input, OnInit } from '@angular/core';
import {Recipe} from '../../models/recipe.model';
import { ViewARecipeService} from '../../services/view-a-recipe.service'

@Component({
  selector: 'app-view-create-recipe',
  templateUrl: './view-create-recipe.component.html',
  styleUrls: ['./view-create-recipe.component.css']
})
export class ViewCreateRecipeComponent implements OnInit {

  @Input() recipe!:Recipe;
  

  constructor() { }

  ngOnInit(): void {
  }

  public formCreateRecipe(): void {
    this.recipe.name;
    this.recipe.servings;
    this.recipe.cookTime;
    this.recipe.prepTime;
    this.recipe.ingredients;


  }
}
