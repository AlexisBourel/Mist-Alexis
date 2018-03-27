import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Profil } from './profil';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class ProfilServiceService {

  constructor(private http: HttpClient) { }

  private profilUrl = 'http://localhost:8080/api/profil';

  public getAllProfil(): Observable<Profil[]> {
    return this.http.get<Profil[]>(this.profilUrl);
  }
}
