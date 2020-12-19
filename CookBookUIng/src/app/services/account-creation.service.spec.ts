import { HttpClient, HttpResponse } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { Observable, of } from 'rxjs';
import { User } from '../models/user.model';

import { AccountCreationService } from './account-creation.service';

class MockHttp {

  public post<T>(url: string, obj: T): void {
    url.toString();
  }

  public get(url: string, username: string): Observable<HttpResponse<User>> {
    const user: User = {username: 'username', password: 'password', firstName: 'Bob', lastName: 'Billy', authorization: 'STANDARD'};
    const response: HttpResponse<User> = new HttpResponse({body: user});
    const observable: Observable<HttpResponse<User>> = of(response);
    return observable;
  }
}

describe('AccountCreationService', () => {
  let service: AccountCreationService;
  const user: User = {username: 'username', password: 'password', firstName: 'Bob', lastName: 'Billy', authorization: 'STANDARD'};

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ {provide: HttpClient, useClass: MockHttp}]
    });
    service = TestBed.inject(AccountCreationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should return true', () => {
    expect(service.createNewUser(user)).toBeTruthy();
  });

  it('should return bob', () => {
    let returnedUser;
    service.getUser('username').subscribe((resp) => {
      returnedUser = resp.body;
    });
    console.log(returnedUser);
    expect(returnedUser).toBeTruthy();
    if (returnedUser !== undefined){
      expect(user).toEqual(returnedUser);
    }
  });
});
