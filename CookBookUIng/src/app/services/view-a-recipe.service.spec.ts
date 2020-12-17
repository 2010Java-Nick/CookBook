import { TestBed } from '@angular/core/testing';

import { ViewARecipeService } from './view-a-recipe.service';

describe('ViewARecipeServiceService', () => {
  let service: ViewARecipeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ViewARecipeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
