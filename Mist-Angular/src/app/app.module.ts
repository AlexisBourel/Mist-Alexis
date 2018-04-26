import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatTableModule, MatToolbarModule, MatPaginator, MatPaginatorModule, MatMenuModule, MatIconModule, MatSelectModule } from '@angular/material';
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
import { AffairesService } from './gestion-affaires/affaires.service';
import { AddAffaireComponent } from './gestion-affaires/add-affaire/add-affaire.component';
import { UpdateAffaireComponent } from './gestion-affaires/update-affaire/update-affaire.component';





@NgModule({
  declarations: [
    AppComponent,
    IndexComponent,
    NavComponent,
    Page404Component,
    GestionAffairesComponent,
    AddAffaireComponent,
    UpdateAffaireComponent,
  ],
  imports: [
    BrowserModule,
    NgbModule.forRoot(),
    NgbModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    MatSelectModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    MatInputModule,
    MatCheckboxModule,
    MatRadioModule,
    HttpModule,
    HttpClientModule,
    MatTableModule,
    MatToolbarModule,
    CommonModule,
    MatPaginatorModule,
    MatMenuModule,
    MatIconModule,
  ],
  exports: [CommonModule, MatToolbarModule, MatInputModule, MatTableModule],

  providers: [AffairesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
export class MaterialModule { }
