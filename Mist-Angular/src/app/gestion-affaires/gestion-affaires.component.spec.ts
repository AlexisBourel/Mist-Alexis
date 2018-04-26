import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GestionAffairesComponent } from './gestion-affaires.component';

describe('GestionAffairesComponent', () => {
  let component: GestionAffairesComponent;
  let fixture: ComponentFixture<GestionAffairesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GestionAffairesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GestionAffairesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
