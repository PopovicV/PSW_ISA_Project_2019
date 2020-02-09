import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PacijentIstorijaOperacijaComponent } from './pacijent-istorija-operacija.component';

describe('PacijentIstorijaOperacijaComponent', () => {
  let component: PacijentIstorijaOperacijaComponent;
  let fixture: ComponentFixture<PacijentIstorijaOperacijaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PacijentIstorijaOperacijaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PacijentIstorijaOperacijaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
