import { Component, OnInit, Input } from '@angular/core';
import { NgForm, FormGroup, FormBuilder } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Affaire } from '../affaire';
import { AffairesService } from '../affaires.service';

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
  const majAffaire = new Affaire(formValue['idAgent'],
                                formValue['titre'],
                                formValue['dateOuverture'],
                                formValue['status'],
                                formValue['dateCloture'],
                                );
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
      this.affaireForm = this.formBuilder.group({
        idAgent:'',
        titre:'',
        dateOuverture:'',
        status:'',
        dateCloture:'',
        })
    }
}
