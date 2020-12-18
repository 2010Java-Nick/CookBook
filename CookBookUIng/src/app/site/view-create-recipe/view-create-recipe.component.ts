import { Component, Input, OnInit } from '@angular/core';
import {Recipe} from '../../models/recipe.model';
import { ViewARecipeService} from '../../services/view-a-recipe.service'
import { FormBuilder } from '@angular/forms';
@Component({
  selector: 'app-view-create-recipe',
  templateUrl: './view-create-recipe.component.html',
  styleUrls: ['./view-create-recipe.component.css']
})
export class ViewCreateRecipeComponent implements OnInit {

  //@Input() recipe!:Recipe;
  recipe={} as Recipe;

  constructor(private recipeService : ViewARecipeService) { }

  ngOnInit(): void {
  }

  public formCreateRecipe(): void {
    //console.log(this.recipe.name);
    this.recipeService.createRecipe(this.recipe);
  }
}
