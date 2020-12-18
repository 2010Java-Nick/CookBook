import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { User } from '../models/user.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AccountCreationService {

  private readonly USER_URL = ':8080/user';

  constructor(private httpClient: HttpClient) { }

  /**
   * Sends user object to back end for storage after verifying input
   * returns true if object passes verification, false if not.
   *
   * Verification:
   *
   * First and last name only contain alphabetical characters or hyphens.
   *
   * Username contains only alphanumeric characters.
   *
   * Password is at least 8 characters long.
   */
  public createNewUser(user: User): boolean {

    console.log(user.firstName.search(`[^a-zA-Z\-]`));

    if (user.firstName.search(`[^a-zA-Z\-]`) > 0 ||
        user.lastName.search(`[^a-zA-Z\-]`) > 0 ||
        user.username.search(`[^a-zA-Z0-9]`) > 0 ||
        user.password.length < 8
        ){
      return false;
    }

    this.httpClient.post<User>(this.USER_URL, user);
    return true;

    // [^a-zA-Z\-]
  }

  public getUser(username: string): Observable<HttpResponse<User>> | null {

    return this.httpClient.get<User>(this.USER_URL + '/' + username, {observe: 'response'});
  }
}
