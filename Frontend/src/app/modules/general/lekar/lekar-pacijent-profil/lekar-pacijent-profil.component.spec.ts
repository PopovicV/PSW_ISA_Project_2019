import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LekarPacijentProfilComponent } from './lekar-pacijent-profil.component';

describe('LekarPacijentProfilComponent', () => {
  let component: LekarPacijentProfilComponent;
  let fixture: ComponentFixture<LekarPacijentProfilComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LekarPacijentProfilComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LekarPacijentProfilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
