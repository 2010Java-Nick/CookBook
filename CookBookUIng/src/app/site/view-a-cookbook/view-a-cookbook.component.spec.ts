import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewACookbookComponent } from './view-a-cookbook.component';

describe('ViewACookbookComponent', () => {
  let component: ViewACookbookComponent;
  let fixture: ComponentFixture<ViewACookbookComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewACookbookComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewACookbookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
