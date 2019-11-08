import { Component, OnInit } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { distinctUntilChanged, switchMap } from 'rxjs/operators';
import { catchError } from 'rxjs/operators';
import { Quote } from '../model/quote';
import { QuoteService } from '../service/quote-service.service';

@Component({
  selector: 'app-quote-search',
  templateUrl: './quote-search.component.html',
  styleUrls: ['./quote-search.component.css']
})

export class QuoteSearchComponent implements OnInit {
  quotes$: Observable<any>;
  error$: Observable<string>;
  show: boolean = true;
  private searchQuotes = new Subject<string>();

  constructor(private quoteService: QuoteService) {}

  search(term: string): void {
    this.show = true;
    this.searchQuotes.next(term);
  }

  ngOnInit(): void {
      this.quotes$ = this.searchQuotes.pipe(
      distinctUntilChanged(),
     switchMap((term: string) => this.quoteService.searchQuotes(term) ),
     //TODO Fix Error Handling
     //catchError(err => {
     //    this.show = false;
     //    this.error$ = err.message;
     // })
      );
  }
}