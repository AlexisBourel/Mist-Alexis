import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatTableDataSource } from '@angular/material';
import { Affaire } from '../affaire';
import { Router, ActivatedRoute } from '@angular/router';
import { AffaireService } from '../affaire.service';

@Component({
  selector: 'app-list-affaires',
  templateUrl: './list-affaires.component.html',
  styleUrls: ['./list-affaires.component.css']
})
export class ListAffairesComponent  implements OnInit {

  @ViewChild(MatPaginator) paginator: MatPaginator;

  affaires: Affaire[];

  displayedColumns = ['id', 'idAgent', 'titre', 'dateOuverture', 'status', 'description',
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
      this.dataSource.paginator = this.paginator; }
    );
  }

}
