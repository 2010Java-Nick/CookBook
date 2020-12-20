import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewCookbookListComponent } from './view-cookbook-list.component';

describe('ViewCookbookListComponent', () => {
  let component: ViewCookbookListComponent;
  let fixture: ComponentFixture<ViewCookbookListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewCookbookListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewCookbookListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
