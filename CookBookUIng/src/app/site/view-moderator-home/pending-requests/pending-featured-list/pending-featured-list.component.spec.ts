import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PendingFeaturedListComponent } from './pending-featured-list.component';

describe('PendingFeaturedListComponent', () => {
  let component: PendingFeaturedListComponent;
  let fixture: ComponentFixture<PendingFeaturedListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PendingFeaturedListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PendingFeaturedListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
