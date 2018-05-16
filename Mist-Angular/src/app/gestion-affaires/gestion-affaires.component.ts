import { Component, OnInit,  ViewChild, AfterViewInit  } from '@angular/core';
import { Subscription } from 'rxjs/Subscription';
import { MatTableDataSource, MatPaginator } from '@angular/material';
import {DataSource} from '@angular/cdk/collections';
import { Router, ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { Affaire } from './affaire';
import { AffaireService } from './affaire.service';

@Component({
  selector: 'app-gestion-affaires',
  templateUrl: './gestion-affaires.component.html',
  styleUrls: ['./gestion-affaires.component.css']
})
export class GestionAffairesComponent implements OnInit {

  @ViewChild(MatPaginator) paginator: MatPaginator;

  affaires: Affaire[];

  displayedColumns = ['titre', 'description', 'status', 'agentName', 'dateOuverture',
                  'dateCloture','edit', 'delete'];
  dataSource = new MatTableDataSource();

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
   this.dataSource.filter = filterValue;
  }

  constructor(private affaireService: AffaireService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.loadAffaire();
  }

  onDelete(id:number) {
    this.affaireService.deleteAffaire(id).subscribe(
      () => this.loadAffaire()
    );
  }

  loadAffaire(){
    this.affaireService.getAllAffaire().subscribe(
      data => { this.dataSource = new MatTableDataSource(data);
      this.dataSource.paginator = this.paginator;
      console.log(data);
      console.log("affaires loaded");
     }
    );
  }

}