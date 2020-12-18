import { Injectable } from '@angular/core';
import {HttpClient} from  '@angular/common/http';
import { Observable } from 'rxjs';
import {Recipe} from '../models/recipe.model'

@Injectable({
  providedIn: 'root'
})
export class ViewARecipeService {

  
  // NEED TO GET THE ID SOMEWHERE

  public recipeId : number = 1 ; 

  private readonly RECIPE_URL = 'http://localhost:9091/recipe';


  constructor(private httpClient: HttpClient) { }

  public getRecipe(): Observable<Recipe>{

    return this.httpClient.get<Recipe>(this.RECIPE_URL);
  }

  public createRecipe(recipe: Recipe): boolean {

    this.httpClient.post<Recipe>(this.RECIPE_URL,recipe);
    return true;
  }
}
