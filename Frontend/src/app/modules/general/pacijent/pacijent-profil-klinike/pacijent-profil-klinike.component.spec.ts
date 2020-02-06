import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PacijentProfilKlinikeComponent } from './pacijent-profil-klinike.component';

describe('PacijentProfilKlinikeComponent', () => {
  let component: PacijentProfilKlinikeComponent;
  let fixture: ComponentFixture<PacijentProfilKlinikeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PacijentProfilKlinikeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PacijentProfilKlinikeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
