import {
  HttpClient,
  HttpErrorResponse,
  HttpHeaders,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { Cookbook } from '../models/cookbook.model';
import { catchError, map, retry, tap } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    // Authorization: 'my-auth-token'
  }),
};
export interface Config {
  rl: string;
  textfile: string;
}
@Injectable({
  providedIn: 'root',
})
export class CookbookService {

  private readonly RECIPE_URL = `http://localhost:9091/cookbook`;

  constructor(private httpClient: HttpClient) {}

  private handleError(error: HttpErrorResponse): Observable<never> {
    if (error.error instanceof ErrorEvent) {
      console.error('An error occurred:', error.error.message);
    } else {
      console.error(
        `Backend returned code ${error.status}, ` + `body was: ${error.error}`
      );
    }
    return throwError('Something bad happened; please try again later.');
  }
  public getCookbook(cookbookId: number): Observable<Cookbook> {
    return this.httpClient
      .get<Cookbook>(this.RECIPE_URL + '/' + cookbookId)
      .pipe(
        retry(2),
        catchError(this.handleError) // then handle the error
      );
  }
  public getCookbooks(): Observable<Cookbook[]> {
    return this.httpClient
      .get<Cookbook[]>(this.RECIPE_URL)
      .pipe(retry(2), catchError(this.handleError));
  }
  public createCookbook(cookbook: Cookbook): any {
    this.httpClient
      .post<any>(this.RECIPE_URL, cookbook, httpOptions)
      .pipe(
        retry(2), // retry a failed request up to 3 times
        catchError(this.handleError) // then handle the error
      )
      .subscribe(
        (res) => console.log(res),
        (err) => console.log(err)
      );
    return cookbook;
  }
}
