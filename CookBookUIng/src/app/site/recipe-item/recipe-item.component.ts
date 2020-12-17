import { Component, OnInit } from '@angular/core';
import {Recipe} from '../../models/recipe.model';
import { ViewARecipeService} from '../../services/view-a-recipe.service'

@Component({
  selector: 'app-recipe-item',
  templateUrl: './recipe-item.component.html',
  styleUrls: ['./recipe-item.component.css']
})
export class RecipeItemComponent implements OnInit {

  recipe!: Recipe ;

  constructor(private viewARecipeService : ViewARecipeService
    ) { }

  ngOnInit(): void {
    this.viewARecipeService.getRecipe().subscribe(

      (result) => { this.recipe = result }
    )}

  

}
