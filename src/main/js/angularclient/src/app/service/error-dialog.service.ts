import { Injectable } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { ErrorDialogComponent } from '../error-dialog/error-dialog.component';

@Injectable()
export class ErrorDialogService {

    public isDialogOpen: Boolean = false;
    
    constructor(public dialog: MatDialog, public thisDialogRef: MatDialogRef<ErrorDialogComponent>) { }

    openDialog(data): any {
        if (this.isDialogOpen) {
            return false;
        }
        
        this.isDialogOpen = true;
        
        this.thisDialogRef = this.dialog.open(ErrorDialogComponent, {
            width: '300px',
            data: data
        });

        this.thisDialogRef.afterClosed().subscribe(result => {
            this.isDialogOpen = false;
        });
    }
    
    closeDialog(): any {
        if (this.isDialogOpen) {
           this.thisDialogRef.close('OK');
        }   
    }
    
}