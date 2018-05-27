import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListAffairesComponent } from './list-affaires.component';

describe('ListAffairesComponent', () => {
  let component: ListAffairesComponent;
  let fixture: ComponentFixture<ListAffairesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListAffairesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListAffairesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
