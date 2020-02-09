import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdministratorZahteviZaGodisnjiComponent } from './administrator-zahtevi-za-godisnji.component';

describe('AdministratorZahteviZaGodisnjiComponent', () => {
  let component: AdministratorZahteviZaGodisnjiComponent;
  let fixture: ComponentFixture<AdministratorZahteviZaGodisnjiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdministratorZahteviZaGodisnjiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdministratorZahteviZaGodisnjiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
