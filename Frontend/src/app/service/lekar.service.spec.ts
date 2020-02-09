import { TestBed } from '@angular/core/testing';

import { LekarService } from './lekar.service';

describe('LekarService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LekarService = TestBed.get(LekarService);
    expect(service).toBeTruthy();
  });
});
