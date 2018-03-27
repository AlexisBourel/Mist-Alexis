import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreationAgentComponent } from './creation-agent.component';

describe('CreationAgentComponent', () => {
  let component: CreationAgentComponent;
  let fixture: ComponentFixture<CreationAgentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreationAgentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreationAgentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
