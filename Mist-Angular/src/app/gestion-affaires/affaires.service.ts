import { Injectable } from '@angular/core';
import { Affaire } from './affaire';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Subscription } from 'rxjs/Subscription';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class AffairesService {

  constructor(private http: HttpClient) { }

  private affaireUrl = 'http://localhost:8080/api/affaire';

  private affaires: Affaire[];

  public createAffaire(affaire: Affaire) {
    
    return this.http.post<Affaire>(this.affaireUrl, affaire, httpOptions);
  }

  public getAffaireById(id: number): Observable<Affaire> {
    const url = `${this.affaireUrl}/${id}`;
    return this.http.get<Affaire>(url);
  }

  public getAllAffaire(): Observable<Affaire[]> {
    return this.http.get<Affaire[]>(this.affaireUrl);
  }

  public updateAffaire(id: number, affaire: Affaire): Observable<any> {
    const url = `${this.affaireUrl}/${id}`;
    console.log(url);
    return this.http.put(url, affaire, httpOptions);
  }

  deleteAffaire(id: number){
    const url = `${this.affaireUrl}/${id}`;
    console.log(url);
    return this.http.delete<Affaire>(url, httpOptions);
  }

}
