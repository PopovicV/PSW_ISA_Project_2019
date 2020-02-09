import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PacijentZahtevanjeNovogPregledaComponent } from './pacijent-zahtevanje-novog-pregleda.component';

describe('PacijentZahtevanjeNovogPregledaComponent', () => {
  let component: PacijentZahtevanjeNovogPregledaComponent;
  let fixture: ComponentFixture<PacijentZahtevanjeNovogPregledaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PacijentZahtevanjeNovogPregledaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PacijentZahtevanjeNovogPregledaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
