import { TestBed } from '@angular/core/testing';

import { ZahtevService } from './zahtev.service';

describe('ZahtevService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ZahtevService = TestBed.get(ZahtevService);
    expect(service).toBeTruthy();
  });
});
