import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { BrowserXhr } from '@angular/http';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule, MatDialogRef, MatDialogContent } from '@angular/material/dialog';

import { AppComponent } from './app.component';
import { ErrorDialogComponent } from './error-dialog/error-dialog.component';
import { QuoteSearchComponent } from './quote-search/quote-search.component';
import { QuoteService } from './service/quote-service.service';
import { ErrorDialogService } from './service/error-dialog.service';
import { HttpConfigInterceptor} from './interceptor/httpconfig.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    QuoteSearchComponent,
    ErrorDialogComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatDialogModule,
    HttpClientModule
  ],
  providers: [
     QuoteService,
     ErrorDialogService,
     { provide: MatDialogRef, useValue: {} },     
     { provide: HTTP_INTERCEPTORS, useClass: HttpConfigInterceptor, multi: true }
  ],
  entryComponents: [ErrorDialogComponent],
  bootstrap: [AppComponent]
})
export class AppModule { } 	