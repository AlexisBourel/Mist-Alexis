import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Agent } from './agent';
import { Observable } from 'rxjs/Observable';
import { Subscription } from 'rxjs/Subscription';
import { Subject } from 'rxjs/Subject';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class AgentService {

  constructor(private http:  HttpClient) {}

  private agents: Agent[];
  agentsSusbject = new Subject<any[]>();

  private agentUrl = 'http://localhost:8080/api/agent';

  public createAgent(agent: Agent) {
    console.log('creation agent');
    this.http.post(this.agentUrl, agent, httpOptions);
    this.emitAgentSubject();
  }

  public getAllAgent() {
  
    this.http.get<any[]>(this.agentUrl).subscribe(
     (response) => {this.agents = response;
                    this.emitAgentSubject();
        }
    );
  }

  public deleteAgent(id: number): Observable<Agent> {
    const url = `${this.agentUrl}/${id}`;
    return this.http.delete<Agent>(url, httpOptions);
  }

  public updateAgent(id: number, agent: Agent): Observable<any> {
    const url = `${this.agentUrl}/${id}`;
    return this.http.put(url, agent, httpOptions);
  }

  emitAgentSubject(){
    this.agentsSusbject.next(this.agents.slice());
  }



}
