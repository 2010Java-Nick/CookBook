import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Recipe } from '../models/recipe.model';

@Injectable({
  providedIn: 'root'
})
export class FeaturedService {

  private readonly FEATURED_URL = 'http://localhost:9091/featured';

  constructor(private httpClient: HttpClient) { }

  public createFeatured(recipe: Recipe): Observable<boolean> {

    return this.httpClient.post<boolean>(this.FEATURED_URL, recipe);
  }

  public getFeaturedRecipes(): Observable<HttpResponse<Recipe[]>> {

    return this.httpClient.get<Recipe[]>(this.FEATURED_URL, { observe: 'response' });
  }

  public completePending(recipe: Recipe): Observable<HttpResponse<boolean>> {

    const response = this.httpClient.put<boolean>(this.FEATURED_URL, recipe, { observe: 'response' });
    response.subscribe();
    return response;
  }
}
