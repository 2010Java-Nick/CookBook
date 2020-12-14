import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewModeratorHomeComponent } from './view-moderator-home.component';

describe('ViewModeratorHomeComponent', () => {
  let component: ViewModeratorHomeComponent;
  let fixture: ComponentFixture<ViewModeratorHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewModeratorHomeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewModeratorHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
