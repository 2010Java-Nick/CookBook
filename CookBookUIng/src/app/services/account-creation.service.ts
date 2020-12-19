import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { User } from '../models/user.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AccountCreationService {

  private readonly USER_URL = 'http://localhost:9091/user';

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

    let success = false;

    if (user.firstName.search(`[^a-zA-Z\-]`) > 0 ||
        user.lastName.search(`[^a-zA-Z\-]`) > 0 ||
        user.username.search(`[^a-zA-Z0-9]`) > 0 ||
        user.password.length < 8
        ){
      return success;
    }
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    const options = {headers};
    this.httpClient.post<User>(this.USER_URL, user)
                   .subscribe(postResponse => { if (postResponse){ success = true; }});
    return success;

    // [^a-zA-Z\-]
  }

  public getUser(username: string): Observable<HttpResponse<User>> {

    return this.httpClient.get<User>(this.USER_URL + '/' + username, {observe: 'response'});
  }
}
