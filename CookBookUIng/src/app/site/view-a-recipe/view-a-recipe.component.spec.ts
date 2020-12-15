import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewARecipeComponent } from './view-a-recipe.component';

describe('ViewARecipeComponent', () => {
  let component: ViewARecipeComponent;
  let fixture: ComponentFixture<ViewARecipeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewARecipeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewARecipeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
