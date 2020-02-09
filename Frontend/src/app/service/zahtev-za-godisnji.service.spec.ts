import { TestBed } from '@angular/core/testing';

import { ZahtevZaGodisnjiService } from './zahtev-za-godisnji.service';

describe('ZahtevZaGodisnjiService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ZahtevZaGodisnjiService = TestBed.get(ZahtevZaGodisnjiService);
    expect(service).toBeTruthy();
  });
});
