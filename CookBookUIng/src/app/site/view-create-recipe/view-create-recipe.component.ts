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

  createRecipeForm;

  constructor(
    private recipeService : ViewARecipeService,
    private formBuilder: FormBuilder,
  ) { 
    this.createRecipeForm =this.formBuilder.group({
      name:'',
      servings: 0,
      prepTime:0,
      cookTime:0,
      steps:'',
      tags:'',
      ingredients:'',
      description:''
    });
  }

  ngOnInit(): void {
    
  }
  onSubmit(customerData: Recipe) {
    // Process data here
    //this.createRecipeForm.reset();
    console.warn(this.recipeService.createRecipe(customerData));
    console.warn('Your recipe has been submitted', customerData);
  }
}
