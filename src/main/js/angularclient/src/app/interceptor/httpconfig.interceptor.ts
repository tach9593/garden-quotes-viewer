import { Injectable } from '@angular/core';

import { ErrorDialogService } from '../service/error-dialog.service';
import { HttpInterceptor, HttpRequest, HttpResponse, HttpHandler, HttpErrorResponse, HttpEvent } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { map, catchError } from 'rxjs/operators';

@Injectable()
export class HttpConfigInterceptor implements HttpInterceptor {

    constructor(public errorDialogService: ErrorDialogService) { }
    
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        
        return next.handle(request).pipe(
            catchError((error: HttpErrorResponse) => {
              let data = {};

              if (error.error instanceof ErrorEvent) {
                  // client-side error
	               data = { 
    	              reason: error.error.message,
        	          status: 'client error'
       	          }
               } else {
                 // server-side error
	               data = { 
    	              reason: error.message,
        	          status: error.status
       	          }
               }
               this.errorDialogService.openDialog(data);
               return throwError(error);
            }));
    }
}