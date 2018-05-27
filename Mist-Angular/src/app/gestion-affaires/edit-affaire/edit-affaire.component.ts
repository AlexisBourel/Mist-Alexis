import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { Affaire } from '../affaire';
import { AffaireService } from '../affaire.service';


@Component({
  selector: 'app-edit-affaire',
  templateUrl: './edit-affaire.component.html',
  styleUrls: ['./edit-affaire.component.css']
})
export class EditAffaireComponent implements OnInit {
  @Input() affaire : Affaire;
  private id : number;
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
  constructor(private route: ActivatedRoute, 
              private affaireService: AffaireService,
              private location: Location) { 
    console.log('edit-affaire.component::constructor');
  }

  ngOnInit() {
    console.log('edit-affaire.component::ngOnInit');
    this.getAffaire();
  }

  getAffaire(): void {
    this.id = +this.route.snapshot.paramMap.get('id');
    console.log('edit-affaire.component::getAffaire id=' + this.id);
    this.affaireService.getAffaire(this.id)
      .subscribe(affaire => this.affaire = affaire);
  }

  updateAffaire(): void {
    console.log('edit-affaire.component::updateAffaire id=' + this.id);
    this.affaireService.updateAffaire(this.id, this.affaire)
    .subscribe(() => this.goBack());
  }

  goBack(): void {
    console.log('edit-affaire.component::goBack');
    this.location.back();
  }
}
