import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, AbstractControl, FormControl, NgForm } from '@angular/forms';
import { Affaire } from '../affaire';
import { AffairesService } from '../affaires.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-affaire',
  templateUrl: './add-affaire.component.html',
  styleUrls: ['./add-affaire.component.css']
})

export class AddAffaireComponent implements OnInit {

  affaireForm: FormGroup;
 
  agentId: number;

  agents = [
    {value: 1, viewValue: 'BOUREL Alexis'},
    {value: 2, viewValue: 'NESIC Alexandre'},
    {value: 3, viewValue: 'SUZANNE Jordan'},
    {value: 4, viewValue: 'NOURRY Jean-Luc'}
  ];

  constructor( private formBuilder: FormBuilder, private affairesService: AffairesService, private router: Router) {};
  
  onSubmit(){
    const formValue = this.affaireForm.value;
    const newAffaire = new Affaire();
    newAffaire.idAgent =this.agentId;
    newAffaire.status = 'ouverte';
    newAffaire.titre = formValue['titre'];
    console.log(newAffaire);
    this.affairesService.createAffaire(newAffaire)
    .subscribe(data => {
      alert('L\'affaire a bien été ouverte');

  });

}

ngOnInit() {
  this.initForm();
}

  initForm() {
    this.affaireForm = this.formBuilder.group({
      idAgent:'',
      titre:'',
      dateOuverture:'',
      status:'',
      dateCloture:'',
      })
  }
}