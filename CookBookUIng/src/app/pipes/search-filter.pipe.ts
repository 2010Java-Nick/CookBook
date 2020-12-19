import { Pipe, PipeTransform } from '@angular/core';
import { Recipe } from '../models/recipe.model';


@Pipe({
  name: 'recipeFilter'
})
export class RecipeFilterPipe implements PipeTransform {

  transform(recipeList: Recipe[], value: string): Recipe[] {
   
    let filteredRecipeList = recipeList.filter(
      (recipe) => {
        if (recipe.name.toString().startsWith(value) || 
        recipe.author.toString().startsWith(value) || 
        recipe.tags.toString().startsWith(value) || 
        recipe.ingredients.toString().startsWith(value) ||
        recipe.description.startsWith(value) )
              return true;
        
        else 
              return false;
      }
    );
 
    return recipeList.filter((recipe) => (recipe.name.toString().startsWith(value) || 
                                      recipe.author.toString().startsWith(value) || 
                                      recipe.tags.toString().startsWith(value) || 
                                      recipe.ingredients.toString().startsWith(value) ||
                                      recipe.description.startsWith(value)));
  }

}
