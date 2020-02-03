import { TestBed } from '@angular/core/testing';

import { SalaServiceService } from './sala.service';

describe('SalaServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SalaServiceService = TestBed.get(SalaServiceService);
    expect(service).toBeTruthy();
  });
});
