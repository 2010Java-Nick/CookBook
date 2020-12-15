import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewCreateRecipeComponent } from './view-create-recipe.component';

describe('ViewCreateRecipeComponent', () => {
  let component: ViewCreateRecipeComponent;
  let fixture: ComponentFixture<ViewCreateRecipeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewCreateRecipeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewCreateRecipeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
