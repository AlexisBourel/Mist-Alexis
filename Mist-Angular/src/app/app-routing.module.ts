import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { Page404Component } from './page-404/page-404.component';
import { NavComponent } from './nav/nav.component';
import { IndexComponent } from './index/index.component';
import { GestionAffairesComponent } from './gestion-affaires/gestion-affaires.component';
import { UpdateAffaireComponent } from './gestion-affaires/update-affaire/update-affaire.component';
import { AddAffaireComponent } from './gestion-affaires/add-affaire/add-affaire.component';
import { ListAffairesComponent } from './gestion-affaires/list-affaires/list-affaires.component';

const routes: Routes = [

  { path: '', redirectTo: '/index', pathMatch: 'full' },

  { path: 'index', component: IndexComponent, children: [

    { path: 'gestion-affaires', component: GestionAffairesComponent, children: [
      { path: 'list', component: ListAffairesComponent },
     ] },
    { path: 'gestion-affaires/creer', component: AddAffaireComponent },
    { path: 'gestion-affaires/:id', component: UpdateAffaireComponent },
    { path: 'gestion-affaires/list', component: ListAffairesComponent },
    { path: 'list', component: ListAffairesComponent}
    
    ]
  },
  
  { path: 'nav', component: NavComponent},
  //{ path : '404', component: Page404Component},
  //{ path: '**', redirectTo: '404' }
  
]

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
