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

  constructor( private formBuilder: FormBuilder, private affairesService: AffairesService, private router: Router) {};
  
  onSubmit(){
  const formValue = this.affaireForm.value;
  const newAffaire = new Affaire(formValue['idAgent'],
                                formValue['titre'],
                                formValue['dateOuverture'],
                                formValue['status'],
                                formValue['dateCloture'],
                          );

    console.log(newAffaire);
    this.affairesService.createAffaire(newAffaire)
    .subscribe(data => {
      alert('L\'affaire a bien été ajoutée');

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