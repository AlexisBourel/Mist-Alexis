import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Agent } from './agent';
import { Observable } from 'rxjs/Observable';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};



@Injectable()
export class AgentService {

  constructor(private http:  HttpClient) {}

  private agentUrl = 'http://localhost:8080/api/utilisateur';

  public createAgent(agent: Agent): Observable<Agent> {
    console.log('creation agent');
    return this.http.post<Agent>(this.agentUrl, agent, httpOptions);
  }

  public getAllAgent(): Observable<Agent []> {
    return this.http.get<Agent[]>(this.agentUrl);
  }

  public deleteAgent(id: number): Observable<Agent> {
    const url = `${this.agentUrl}/${id}`;
    return this.http.delete<Agent>(url, httpOptions);
  }

  public updateAgent(id: number, agent: Agent): Observable<any> {
    const url = `${this.agentUrl}/${id}`;
    return this.http.put(url, agent, httpOptions);
  }

}
