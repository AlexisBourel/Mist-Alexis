import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { Page404Component } from './page-404/page-404.component';
import { NavComponent } from './nav/nav.component';
import { IndexComponent } from './index/index.component';
import { GestionAffairesComponent } from './gestion-affaires/gestion-affaires.component';
import { ListAffairesComponent } from './gestion-affaires/list-affaires/list-affaires.component';
import { CreateAffaireComponent } from './gestion-affaires/create-affaire/create-affaire.component';
import { EditAffaireComponent } from './gestion-affaires/edit-affaire/edit-affaire.component';

const routes: Routes = [

  { path: '', redirectTo: '/index', pathMatch: 'full' },

  { path: 'index', component: IndexComponent, children: [
    { path: 'gestion-affaires/new', component: CreateAffaireComponent },
    { path: 'gestion-affaires', component: GestionAffairesComponent, children: [
      { path: 'list', component: ListAffairesComponent },
     ] },
    { path: 'gestion-affaires/:id', component: EditAffaireComponent }, 
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
