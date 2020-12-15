import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAccountCreationComponent } from './view-account-creation.component';

describe('ViewAccountCreationComponent', () => {
  let component: ViewAccountCreationComponent;
  let fixture: ComponentFixture<ViewAccountCreationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewAccountCreationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewAccountCreationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
