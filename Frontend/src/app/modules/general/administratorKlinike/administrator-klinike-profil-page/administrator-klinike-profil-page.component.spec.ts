import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdministratorKlinikeProfilPageComponent } from './administrator-klinike-profil-page.component';

describe('AdministratorKlinikeProfilPageComponent', () => {
  let component: AdministratorKlinikeProfilPageComponent;
  let fixture: ComponentFixture<AdministratorKlinikeProfilPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdministratorKlinikeProfilPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdministratorKlinikeProfilPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
