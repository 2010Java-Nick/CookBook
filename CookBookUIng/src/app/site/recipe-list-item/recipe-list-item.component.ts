import { Component, Input, OnInit } from '@angular/core';
import { Recipe } from 'src/app/models/recipe.model';
import { ViewARecipeService } from 'src/app/services/view-a-recipe.service';

@Component({
  selector: '.app-recipe-list-item',
  templateUrl: './recipe-list-item.component.html',
  styleUrls: ['./recipe-list-item.component.css']
})
export class RecipeListItemComponent implements OnInit {

    
  @Input()
  recipe!: Recipe;

  recipeList: Recipe []=new Array();
  searchValue = ``;

  searchValueInput(searchValue: string) {
    this.searchValue = searchValue;
  }

  constructor(private recipeService : ViewARecipeService) { }

  ngOnInit(): void {
    this.recipeService.getRecipes().subscribe(
      (result) => { this.recipeList = result }
    );
  }

}
