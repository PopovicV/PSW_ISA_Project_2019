import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LekarZakazivanjePregledaComponent } from './lekar-zakazivanje-pregleda.component';

describe('LekarZakazivanjePregledaComponent', () => {
  let component: LekarZakazivanjePregledaComponent;
  let fixture: ComponentFixture<LekarZakazivanjePregledaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LekarZakazivanjePregledaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LekarZakazivanjePregledaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
