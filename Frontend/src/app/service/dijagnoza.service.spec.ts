import { TestBed } from '@angular/core/testing';

import { DijagnozaService } from './dijagnoza.service';

describe('DijagnozaService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DijagnozaService = TestBed.get(DijagnozaService);
    expect(service).toBeTruthy();
  });
});
