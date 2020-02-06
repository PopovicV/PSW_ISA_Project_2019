import { TestBed } from '@angular/core/testing';

import { KlinikaService } from './klinika.service';

describe('KlinikaService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: KlinikaService = TestBed.get(KlinikaService);
    expect(service).toBeTruthy();
  });
});
