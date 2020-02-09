import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ZahtevZaGodisnjiComponent } from './zahtev-za-godisnji.component';

describe('ZahtevZaGodisnjiComponent', () => {
  let component: ZahtevZaGodisnjiComponent;
  let fixture: ComponentFixture<ZahtevZaGodisnjiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ZahtevZaGodisnjiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ZahtevZaGodisnjiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
