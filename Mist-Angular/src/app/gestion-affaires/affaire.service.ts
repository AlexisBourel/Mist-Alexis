import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Affaire } from './affaire';
import { FormGroup } from '@angular/forms';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class AffaireService {

  private affaireUrl = "http://localhost:8080/api/affaire";

  constructor(private http: HttpClient) { }

  getAllAffaire(): Observable<Affaire[]> {
    console.log("affaire.service::getAllAffaire");
    return this.http.get<Affaire[]>(this.affaireUrl);
  }

  getAffaire(id: number): Observable<Affaire> {
    console.log("affaire.service::getAffaire with id=" + id);
    const url = `${this.affaireUrl}/${id}`;
    return this.http.get<Affaire>(url);
  }

  createAffaire (affaire: Affaire): Observable<Affaire> {
    console.log("affaire.service::createAffaire");
    return this.http.post<Affaire>(this.affaireUrl, affaire, httpOptions)
  }

  updateAffaire(id: number, affaire:Affaire): Observable<any> {
    console.log("affaire.service::updateAffaire with id=" + id);
    const url = `${this.affaireUrl}/${id}`
    return this.http.put(url, affaire, httpOptions);
  }

  deleteAffaire(affaire: Affaire | number): Observable<any> {
    console.log("affaire.service::deleteAffaire");
    const id = typeof affaire === 'number' ? affaire : affaire.id;
    const url = `${this.affaireUrl}/${id}`;
  
    return this.http.delete<Affaire>(url, httpOptions);
  }
}