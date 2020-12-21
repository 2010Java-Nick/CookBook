import { HttpClient, HttpResponse } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { Recipe } from '../models/recipe.model';
import { FeaturedService } from './featured.service';


class MockHttp {

  public post<T>(url: string, obj: T): Observable<HttpResponse<boolean>> {
    const response: HttpResponse<boolean> = new HttpResponse({ body: true });
    return of(response);
  }

  public get(url: string): Observable<HttpResponse<Recipe[]>> {
    const recipe: Recipe = {
      id: 1,
      name: 'string',
      author: 'string',
      featured: false,
      servings: 1,
      prepTime: 1,
      cookTime: 1,
      steps: 'string',
      tags: 'string',
      ingredients: 'string',
      description: 'string'
    };
    const recipes: Recipe[] = [recipe];
    const response: HttpResponse<Recipe[]> = new HttpResponse({ body: recipes });
    const observable: Observable<HttpResponse<Recipe[]>> = of(response);
    return observable;
  }
}

describe('FeaturedService', () => {
  let service: FeaturedService;

  const recipe: Recipe = {
    id: 1,
    name: 'string',
    author: 'string',
    featured: false,
    servings: 1,
    prepTime: 1,
    cookTime: 1,
    steps: 'string',
    tags: 'string',
    ingredients: 'string',
    description: 'string'
  };
  const recipes: Recipe[] = [recipe];

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [{provide: HttpClient, useClass: MockHttp}]
    });
    service = TestBed.inject(FeaturedService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should return true', () => {
    expect(service.createFeatured(recipe)).toBeTruthy();
  });

  it('should return recipe list', () => {
    let returnedRecipes;
    service.getFeaturedRecipes().subscribe(response => {
      returnedRecipes = response.body;
    });
    expect(returnedRecipes).toBeTruthy();

    if (returnedRecipes !== undefined) {
      expect(returnedRecipes).toEqual(recipes);
    }
  });
});
