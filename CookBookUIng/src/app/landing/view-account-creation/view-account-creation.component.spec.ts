import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';
import { Observable, of } from 'rxjs';
import { User } from 'src/app/models/user.model';
import { AccountCreationService } from 'src/app/services/account-creation.service';

import { ViewAccountCreationComponent } from './view-account-creation.component';

class MockService {
  public createNewUser(user: User): Observable<boolean> { return of(true); }
}

describe('ViewAccountCreationComponent', () => {
  let component: ViewAccountCreationComponent;
  let fixture: ComponentFixture<ViewAccountCreationComponent>;
  let router: Router;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ViewAccountCreationComponent],
      providers: [{ provide: AccountCreationService, useClass: MockService }],
      imports: [FormsModule, RouterTestingModule]
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewAccountCreationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should send http request', () => {
    fixture = TestBed.createComponent(ViewAccountCreationComponent);
  });
});
