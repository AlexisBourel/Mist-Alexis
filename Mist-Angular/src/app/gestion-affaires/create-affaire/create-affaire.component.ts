import { Component, OnInit } from '@angular/core';
import { AffaireService } from '../affaire.service';
import { Affaire } from '../affaire';
import { Agent } from '../agent';

@Component({
  selector: 'app-create-affaire',
  templateUrl: './create-affaire.component.html',
  styleUrls: ['./create-affaire.component.css']
})
export class CreateAffaireComponent implements OnInit {


  affaire = new Affaire;
  submitted = false;
  agents = [
    {value: 1, viewValue: 'BOUREL Alexis'},
    {value: 2, viewValue: 'NESIC Alexandre'},
    {value: 3, viewValue: 'SUZANNE Jordan'},
    {value: 4, viewValue: 'NOURRY Jean-Luc'}
  ];
  status = [
    {value: 'Ouverte', viewValue: 'Ouverte'},
    {value: 'Close', viewValue: 'Close'},
  ]

  constructor(private affaireService: AffaireService) {
    console.log("create-affaire.component::constructor");
  }

  ngOnInit() {
    
    }

  private save(): void{
    console.log("create-affaire.component::save");
    //this.affaireService.createAffaire(this.affaire).subscribe();
    this.affaireService.createAffaire(this.affaire).subscribe(
      function(response) {console.log("create-affaire.component.ts::save response = " + response);},
      function(error) {console.log("create-affaire.component.ts::save error = " + JSON.stringify(error));},
      function() {console.log("create-affaire.component.ts::save is completed ");});
  }

  createAffaire(){
    console.log("create-affaire.component::createAffaire");
    this.submitted = true;
    this.save();
  }

  reload(): void{
    console.log("create-affaire.component::relaod");
    this.submitted = false;
    this.affaire = new Affaire;
  }
}