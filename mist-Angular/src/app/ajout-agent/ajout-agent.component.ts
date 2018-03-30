import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, AbstractControl, FormControl, NgForm } from '@angular/forms';
import { Profil } from '../profil';
import { ProfilServiceService } from '../profil-service.service';
import { Agent } from '../agent';
import { AgentService } from '../agent.service';
import { Router } from '@angular/router';



@Component({
  selector: 'app-ajout-agent',
  templateUrl: './ajout-agent.component.html',
  styleUrls: ['./ajout-agent.component.css']
})
export class AjoutAgentComponent implements OnInit {


  agentForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private profilService: ProfilServiceService, private agentService: AgentService, private router: Router) {
   }

   onSubmit() {
    const formValue = this.agentForm.value;
    const profil = this.profilService.getProfil(formValue['profil']);
    console.log(profil);
    const newAgent = new Agent(
      formValue['nom'],
      formValue['prenom'],
      formValue['adresse'],
      formValue['ville'],
      formValue['email'],
      formValue['mdp'],
      profil
    );
    this.agentService.createAgent(newAgent);
   // this.router.navigate(['agents']);

   }


  ngOnInit() {
    this.initForm();
  }

  initForm(){
    this.agentForm = this.formBuilder.group({
      nom:'',
      prenom:'',
      adresse:'',
      ville:'',
      email:['',[Validators.required, Validators.email]],
      mdp:'',
      confMdp:'',
      profil: ''

    });
  }

}
