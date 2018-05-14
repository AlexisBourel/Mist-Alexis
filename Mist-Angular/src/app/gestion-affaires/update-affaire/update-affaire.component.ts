import { Component, OnInit, Input } from '@angular/core';
import { NgForm, FormGroup, FormBuilder } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Affaire } from '../affaire';
import { AffairesService } from '../affaires.service';
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'app-update-affaire',
  templateUrl: './update-affaire.component.html',
  styleUrls: ['./update-affaire.component.css']
})
export class UpdateAffaireComponent implements OnInit {

  id:number;
  erreur = false;
  affaireForm: FormGroup;

  constructor(private route: ActivatedRoute,
     private router: Router, private affaireService: AffairesService, private formBuilder: FormBuilder) { }

  onSubmit() {
    const formValue = this.affaireForm.value;
    const majAffaire = new Affaire();
    majAffaire.idAgent = formValue['idAgent'];
    majAffaire.titre = formValue['titre'];
    majAffaire.status = formValue['status'];
    if (formValue['dateCloture'] !== null) {
      majAffaire.dateCloture = formValue['dateCloture'];
    };                            
    console.log(JSON.stringify(majAffaire));
    
      this.affaireService.updateAffaire(this.id, majAffaire)
      .subscribe(data => {
        alert('L\'affaire a bien été modifiée');  
    });
  
  }

  ngOnInit() {
    this.id = +this.route.snapshot.paramMap.get('id');
    this.initForm();
  }
  
    initForm() {
      var selectedAffaire: Affaire = this.affaireService.getAffaireById(this.id);
      this.affaireForm = this.formBuilder.group({
        idAgent: selectedAffaire.idAgent,
        titre:'',
        dateOuverture:'',
        status:'',
        dateCloture:'',
        })
    }
}
