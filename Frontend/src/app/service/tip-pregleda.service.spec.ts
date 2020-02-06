import { TestBed } from '@angular/core/testing';

import { TipPregledaService } from './tip-pregleda.service';

describe('TipPregledaService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TipPregledaService = TestBed.get(TipPregledaService);
    expect(service).toBeTruthy();
  });
});
