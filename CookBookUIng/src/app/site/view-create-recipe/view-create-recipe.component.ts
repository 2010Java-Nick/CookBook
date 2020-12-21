import { Component, Input, OnInit } from '@angular/core';
import {Recipe} from '../../models/recipe.model';
import { ViewARecipeService} from '../../services/view-a-recipe.service'
import { FormBuilder } from '@angular/forms';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';


@Component({
  selector: 'app-view-create-recipe',
  templateUrl: './view-create-recipe.component.html',
  styleUrls: ['./view-create-recipe.component.css']
})
export class ViewCreateRecipeComponent implements OnInit {

  //@Input() recipe!:Recipe;
  //recipe={} as Recipe;
  error='';
  createRecipeForm;
  valid=true;

  constructor(
    private recipeService : ViewARecipeService,
    private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router

  ) { 
    this.createRecipeForm =this.formBuilder.group({
      name: '',
      servings: 0,
      prepTime:0,
      cookTime:0,
      steps:'',
      tags:'',
      ingredients:'',
      description:'',
      author: 'username'
    });
  }

  ngOnInit(): void {
   

    
    
  }
  onSubmit(recipe: Recipe) {
    // Process data here
    //this.createRecipeForm.reset();
    if (recipe.name==undefined|| recipe.name==''){
      this.error= ' Enter a name';
      this.valid=false;
    }
    else if(recipe.prepTime<1){
      this.error= ' Enter preparation time';
      this.valid=false;
    }
    else if(recipe.cookTime<1){
      this.error= ' Enter cook time';
      this.valid=false;
    }
    else if(recipe.steps==undefined|| recipe.steps==''){
      this.error= ' Enter steps ';
      this.valid=false;
    }
    else if(recipe.ingredients==undefined|| recipe.ingredients==''){
      this.error= ' Enter ingredients ';
      this.valid=false;
    }
    else if(recipe.description==undefined|| recipe.description==''){
      this.error= ' Enter description ';
      this.valid=false;
    }
    else{
      this.error=' ';
      console.warn(this.recipeService.createRecipe(recipe));
      console.warn('Your recipe has been submitted', recipe);
      this.router.navigate(['/main']);
    }
    // recipe.name = 'Recsipe' ;
    // recipe.author = '2';
    // recipe.featured = false;
    // recipe.servings = 10;
    // recipe.prepTime = 10;
    // recipe.cookTime = 10;
    // recipe.steps = '';
    // recipe.tags = '';
    // recipe.ingredients= '' ;
    // recipe.description = '';

    

  }
}
