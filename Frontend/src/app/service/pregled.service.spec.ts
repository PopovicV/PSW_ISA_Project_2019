import { TestBed } from '@angular/core/testing';

import { PregledService } from './pregled.service';

describe('PregledService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: PregledService = TestBed.get(PregledService);
    expect(service).toBeTruthy();
  });
});
