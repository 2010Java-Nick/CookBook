import { Component, OnInit } from '@angular/core';
import {Recipe} from '../../models/recipe.model';
import { ViewARecipeService} from '../../services/view-a-recipe.service'


@Component({
  selector: 'app-view-recipe-list',
  templateUrl: './view-recipe-list.component.html',
  styleUrls: ['./view-recipe-list.component.css']
})
export class ViewRecipeListComponent implements OnInit {

  recipeList: Recipe []=new Array();
  searchValue = ``;
  constructor(private recipeService : ViewARecipeService) { }

  ngOnInit(): void {
    this.recipeService.getRecipes().subscribe(
      (result) => { this.recipeList = result }
    );
  }

}
