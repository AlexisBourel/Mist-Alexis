import { TestBed, inject } from '@angular/core/testing';

import { AffairesService} from './affaires.service';

describe('AffairesServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AffairesService]
    });
  });

  it('should be created', inject([AffairesService], (service: AffairesService) => {
    expect(service).toBeTruthy();
  }));
});
