import { HttpClient } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { from, Observable } from 'rxjs';
import { User } from '../models/user.model';

import { AccountCreationService } from './account-creation.service';

class MockHttp {

  public post<T>(url: string, obj: T): void {
    url.toString();
  }

  public get(url: string, username: string): Observable<User> | null {
    const user: User = {username: 'username', password: 'password', firstName: 'Bob', lastName: 'Billy', authorization: 'STANDARD'};
    url.toString();
    if (username === user.username){
      return from([user]);
    } else {
      return null;
    }
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
    const returnedUser = service.getUser('username')?.subscribe(user => user);
    console.log(returnedUser);
    expect(returnedUser).toEqual(user);
  });
});
