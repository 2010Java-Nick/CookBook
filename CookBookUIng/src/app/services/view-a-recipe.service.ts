import { Injectable } from '@angular/core';

import {HttpClient,HttpParams} from  '@angular/common/http';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { HttpHeaders } from '@angular/common/http';
import { Observable,of,throwError } from 'rxjs';
import { catchError, map, retry, tap } from 'rxjs/operators';

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
  private readonly RECIPE_URL = `http://localhost:9091/recipe`;

  constructor(private httpClient: HttpClient) { }

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
  public getRecipe(recipeId:number): Observable<Recipe>{
    return this.httpClient.get<Recipe>(
      this.RECIPE_URL+'/'+recipeId)
      .pipe(
        retry(2),
        catchError(this.handleError) // then handle the error
      );
  }

  public createRecipe(recipe: Recipe): any {
    this.httpClient.post<any>(
      this.RECIPE_URL,recipe,httpOptions)
      .pipe(
        retry(2), // retry a failed request up to 3 times
        catchError(this.handleError) // then handle the error
      ).subscribe(
        (res) => console.log(res),
        (err) => console.log(err)  );
    return  recipe ;
  }

  public getRecipes(): Observable<Recipe[]>{
    return this.httpClient.get<Recipe[]>(
      this.RECIPE_URL)
      .pipe(
        retry(2),
        catchError(this.handleError)
      );
  }

 public search(searchValue: string): Observable<Recipe[]> {
    // clear if no pkg name
    if (!searchValue.trim()) { return of([]); }


    // TODO: Add error handling
    return this.httpClient.get(this.RECIPE_URL, httpOptions).pipe(
      map((data: any) => {
        return data.results.map((entry: any) => ({
            name: entry.name[0],
            tags: entry.tags[0],
            description: entry.description[0],
            ingredients: entry.ingredients[0]
          } as Recipe)
        );
      })
    );
  }

// searchRecipe(searchValue: string): Observable<Recipe[]> {
//   if (!searchValue.trim()) {
//     // if not search term, return empty hero array.
//     return of([]);
//   }
//   return this.httpClient.get<Recipe[]>(`${this.RECIPE_URL}/?name=${searchValue}`).pipe(
//     tap(x => x.length ?
//        console.log(`found matching recipes"${searchValue}"`) :
//        console.log(`no matching recipes "${searchValue}"`)),
//     // catchError(this.handleError<Recipes[]>('searchRecipe', []))
//   );
// }

}
