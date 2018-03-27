import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { Component } from '@angular/core';
import { AccordeonRechercheComponent } from './accordeon-recherche/accordeon-recherche.component';
import { AffichageRechercheComponent } from './affichage-recherche/affichage-recherche.component';
import { IndexComponent } from './index/index.component';
import { AppRoutingModule } from './/app-routing.module';
import { AcceuilComponent } from './acceuil/acceuil.component';
import { ProfilComponent } from './profil/profil.component';
import { GestionDroitsComponent } from './gestion-droits/gestion-droits.component';
import { HotlistComponent } from './hotlist/hotlist.component';
import { GestionAffaireComponent } from './gestion-affaire/gestion-affaire.component';
import { SuspectFormComponent } from './suspect-form/suspect-form.component';
import { ArmeFormComponent } from './arme-form/arme-form.component';
import { VehiculeFormComponent } from './vehicule-form/vehicule-form.component';
import { AffaireFormComponent } from './affaire-form/affaire-form.component';
import { FormControl, FormGroup, FormBuilder, FormsModule } from '@angular/forms';

import { ReactiveFormsModule} from '@angular/forms';
import { MatSelectModule } from '@angular/material/select';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CreationAgentComponent } from './creation-agent/creation-agent.component';
import { MatFormFieldModule, MatInputModule, MatCheckboxModule, MatRadioModule } from '@angular/material';
import { Page404Component } from './page-404/page-404.component';
import { HttpClientModule } from '@angular/common/http';
import { HttpModule } from '@angular/http';
import { AgentService } from './agent.service';
import { ModifAffaireComponent } from './modif-affaire/modif-affaire.component';
import { SuppressionAgentComponent } from './suppression-agent/suppression-agent.component';
import { ProfilServiceService } from './profil-service.service';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    AccordeonRechercheComponent,
    AffichageRechercheComponent,
    IndexComponent,
    AcceuilComponent,
    ProfilComponent,
    GestionDroitsComponent,
    HotlistComponent,
    GestionAffaireComponent,
    SuspectFormComponent,
    ArmeFormComponent,
    VehiculeFormComponent,
    AffaireFormComponent,
    CreationAgentComponent,
    Page404Component,
    ModifAffaireComponent,
    SuppressionAgentComponent,
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
    HttpClientModule

  ],
  
  providers: [AgentService, ProfilServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
