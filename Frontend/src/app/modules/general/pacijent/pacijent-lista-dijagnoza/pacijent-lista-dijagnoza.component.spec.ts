import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PacijentListaDijagnozaComponent } from './pacijent-lista-dijagnoza.component';

describe('PacijentListaDijagnozaComponent', () => {
  let component: PacijentListaDijagnozaComponent;
  let fixture: ComponentFixture<PacijentListaDijagnozaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PacijentListaDijagnozaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PacijentListaDijagnozaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
