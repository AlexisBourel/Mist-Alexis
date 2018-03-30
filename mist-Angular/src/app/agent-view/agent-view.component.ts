import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { Subscription } from 'rxjs/Subscription';
import { AgentService } from '../agent.service';
import { MatTableDataSource, MatPaginator } from '@angular/material';
import { Agent } from '../agent';

@Component({
  selector: 'app-agent-view',
  templateUrl: './agent-view.component.html',
  styleUrls: ['./agent-view.component.css']
})
export class AgentViewComponent implements OnInit, AfterViewInit {

  @ViewChild(MatPaginator) paginator: MatPaginator;

  agents: Agent[];
  agentSubscription: Subscription;
  displayedColumns = ['id', 'nom', 'prenom', 'email', 'status', 'edit', 'delete'];
  dataSource;

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }
 
  constructor(private agentService: AgentService) { }

  ngOnInit() {
    this.agentSubscription = this.agentService.agentsSusbject.subscribe(
      (data: any[]) => {this.agents = data; }
    );
    this.agentService.emitAgentSubject();
    this.dataSource = new MatTableDataSource<Agent>(this.agents);
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

  
}
