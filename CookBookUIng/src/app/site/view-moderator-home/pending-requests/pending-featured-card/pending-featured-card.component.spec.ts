import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PendingFeaturedCardComponent } from './pending-featured-card.component';

describe('PendingFeaturedCardComponent', () => {
  let component: PendingFeaturedCardComponent;
  let fixture: ComponentFixture<PendingFeaturedCardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PendingFeaturedCardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PendingFeaturedCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
