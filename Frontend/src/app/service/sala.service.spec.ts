import { TestBed } from '@angular/core/testing';

import { SalaService } from './sala.service';

describe('SalaServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SalaService = TestBed.get(SalaService);
    expect(service).toBeTruthy();
  });
});
