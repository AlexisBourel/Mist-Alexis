import { Component, OnInit } from '@angular/core';
import { Agent } from '../agent';
import { AgentService } from '../agent.service';

@Component({
  selector: 'app-suppression-agent',
  templateUrl: './suppression-agent.component.html',
  styleUrls: ['./suppression-agent.component.css']
})
export class SuppressionAgentComponent implements OnInit {

  agentSelected: Agent;
  agents: Agent[];

  constructor(private agentService : AgentService) { }

  ngOnInit() {
    this.getAllAgents();

    }

  getAllAgents(): void{
    this.agentService.getAllAgent().subscribe((agents) => this.agents = agents );
  }

  agentSelect(agent){
    this.agentSelected =  agent;
  }

  deleteAgent(){
    this.agentService.deleteAgent(this.agentSelected.id).subscribe(() => this.getAllAgents());
  }


}
