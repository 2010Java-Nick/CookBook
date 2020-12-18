import { Injectable } from '@angular/core';

import {HttpClient,HttpParams} from  '@angular/common/http';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { Observable,throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

import {Recipe} from '../models/recipe.model'

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    //Authorization: 'my-auth-token'
  })
};

export interface Config {
  rl: string;
  textfile: string;
}

@Injectable({
  providedIn: 'root'
})
export class ViewARecipeService {

  
  // NEED TO GET THE ID SOMEWHERE

  public recipeId : string= '/1' ; 

  private readonly RECIPE_URL = `http://localhost:9091/recipe`;


  constructor(private httpClient: HttpClient) { }

  getConfig() {
    return this.httpClient.get<Config>(this.RECIPE_URL)
      .pipe(
        retry(3), // retry a failed request up to 3 times
        catchError(this.handleError) // then handle the error
      );
  }
  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    // Return an observable with a user-facing error message.
    return throwError(
      'Something bad happened; please try again later.');
  }

// need to add the id as parameter recipeId:number
  public getRecipe(): Observable<Recipe>{

    return this.httpClient.get<Recipe>(
      this.RECIPE_URL+this.recipeId)
      .pipe(
        retry(2), // retry a failed request up to 3 times
        catchError(this.handleError) // then handle the error
      );
  }

  public createRecipe(recipe: Recipe): any {
    this.httpClient.post<Recipe>(this.RECIPE_URL,recipe);
    // this.httpClient.post<Recipe>(
    //   this.RECIPE_URL,recipe,httpOptions)
    //   .pipe(
    //     retry(2), // retry a failed request up to 3 times
    //     catchError(this.handleError) // then handle the error
    //   );
    return  recipe ;
  }
}
