import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ZapravoProfilComponent } from './zapravo-profil.component';

describe('ZapravoProfilComponent', () => {
  let component: ZapravoProfilComponent;
  let fixture: ComponentFixture<ZapravoProfilComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ZapravoProfilComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ZapravoProfilComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
