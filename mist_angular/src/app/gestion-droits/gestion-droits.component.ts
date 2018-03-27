import { Component, OnInit } from '@angular/core';
import { Agent } from '../agent';
import { AgentService } from '../agent.service';
import { ProfilServiceService } from '../profil-service.service';
import { Profil } from '../profil';

@Component({
selector: 'app-gestion-droits',
templateUrl: './gestion-droits.component.html',
styleUrls: ['./gestion-droits.component.css']
})

export class GestionDroitsComponent implements OnInit {

estSelect = false;
public agents: Agent[];
profil: string;
agentSelected: Agent;
profils = [];

constructor(private agentService: AgentService, private profilService: ProfilServiceService) { }

ngOnInit() {
  this.getAllAgent();
  this.loadProfil();
}

getAllAgent(): void {
  this.agentService.getAllAgent().subscribe(agents => this.agents = agents);
}

agentSelectionne(agent: Agent) {
  this.agentSelected = agent;
  this.estSelect = true;
}

loadProfil(){
  this.profilService.getAllProfil().subscribe((profil) => this.profils = profil );
}

updateProfil(){
  this.agentService.updateAgent(this.agentSelected.id, this.agentSelected).subscribe(() => this.getAllAgent());
}

}
