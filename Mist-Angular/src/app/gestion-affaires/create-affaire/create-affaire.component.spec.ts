import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateAffaireComponent } from './create-affaire.component';

describe('CreateAffaireComponent', () => {
  let component: CreateAffaireComponent;
  let fixture: ComponentFixture<CreateAffaireComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateAffaireComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateAffaireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
