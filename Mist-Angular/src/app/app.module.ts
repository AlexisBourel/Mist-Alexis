import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatTableModule, MatToolbarModule, MatPaginator, MatPaginatorModule, MatMenuModule, MatIconModule, MatSelectModule, MatDatepicker, MatDatepickerModule, MatNativeDateModule } from '@angular/material';
import { MatFormFieldModule, MatInputModule, MatCheckboxModule, MatRadioModule } from '@angular/material';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HttpModule } from '@angular/http';

import { CommonModule } from '@angular/common';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './/app-routing.module';
import { IndexComponent } from './index/index.component';
import { NavComponent } from './nav/nav.component';
import { Page404Component } from './page-404/page-404.component';
import { HttpClientModule } from '@angular/common/http';
import { GestionAffairesComponent } from './gestion-affaires/gestion-affaires.component';
import { ListAffairesComponent } from './gestion-affaires/list-affaires/list-affaires.component';
import { CreateAffaireComponent } from './gestion-affaires/create-affaire/create-affaire.component';
import { AffaireService } from './gestion-affaires/affaire.service';
import { EditAffaireComponent } from './gestion-affaires/edit-affaire/edit-affaire.component';






@NgModule({
  declarations: [
    AppComponent,
    IndexComponent,
    NavComponent,
    Page404Component,
    GestionAffairesComponent,
    ListAffairesComponent,
    CreateAffaireComponent,
    EditAffaireComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    CommonModule,
    NgbModule.forRoot(),
    NgbModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpModule,
    HttpClientModule,
    
    
    MatFormFieldModule,
    MatInputModule,
    MatCheckboxModule,
    MatRadioModule,
    MatTableModule,
    MatToolbarModule,
    MatSelectModule,
    MatPaginatorModule,
    MatMenuModule,
    MatIconModule,
    MatDatepickerModule,
    MatNativeDateModule,
  ],
  exports: [CommonModule, MatToolbarModule, MatInputModule, MatTableModule],

  providers: [
    AffaireService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
export class MaterialModule { }
