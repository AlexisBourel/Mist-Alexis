import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Agent } from '../agent';
import { AgentService } from '../agent.service';

import { ProfilServiceService } from '../profil-service.service';
import { Profil } from '../profil';


@Component({
  selector: 'app-creation-agent',
  templateUrl: './creation-agent.component.html',
  styleUrls: ['./creation-agent.component.css']
})

export class CreationAgentComponent implements OnInit {

  agent: Agent = new Agent();
  public profils: Profil[];

  ngOnInit() {
    this.loadProfil();
  }

  constructor(private router: Router, private profilService: ProfilServiceService,  private agentService: AgentService) { }

  createAgent(agent): void {
    this.agentService.createAgent(this.agent)
      .subscribe(data => {
        alert('L\'agent a bien été créé');
      });
  }

  setProfil(profil: Profil): void{
    this.agent.profil = profil;
  }

  loadProfil(): void {
    this.profilService.getAllProfil().subscribe((profil) => this.profils = profil);
  }

  
}
