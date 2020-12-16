import { TestBed } from '@angular/core/testing';

import { ViewARecipeServiceService } from './view-a-recipe-service.service';

describe('ViewARecipeServiceService', () => {
  let service: ViewARecipeServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ViewARecipeServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
