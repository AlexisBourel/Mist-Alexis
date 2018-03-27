import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AccordeonRechercheComponent } from './accordeon-recherche/accordeon-recherche.component';
import { AffichageRechercheComponent } from './affichage-recherche/affichage-recherche.component';
import { NavComponent } from './nav/nav.component';
import { IndexComponent } from './index/index.component';
import { AcceuilComponent} from './acceuil/acceuil.component';
import { ProfilComponent} from './profil/profil.component';
import { GestionDroitsComponent } from './gestion-droits/gestion-droits.component';
import { HotlistComponent} from './hotlist/hotlist.component';
import { GestionAffaireComponent } from './gestion-affaire/gestion-affaire.component';
import { SuspectFormComponent } from './suspect-form/suspect-form.component';
import { ArmeFormComponent } from './arme-form/arme-form.component';
import { VehiculeFormComponent } from './vehicule-form/vehicule-form.component';
import { AffaireFormComponent } from './affaire-form/affaire-form.component';
import { Page404Component } from './page-404/page-404.component';
import {MatSelectModule} from '@angular/material/select';
import { SuppressionAgentComponent } from './suppression-agent/suppression-agent.component';

import { RouterModule, Routes } from '@angular/router';



const routes: Routes = [

  { path: '', redirectTo: '/acceuil', pathMatch: 'full' },
  { path: 'acceuil', component: AcceuilComponent },
  { path: 'index', component: IndexComponent, children: [

    { path: '', redirectTo: 'hotlist', pathMatch: 'full'},

    { path: 'accordeon-recherche', component: AccordeonRechercheComponent , children: [

      { path: 'suspect-form', component: SuspectFormComponent },
      { path: 'arme-form', component: ArmeFormComponent },
      { path: 'vehicule-form', component: VehiculeFormComponent },
      { path: 'affaire-form', component: AffaireFormComponent },
    ]
  
  },

    { path: 'affichage-recherche', component: AffichageRechercheComponent },
  
    { path: 'profil', component: ProfilComponent },

    { path: 'gestion-droits', component: GestionDroitsComponent },

    { path: 'gestion-affaire', component: GestionAffaireComponent },

    { path: 'hotlist', component: HotlistComponent },

    { path: 'suppression-agent', component: SuppressionAgentComponent }

  ]

},

  { path: '**', component: AcceuilComponent },
  
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  declarations: [],
  exports : [
    RouterModule
    ]
})

export class AppRoutingModule { }
