import { Component, OnInit } from '@angular/core';
import { AffaireService } from '../affaire.service';
import { Affaire } from '../affaire';
import { Agent } from '../agent';
import { FormControl, Validators, FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-create-affaire',
  templateUrl: './create-affaire.component.html',
  styleUrls: ['./create-affaire.component.css']
})
export class CreateAffaireComponent implements OnInit {


  affaire = new Affaire;
  submitted = false;
  valid = true;
  error = false;
  agents = [
    { value: 1, viewValue: 'BOUREL Alexis' },
    { value: 2, viewValue: 'NESIC Alexandre' },
    { value: 3, viewValue: 'SUZANNE Jordan' },
    { value: 4, viewValue: 'NOURRY Jean-Luc' }
  ];
  status = [
    { value: 'Ouverte', viewValue: 'Ouverte' },
    { value: 'Close', viewValue: 'Close' },
  ]

  constructor(private affaireService: AffaireService, ) {
    console.log("create-affaire.component::constructor");
  }

  ngOnInit() {
  }

  private save(): void {
    console.log("create-affaire.component::save");
    //this.affaireService.createAffaire(this.affaire).subscribe();
    this.affaireService.createAffaire(this.affaire).subscribe(
      (response) => { 
        this.submitted = true;
        console.log("create-affaire.component.ts::save response = " + response);
       },
      (error) => {
        this.error = true;
        console.log("create-affaire.component.ts::save error = " + JSON.stringify(error));
      },
      function () { console.log("create-affaire.component.ts::save is completed "); }
    );
  }


  createAffaire() {
    this.validationFormulaire();
    if (this.valid) {
      console.log("create-affaire.component::createAffaire");
      this.save();
    }
  }

  reload(): void {
    console.log("create-affaire.component::relaod");
    this.submitted = false;
    this.affaire = new Affaire;
  }

  private validationFormulaire(): void {
    if (
      this.affaire.titre == null ||
      this.affaire.idAgent == null ||
      this.affaire.status == null ||
      this.affaire.dateOuverture == null ||
      this.affaire.description == null) {
      this.valid = false;

    } else {
      this.valid = true;
    }
  }
}