import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewRecipeListComponent } from './view-recipe-list.component';

describe('ViewRecipeListComponent', () => {
  let component: ViewRecipeListComponent;
  let fixture: ComponentFixture<ViewRecipeListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewRecipeListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewRecipeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
