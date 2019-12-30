import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map } from 'rxjs/operators';
import {throwError as observableThrowError,  Observable } from 'rxjs';
import { Quote } from '../model/quote';

@Injectable()
export class QuoteService {

  private quotesUrl: string;
 
  constructor(private http: HttpClient) {
    this.quotesUrl = 'http://localhost:8080/';
  }

  public searchQuotes(term: string): Observable<Quote[]> {
    return this.http.get<Quote[]>(`${this.quotesUrl}/quotes/${term}`);
  }
  
}