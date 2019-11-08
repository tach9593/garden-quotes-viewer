import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QuoteSearchComponent } from './quote-search.component';

describe('QuoteSearchComponent', () => {
  let component: QuoteSearchComponent;
  let fixture: ComponentFixture<QuoteSearchComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QuoteSearchComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QuoteSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
