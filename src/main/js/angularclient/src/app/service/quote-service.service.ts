import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { Quote } from '../model/quote';

@Injectable()
export class QuoteService {

  private quotesUrl: string;
 
  constructor(private http: HttpClient) {
    this.quotesUrl = 'http://localhost:8080/';
  }

  public searchQuotes(term: string): Observable<Quote[]> {
    return this.http.get<Quote[]>(`${this.quotesUrl}/quotes/${term}`).pipe(  
           map( (quotes) => quotes.map ( (quote) => ({ ...new Quote(), ...quote}))),
           catchError(this.handleError) 
     );
  }
  
  private handleError (error: Response | any) {
    let errMsg: string;
    if (error instanceof Response) {
      const err = error || '';
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    return Observable.throw(errMsg);
  }
}