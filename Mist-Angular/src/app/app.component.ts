import { Component, OnInit } from '@angular/core';
import { AgentService } from './agent.service';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  constructor(private agentService: AgentService) {}

  ngOnInit() {
    this.agentService.getAllAgent();
  }

}
